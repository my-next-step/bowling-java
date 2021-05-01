package bowling.domain.state;

import bowling.domain.HitCount;
import bowling.exception.InsufficientMaxCountException;
import bowling.exception.NoMoreBowlActionsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SpareTest {

    @DisplayName("Spare 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        State ready = Ready.initialize();

        // when
        State firstBowl = ready.bowl(HitCount.valueOf(0));
        State spare = firstBowl.bowl(HitCount.valueOf(10));

        // then
        assertAll(
                () -> assertThat(spare).isNotNull(),
                () -> assertThat(spare).isInstanceOf(Spare.class)
        );
    }

    @DisplayName("Spare 인스턴스 생성시 들어오는 값들의 합이 10이 되는지 테스트")
    @Test
    void 검증() {
        // given
        int firstCount = 9;
        int secondCount = 0;

        // when and then
        assertThatThrownBy(()-> Spare.of(firstCount, secondCount))
                .isInstanceOf(InsufficientMaxCountException.class)
                .hasMessage("( 9 )와 ( 0 )의 합인 ( 9 )는, 10을 충족하지 않습니다.");
    }

    @DisplayName("Spare 인스턴스가 알맞은 종료 여부를 반환하는지 테스트")
    @Test
    void 반환_종료_여부() {
        // given
        int firstCount = 0;
        int secondCount = 10;

        // when
        State spare = Spare.of(firstCount, secondCount);

        // then
        assertThat(spare.isFinish()).isTrue();
    }

    @DisplayName("Spare 인스턴스가 bowl() 호출시, 예외처리 여부 테스트")
    @Test
    void 검증_bowl() {
        // given
        int firstCount = 0;
        int secondCount = 10;

        // when
        State spare = Spare.of(firstCount, secondCount);

        // then
        assertThatThrownBy(()-> spare.bowl(HitCount.valueOf(10)))
                .isInstanceOf(NoMoreBowlActionsException.class)
                .hasMessage("현재 상태에서는 더 이상 투구를 할 수 없습니다.");
    }

}