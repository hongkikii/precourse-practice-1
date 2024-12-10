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

    public int getSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue).sum();
    }

    private void save(String input) {
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf("//") + 5);
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
        numbers.add(parse(numberCandidate));
    }

    private int parse(StringBuilder numberCandidate) {
        try {
            int result = Integer.parseInt(numberCandidate.toString());
            if (result <= 0) {
                throw new IllegalArgumentException();
            }
            return result;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
