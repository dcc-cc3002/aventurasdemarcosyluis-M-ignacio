package model;

import model.abstracts.AbstractOpponent;
import model.enums.OpponentType;
import model.interfaces.IBoo;

/**
 * Boo is the most common ghost enemy. He only attacks Luis. If He attacked
 * with a hammer, He dodges it. He can be injured by any other attack.
 */
public class Boo extends AbstractOpponent implements IBoo {

    public Boo(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dType);
    }

    public Boo(int dRank, OpponentType dType) {
        super(dRank, dType);
    }
    //Javadoc inherited
    @Override
    public int maxHealth(int rank) {
        return 10 + (rank - 1) * 5;
    }

    //Javadoc inherited
    @Override
    public int maxHit(int rank) {
        return 30 + (rank -1)*3;
    }

    //Javadoc inherited
    @Override
    public int maxDefense(int rank) {
        return 30 + (rank - 1) * 4;
    }

    @Override
    public void attackedByJumpMarcos(Marcos marcos) {
        int damage=  calculateDamage(marcos,this,1);
        this.doHurt(damage);
    }

    @Override
    public void attackedByHammerMarcos(Marcos marcos) {
        doHurt(0);
    }

    @Override
    public void attackNormal(Luis luis) {

    }
}
