package xyz.yeongdu.spring.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import xyz.yeongdu.spring.dtos.UserDto;
import xyz.yeongdu.spring.models.User;
import xyz.yeongdu.spring.repositories.UserRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserDto userDto) {
        User user = this.userRepository.findUserByUsername(userDto.getUsername());

        System.out.println(user);
        System.out.println(userDto.getUsername());

        if (user != null) throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflict Data");

        return this.userRepository.save(
                User.builder()
                        .username(userDto.getUsername())
                        .password(passwordEncoder.encode(userDto.getPassword())
                        ).build()
        );
    }

    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }
}
