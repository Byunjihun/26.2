package hannamproject.hanpro.service;

import hannamproject.hanpro.entity.BoardPost;
import hannamproject.hanpro.repository.BoardPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return boardPostRepository.save(post);
    }

    public BoardPost updatePost(Long id, BoardPost updatedPost) {
        return boardPostRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    post.setAuthor(updatedPost.getAuthor());
                    post.setAuthorName(updatedPost.getAuthorName());
                    return boardPostRepository.save(post);
                }).orElse(null);
    }

    public void deletePost(Long id) {
        boardPostRepository.deleteById(id);
    }
}
