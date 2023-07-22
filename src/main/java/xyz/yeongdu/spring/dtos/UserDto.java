package xyz.yeongdu.spring.dtos;

import lombok.*;
import xyz.yeongdu.spring.models.User;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long Id;
    private String username;
    private String password;

    public User toEntity() {
        return User.builder().username(this.getUsername()).password(this.getPassword()).build();
    }
}
