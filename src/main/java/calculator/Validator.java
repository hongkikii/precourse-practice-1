package calculator;

import java.util.regex.Pattern;

public class Validator {
    public static void validate(String input) {
        // 커스텀 구분자가 존재하는 경우
        if(input.startsWith("//") && input.contains("\\n")) { // 커스텀 구분자 정의 규칙을 잘 지키는지
            return;
        }

        // 커스텀 구분자가 존재하지 않는 경우
        if (!Pattern.matches("[0-9|,:]*", input)) { // 기본 구분자, 숫자 이외의 문자를 포함한 경우
            throw new IllegalArgumentException();
        }
    }
}
