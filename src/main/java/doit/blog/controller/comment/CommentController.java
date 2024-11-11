package doit.blog.controller.comment;

import doit.blog.controller.ListWrapper;
import doit.blog.controller.comment.dto.CommentCreateRequest;
import doit.blog.controller.comment.dto.CommentIdResponse;
import doit.blog.controller.comment.dto.CommentInfoResponse;
import doit.blog.controller.comment.dto.CommentUpdateRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController implements CommentControllerDocs {


    @PostMapping
    public CommentIdResponse addNewComment(@PathVariable Long postId,
                                           @RequestBody CommentCreateRequest commentCreateRequest) {
        return null;
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long postId,
                              @PathVariable Long commentId) {

    }

    @PutMapping("/{commentId}")
    public CommentIdResponse updateComment(@PathVariable Long postId,
                                           @PathVariable Long commentId,
                                           @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return null;
    }

    @GetMapping
    public ListWrapper<CommentInfoResponse> getComments(@PathVariable Long postId) {
        return null;
    }
}
