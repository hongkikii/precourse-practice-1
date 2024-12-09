package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private final List<Character> separators;

    public Separator(String input) {
        separators = new ArrayList<>();
        separators.add(',');
        separators.add(':');

        if (input.startsWith("//")) {
            int customSeparatorIdx = input.indexOf("//") + 2;
            separators.add(input.charAt(customSeparatorIdx));
        }
    }

    public boolean contains(char c) {
        return separators.contains(c);
    }
}
