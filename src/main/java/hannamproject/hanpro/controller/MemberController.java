package hannamproject.hanpro.controller;

import hannamproject.hanpro.dto.MemberDto;
import hannamproject.hanpro.entity.GraduationEntity;
import hannamproject.hanpro.service.MemberService;
import hannamproject.hanpro.service.GraduationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final GraduationService graduationService;

    @GetMapping("/member/login")
    public Object login(@RequestBody MemberDto memberDto, HttpSession httpSession){
        MemberDto loginResult = memberService.login(memberDto);
        if (loginResult != null){
            httpSession.setAttribute("memberStudentId", loginResult.getMemberStudentId());
            httpSession.setAttribute("memberName", loginResult.getMemberName());
            httpSession.setAttribute("memberDepartment", loginResult.getMemberDepartment());
            httpSession.setAttribute("memberGrade", loginResult.getMemberGrade());
            httpSession.setAttribute("memberGraduationScore", loginResult.getMemberGraduationScore());
            return successResponse(loginResult);
        } else {
            return errorResponse("Invalid credentials");
        }
    }

    @GetMapping("/member/login/graduation")
    public ResponseEntity<Object> getGraduationScore(HttpSession httpSession) {
        String memberStudentId = (String) httpSession.getAttribute("memberStudentId");
        if (memberStudentId != null) {
            Optional<GraduationEntity> graduationScore = graduationService.findGraduationScore(memberStudentId);
            return graduationScore
                    .map(score -> ResponseEntity.ok((Object) Map.of("totalScore", score.getTotalScore())))
                    .orElseGet(() -> new ResponseEntity<>(errorResponse("Graduation score not found"), HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(errorResponse("Invalid credentials"), HttpStatus.UNAUTHORIZED);
        }
    }

    private Object successResponse(MemberDto memberDto){
        return Map.of(
                "loginSuccess", true,
                "userData", Map.of(
                        "memberStudentId", memberDto.getMemberStudentId(),
                        "memberName", memberDto.getMemberName(),
                        "memberDepartment", memberDto.getMemberDepartment(),
                        "memberGrade", memberDto.getMemberGrade(),
                        "memberGraduationScore", memberDto.getMemberGraduationScore()
                )
        );
    }

    private Object errorResponse(String errorMessage) {
        return Map.of("loginSuccess", false, "errorMessage", errorMessage);
    }
}
