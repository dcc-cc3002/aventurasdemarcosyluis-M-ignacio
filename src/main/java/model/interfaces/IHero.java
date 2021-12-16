package model.interfaces;

import model.*;
import model.enums.HeroType;

/**
 * Hero interface. Declares the common logic between the heroes.
 */
public interface IHero extends Character {

    /**
     * Perform a jump attack on an opponent goomba. Has
     * 100% chance of being an effective attack.
     *
     * @param opponent Goomba attacked
     */
    void attackJump(Goomba opponent);

    /**
     * Perform a jump attack on an opponent Spiny. Has
     * 100% chance of being an effective attack.
     *
     * @param opponent Spiny attacked
     */
    void attackJump(Spiny opponent);

    /**
     * Perform a hammer attack on a Goomba character. Corresponds to
     * an attack with greater damage but that has a 25% chance of failure.
     * To control the result of the attack, the seed variable is added
     *
     * @param opponent Goomba attacked
     * @param seed     random class seed
     */
    void attackHammer(Goomba opponent, Integer seed);

    /**
     * Perform a hammer attack on a Spiny character. Corresponds to
     * an attack with greater damage but that has a 25% chance of failure.
     * To control the result of the attack, the seed variable is added
     *
     * @param opponent Spiny attacked
     * @param seed     random class seed
     */
    void attackHammer(Spiny opponent, Integer seed);

    /**
     * Determines maximum fight points.
     *
     * @return maximum fight points
     */
    int maxFight();

    /**
     * Given us the maximum Health Points some Hero or Opponent by
     * his current level.
     *
     * @return maximum Health Points
     */
    int maxHealth();

    /**
     * Get Fight Points.
     *
     * @return current Fight Points
     */
    int getFightPoint();

    /**
     * Set Fight Points.
     *
     * @param fightPoint new Fight Points
     */
    void setFightPoint(int fightPoint);

    /**
     * The effect of an item is applied to an Object Hero.
     *
     * @param item selected item
     */
    void spendItem(IItems item);

    /**
     * get Type
     *
     * @return Hero Type
     */
    HeroType getType();

    /**
     * se aumenta en nivel de los hero de la partida
     */
    void lvlUp();
}
