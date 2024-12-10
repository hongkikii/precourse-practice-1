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
        try {
            int sum = numbers.stream()
                    .mapToInt(Integer::intValue).sum();
            if(sum < 0) {
                throw new IllegalArgumentException();
            }
            return sum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
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
        if(numberCandidate.length() > 0) {
            numbers.add(parse(numberCandidate));
        }
    }

    private int parse(StringBuilder numberCandidate) {
        try {
            int result = Integer.parseInt(numberCandidate.toString());
            if (result <= 0 || result > 21_0000_0000) {
                throw new IllegalArgumentException();
            }
            return result;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
