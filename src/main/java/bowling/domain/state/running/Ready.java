package bowling.domain.state.running;

import bowling.domain.score.Score;
import bowling.domain.state.Pins;
import bowling.domain.state.State;
import bowling.domain.state.finish.Strike;
import org.apache.logging.log4j.util.Strings;

public final class Ready extends Running {

    private Pins readyPins = Pins.full();

    public static final State initialize() {
        return new Ready();
    }

    private Ready() {
    }

    @Override
    public final State bowl(final Pins firstPins) {
        if (crush(firstPins).isEmpty()) {
            return Strike.initialize();
        }
        return FirstBowl.from(firstPins);
    }

    private final Pins crush(final Pins firstPins) {
        return readyPins.hit(firstPins.count());
    }

    @Override
    public final Score calculateAdditionalScore(final Score beforeScore) {
        return Score.unavailable();
    }

    @Override
    public final String description() {
        return Strings.EMPTY;
    }
}
