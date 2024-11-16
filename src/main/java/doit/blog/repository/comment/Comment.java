package doit.blog.repository.comment;

import doit.blog.repository.BaseEntity;
import doit.blog.repository.post.Post;
import doit.blog.repository.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    private Comment(String content, Post post, User user) {
        this.content = content;
        this.post = post;
        this.user = user;
    }

    public static Comment create(String content, Post post, User user) {
        return Comment.builder()
                .content(content)
                .post(post)
                .user(user)
                .build();
    }

    public boolean isWrittenBy(User user) {
        return this.user.equals(user);
    }

    public void update(String content) {
        this.content = content;
    }
}
