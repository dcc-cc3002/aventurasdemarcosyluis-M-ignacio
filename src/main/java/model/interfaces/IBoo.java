package model.interfaces;

import model.Marcos;

/**
 * Boo interface. Declare the attack logic with the heroes.
 */
public interface IBoo extends IOpponent {

    /**
     * Calculates the damage taken when attacked by
     * a Marcos hero with a "Jump Attack".
     *
     * @param marcos Luis attacker
     */
    void attackedByJumpMarcos(Marcos marcos);

    /**
     * Determines the damage taken when attacked by
     * a Marcos hero with a hammer attack.
     * @param marcos marcos attacked
     */
    void attackedByHammerMarcos(Marcos marcos);
}
