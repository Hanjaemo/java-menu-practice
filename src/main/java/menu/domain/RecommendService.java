package menu.domain;

import java.util.List;
import java.util.Optional;

import camp.nextstep.edu.missionutils.Randoms;

public class RecommendService {

    private final NumberGenerator generator;

    public RecommendService(NumberGenerator generator) {
        this.generator = generator;
    }

    public void recommendCategory() {
        Category category = getCategory();
        RecommendResult.addCategory(category);
    }

    public void recommendMenu(Category category) {
        List<Coach> coaches = CoachRepository.coaches();
        for (Coach coach : coaches) {
            addMenu(category, coach);
        }
    }

    private void addMenu(Category category, Coach coach) {
        List<String> menus = MenuRepository.get(category);
        String menu = Randoms.shuffle(menus).get(0);
        while (coach.unwanted().contains(menu) || coach.isExists(menu)) {
            menu = Randoms.shuffle(menus).get(0);
        }
        coach.addMenu(menu);
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
