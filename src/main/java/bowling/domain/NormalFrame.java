package bowling.domain;

import bowling.domain.state.State;
import bowling.exception.NoMoreBowlActionsException;

import static bowling.util.BowlingFixture.*;

public final class NormalFrame implements Frame {

    private State state;
    private Frame next;
    private final int index;

    public NormalFrame(final int index) {
        this.state = State.initialize();
        this.next = Frame.initialize();
        this.index = index;
    }

    public static final Frame initialize() {
        return new NormalFrame(FRAME_START_INDEX);
    }

    public static final Frame from(final int index) {
        return new NormalFrame(index);
    }

    private void validateFinish() {
        if(state.isFinish()){
            throw new NoMoreBowlActionsException();
        }
    }

    private final Frame nextFrame() {
        if (index + INCREASE_INDEX_UNIT == FRAME_LAST_INDEX) {
        }
        return new NormalFrame(index + INCREASE_INDEX_UNIT);
    }

    @Override
    public final Frame bowl(final HitCount hitCOunt) {
        validateFinish();
        state = state.bowl(hitCOunt);
        if (state.isFinish()) {
            next = nextFrame();
            return next;
        }
        return this;
    }

    @Override
    public final boolean isFinish() {
        return state.isFinish();
    }

    @Override
    public final int index() {
        return index;
    }

}
