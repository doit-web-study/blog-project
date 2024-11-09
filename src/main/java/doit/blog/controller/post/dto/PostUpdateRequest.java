package doit.blog.controller.post.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public record PostUpdateRequest(
        @Schema(description = "게시글 내용", example = "헬린이입니다.")
        String postContent,
        @Schema(description = "게시글 이미지", example = "https://image.url")
        String postImage,
        @Schema(description = "카테고리 식별 ID", example = "1")
        Long categoryId
) {
}
