package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN = 1;
    private static final int MAX = 5;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
