package doit.blog.controller.post.dto;

import doit.blog.repository.post.Post;
import lombok.Builder;

@Builder
public record PostIdResponse(
        Long postId
) {
    public static PostIdResponse from(Post post) {
        return PostIdResponse.builder()
                .postId(post.getId())
                .build();
    }
}
