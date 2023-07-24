package xyz.yeongdu.spring.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.yeongdu.spring.dtos.UserDto;
import xyz.yeongdu.spring.exceptions.UserAlreadyExistException;
import xyz.yeongdu.spring.models.User;
import xyz.yeongdu.spring.repositories.UserRepository;
import xyz.yeongdu.spring.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public User createUser(UserDto userDto) {
        User user = this.userRepository.findUserByUsername(userDto.getUsername());

        if (user != null) throw new UserAlreadyExistException();

        return this.userRepository.save(
                User.builder()
                        .username(userDto.getUsername())
                        .password(passwordEncoder.encode(userDto.getPassword())
                        ).build()
        );
    }

    public Map<String, String> login(Map<String, String> user) {
        Map<String, String> result = new HashMap<>();

        User member = userRepository.findUserByUsername(user.get("username"));

        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new UserAlreadyExistException();
        }

        result.put("access-token", jwtTokenProvider.generateToken(member.getUsername(), member.getRole()));

        return result;
    }
}
