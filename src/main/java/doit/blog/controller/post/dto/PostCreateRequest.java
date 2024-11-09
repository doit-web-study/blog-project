package doit.blog.controller.post.dto;

import doit.blog.repository.post.Post;
import io.swagger.v3.oas.annotations.media.Schema;

public record PostCreateRequest(
        @Schema(description = "게시글 제목", example = "상체 운동 루틴 추천해주세요.")
        String postTitle,
        @Schema(description = "게시글 내용", example = "제목이 곧 내용입니다.")
        String postContent,
        @Schema(description = "게시글 이미지", example = "https://image.url")
        String postImage,
        @Schema(description = "카테고리 식별 ID", example = "1")
        Long categoryId
) {
    public Post toEntity() {
        return Post.builder()
                .title(postTitle)
                .content(postContent)
                .image(postImage)
                .build();
    }
}