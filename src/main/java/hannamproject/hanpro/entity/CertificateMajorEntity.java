package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 전공 관련 자격증 및 국가 고시
// 최대 600점
// 5급 공무원: 1차 합격 – 900점, 2차 합격 – 1000점
// 7급 공무원: 1차 합격 – 800점, 2차 합격 – 1000점
// 9급 공무원: 1차 합격 – 700점, 2차 합격 – 1000점
// 기술사 3가지: 1차 합격 – 900점, 2차 합격 – 1000점
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "certificate_major_table")
public class CertificateMajorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    private String qualificationType;
    private int qualificationScore;
    private String scoreName; // 추가된 필드

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private MemberEntity member;
}

