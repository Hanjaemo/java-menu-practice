package menu.domain;

import java.util.List;

public class CoachService {

    public void saveCoach(List<String> coaches) {
        coaches.forEach(coach ->
                CoachRepository.save(new Coach(coach))
        );
    }
}
