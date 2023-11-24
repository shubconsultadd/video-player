package com.video.app.backend.Service.userService;

import com.video.app.backend.models.User;
import com.video.app.backend.payload.LoginDto;
import com.video.app.backend.payload.UserDto;

public interface UserService {
    UserDto registerUser(UserDto user);

    UserDto findByEmail(String email);
    String login(LoginDto loginDto);
}
