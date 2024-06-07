package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//취업 테이블
//기업 취업(4대 보험 가입 기업) 및 대학원 진학, 군 입대: 850점

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employment_table")
public class EmploymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    private String employmentType;
    private int employmentScore;
    private String scoreName;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private MemberEntity member;
}
