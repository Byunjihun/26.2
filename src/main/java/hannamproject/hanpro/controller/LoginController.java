package hannamproject.hanpro.controller;

import hannamproject.hanpro.dto.MemberDto;
import hannamproject.hanpro.security.JwtTokenProvider;
import hannamproject.hanpro.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class LoginController {
    private final LoginService loginService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto memberDto) {
        try {
            MemberDto loginResult = loginService.login(memberDto);
            if (loginResult != null) {
                String token = jwtTokenProvider.createToken(loginResult.getStudentId());
                return ResponseEntity.ok()
                        .header("Authorization", "Bearer " + token)
                        .body(successResponse(loginResult));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse("잘못된 자격 증명"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse("로그인 중 오류 발생"));
        }
    }

    private Map<String, Object> successResponse(MemberDto memberDto) {
        return Map.of(
                "loginSuccess", true,
                "useData", Map.of(
                        "studentId", memberDto.getStudentId(),
                        "userName", memberDto.getUserName(),
                        "department", memberDto.getDepartment(),
                        "year", memberDto.getYear(),
                        "graduationScore", memberDto.getGraduationScore()
                )
        );
    }

    private Map<String, Object> errorResponse(String errorMessage) {
        return Map.of(
                "loginSuccess", false,
                "errorMessage", errorMessage
        );
    }
}
