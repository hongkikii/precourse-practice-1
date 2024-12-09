package calculator;

import static calculator.Validator.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View view = new View();
        view.showInputRequestMessage();

        String input = Console.readLine();
        validate(input);

        Separator separator = new Separator(input);
        Number number = new Number(input, separator);
        int sum = number.getSum();

        view.show(sum);
    }
}
