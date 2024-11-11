package doit.blog.controller.comment;

import doit.blog.controller.ListWrapper;
import doit.blog.controller.comment.dto.CommentIdResponse;
import doit.blog.controller.comment.dto.CommentInfoResponse;
import doit.blog.controller.comment.dto.CommentUpdateRequest;
import doit.blog.controller.comment.dto.CommentCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Comment", description = "댓글 관련 API")
public interface CommentControllerDocs {

    @Operation(summary = "댓글 작성", description = "게시글에 새로운 댓글을 작성한다.")
    @ApiResponse(responseCode = "200", description = "댓글 작성 성공")
    CommentIdResponse addNewComment(
            @Schema(description = "게시글 식별 ID", example = "1")
            Long postId,
            @Schema(description = "새롭게 추가할 댓글 내용", implementation = CommentCreateRequest.class)
            CommentCreateRequest commentCreateRequest
    );

    @Operation(summary = "댓글 삭제", description = "댓글을 삭제한다.")
    @ApiResponse(responseCode = "200", description = "댓글 삭제 성공")
    void deleteComment(
            @Schema(description = "게시글 식별 ID", example = "1")
            Long postId,
            @Schema(description = "삭제할 댓글 식별 ID", example = "1")
            Long commentId
    );

    @Operation(summary = "댓글 수정", description = "댓글을 수정한다.")
    @ApiResponse(responseCode = "200", description = "댓글 수정 성공")
    CommentIdResponse updateComment(
            @Schema(description = "게시글 식별 ID", example = "1")
            Long postId,
            @Schema(description = "수정할 댓글 식별 ID", example = "1")
            Long commentId,
            @Schema(description = "수정할 댓글 내용", implementation = CommentUpdateRequest.class)
            CommentUpdateRequest commentUpdateRequest
    );

    @Operation(summary = "게시글 댓글 불러오기", description = "게시글에 달린 댓글을 불러온다.")
    @ApiResponse(responseCode = "200", description = "게시글 댓글 불러오기 성공")
    ListWrapper<CommentInfoResponse> getComments(
            @Schema(description = "게시글 식별 ID", example = "1")
            Long postId
    );

}
