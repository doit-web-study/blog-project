package doit.blog.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    default Post getById(Long postId) {
        return this.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 게시글이 없습니다."));
    }
}
