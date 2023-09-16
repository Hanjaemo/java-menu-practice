package menu.view;

import java.util.List;

public class OutputView {

    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResultMessage(List<String> categories) {
        System.out.println("메뉴 추천 결과입니다.");
    }

    public void printWeek() {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printCategories(List<String> categories) {
        printOpeningBracket();
        System.out.println("카테고리 ");
        categories.forEach(category ->
                System.out.println("| " + category + " ")
        );
        printClosingBracket();
    }

    public void printMenusForCoach(String coach, List<String> menus) {
        printOpeningBracket();
        System.out.println(" " + coach + " ");
        menus.forEach(menu -> 
                System.out.println("| " + menu + " ")
        );
        printClosingBracket();
    }

    public void printEndMessage() {
        System.out.println("추천을 완료했습니다.");
    }

    private void printOpeningBracket() {
        System.out.print(OPENING_BRACKET);
    }

    private void printClosingBracket() {
        System.out.println(CLOSING_BRACKET);
    }
}
