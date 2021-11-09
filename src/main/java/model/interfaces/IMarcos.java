package model.interfaces;

import model.*;

/**
 * Marcos interface. Declare attack logic with Opponents.
 */
public interface IMarcos extends IHero {
    /**
     * Perform a hammer attack on a Boo character. Corresponds to
     * an attack with greater damage but that has a 25% chance of failure.
     * To control the result of the attack, the seed variable is added
     *
     * @param opponent Boo attacked
     * @param seed     random class seed
     */
    void attackHammer(Boo opponent, Integer seed);
    /**
     * Perform a jump attack on an opponent Boo. Has
     * 100% chance of being an effective attack.
     *
     * @param opponent Boo attacked
     */
    void attackJump(Boo opponent);
    /**
     * Calculates the damage taken by a "normal attack"
     * made by a goomba-type opponent.
     *
     * @param goomba Goomba attacker
     */
    void attackedByGoomba(Goomba goomba);
    /**
     * Calculates the damage taken by a "normal attack"
     * made by a Spiny-type opponent.
     *
     * @param spiny Goomba attacker
     */
    void attackedBySpiny(Spiny spiny);
}
