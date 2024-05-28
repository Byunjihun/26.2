package hannamproject.hanpro.entity;

import hannamproject.hanpro.dto.GraduationDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "graduation_score_table")
public class GraduationEntity {
    @Id
    private String memberStudentId;
    @Column
    private Long capstoneDesignScore;
    @Column
    private Long certificateAndExaminationScore;
    @Column
    private Long consultingScore;
    @Column
    private Long departmentEventScore;
    @Column
    private Long employmentTrainingScore;
    @Column
    private Long foreignLanguageSkillScore;
    @Column
    private Long graduationExhibitionAwardScore;
    @Column
    private Long internshipScore;
    @Column
    private Long OverseasStudyScore;
    @Column
    private Long swContestScore;
    @Column
    private Long totalScore;
    @Column
    private String memberPassword;

    public static GraduationEntity toGraduationEntity(GraduationDto graduationDto){
        GraduationEntity graduationEntity = new GraduationEntity();
        graduationEntity.setMemberStudentId(graduationDto.getMemberStudentId());
        graduationEntity.setCapstoneDesignScore(graduationDto.getCapstoneDesignScore());
        graduationEntity.setCertificateAndExaminationScore(graduationDto.getCertificateAndExaminationScore());
        graduationEntity.setConsultingScore(graduationDto.getConsultingScore());
        graduationEntity.setDepartmentEventScore(graduationDto.getDepartmentEventScore());
        graduationEntity.setEmploymentTrainingScore(graduationDto.getEmploymentTrainingScore());
        graduationEntity.setForeignLanguageSkillScore(graduationDto.getForeignLanguageSkillScore());
        graduationEntity.setGraduationExhibitionAwardScore(graduationDto.getGraduationExhibitionAwardScore());
        graduationEntity.setInternshipScore(graduationDto.getInternshipScore());
        graduationEntity.setOverseasStudyScore(graduationDto.getOverseasStudyScore());
        graduationEntity.setSwContestScore(graduationDto.getSwContestScore());
        graduationEntity.setTotalScore(graduationDto.getTotalScore());
        graduationEntity.setMemberPassword(graduationEntity.getMemberPassword());
        return graduationEntity;
    }
}
