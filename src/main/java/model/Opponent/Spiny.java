package model.Opponent;

import model.Hero.Luis;
import model.Hero.Marcos;

/**
 * He's character with a red spiky shell. If a model.items.main character attacks
 * Spiny  with a jumping then the attacker receives damage to five percent
 * of his HP and Spiny don't receive any damage. Spiny can be injured
 * fby any other attack.
 */
public class Spiny extends AbstractOpponent implements ISpiny {

    /**
     * Spiny Opponent constructor. It allows to create a new "Spiny" object
     * initialized with any atributte initial.
     *
     * @param dRank        actual rank
     * @param dHitPoint    define hit points
     * @param dDefPoint    define defense points
     * @param dHealthPoint define health points
     * @param dType        define opponent type
     */
    public Spiny(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dType);
    }

    /**
     * Spiny Opponent constructor. It allows to create a new "Spiny" objects initialized
     * with atributte given the Rank entered.
     *
     * @param dRank define rank
     * @param dType define opponent type
     */
    public Spiny(int dRank, OpponentType dType) {
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
        return 50 + (rank - 1) * 5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int maxDefense(int rank) {
        return 10 + (rank - 1) * 3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackedByJumpLuis(Luis luis) {
        int damage = luis.boundAttack(0.05);
        luis.doHurt(damage);
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
    public void attackedByJumpMarcos(Marcos marcos) {
        int damage = marcos.boundAttack(0.05);
        marcos.doHurt(damage);
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
    public void attackNormal(Marcos marcos) {
        marcos.attackedBySpiny(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackNormal(Luis luis) {
        luis.attackedBySpiny(this);
    }
}


