package doit.blog.controller.post.dto;

import doit.blog.repository.category.CategoryType;
import doit.blog.repository.post.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record PostInfoWithUserInfoResponse(
        @Schema(description = "게시글 식별 ID", example = "1")
        Long postId,
        @Schema(description = "게시글 제목", example = "저녁 메뉴 추천해주세요.")
        String postTitle,
        @Schema(description = "게시글 내용", example = "제목이 곧 내용입니다.")
        String postContent,
        @Schema(description = "게시글 이미지", example = "https://image.url")
        String postImage,
        @Schema(description = "좋아요 수", example = "0")
        Integer likeCount,
        @Schema(description = "게시글 생성일시", example = "2024-07-01T00:00:00")
        LocalDateTime createdAt,
        @Schema(description = "게시글 수정일시", example = "2024-07-01T00:00:00")
        LocalDateTime modifiedAt,
        @Schema(description = "카테고리 타입", example = "SPORTS")
        CategoryType categoryType,
        @Schema(description = "유저 식별 ID", example = "1")
        Long userId,
        @Schema(description = "유저 닉네임", example = "doit")
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