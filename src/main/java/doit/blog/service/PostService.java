package doit.blog.service;

import doit.blog.controller.post.dto.PostCreateRequest;
import doit.blog.controller.post.dto.PostIdResponse;
import doit.blog.controller.post.dto.PostInfoWithUserInfoResponse;
import doit.blog.controller.post.dto.PostUpdateRequest;
import doit.blog.repository.category.Category;
import doit.blog.repository.category.CategoryRepository;
import doit.blog.repository.post.Post;
import doit.blog.repository.post.PostRepository;
import doit.blog.repository.user.User;
import doit.blog.repository.user.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public PostIdResponse createPost(PostCreateRequest request, Long userId) {
        User user = userRepository.getById(userId);
        Category category = categoryRepository.getById(request.categoryId());

        Post post = Post.create(request.postTitle(), request.postContent(), request.postImage(), user, category);
        postRepository.save(post);

        return PostIdResponse.from(post);
    }

    public PostIdResponse updatePost(Long postId, PostUpdateRequest request, Long userId) {
        Post post = postRepository.getById(postId);
        User user = userRepository.getById(userId);
        Category category = categoryRepository.getById(request.categoryId());

        if (!post.isWrittenBy(user)) {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        }

        post.update(request.postContent(), request.postImage(), category);
        postRepository.save(post);

        return PostIdResponse.from(post);
    }

    public void deletePost(Long postId, Long userId) {
        Post post = postRepository.getById(postId);
        User user = userRepository.getById(userId);

        if (!post.isWrittenBy(user)) {
            throw new IllegalArgumentException("작성자만 삭제할 수 있습니다.");
        }

        postRepository.deleteById(postId);
    }

    public PostInfoWithUserInfoResponse getPost(Long postId) {
        Post post = postRepository.getById(postId);
        return PostInfoWithUserInfoResponse.from(post);
    }

    public List<PostInfoWithUserInfoResponse> getPosts(String keyword, Long categoryId) {
        // 카테고리가 없는 경우, 전체 카테고리로 설정
        boolean categoryCondition = categoryId != null;
        Category category = categoryCondition ? categoryRepository.getById(categoryId) : null;

        // 키워드가 없는 경우, 전체 키워드로 설정
        boolean keywordCondition = !(keyword == null || keyword.isBlank());

        List<Post> posts;

        if (keywordCondition && categoryCondition) {
            // 키워드, 카테고리 모두 있는 경우
            keyword = "%" + keyword + "%";
            posts = postRepository.findAllByTitleLikeAndCategory(keyword, category);
        } else if (categoryCondition) {
            // 카테고리만 있는 경우
            posts = postRepository.findAllByCategory(category);
        } else if (keywordCondition) {
            // 키워드만 있는 경우
            keyword = "%" + keyword + "%";
            posts = postRepository.findAllByTitleLike(keyword);
        } else {
            posts = postRepository.findAll();
        }

        return posts.stream()
                .map(PostInfoWithUserInfoResponse::from)
                .toList();
    }
}
