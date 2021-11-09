package model.interfaces;

import model.Boo;
import model.Goomba;
import model.Spiny;

/**
 * Luis interface. declare attack logic with Opponents.
 */
public interface ILuis extends IHero {

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

    /**
     * Calculates the damage taken by a "normal attack"
     * made by a Boo-type opponent.
     *
     * @param boo Goomba attacker
     */
    void attackedByBoo(Boo boo);

}
