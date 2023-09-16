package menu.domain;

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
//                .orElseThrow(() -> new NoSuchElementException("[ERROR] 존재하지 않는 카테고리입니다."));
    }

    public String getName() {
        return name;
    }
}
