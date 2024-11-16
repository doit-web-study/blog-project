package doit.blog.controller.comment.dto;

import doit.blog.repository.comment.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CommentIdResponse(
        @Schema(description = "댓글 식별 ID", example = "1")
        Long commentId
) {
    public static CommentIdResponse from(Comment comment) {
        return CommentIdResponse.builder()
                .commentId(comment.getId())
                .build();
    }
}
