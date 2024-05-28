package hannamproject.hanpro.dto;

import hannamproject.hanpro.entity.GraduationEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GraduationDto {
    private String memberStudentId;
    private Long capstoneDesignScore;
    private String memberPassword;
    private Long certificateAndExaminationScore;
    private Long consultingScore;
    private Long departmentEventScore;
    private Long employmentTrainingScore;
    private Long foreignLanguageSkillScore;
    private Long graduationExhibitionAwardScore;
    private Long internshipScore;
    private Long overseasStudyScore;
    private Long swContestScore;
    private Long totalScore;

    public static GraduationDto toGraduationDto(GraduationEntity graduationEntity){
        GraduationDto graduationDto = new GraduationDto();
        graduationDto.setMemberStudentId(graduationEntity.getMemberStudentId());
        graduationDto.setCapstoneDesignScore(graduationEntity.getCapstoneDesignScore());
        graduationDto.setCertificateAndExaminationScore(graduationEntity.getCertificateAndExaminationScore());
        graduationDto.setConsultingScore(graduationEntity.getConsultingScore());
        graduationDto.setDepartmentEventScore(graduationEntity.getDepartmentEventScore());
        graduationDto.setEmploymentTrainingScore(graduationEntity.getEmploymentTrainingScore());
        graduationDto.setForeignLanguageSkillScore(graduationEntity.getForeignLanguageSkillScore());
        graduationDto.setGraduationExhibitionAwardScore(graduationEntity.getGraduationExhibitionAwardScore());
        graduationDto.setInternshipScore(graduationEntity.getInternshipScore());
        graduationDto.setOverseasStudyScore(graduationEntity.getOverseasStudyScore());
        graduationDto.setSwContestScore(graduationEntity.getSwContestScore());
        graduationDto.setTotalScore(graduationEntity.getTotalScore());
        return graduationDto;

    }
}