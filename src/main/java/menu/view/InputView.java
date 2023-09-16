package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String DELIMITER = ",";

    public List<String> readCoaches() {
        System.out.println("코치의 이름을 입력해주세요. (, 로 구분)");
        String input = Console.readLine();
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public List<String> readUnwanted(String coachName) {
        System.out.println(coachName + "(이)가 목 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
