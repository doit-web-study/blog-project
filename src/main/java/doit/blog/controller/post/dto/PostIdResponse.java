package doit.blog.controller.post.dto;

import doit.blog.repository.post.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record PostIdResponse(
        @Schema(description = "게시글 식별 ID", example = "1")
        Long postId
) {
    public static PostIdResponse from(Post post) {
        return PostIdResponse.builder()
                .postId(post.getId())
                .build();
    }
}
