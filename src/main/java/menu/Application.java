package menu;

import menu.controller.RecommendController;
import menu.domain.RandomNumberGenerator;
import menu.domain.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RecommendController controller = new RecommendController(
                new MenuConfig(),
                new RecommendService(new RandomNumberGenerator()),
                new InputView(),
                new OutputView()
        );
        controller.start();
    }
}
