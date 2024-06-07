package hannamproject.hanpro.controller;

import hannamproject.hanpro.dto.MemberDto;
import hannamproject.hanpro.entity.BoardPost;
import hannamproject.hanpro.entity.MemberEntity;
import hannamproject.hanpro.service.BoardPostService;
import hannamproject.hanpro.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardPostController {

    private final BoardPostService boardPostService;
    private final LoginService loginService;

    @GetMapping
    public ResponseEntity<List<BoardPost>> getAllPosts() {
        return ResponseEntity.ok(boardPostService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardPost> getPostById(@PathVariable("id") Long id) {
        BoardPost post = boardPostService.getPostById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<BoardPost> createPost(@RequestBody BoardPost post, Principal principal) {
        String authorId = principal.getName();
        MemberDto member = loginService.getMemberDetails(authorId).orElse(null);

        if (member != null) {
            post.setAuthorId(authorId);
            post.setAuthorName(member.getUserName());
            post.setCreatedTime(LocalTime.now());
            return ResponseEntity.status(HttpStatus.CREATED).body(boardPostService.createPost(post));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardPost> updatePost(@PathVariable("id") Long id, @RequestBody BoardPost post, Principal principal) {
        String authorId = principal.getName();
        MemberDto member = loginService.getMemberDetails(authorId).orElse(null);

        if (member != null) {
            post.setAuthorId(authorId);
            post.setAuthorName(member.getUserName());
            return ResponseEntity.ok(boardPostService.updatePost(id, post));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        boardPostService.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
