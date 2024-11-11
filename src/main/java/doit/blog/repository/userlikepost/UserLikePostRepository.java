package doit.blog.repository.userlikepost;

import doit.blog.repository.post.Post;
import doit.blog.repository.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikePostRepository extends JpaRepository<UserLikePost, Long> {

    Boolean existsByUserAndPost(User user, Post post);
}
