package xyz.yeongdu.spring.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @Id @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @ManyToOne
    private User user;
    @CreatedDate
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    @Column(nullable = true)
    private Date deletedAt;
}
