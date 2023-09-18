package menu.domain;

import java.util.List;
import java.util.Set;

public class CoachService {

    public void saveCoach(List<String> coaches) {
        coaches.forEach(coach ->
                CoachRepository.save(new Coach(
                        new Name(coach)
                        )
                )
        );
    }

    public void addUnwantedForCoaches(Coach coach, Set<String> unwanted) {
        coach.addUnwanted(unwanted);
    }
}
