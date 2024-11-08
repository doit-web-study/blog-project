package doit.blog.controller.post;

import doit.blog.controller.post.dto.PostCreateRequest;
import doit.blog.controller.post.dto.PostIdResponse;
import doit.blog.controller.post.dto.PostInfoWithUserInfoResponse;
import doit.blog.controller.post.dto.PostUpdateRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController implements PostControllerDocs{

    @PostMapping
    public PostIdResponse writePost(@RequestBody PostCreateRequest request) {
        return null;
    }

    @PutMapping("/{postId}")
    public PostIdResponse updatePost(@PathVariable Long postId) {
        return null;
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {

    }

    @GetMapping("/{postId}")
    public PostInfoWithUserInfoResponse getPost(@PathVariable Long postId) {
        return null;
    }
}
