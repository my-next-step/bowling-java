package bowling.domain.state;

import bowling.domain.HitCount;

public final class FirstBowl extends Running {

    private final int firstCount;

    private FirstBowl(final int firstCount) {
        this.firstCount = firstCount;
    }

    public static final State from(final int firstCount) {
        return new FirstBowl(firstCount);
    }

    @Override
    public final State bowl(final HitCount hitCount) {
        return null;
    }
}