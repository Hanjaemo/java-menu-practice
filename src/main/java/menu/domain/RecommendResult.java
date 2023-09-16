package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendResult {

    private static final int CATEGORY_RECOMMENDATION_LIMIT = 2;

    private static final List<Category> categories = new ArrayList<>();

    public static List<Category> categories() {
        return Collections.unmodifiableList(categories);
    }

    public static void addCategory(Category category) {
        categories.add(category);
    }

    public static boolean isOverCategoryRecommendLimit(Category category) {
        long recommendedCount = categories.stream()
                .filter(c -> c == category)
                .count();
        return recommendedCount > CATEGORY_RECOMMENDATION_LIMIT;
    }

    public static void clear() {
        categories.clear();
    }
}
