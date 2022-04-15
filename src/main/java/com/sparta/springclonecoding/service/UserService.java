package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.SignupRequestDto;
import com.sparta.springclonecoding.model.User;
import com.sparta.springclonecoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void save(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
//        String nickname = requestDto.getNickname();
        String message;
        Optional<User> found = userRepository.findByUsername(username);

        // username 중복 체크
//        if(validatedDuplicateUsername(found)) {
//            message = ILLEGAL_USER_NAME_DUPLICATION;
//            return new JudgeSuccessDto(false, message);
//        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(username, password);
        userRepository.save(user);
        message = "회원가입 성공";
//        return new JudgeSuccessDto(true, message);
    }

    // 유저이름 중복 체크
//    private boolean validatedDuplicateUsername(Optional<User> found) {
//        return found.isPresent() ? true : false;
//    }
}
