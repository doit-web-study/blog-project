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
    public static PostInfoWithUserInfoResponse from(Post post) {
        return PostInfoWithUserInfoResponse.builder()
                .postId(post.getId())
                .postTitle(post.getTitle())
                .postContent(post.getContent())
                .postImage(post.getImage())
                .likeCount(post.getLikeCount())
                .createdAt(post.getCreatedAt())
                .modifiedAt(post.getModifiedAt())
                .categoryType(post.getCategory().getType())
                .userId(post.getUser().getId())
                .userNickname(post.getUser().getNickname())
                .build();
    }
}