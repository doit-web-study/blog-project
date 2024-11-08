package doit.blog.controller.post.dto;


public record PostUpdateRequest(
        String postContent,
        String postImage,
        Long categoryId
) {
}
