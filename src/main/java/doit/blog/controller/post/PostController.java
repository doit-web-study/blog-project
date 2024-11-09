package doit.blog.controller.post;

import doit.blog.controller.post.dto.PostCreateRequest;
import doit.blog.controller.post.dto.PostIdResponse;
import doit.blog.controller.post.dto.PostInfoWithUserInfoResponse;
import doit.blog.controller.post.dto.PostUpdateRequest;
import doit.blog.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController implements PostControllerDocs{
    private final HttpSession session;
    private final PostService postService;

    @PostMapping
    public PostIdResponse writePost(@RequestBody PostCreateRequest request) {
        Long userId = (Long) session.getAttribute("userId");
        return postService.createPost(request, userId);
    }

    @PutMapping("/{postId}")
    public PostIdResponse updatePost(@PathVariable Long postId,
                                     @RequestBody PostUpdateRequest request) {
        Long userId = (Long) session.getAttribute("userId");
        return postService.updatePost(postId, request, userId);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        Long userId = (Long) session.getAttribute("userId");
        postService.deletePost(postId, userId);
    }

    @GetMapping("/{postId}")
    public PostInfoWithUserInfoResponse getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }
}
