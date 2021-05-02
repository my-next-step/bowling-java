package bowling.domain.state;

import bowling.domain.HitCount;

public final class TestRunning extends Running {
    @Override
    public State bowl(HitCount hitCount) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int firstCount() {
        return 0;
    }

    @Override
    public int secondCount() {
        return 0;
    }
}