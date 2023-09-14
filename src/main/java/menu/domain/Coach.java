package menu.domain;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private String name;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isLengthOutOfBounds(name.length())) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 이상이어야 합니다.");
        }
    }

    private boolean isLengthOutOfBounds(int length) {
        return !(MIN_NAME_LENGTH <= length && length <= MAX_NAME_LENGTH);
    }
}
