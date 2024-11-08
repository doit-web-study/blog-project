package doit.blog.controller.post.dto;

import doit.blog.repository.category.CategoryType;
import doit.blog.repository.post.Post;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record PostInfoWithUserInfoResponse(
        Long postId,
        String postTitle,
        String postContent,
        String postImage,
        Integer likeCount,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt,
        CategoryType categoryType,
        Long userId,
        String userNickname
) {
}