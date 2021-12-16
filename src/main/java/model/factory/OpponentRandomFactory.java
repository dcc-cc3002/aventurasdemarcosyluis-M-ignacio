package model.factory;

import model.Opponent.Boo;
import model.Opponent.Goomba;
import model.Opponent.Spiny;
import model.Opponent.OpponentType;
import model.Opponent.IOpponent;

import java.util.Random;

/**
 * class that is responsible for creating enemies randomly. It is possible
 * to select the random variable when planting a seed
 */
public class OpponentRandomFactory implements OpponentFactory {
    final Random random = new Random();

    /**
     * Is responsible for creating an enemy randomly.
     *
     * @param rank rank initialized
     * @return random Opponent
     */
    public IOpponent createOpponent(int rank) {
        float number = nextNumber();
        if (number < 0.33) {
            return new Boo(rank, OpponentType.BOO);
        } else {
            if (number < 0.66) {
                return new Goomba(rank, OpponentType.GOOMBA);
            } else {
                return new Spiny(rank, OpponentType.SPINY);
            }
        }
    }

    /**
     * Get Random variable.
     *
     * @return attribute Random
     */
    private Random getRandom() {
        return random;
    }

    /**
     * The value of the random variable is defined.
     *
     * @param seed number seed
     */
    public void plantSeed(int seed) {
        getRandom().setSeed(seed);
    }

    /**
     * A new random number is generated.
     *
     * @return random number
     */
    public float nextNumber() {
        return getRandom().nextFloat();
    }

}
