package model.Opponent;

import model.Hero.Luis;
import model.Hero.Marcos;

/**
 * Goomba is a recurring and the most common Opponent among all enemies.
 * He's bump into an enemy to hurt them. He attacks Marcos and Luis
 * normally when it is her turn. He can be injured to any attack type.
 */
public class Goomba extends AbstractOpponent implements IGoomba {

    /**
     * Goomba Opponent constructor. It allows to create a new "Goomba" object
     * initialized with any atributte initial.
     *
     * @param dRank        actual rank
     * @param dHitPoint    define hit points
     * @param dDefPoint    define defense points
     * @param dHealthPoint define health points
     * @param dType        define opponent type
     */
    public Goomba(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dType);
    }

    /**
     * Goomba Opponent constructor. It allows to create a new "Goomba" objects initialized
     * with atributte given the Rank entered.
     *
     * @param dRank define rank
     * @param dType define opponent type
     */
    public Goomba(int dRank, OpponentType dType) {
        super(dRank, dType);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int maxHealth(int rank) {
        return 10 + (rank - 1) * 5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int maxHit(int rank) {
        return 30 + (rank - 1) * 2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int maxDefense(int rank) {
        return 5 + (rank - 1) * 5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackedByJumpLuis(Luis luis) {
        int damage = calculateDamage(luis, this, 1);
        this.doHurt(damage);
    }

    /**
     * {@inheritDoc}
     */
    public void attackedByJumpMarcos(Marcos marcos) {
        int damage = calculateDamage(marcos, this, 1);
        this.doHurt(damage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackedByHammerLuis(Luis luis) {
        int damage = calculateDamage(luis, this, 1.5);
        this.doHurt(damage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackedByHammerMarcos(Marcos marcos) {
        int damage = calculateDamage(marcos, this, 1.5);
        this.doHurt(damage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackNormal(Marcos hero) {
        hero.attackedByGoomba(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackNormal(Luis hero) {
        hero.attackedByGoomba(this);
    }

}
