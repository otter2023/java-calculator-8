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
    void 구분자_외의_문자테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자와 숫자 이외의 문자가 있습니다.")
        );
    }

    @Test
    void 문자열의_시작과_끝_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자열은 숫자로 시작하고 끝나야 합니다.")
        );
    }

    @Test
    void 커스텀_문자열_지정_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1*2*3//*\n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 커스텀 문자열 형식이 아닙니다.")
        );
    }

    @Test
    void 연속된_구분자_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 연속해서 등장할 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
