package bowling.domain.player;

import bowling.exception.InvalidPlayerCountException;

public final class PlayerCount {

    private static final int MINIMUM_PLAYER_COUNT = 1;
    private static final int INCREASE_UNIT = 1;

    private final int playerCount;
    private final int sequence;

    public PlayerCount(final int playerCount) {
        this(playerCount, MINIMUM_PLAYER_COUNT);
    }

    public PlayerCount(final int playerCount, final int sequence) {
        validatePinCount(playerCount);
        this.playerCount = playerCount;
        this.sequence = sequence;
    }

    private final void validatePinCount(final int playerCount) {
        if (playerCount < MINIMUM_PLAYER_COUNT) {
            throw new InvalidPlayerCountException(playerCount);
        }
    }

    public final int sequence() {
        return sequence;
    }

    public final PlayerCount next() {
        return new PlayerCount(playerCount, Math.addExact(sequence, INCREASE_UNIT));
    }

    public final boolean isFinish() {
        return sequence == playerCount;
    }
}
