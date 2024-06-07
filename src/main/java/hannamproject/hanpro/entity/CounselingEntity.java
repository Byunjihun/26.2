package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 상담실적
// 매 학기 1회당 10점, 추가 상담 포함, 최대 150점

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "counseling_table")
public class CounselingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    private int counselingScore;
    private String scoreName;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private MemberEntity member;
}
