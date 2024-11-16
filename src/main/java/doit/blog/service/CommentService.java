package doit.blog.service;

import doit.blog.controller.comment.dto.CommentCreateRequest;
import doit.blog.controller.comment.dto.CommentIdResponse;
import doit.blog.controller.comment.dto.CommentInfoResponse;
import doit.blog.controller.comment.dto.CommentUpdateRequest;
import doit.blog.repository.comment.Comment;
import doit.blog.repository.comment.CommentRepository;
import doit.blog.repository.post.Post;
import doit.blog.repository.post.PostRepository;
import doit.blog.repository.user.User;
import doit.blog.repository.user.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public CommentIdResponse createComment(Long postId, CommentCreateRequest request, Long userId) {
        User user = userRepository.getById(userId);
        Post post = postRepository.getById(postId);

        Comment comment = Comment.create(request.commentContent(), post, user);
        commentRepository.save(comment);

        return CommentIdResponse.from(comment);
    }

    public void deleteComment(Long postId, Long commentId, Long userId) {
        Post post = postRepository.getById(postId);
        Comment comment = commentRepository.getById(commentId);
        User user = userRepository.getById(userId);

        if (!comment.isWrittenBy(user)) {
            throw new IllegalArgumentException("작성자만 삭제할 수 있습니다.");
        }

        commentRepository.deleteById(commentId);
    }

    public CommentIdResponse updateComment(Long postId, Long commentId, CommentUpdateRequest request, Long userId) {
        Post post = postRepository.getById(postId);
        Comment comment = commentRepository.getById(commentId);
        User user = userRepository.getById(userId);

        if (!comment.isWrittenBy(user)) {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        }

        comment.update(request.commentContent());
        commentRepository.save(comment);

        return CommentIdResponse.from(comment);
    }

    public List<CommentInfoResponse> getComments(Long postId) {
        Post post = postRepository.getById(postId);
        List<Comment> comments = commentRepository.findAllByPost(post);

        return comments.stream()
                .map(CommentInfoResponse::from)
                .toList();
    }
}
