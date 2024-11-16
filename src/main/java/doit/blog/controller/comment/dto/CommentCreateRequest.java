package doit.blog.controller.comment.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CommentCreateRequest(
        @Schema(description = "댓글 내용", example = "댓글 생성 내용입니다.")
        String commentContent
) {
}
