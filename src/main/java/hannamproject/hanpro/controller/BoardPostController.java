
package hannamproject.hanpro.controller;

import hannamproject.hanpro.entity.BoardPost;
import hannamproject.hanpro.service.BoardPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardPostController {

    private final BoardPostService boardPostService;

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
        post.setAuthor(principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(boardPostService.createPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardPost> updatePost(@PathVariable("id") Long id, @RequestBody BoardPost post) {
        BoardPost updatedPost = boardPostService.updatePost(id, post);
        return updatedPost != null ? ResponseEntity.ok(updatedPost) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        boardPostService.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
