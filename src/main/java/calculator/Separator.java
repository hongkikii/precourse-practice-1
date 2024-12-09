package calculator;

import java.util.HashSet;
import java.util.Set;

public class Separator {
    private final Set<Character> separators;

    public Separator(String input) {
        separators = new HashSet<>();
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
