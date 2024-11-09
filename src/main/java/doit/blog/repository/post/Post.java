package doit.blog.repository.post;

import doit.blog.controller.post.dto.PostUpdateRequest;
import doit.blog.repository.BaseEntity;
import doit.blog.repository.category.Category;
import doit.blog.repository.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "\"post\"")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String image;

    private Integer likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Builder
    private Post(String title, String content, String image, User user, Category category) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.likeCount = 0;
        this.user = user;
        this.category = category;
    }

    public static Post create(String title, String content, String image, User user, Category category) {
        return Post.builder()
                .title(title)
                .content(content)
                .image(image)
                .user(user)
                .category(category)
                .build();
    }

    public void update(String content, String image, Category category) {
        this.content = content;
        this.image = image;
        this.category = category;
    }

    public boolean isWrittenBy(User user) {
        return this.user.equals(user);
    }
}
