package hannamproject.hanpro.service;

import hannamproject.hanpro.entity.BoardPost;
import hannamproject.hanpro.repository.BoardPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardPostService {

    private final BoardPostRepository boardPostRepository;

    public List<BoardPost> getAllPosts() {
        return boardPostRepository.findAll();
    }

    public BoardPost getPostById(Long id) {
        return boardPostRepository.findById(id).orElse(null);
    }

    public BoardPost createPost(BoardPost post) {
        post.setCreatedTime(LocalTime.now());
        return boardPostRepository.save(post);
    }

    public BoardPost updatePost(Long id, BoardPost updatedPost) {
        return boardPostRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    post.setAuthorId(updatedPost.getAuthorId());  // Set authorId to the updating user
                    post.setAuthorName(updatedPost.getAuthorName());  // Set authorName to the updating user's name
                    post.setCreatedDate(post.getCreatedDate());
                    post.setCreatedTime(post.getCreatedTime());
                    return boardPostRepository.save(post);
                }).orElse(null);
    }

    public void deletePost(Long id) {
        boardPostRepository.deleteById(id);
    }
}
