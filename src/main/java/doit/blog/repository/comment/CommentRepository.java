package doit.blog.repository.comment;

import doit.blog.repository.post.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    default Comment getById(Long commentId) {
        return findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));
    }

    List<Comment> findAllByPost(Post post);
}
