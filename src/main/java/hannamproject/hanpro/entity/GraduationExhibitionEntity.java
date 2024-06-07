package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 졸업작품전 입상
// 입상시 100점
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "graduation_exhibition_table")
public class GraduationExhibitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    private int graduationProjectScore;
    private String scoreName;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private MemberEntity member;
}


