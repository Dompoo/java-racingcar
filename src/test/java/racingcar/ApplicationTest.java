package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }
    
    @Test
    void 이름이_2자보다_작으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_5자보다_크면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 이름에_중복이_있으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 자동차_개수가_2개보다_적으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 자동차_개수가_30개보다_많으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(
                        "car1,car2,car3,car4,car5,car6,car7,car8,car9,car10," +
                        "car11,car12,car13,car14,car15,car16,car17,car18,car19,car20," +
                        "car21,car22,car23,car24,car25,car26,car27,car28,car29,car30," +
                        "car31",
                        "1"
                )).isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 시도_회수가_1보다_적으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,dompo", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 시도_회수가_30보다_많으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,dompo", "31"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
