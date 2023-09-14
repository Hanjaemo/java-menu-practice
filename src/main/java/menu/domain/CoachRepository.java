package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public static void save(Coach coach) {
        coaches.add(coach);
    }

    public static int size() {
        return coaches.size();
    }
}
