package bowling.domain.state;

import bowling.domain.HitCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @DisplayName("State 인터페이스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        State state = new TestState();

        // then
        assertThat(state).isNotNull();

    }

}