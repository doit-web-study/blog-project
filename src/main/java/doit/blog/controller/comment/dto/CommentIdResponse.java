package doit.blog.controller.comment.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CommentIdResponse(
        @Schema(description = "댓글 식별 ID", example = "1")
        Long commentId
) {
}
