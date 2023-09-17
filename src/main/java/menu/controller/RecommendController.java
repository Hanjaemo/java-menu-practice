package menu.controller;

import java.util.stream.Collectors;

import menu.MenuConfig;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.MenuRepository;
import menu.domain.RecommendResult;
import menu.domain.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private static final int DAYS = 5;

    private final RecommendService recommendService;
    private final InputView inputView;
    private final OutputView outputView;

    public RecommendController(RecommendService recommendService,
                               InputView inputView,
                               OutputView outputView) {
        this.recommendService = recommendService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {

        outputView.printStartMessage();
        saveCoaches();
        addUnwantedForCoaches();
        recommend();
        printResult();
        outputView.printEndMessage();
    }

    private void recommend() {
        for (int i = 0; i < DAYS; i++) {
            recommendService.recommendCategory();
            recommendService.recommendMenu(RecommendResult.categories().get(i));
        }
    }

    private void printResult() {
        outputView.printResultMessage();
        outputView.printWeek();
        outputView.printCategories(RecommendResult.categories()
                .stream()
                .map(Category::getName)
                .collect(Collectors.toList())
        );
        printMenus();
    }

    private void printMenus() {
        CoachRepository.coaches()
                .forEach(coach -> outputView.printMenusForCoach(coach.getName(), coach.menus()));
    }

    private void addUnwantedForCoaches() {
        CoachRepository.coaches()
                .forEach(coach -> inputView.readUnwanted(coach.getName()));
    }

    private void saveCoaches() {
        inputView.readCoaches()
                .forEach(coach -> 
                        CoachRepository.save(new Coach(coach))
                );
    }
}
