package menu.domain.coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import menu.domain.coach.Coach;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public static void save(Coach coach) {
        coaches.add(coach);
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
}
