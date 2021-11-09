package model.interfaces;

import model.Luis;

/**
 * Common interface for all opponents. It contains their common logic.
 */
public interface IOpponent extends Character {
    /**
     * Perform a normal attack on a Luis-type hero.
     *
     * @param luis Luis attacked
     */
    void attackNormal(Luis luis);

}
