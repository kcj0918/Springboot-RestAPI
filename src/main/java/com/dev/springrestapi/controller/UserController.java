package com.dev.springrestapi.controller;

import com.dev.springrestapi.dto.request.user.UserAddRequestDto;
import com.dev.springrestapi.dto.response.DefaultResponse;
import com.dev.springrestapi.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
}
