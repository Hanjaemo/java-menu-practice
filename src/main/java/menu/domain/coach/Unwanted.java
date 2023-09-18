package menu.domain.coach;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import menu.domain.menu.MenuRepository;

public class Unwanted {

    private static final int MAX_UNWANTED_SIZE = 2;
    private static final String BLANK = "";

    private final Set<String> unwanted = new HashSet<>();

    public Unwanted(Set<String> unwanted) {
        if (unwanted.contains(BLANK)) {
            return;
        }
        validate(unwanted);
        this.unwanted.addAll(unwanted);
    }

    public Set<String> unwanted() {
        return Collections.unmodifiableSet(unwanted);
    }

    private void validate(Set<String> unwanted) {
        validateOverSize(unwanted);
        for (String once : unwanted) {
            validateExists(once);
        }
    }

    private void validateOverSize(Set<String> unwanted) {
        if (isOverMaxSize(unwanted.size())) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최대 2개까지만 등록 가능합니다.");
        }
    }

    private boolean isOverMaxSize(int size) {
        return size == MAX_UNWANTED_SIZE;
    }

    private void validateExists(String unwantedMenu) {
        if (containsMenuRepositoryFail(unwantedMenu)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
        }
    }

    private boolean containsMenuRepositoryFail(String menu) {
        return !MenuRepository.contains(menu);
    }
}
