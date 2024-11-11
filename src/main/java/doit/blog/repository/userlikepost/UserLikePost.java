package doit.blog.repository.userlikepost;

import doit.blog.repository.BaseEntity;
import doit.blog.repository.post.Post;
import doit.blog.repository.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "\"user\"")
public class UserLikePost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Builder
    private UserLikePost(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public static UserLikePost create(User user, Post post) {
        return UserLikePost.builder()
                .user(user)
                .post(post)
                .build();
    }
}
