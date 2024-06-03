package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "board_post")
@EntityListeners(AuditingEntityListener.class)
public class BoardPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 제목

    private String content; // 작성 내용

    private String author; // 작성자 ID

    private String authorName; // 작성자 이름

    @CreatedDate
    @Column(updatable = false)
    private LocalDate createdDate; // 작성일

    private LocalTime createdTime; // 작성 시간

    @LastModifiedDate
    private LocalDateTime updatedDate; // 업데이트 시간
}
