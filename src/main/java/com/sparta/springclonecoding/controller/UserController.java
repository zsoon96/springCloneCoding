package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.IsDto;
import com.sparta.springclonecoding.dto.ResultDto;
import com.sparta.springclonecoding.dto.SignupRequestDto;
import com.sparta.springclonecoding.repository.UserRepository;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import com.sparta.springclonecoding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    // 회원가입 등록
    @PostMapping("/user/signup")
    public ResultDto join(
            @Validated @RequestBody SignupRequestDto requestDto,
            BindingResult bindingResult) {
        // 유효성 검증을 통해 유효하지 않은 결과를 JudgeSuccessDto에 담아서 클라이언트에게 보내준다.
        if (bindingResult.hasErrors()) {
            // 유효성 검사에 실패했을 경우 Error를 리스트 형식으로 가져온다.
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());

            return new ResultDto(false, errors.get(0));
        }
        userService.save(requestDto);
        return userService.save(requestDto);
    }

    // 회원 로그인 여부 확인
    @GetMapping("/api/islogin")
    public IsDto isLogin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return new IsDto(userDetails.getUser().getUsername(), userDetails.getUser().getNickname());
    }

    // 회원 중복 확인
    @PostMapping("/api/idcheck")
    public ResultDto idCheck(@RequestBody IsDto isDto) {
        if (userRepository.findByUsername(isDto.getUsername()).isPresent()) {
            return new ResultDto(false, "이미 존재하는 아이디 입니다.");
        }
        return new ResultDto(true, "사용할 수 있는 아이디 입니다.");
    }
}
