package hannamproject.hanpro.controller;

import hannamproject.hanpro.service.MemberImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/member/image")
@RequiredArgsConstructor
public class MemberImageController {

    private final MemberImageService memberImageService;

    @GetMapping
    public ResponseEntity<String> getImagePath(Principal principal) {
        String studentId = principal.getName();
        return memberImageService.getImagePathByStudentId(studentId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Void> saveImagePath(@RequestParam("imagePath") String imagePath, Principal principal) {
        String studentId = principal.getName();
        memberImageService.saveMemberImage(studentId, imagePath);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
