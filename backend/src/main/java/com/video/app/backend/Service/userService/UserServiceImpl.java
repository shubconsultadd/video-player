package com.video.app.backend.Service.userService;

import com.video.app.backend.Repository.UserRepo;
import com.video.app.backend.models.User;
import com.video.app.backend.payload.LoginDto;
import com.video.app.backend.payload.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto registerUser(UserDto userDto) {
        if(userRepo.findByEmail(userDto.getEmail())!=null)
            throw new IllegalArgumentException("Email already exists");
        User user = this.modelMapper.map(userDto,User.class);
        User savedUser = userRepo.save(user);
        return this.modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public String login(LoginDto loginDto) {
        User user = userRepo.findByEmail(loginDto.getEmail());
        if(user!=null && user.getPassword().equals(loginDto.getPassword())){
            return generateToken(user);
        }
        throw new IllegalArgumentException("Invalid Credentials!");
    }

    private String generateToken(User user){
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Jwts.builder().
                setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                .signWith(secretKey)
                .compact();
    }
}
