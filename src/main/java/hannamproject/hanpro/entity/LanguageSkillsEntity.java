package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 외국어 능력
// TOEIC 성적: 단계별 최저 100점, 최고 500점
// JLPT 2급: 350점, 1급: 500점

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "language_skills_table")
public class LanguageSkillsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    private String language;
    private int languageScore;
    private String scoreName;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private MemberEntity member;
}
