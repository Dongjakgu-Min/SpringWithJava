package xyz.yeongdu.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.yeongdu.spring.dtos.UserDto;
import xyz.yeongdu.spring.models.User;
import xyz.yeongdu.spring.services.UserService;
import xyz.yeongdu.spring.util.MultiResponseDto;
import xyz.yeongdu.spring.util.SingleResponseDto;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<SingleResponseDto<UserDto>> createUser(@RequestBody UserDto userDto) {
        User user = this.userService.createUser(userDto);
        return new ResponseEntity<>(new SingleResponseDto<>(user.toDto()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<MultiResponseDto<UserDto>> findAllUser() {
        List<UserDto> user= this.userService.findAllUser().stream().map(User::toDto).toList();
        return new ResponseEntity<>(new MultiResponseDto<>(user), HttpStatus.OK);
    }
}
