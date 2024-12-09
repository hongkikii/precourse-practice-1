package calculator;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> numbers;
    private final Separator separator;

    public Number(String input, Separator separator) {
        this.separator = separator;
        this.numbers = new ArrayList<>();
        save(input);
    }

    private void save(String input) {
        if (input.startsWith("//")) {
            input = input.substring(2);
        }

        StringBuilder numberCandidate = new StringBuilder();
        for(char c: input.toCharArray()) {
            if(separator.contains(c)) {
                numbers.add(parse(numberCandidate));
                numberCandidate = new StringBuilder();
                continue;
            }
            numberCandidate.append(c);
        }
    }

    private int parse(StringBuilder numberCandidate) {
        try {
            return Integer.parseInt(numberCandidate.toString());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
