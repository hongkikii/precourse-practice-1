package calculator;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> numbers;
    private final Separator separator;

    public Number(String input) {
        this.separator = new Separator(input);
        this.numbers = new ArrayList<>();
    }

    private void validate(String input) {
        // 양수가 아닌 경우 예외 발생
        // 구분자가 아닌 경우 예외 발생
    }
}
