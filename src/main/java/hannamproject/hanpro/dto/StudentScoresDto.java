package hannamproject.hanpro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentScoresDto {
    private Long graduationScore;
    private int competitionScore;
    private int counselingScore;
    private int employmentScore;
    private int eventsScore;
    private int graduationProjectScore;
    private int internshipScore;
    private int languageSkillsScore;
    private int overseasStudyScore;
    private int qualificationScore;
    private int trainingScore;
}
