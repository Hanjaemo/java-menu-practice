package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String DELIMITER = ",";

    public List<String> readCoaches() {
        String input = Console.readLine();
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public List<String> readUnwanted() {
        String input = Console.readLine();
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
