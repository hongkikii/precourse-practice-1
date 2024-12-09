package calculator;

public class View {
    public void showInputRequestMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void show(int sum) {
        System.out.println("결과 : " + sum);
    }
}
