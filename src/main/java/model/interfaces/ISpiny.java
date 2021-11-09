package model.interfaces;

import model.Marcos;
import model.Luis;

/**
 * Spiny interface. Declare the attack logic with the heroes.
 */
public interface ISpiny extends IOpponent {

    /**
     * calculates the damage returned to the attacking
     * Hero when attacked by a "Jump Attack".
     *
     * @param luis Luis attacker
     */
    void attackedByJumpLuis(Luis luis);

    /**
     * Determines the damage taken when attacked by a Marcos hero
     * with a hammer attack.
     *
     * @param luis Luis attacker
     */
    void attackedByHammerLuis(Luis luis);

    /**
     * calculates the damage returned to the attacking
     * Hero when attacked by a "jump attack".
     *
     * @param marcos Luis attacker
     */
    void attackedByJumpMarcos(Marcos marcos);

    /**
     * Determines the damage taken when attacked by a Marcos hero
     * with a hammer attack.
     *
     * @param marcos marcos attacker
     */
    void attackedByHammerMarcos(Marcos marcos);

    /**
     * Perform a normal attack on a Marcos-type hero.
     *
     * @param marcos Marcos attacked
     */
    void attackNormal(Marcos marcos);
}
