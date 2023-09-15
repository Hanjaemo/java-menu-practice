package menu.domain;

import java.util.HashSet;
import java.util.Set;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MAX_UNWANTED_SIZE = 2;

    private String name;
    private Set<String> unwanted = new HashSet<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    public void addUnwanted(String menu) {
        if (isMaxSize(unwanted.size())) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최대 2개까지만 등록 가능합니다.");
        }
        if (containsMenuRepositoryFail(menu)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
        }
        if (contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 메뉴를 등록할 수 없습니다.");
        }
        unwanted.add(menu);
    }

    private boolean contains(String menu) {
        return unwanted.contains(menu);
    }

    public Set<String> getUnwanted() {
        return unwanted;
    }

    private void validate(String name) {
        if (isLengthOutOfBounds(name.length())) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 이상이어야 합니다.");
        }
    }

    private boolean containsMenuRepositoryFail(String menu) {
        return !MenuRepository.contains(menu);
    }

    private boolean isLengthOutOfBounds(int length) {
        return !(MIN_NAME_LENGTH <= length && length <= MAX_NAME_LENGTH);
    }

    private boolean isMaxSize(int size) {
        return size == MAX_UNWANTED_SIZE;
    }
}
