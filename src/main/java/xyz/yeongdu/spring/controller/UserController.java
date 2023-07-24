package xyz.yeongdu.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.yeongdu.spring.dtos.UserDto;
import xyz.yeongdu.spring.models.User;
import xyz.yeongdu.spring.services.AuthService;
import xyz.yeongdu.spring.services.UserService;
import xyz.yeongdu.spring.util.MultiResponseDto;
import xyz.yeongdu.spring.util.SingleResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<MultiResponseDto<UserDto>> findAllUser() {
        List<UserDto> user= this.userService.findAllUser().stream().map(User::toDto).toList();
        return new ResponseEntity<>(new MultiResponseDto<>(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SingleResponseDto<UserDto>> createUser(@RequestBody UserDto userDto) {
        User user = this.authService.createUser(userDto);
        return new ResponseEntity<>(new SingleResponseDto<>(user.toDto()), HttpStatus.CREATED);
    }
}
