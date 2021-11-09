package model.factory;

import model.interfaces.IOpponent;

/**
 * interface creator. Declares the createOpponent method, which is implemented
 * by each particular factory.
 */
public interface OpponentFactory {

    /**
     * Generic method that is implemented to create enemies.
     *
     * @param rank rank initialized
     * @return new Opponent
     */
    IOpponent createOpponent(int rank);
}
