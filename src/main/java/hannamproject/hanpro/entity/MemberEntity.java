package hannamproject.hanpro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @Column
    private String studentId;

    @Column
    private String memberEmail;

    @Column
    private String userName;

    @Column
    private String memberPassword;

    @Column
    private String department;

    @Column
    private String year;

    @Column
    private Long graduationScore;

    @Column
    private Integer maxScore;

    @ElementCollection
    @CollectionTable(name = "member_skills", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "skill")
    private List<String> skills;

    @ElementCollection
    @CollectionTable(name = "member_subjects", joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyColumn(name = "subject_name")
    @Column(name = "is_enrolled")
    private Map<String, Boolean> subjects;
}
