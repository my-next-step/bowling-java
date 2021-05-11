package bowling.domain.score;

import bowling.exception.ScoreListNullPointerException;

import java.util.List;
import java.util.Objects;

public final class Scores {

    private final List<Score> scores;

    public static final Scores of(final List<Score> scores) {
        return new Scores(scores);
    }

    private Scores(final List<Score> scores) {
        validateNull(scores);
        this.scores = scores;
    }

    private final void validateNull(final List<Score> scores) {
        if (Objects.isNull(scores)) {
            throw new ScoreListNullPointerException();
        }
    }


}
