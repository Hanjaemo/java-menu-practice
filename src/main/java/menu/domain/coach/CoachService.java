package menu.domain.coach;

import java.util.List;
import java.util.Set;

public class CoachService {

    public void saveCoach(List<String> coaches) {
        CoachRepository.save(coaches);
    }

    public List<Coach> coaches() {
        return CoachRepository.coaches();
    }

    public void addUnwantedForCoaches(Coach coach, Set<String> unwanted) {
        coach.addUnwanted(unwanted);
    }
}
