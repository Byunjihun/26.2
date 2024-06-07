package hannamproject.hanpro.controller;

import hannamproject.hanpro.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PutMapping("/graduation-score")
    public ResponseEntity<Long> updateGraduationScore(Principal principal) {
        String studentId = principal.getName();
        memberService.updateGraduationScore(studentId);
        Long updatedGraduationScore = memberService.getGraduationScore(studentId);
        return ResponseEntity.ok(updatedGraduationScore);
    }

    @GetMapping("/graduation-score")
    public ResponseEntity<Long> getGraduationScore(Principal principal) {
        String studentId = principal.getName();
        Long graduationScore = memberService.getGraduationScore(studentId);
        return ResponseEntity.ok(graduationScore);
    }

    @PutMapping("/graduation-score/update/counseling-score")
    public ResponseEntity<Void> updateCounselingScore(Principal principal,
                                                      @RequestParam("newScore") int newScore,
                                                      @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateCounselingScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/competition-score")
    public ResponseEntity<Void> updateCompetitionScore(Principal principal,
                                                       @RequestParam("newScore") int newScore,
                                                       @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateCompetitionScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/employment-score")
    public ResponseEntity<Void> updateEmploymentScore(Principal principal,
                                                      @RequestParam("newScore") int newScore,
                                                      @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateEmploymentScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/events-score")
    public ResponseEntity<Void> updateEventsScore(Principal principal,
                                                  @RequestParam("newScore") int newScore,
                                                  @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateEventsScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/graduation-project-score")
    public ResponseEntity<Void> updateGraduationProjectScore(Principal principal,
                                                             @RequestParam("newScore") int newScore,
                                                             @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateGraduationProjectScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/internship-score")
    public ResponseEntity<Void> updateInternshipScore(Principal principal,
                                                      @RequestParam("newScore") int newScore,
                                                      @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateInternshipScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/language-skills-score")
    public ResponseEntity<Void> updateLanguageSkillsScore(Principal principal,
                                                          @RequestParam("newScore") int newScore,
                                                          @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateLanguageSkillsScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/overseas-study-score")
    public ResponseEntity<Void> updateOverseasStudyScore(Principal principal,
                                                         @RequestParam("newScore") int newScore,
                                                         @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateOverseasStudyScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/qualification-score")
    public ResponseEntity<Void> updateQualificationScore(Principal principal,
                                                         @RequestParam("newScore") int newScore,
                                                         @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateQualificationScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/graduation-score/update/training-score")
    public ResponseEntity<Void> updateTrainingScore(Principal principal,
                                                    @RequestParam("newScore") int newScore,
                                                    @RequestParam("scoreName") String scoreName) {
        String studentId = principal.getName();
        memberService.updateTrainingScore(studentId, newScore, scoreName);
        return ResponseEntity.ok().build();
    }
}
