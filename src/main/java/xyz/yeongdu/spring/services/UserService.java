package xyz.yeongdu.spring.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.yeongdu.spring.dtos.UserDto;
import xyz.yeongdu.spring.exceptions.UserAlreadyExistException;
import xyz.yeongdu.spring.models.User;
import xyz.yeongdu.spring.repositories.UserRepository;
import xyz.yeongdu.spring.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }
    public User findUserById(Long userId) { return this.userRepository.findUserById(userId); }
}
