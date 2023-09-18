package menu.domain.menu;

import java.util.Arrays;
import java.util.Optional;

public enum Category {

    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String name;
    private final int number;

    Category(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static Optional<Category> of(int number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.number == number)
                .findFirst();
    }

    public String getName() {
        return name;
    }
}
