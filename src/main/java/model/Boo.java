package model;

import model.abstracts.AbstractOpponent;
import model.enums.OpponentType;
import model.interfaces.IBoo;

/**
 * Boo is the most common ghost enemy. He only attacks Luis. If He attacked
 * with a hammer, He dodges it. He can be injured by any other attack.
 */
public class Boo extends AbstractOpponent implements IBoo {

    /**
     * Boo Opponent constructor. It allows to create a new "Boo" object
     * initialized with any atributte initial.
     *
     * @param dRank        actual rank
     * @param dHitPoint    define hit points
     * @param dDefPoint    define defense points
     * @param dHealthPoint define health points
     * @param dType        define opponent type
     */
    public Boo(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dType);
    }

    /**
     * Boo Opponent constructor. It allows to create a new "Spiny" objects initialized
     * with atributte given the Rank entered.
     *
     * @param dRank define rank
     * @param dType define opponent type
     */
    public Boo(int dRank, OpponentType dType) {
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
        return 40 + (rank - 1) * 3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int maxDefense(int rank) {
        return 10 + (rank - 1) * 4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackedByJumpMarcos(Marcos marcos) {
        int damage = calculateDamage(marcos, this, 1);
        this.doHurt(damage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackedByHammerMarcos(Marcos marcos) {
        this.dodge();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackNormal(Luis luis) {
        luis.attackedByBoo(this);
    }

    /**
     * Dodge the attack made. Take no damage from the attack.
     */
    private void dodge() {
        this.doHurt(0);
    }


}
