package doit.blog.controller.comment.dto;

import doit.blog.repository.comment.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

public record CommentInfoResponse(
        @Schema(description = "댓글 식별 ID", example = "1")
        Long commentId,
        @Schema(description = "댓글 내용", example = "댓글 내용입니다.")
        String commentContent,
        @Schema(description = "댓글 생성일시", example = "2024-07-01T00:00:00")
        LocalDateTime createdAt,
        @Schema(description = "댓글 수정일시", example = "2024-07-01T00:00:00")
        LocalDateTime modifiedAt
) {
    public static CommentInfoResponse from(Comment comment) {
        return new CommentInfoResponse(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }
}
