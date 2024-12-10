package calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Separator {
    private final Set<Character> separators;

    public Separator(String input) {
        separators = new HashSet<>();
        separators.add(',');
        separators.add(':');

        if (input.startsWith("//")) {
            validateCustom(input);
            separators.add(input.charAt(getCustomStartIdx(input)));
        }
    }

    public boolean contains(char c) {
        return separators.contains(c);
    }

    private void validateCustom(String input) {
        int start = getCustomStartIdx(input);
        int end = input.indexOf("\\n") - 1;

        if(end - start != 0) { // 1자리가 아닌 경우
            throw new IllegalArgumentException();
        }
        if(Pattern.matches("^[0-9]+", input.substring(start, end+1))) { // 숫자인 경우
            throw new IllegalArgumentException();
        }
    }

    private int getCustomStartIdx(String input) {
        return input.indexOf("//") + 2;
    }
}
