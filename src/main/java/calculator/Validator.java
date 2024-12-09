package calculator;

import java.util.regex.Pattern;

public class Validator {
    public static void validate(String input) {
        // 커스텀 구분자가 존재하는 경우
        if(input.startsWith("//") && input.contains("\\n")) {
            int start = input.indexOf("//") + 2;
            int end = input.indexOf("\\n") - 1;

            if(end - start != 0) { // 1자리가 아닌 경우
                throw new IllegalArgumentException();
            }
            if(Pattern.matches("^[0-9]+", input.substring(start, end+1))) { // 숫자인 경우
                throw new IllegalArgumentException();
            }
            return;
        }

        // 커스텀 구분자가 존재하지 않는 경우
        if (!Pattern.matches("[0-9|,:]*", input)) { // 기본 구분자, 숫자 이외의 문자를 포함한 경우
            throw new IllegalArgumentException();
        }
    }
}
