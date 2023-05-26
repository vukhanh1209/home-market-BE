package com.example.homemarket.controller;

import com.example.homemarket.dtos.UserDTO;
import com.example.homemarket.dtos.response.UserForgetPasswordResponse;
import com.example.homemarket.dtos.response.UserLoginResponse;
import com.example.homemarket.dtos.response.UserRegisterOtpRespone;
import com.example.homemarket.dtos.response.UserResetPasswordResponse;
import com.example.homemarket.entities.User;
import com.example.homemarket.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@ModelAttribute  UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@ModelAttribute UserLoginResponse userLoginResponse){
        UserLoginResponse response = userService.login(userLoginResponse);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/otp")
    public ResponseEntity<UserRegisterOtpRespone> otp(@ModelAttribute UserRegisterOtpRespone userRegisterOtpRespone){
        UserRegisterOtpRespone response = userService.otp(userRegisterOtpRespone);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/forgetPassword")
    public ResponseEntity<UserForgetPasswordResponse> forgetPassword(@ModelAttribute UserForgetPasswordResponse userForgetPasswordResponse){
        UserForgetPasswordResponse response = userService.forgetPassword(userForgetPasswordResponse);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/resetPassword")
    public ResponseEntity<UserResetPasswordResponse> resetPassword(@ModelAttribute UserResetPasswordResponse userResetPasswordResponse){
        UserResetPasswordResponse response = userService.resetPassword(userResetPasswordResponse);
        return ResponseEntity.ok(response);
    }
//   @GetMapping("/{userId}")
//   public ResponseEntity<UserDTO> getUser(@PathVariable Integer userId){
//       return new ResponseEntity<>(user)
//   }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getUser(userId),HttpStatus.OK);
    }

}