package com.dev.springrestapi.user.controller;

import com.dev.springrestapi.user.domain.User;
import com.dev.springrestapi.user.dto.request.user.UserAddRequestDto;
import com.dev.springrestapi.user.dto.response.DefaultResponse;
import com.dev.springrestapi.user.dto.response.user.GetUserResponseDto;
import com.dev.springrestapi.user.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@AllArgsConstructor
@Api
public class UserController {
    private UserService userService;

    @PostMapping("user/sign/up")
    @ResponseBody
    public ResponseEntity<DefaultResponse> signUp(@RequestBody UserAddRequestDto userAddRequestDto) {
        userService.addUser(userAddRequestDto);
        return new ResponseEntity<>(new DefaultResponse(DefaultResponse.Status.SUCCESS), HttpStatus.OK);
    }

    @GetMapping("user/{email}")
    @ResponseBody
    public ResponseEntity<DefaultResponse> getUser(@PathVariable("email") String email) {
        User user = userService.getUserByEmail(email);
        GetUserResponseDto getUserResponseDto = GetUserResponseDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
        return new ResponseEntity<>(new DefaultResponse(getUserResponseDto), HttpStatus.OK);
    }
}
