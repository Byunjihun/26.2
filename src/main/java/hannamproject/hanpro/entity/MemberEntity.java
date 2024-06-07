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
    private Long graduationScore; // Ensure this is Long

    @Column
    private Integer maxScore; // Ensure this is Integer

    @ElementCollection
    @CollectionTable(name = "member_skills", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "skill")
    private List<String> skills;

    @ElementCollection
    @CollectionTable(name = "member_subjects", joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyColumn(name = "subject_name")
    @Column(name = "is_enrolled")
    private Map<String, Boolean> subjects;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<CertificateMajorEntity> certificateMajorEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<CounselingEntity> counselingEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<DepartmentEventsEntity> departmentEventsEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<EmploymentEntity> employmentEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<EmploymentTrainingEntity> employmentTrainingEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<GraduationExhibitionEntity> graduationExhibitionEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<InternshipEntity> internshipEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<LanguageSkillsEntity> languageSkillsEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<OverseasTrainingEntity> overseasTrainingEntities;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<S_W_ContestEntity> s_w_ContestEntities;
}
