package hannamproject.hanpro.service;

import hannamproject.hanpro.entity.*;
import hannamproject.hanpro.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final S_W_ContestRepository competitionRepository;
    private final CounselingRepository counselingRepository;
    private final EmploymentRepository employmentRepository;
    private final Department_EventsRepository eventsRepository;
    private final Graduation_ExhibitionRepository graduationProjectRepository;
    private final InternshipRepository internshipRepository;
    private final LanguageSkillsRepository languageSkillsRepository;
    private final OverseasTrainingRepository overseasStudyRepository;
    private final CertificateMajorRepository qualificationRepository;
    private final EmploymentTrainingRepository trainingRepository;

    public void updateGraduationScore(String studentId) {
        Long totalScore = calculateTotalScore(studentId);
        MemberEntity member = memberRepository.findByStudentId(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));
        member.setGraduationScore(totalScore);
        memberRepository.save(member);
    }

    public Long getGraduationScore(String studentId) {
        MemberEntity member = memberRepository.findByStudentId(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));
        return member.getGraduationScore();
    }

    private Long calculateTotalScore(String studentId) {
        Long totalScore = 0L;

        totalScore += competitionRepository.findByStudentId(studentId).stream().mapToInt(S_W_ContestEntity::getCompetitionScore).sum();
        totalScore += counselingRepository.findByStudentId(studentId).stream().mapToInt(CounselingEntity::getCounselingScore).sum();
        totalScore += employmentRepository.findByStudentId(studentId).stream().mapToInt(EmploymentEntity::getEmploymentScore).sum();
        totalScore += eventsRepository.findByStudentId(studentId).stream().mapToInt(DepartmentEventsEntity::getEventsScore).sum();
        totalScore += graduationProjectRepository.findByStudentId(studentId).stream().mapToInt(GraduationExhibitionEntity::getGraduationProjectScore).sum();
        totalScore += internshipRepository.findByStudentId(studentId).stream().mapToInt(InternshipEntity::getInternshipScore).sum();
        totalScore += languageSkillsRepository.findByStudentId(studentId).stream().mapToInt(LanguageSkillsEntity::getLanguageScore).sum();
        totalScore += overseasStudyRepository.findByStudentId(studentId).stream().mapToInt(OverseasTrainingEntity::getOverseasStudyScore).sum();
        totalScore += qualificationRepository.findByStudentId(studentId).stream().mapToInt(CertificateMajorEntity::getQualificationScore).sum();
        totalScore += trainingRepository.findByStudentId(studentId).stream().mapToInt(EmploymentTrainingEntity::getTrainingScore).sum();

        return totalScore;
    }

    public void updateCounselingScore(String studentId, int newScore, String scoreName) {
        CounselingEntity entity = new CounselingEntity();
        entity.setStudentId(studentId);
        entity.setCounselingScore(newScore);
        entity.setScoreName(scoreName);
        counselingRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateCompetitionScore(String studentId, int newScore, String scoreName) {
        S_W_ContestEntity entity = new S_W_ContestEntity();
        entity.setStudentId(studentId);
        entity.setCompetitionScore(newScore);
        entity.setScoreName(scoreName);
        competitionRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateEmploymentScore(String studentId, int newScore, String scoreName) {
        EmploymentEntity entity = new EmploymentEntity();
        entity.setStudentId(studentId);
        entity.setEmploymentScore(newScore);
        entity.setScoreName(scoreName);
        employmentRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateEventsScore(String studentId, int newScore, String scoreName) {
        DepartmentEventsEntity entity = new DepartmentEventsEntity();
        entity.setStudentId(studentId);
        entity.setEventsScore(newScore);
        entity.setScoreName(scoreName);
        eventsRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateGraduationProjectScore(String studentId, int newScore, String scoreName) {
        GraduationExhibitionEntity entity = new GraduationExhibitionEntity();
        entity.setStudentId(studentId);
        entity.setGraduationProjectScore(newScore);
        entity.setScoreName(scoreName);
        graduationProjectRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateInternshipScore(String studentId, int newScore, String scoreName) {
        InternshipEntity entity = new InternshipEntity();
        entity.setStudentId(studentId);
        entity.setInternshipScore(newScore);
        entity.setScoreName(scoreName);
        internshipRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateLanguageSkillsScore(String studentId, int newScore, String scoreName) {
        LanguageSkillsEntity entity = new LanguageSkillsEntity();
        entity.setStudentId(studentId);
        entity.setLanguageScore(newScore);
        entity.setScoreName(scoreName);
        languageSkillsRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateOverseasStudyScore(String studentId, int newScore, String scoreName) {
        OverseasTrainingEntity entity = new OverseasTrainingEntity();
        entity.setStudentId(studentId);
        entity.setOverseasStudyScore(newScore);
        entity.setScoreName(scoreName);
        overseasStudyRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateQualificationScore(String studentId, int newScore, String scoreName) {
        CertificateMajorEntity entity = new CertificateMajorEntity();
        entity.setStudentId(studentId);
        entity.setQualificationScore(newScore);
        entity.setScoreName(scoreName);
        qualificationRepository.save(entity);
        updateGraduationScore(studentId);
    }

    public void updateTrainingScore(String studentId, int newScore, String scoreName) {
        EmploymentTrainingEntity entity = new EmploymentTrainingEntity();
        entity.setStudentId(studentId);
        entity.setTrainingScore(newScore);
        entity.setScoreName(scoreName);
        trainingRepository.save(entity);
        updateGraduationScore(studentId);
    }
}
