package model.Opponent;

import model.Hero.Luis;
import model.Hero.Marcos;
import model.Opponent.IOpponent;

/**
 * Goomba interface. Declare the attack logic with the heroes.
 */
public interface IGoomba extends IOpponent {

    /**
     * Calculates the damage taken when attacked by a hero with a "Jump Attack".
     *
     * @param luis Luis attacker
     */
    void attackedByJumpLuis(Luis luis);

    /**
     * Determines the damage taken when attacked by a Luis hero
     * with a hammer attack.
     * @param luis Luis attacker
     */
    void attackedByHammerLuis(Luis luis);

    /**
     * Calculates the damage taken when attacked by a hero with a "Jump Attack".
     *
     * @param marcos Luis attacker
     */
    void attackedByJumpMarcos(Marcos marcos);

    /**
     * Determines the damage taken when attacked by a
     * Marcos hero with a hammer attack.
     *
     * @param marcos Marcos attacker
     */
    void attackedByHammerMarcos(Marcos marcos);

    /**
     * Perform a normal attack on a Marcos-type hero.
     *
     * @param marcos Marcos attacked
     */
    void attackNormal(Marcos marcos);


}
