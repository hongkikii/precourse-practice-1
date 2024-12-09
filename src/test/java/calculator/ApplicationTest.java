package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 커스텀_구분자_제외_입력이_없는_경우_0을_반환한다() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자가_2자리_이상일_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!@\\n2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_0자리일_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_숫자일_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("기본 구분자, 커스텀 구분자, 양수 이외의 문자가 추출되는 경우 예외가 발생한다.")
    @Test
    void exceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#\\n2:3)5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("기본 구분자, 커스텀 구분자, 양수를 포함할 경우 정상적으로 결과를 출력한다.")
    @Test
    void printTest() {
        assertSimpleTest(() -> {
            run("//;\\n1:2,3;400");
            assertThat(output()).contains("결과 : 406");
        });
    }
}
