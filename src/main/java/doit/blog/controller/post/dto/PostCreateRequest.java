package doit.blog.controller.post.dto;

import doit.blog.repository.post.Post;

public record PostCreateRequest(
        String postTitle,
        String postContent,
        String postImage,
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