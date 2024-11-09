package doit.blog.controller.post;

import doit.blog.controller.post.dto.PostCreateRequest;
import doit.blog.controller.post.dto.PostIdResponse;
import doit.blog.controller.post.dto.PostInfoWithUserInfoResponse;
import doit.blog.controller.post.dto.PostUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Post", description = "게시글 관련 API")
public interface PostControllerDocs {

    @Operation(summary = "게시글 작성", description = "게시글을 작성한다.")
    @ApiResponse(responseCode = "200", description = "게시글 작성 성공")
    @ApiResponse(responseCode = "400", description = "게시글 작성 실패")
    PostIdResponse writePost(
            @Schema(description = "게시글 작성 정보", implementation = PostCreateRequest.class)
            PostCreateRequest postCreateRequest
    );

    @Operation(summary = "게시글 수정", description = "게시글을 수정한다.")
    @ApiResponse(responseCode = "200", description = "게시글 수정 성공")
    @ApiResponse(responseCode = "400", description = "게시글 수정 실패")
    PostIdResponse updatePost(
            @Schema(description = "게시글 식별 ID", example = "1")
            Long postId,
            @Schema(description = "게시글 수정 정보", implementation = PostUpdateRequest.class)
            PostUpdateRequest postUpdateRequest
    );

    @Operation(summary = "게시글 삭제", description = "게시글을 삭제한다.")
    @ApiResponse(responseCode = "200", description = "게시글 삭제 성공")
    @ApiResponse(responseCode = "400", description = "게시글 삭제 실패")
    void deletePost(
            @Schema(description = "게시글 식별 ID", example = "1")
            Long postId
    );

    @Operation(summary = "게시글 단건 조회", description = "게시글을 조회한다.")
    @ApiResponse(responseCode = "200", description = "게시글 조회 성공")
    @ApiResponse(responseCode = "400", description = "게시글 조회 실패")
    PostInfoWithUserInfoResponse getPost(
            @Schema(description = "게시글 식별 ID", example = "1")
            Long postId
    );
}
