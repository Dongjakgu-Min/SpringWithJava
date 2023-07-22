package xyz.yeongdu.spring.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import xyz.yeongdu.spring.dtos.UserDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @CreatedDate @Column
    private Date createdAt;
    @UpdateTimestamp @Column
    private Date updatedAt;
    @Column(nullable = true)
    private Date deletedAt;
    @Builder.Default @Enumerated @Column
    private UserRole role = UserRole.ROLE_MEMBER;
    @AllArgsConstructor
    public enum UserRole {
        ROLE_MEMBER("사용자");
        @Getter
        final String role;
    }

    public UserDto toDto() {
        return UserDto.builder().username(this.username).password(this.password).build();
    }
}
