package xyz.yeongdu.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yeongdu.spring.dtos.UserDto;
import xyz.yeongdu.spring.models.User;
import xyz.yeongdu.spring.services.AuthService;
import xyz.yeongdu.spring.util.SingleResponseDto;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<SingleResponseDto<Map<String, String>>> login(@RequestBody Map<String, String> request) {
        return new ResponseEntity<>(new SingleResponseDto<>(this.authService.login(request)), HttpStatus.OK);
    }
}
