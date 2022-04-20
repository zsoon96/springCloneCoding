package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.CommentResponseDto;
import com.sparta.springclonecoding.dto.DetailDto;
import com.sparta.springclonecoding.dto.PostResponseDto;
import com.sparta.springclonecoding.dto.ProfileDto;
import com.sparta.springclonecoding.model.Comment;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.model.User;
import com.sparta.springclonecoding.repository.CommentRepository;
import com.sparta.springclonecoding.repository.FollowRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import com.sparta.springclonecoding.repository.UserRepository;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final S3Service s3Service;
    private final FollowRepository followRepository;
    private final CommentRepository commentRepository;

    // 회원 프로필
    public ProfileDto showProfile(UserDetailsImpl userDetails, Long userid){
        User user = userRepository.findById(userid).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다."));
        // 게시글 수
        int postCnt = postRepository.countAllByUserId(userid);
        // 로그인 된 유저와 프로필 유저 일치 여부
        boolean loginUser = userid.equals(userDetails.getUser().getId());
        // 해당 프로필을 팔로우한 유저(팔로워) 수
        Long userFollowerCnt = followRepository.countFollowerById(userid);
        // 해당 프로필이 팔로우한 유저(팔로잉) 수
        Long userFollowingCnt = followRepository.countFollowingById(userid);

        return new ProfileDto(user, postCnt, loginUser, userFollowerCnt, userFollowingCnt);
    }

    // 상세 페이지 + 댓글 페이징 처리
    public DetailDto showDetail(Long postid, UserDetailsImpl userDetails, int loadComment){
        Post post =postRepository.findById(postid).orElseThrow(
                ()-> new IllegalArgumentException("없는 포스트입니다"));
        Boolean myLike = false;
        Long userid =userDetails.getUser().getId();
        for(int i =0; i<post.getFavorites().size(); i++){
            if (post.getFavorites().get(i).getUserid() == userid) {
                myLike = true;
                break;
            }
        }
        // 코멘트 리스트 불러와서 페이징처리
        List<Comment> commentList = commentRepository.findAllByPostidOrderByIdDesc(postid);
        final int end = Math.min(loadComment+10 , commentList.size());
        commentList.subList(loadComment,end);

        return new DetailDto(post,post.getFavorites().size(),myLike);
    }

    // 게시글 저장
    public PostResponseDto postPost (MultipartFile multipartFile, String content, UserDetailsImpl userDetails) throws IOException {
        String imageUrl = s3Service.upload(multipartFile);
        Post post = new Post(content,imageUrl,userDetails);
        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow(
                () -> new IllegalArgumentException("계정이 없습니다.")
        );
        user.getPosts().add(post);
        postRepository.save(post);

        return getPostResponseDto(user.getId(), post);
    }

    // 게시글 목록 조회 - 게시글 리스트를 반복문으로 꺼내서 각 게시글의 각 코멘트 갯수 보여주고 다시 담아주기
    public List<PostResponseDto> getPost (UserDetailsImpl userDetails,
                                          int loadPost) {

        List<Post> posts = postRepository.findAllByOrderByIdDesc();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        Long userId = userDetails.getUser().getId();
        if (userId == null) {
            throw new IllegalArgumentException("계정이 없습니다.");
        }

        for (Post post : posts) {
            // 해당 게시물에 대한 사용자의 좋아요 확인 -> 각 포스트마다 좋아요한 리스트에 userid가 사용자와 일치하면 true로 변환
            PostResponseDto postResponseDto = getPostResponseDto(userId, post);
            postResponseDtos.add(postResponseDto);
        }

        // list를 page으로 바꿔서 리턴
        final int end = Math.min(loadPost+3 , postResponseDtos.size());
        return postResponseDtos.subList(loadPost,end);
    }

    @NotNull
    private PostResponseDto getPostResponseDto(Long userId, Post post) {
        boolean myLike = false;
        for (int i = 0; i < post.getFavorites().size(); i++) {
            if (post.getFavorites().get(i).getUserid() == userId){
                myLike = true;
            }
        }
        User user = userRepository.findByPosts(post);

        // 댓글 갯수
        int commentCnt = 0;
        if (!post.getComments().isEmpty()) {
            commentCnt = post.getComments().size();
        }

        // 좋아요 수
        int favoriteCnt = 0;
        if (!post.getFavorites().isEmpty()) {
            favoriteCnt = post.getFavorites().size();
        }

        List<CommentResponseDto> commentList = new ArrayList<>();

        for(Comment comment : post.getComments()) {

            String nickname = userRepository.findById(comment.getUserid()).get().getNickname();

            CommentResponseDto commentResponseDto = new CommentResponseDto(comment, nickname);
            commentList.add(commentResponseDto);
        }

        PostResponseDto postResponseDto = new PostResponseDto(post, commentList, commentCnt,favoriteCnt,myLike,user);
        return postResponseDto;
    }



    // 게시글 수정
    @Transactional
    public PostResponseDto putPost(Long postId, String content, Long userId){
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 없습니다.")
        );
        post.update(content);

        return getPostResponseDto(userId, post);
    }


    // 게시글 삭제
    public Long delPost(Long postId) {
        postRepository.deleteById(postId);
        return postId;
    }

    // 프로필 수정
    @Transactional
    public void editprofile(MultipartFile multipartFile,UserDetailsImpl userDetails) {
        String imageUrl = s3Service.upload(multipartFile,"static");
        User user = userRepository.findById(userDetails.getId()).orElseThrow(
                ()-> new IllegalArgumentException("없는 유저입니다.")
        );
        user.update(imageUrl);
    }
}
