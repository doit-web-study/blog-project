package doit.blog.controller.comment;

import doit.blog.controller.ListWrapper;
import doit.blog.controller.comment.dto.CommentCreateRequest;
import doit.blog.controller.comment.dto.CommentIdResponse;
import doit.blog.controller.comment.dto.CommentInfoResponse;
import doit.blog.controller.comment.dto.CommentUpdateRequest;
import doit.blog.service.CommentService;
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
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController implements CommentControllerDocs {
    private final HttpSession session;
    private final CommentService commentService;

    @PostMapping
    public CommentIdResponse addNewComment(@PathVariable Long postId,
                                           @RequestBody CommentCreateRequest commentCreateRequest) {
        Long userId = (Long) session.getAttribute("userId");
        return commentService.createComment(postId, commentCreateRequest, userId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long postId,
                              @PathVariable Long commentId) {
        Long userId = (Long) session.getAttribute("userId");
        commentService.deleteComment(postId, commentId, userId);
    }

    @PutMapping("/{commentId}")
    public CommentIdResponse updateComment(@PathVariable Long postId,
                                           @PathVariable Long commentId,
                                           @RequestBody CommentUpdateRequest commentUpdateRequest) {
        Long userId = (Long) session.getAttribute("userId");
        return commentService.updateComment(postId, commentId, commentUpdateRequest, userId);
    }

    @GetMapping
    public ListWrapper<CommentInfoResponse> getComments(@PathVariable Long postId) {
        return ListWrapper.of(commentService.getComments(postId));
    }
}
