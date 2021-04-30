package bowling.domain.state;

import bowling.domain.HitCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PinsTest {

    @DisplayName("Pins 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        Pins pins = Pins.initialize();

        // then
        assertThat(pins).isNotNull();
    }

    @DisplayName("Pins 인스턴스가 맞은 갯수만큼 감소하는지에 대한 테스트")
    @Test
    void 감소() {
        // when
        Pins pins = Pins.initialize();

        // then
        assertAll(
                () -> assertThat(pins.hit(HitCount.valueOf(10))).isNotNull(),
                () -> assertThat(pins.hit(HitCount.valueOf(0))).isNotNull()
        );

    }
}