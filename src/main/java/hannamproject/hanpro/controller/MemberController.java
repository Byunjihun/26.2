package hannamproject.hanpro.controller;

import hannamproject.hanpro.dto.MemberDto;
import hannamproject.hanpro.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto memberDto, HttpSession httpSession, HttpServletResponse response) {
        try {
            MemberDto loginResult = memberService.login(memberDto);
            if (loginResult != null) {
                setSessionAttributes(httpSession, loginResult);
                handleRememberMeOption(memberDto, loginResult, response);
                return ResponseEntity.ok(successResponse(loginResult));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse("잘못된 자격 증명"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse("로그인 중 오류 발생"));
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Map<String, Object>> getLoginForm(HttpServletRequest request) {
        String memberStudentId = getRememberedStudentId(request);
        return ResponseEntity.ok(Map.of("memberStudentId", memberStudentId));
    }

    private void setSessionAttributes(HttpSession session, MemberDto member) {
        session.setAttribute("memberStudentId", member.getMemberStudentId());
        session.setAttribute("memberName", member.getMemberName());
        session.setAttribute("memberDepartment", member.getMemberDepartment());
        session.setAttribute("memberGrade", member.getMemberGrade());
        session.setAttribute("memberGraduationScore", member.getMemberGraduationScore());
    }

    private void handleRememberMeOption(MemberDto memberDto, MemberDto loginResult, HttpServletResponse response) {
        if (memberDto.isRememberMe()) {
            Cookie cookie = new Cookie("memberStudentId", loginResult.getMemberStudentId());
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("memberStudentId", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    private String getRememberedStudentId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("memberStudentId".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private Map<String, Object> successResponse(MemberDto memberDto) {
        return Map.of(
                "loginSuccess", true,
                "useData", Map.of(
                        "memberStudentId", memberDto.getMemberStudentId(),
                        "memberName", memberDto.getMemberName(),
                        "memberDepartment", memberDto.getMemberDepartment(),
                        "memberGrade", memberDto.getMemberGrade(),
                        "memberGraduationScore", memberDto.getMemberGraduationScore()
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
