package doit.blog.controller.post.dto;

public record PostCreateRequest(
        String postTitle,
        String postContent,
        String postImage,
        Long categoryId
) {
}