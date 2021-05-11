package bowling.domain.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoresTest {

    @DisplayName()
    @Test
    void 생성() {
        // given
        List<Score> scoreList = new ArrayList<>();

        // when
        Scores scores = Scores.of(scoreList);

        // then
        assertThat(scores).isNotNull();
    }
}