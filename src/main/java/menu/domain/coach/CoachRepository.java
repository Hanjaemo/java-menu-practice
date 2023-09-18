package menu.domain.coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public static void save(List<String> inputCoaches) {
        validate(inputCoaches);
        coaches.addAll(inputCoaches.stream()
                .map(Coach::new)
                .collect(Collectors.toList()));
    }

    public static int size() {
        return coaches.size();
    }

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static void clear() {
        coaches.clear();
    }

    private static void validate(List<String> coaches) {
        if (outOfBounds(coaches)) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명이어야 합니다.");
        }
    }

    private static boolean outOfBounds(List<String> coaches) {
        return !(2 <= coaches.size() && coaches.size() <= 5);
    }
}
