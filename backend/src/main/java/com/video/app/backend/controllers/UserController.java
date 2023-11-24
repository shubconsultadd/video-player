package com.video.app.backend.controllers;

import com.video.app.backend.Service.userService.UserService;
import com.video.app.backend.models.User;
import com.video.app.backend.payload.LoginDto;
import com.video.app.backend.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
        UserDto registeredUser = this.userService.registerUser(userDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<UserDto> findByEmail(@RequestParam String email){
        UserDto userDto = this.userService.findByEmail(email);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        try{
            String token = this.userService.login(loginDto);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization","Bearer "+token);
            return ResponseEntity.ok().headers(httpHeaders).body("Login Successful!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }
}
