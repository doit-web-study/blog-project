package doit.blog.common.data;

import doit.blog.repository.category.Category;
import doit.blog.repository.category.CategoryRepository;
import doit.blog.repository.category.CategoryType;
import jakarta.annotation.PostConstruct;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final CategoryRepository categoryRepository;

    @PostConstruct
    public void init() {
        if (categoryRepository.count() > 0) {
            return;
        }

        Arrays.stream(CategoryType.values())
            .map(Category::create)
            .forEach(categoryRepository::save);
    }
}
