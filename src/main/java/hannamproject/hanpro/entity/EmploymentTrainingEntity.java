package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 취업 훈련 참가 실적
// 1회 참가 시 50점, 최대(3회 이상) 150점
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employment_training_table")
public class EmploymentTrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    private int trainingScore;
    private String scoreName;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private MemberEntity member;
}
