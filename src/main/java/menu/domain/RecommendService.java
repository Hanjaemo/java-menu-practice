package menu.domain;

import java.util.Optional;

public class RecommendService {

    private final NumberGenerator generator;

    public RecommendService(NumberGenerator generator) {
        this.generator = generator;
    }

    public void recommendCategory() {
        Category category = getCategory();
        RecommendResult.addCategory(category);
    }

    private Category getCategory() {
        Optional<Category> category = getOptionalCategory();
        while (category.isEmpty() || RecommendResult.isOverCategoryRecommendLimit(category.get())) {
            category = getOptionalCategory();
        }
        return category.get();
    }

    private Optional<Category> getOptionalCategory() {
        return Category.of(generator.generate());
    }
}
