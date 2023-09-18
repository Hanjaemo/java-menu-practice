package menu;

import menu.controller.RecommendController;
import menu.domain.coach.CoachService;
import menu.domain.menu.MenuRepository;
import menu.utils.RandomNumberGenerator;
import menu.domain.recommend.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuRepository.init(new MenuConfig());
        RecommendController controller = new RecommendController(
                new RecommendService(new RandomNumberGenerator()),
                new CoachService(),
                new InputView(),
                new OutputView()
        );
        controller.start();
    }
}
