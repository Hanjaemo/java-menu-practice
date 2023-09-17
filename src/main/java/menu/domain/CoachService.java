package menu.domain;

import java.util.List;

public class CoachService {

    public void saveCoach(List<String> coaches) {
        coaches.forEach(coach ->
                CoachRepository.save(new Coach(coach))
        );
    }

    public void addUnwantedForCoaches(Coach coach, List<String> unwanted) {
        unwanted.forEach(coach::addUnwanted);
    }
}
