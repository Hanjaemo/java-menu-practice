package menu.controller;

import java.util.stream.Collectors;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.CoachService;
import menu.domain.RecommendResult;
import menu.domain.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {

    private static final int DAYS = 5;

    private final RecommendService recommendService;
    private final CoachService coachService;
    private final InputView inputView;
    private final OutputView outputView;

    public RecommendController(RecommendService recommendService,
                               CoachService coachService,
                               InputView inputView,
                               OutputView outputView) {
        this.recommendService = recommendService;
        this.coachService = coachService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        printStartMessage();
        saveCoaches();
        addUnwantedForCoaches();
        recommend();
        printResult();
        printEndMessage();
    }

    private void printStartMessage() {
        outputView.printStartMessage();
    }

    private void saveCoaches() {
        coachService.saveCoach(inputView.readCoaches());
    }

    private void addUnwantedForCoaches() {
        CoachRepository.coaches()
                .forEach(coach ->
                        coachService.addUnwantedForCoaches(coach, inputView.readUnwanted(coach.getName()))
                );
    }

    private void recommend() {
        for (int day = 0; day < DAYS; day++) {
            recommendService.recommendCategory();
            recommendService.recommendMenu(RecommendResult.getCategoryOfDay(day));
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

    private void printEndMessage() {
        outputView.printEndMessage();
    }
}
