package menu.domain.coach;

import java.util.List;
import java.util.Set;

import menu.domain.coach.Coach;
import menu.domain.coach.CoachName;
import menu.domain.coach.CoachRepository;

public class CoachService {

    public void saveCoach(List<String> coaches) {
        coaches.forEach(coach ->
                CoachRepository.save(new Coach(
                        new CoachName(coach)
                        )
                )
        );
    }

    public void addUnwantedForCoaches(Coach coach, Set<String> unwanted) {
        coach.addUnwanted(unwanted);
    }
}
