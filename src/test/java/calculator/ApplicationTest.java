package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 빈_문자열이_입력될_시_0을_반환한다() {
        assertSimpleTest(() -> {
            run("");
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
}
