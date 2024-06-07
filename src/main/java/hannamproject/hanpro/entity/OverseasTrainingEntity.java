package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 해외 연수
// 최대 200점
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "overseas_training_table")
public class OverseasTrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    private int overseasStudyScore;
    private String scoreName;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private MemberEntity member;
}
