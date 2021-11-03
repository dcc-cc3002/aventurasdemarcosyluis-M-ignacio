package model;

import model.abstracts.AbstractOpponent;
import model.enums.OpponentType;
import model.interfaces.IGoomba;

/**
 * Goomba is a recurring and the most common Opponent among all enemies.
 * He's bump into an enemy to hurt them. He attacks Marcos and Luis
 * normally when it is her turn. He can be injured to any attack type.
 */
public class Goomba extends AbstractOpponent implements IGoomba {

    public Goomba(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dType);
    }
    public Goomba(int dRank, OpponentType dType) {
        super(dRank, dType);

    }
    //Javadoc inherited
    @Override
    public int maxHealth(int rank) {
        return 30 + (rank - 1) * 5;
    }

    //Javadoc inherited
    @Override
    public int maxHit(int rank) {
        return 20 + (rank - 1) * 2;
    }

    //Javadoc inherited
    @Override
    public int maxDefense(int rank) {
        return 40 + (rank - 1) * 5;
    }



    @Override
    public void attackedByJumpLuis(Luis luis) {
        int damage = calculateDamage(luis, this,1);
        this.doHurt(damage);
    }

    public void attackedByJumpMarcos(Marcos marcos) {
        int damage = calculateDamage(marcos,this ,1);
        this.doHurt(damage);
    }

    @Override
    public void attackedByHammerLuis(Luis luis) {
        int damage = calculateDamage(luis, this,1.5);
        this.doHurt(damage);
    }

    @Override
    public void attackedByHammerMarcos(Marcos marcos) {
        int damage= calculateDamage(marcos,this,1.5);
        this.doHurt(damage);
    }

    @Override
    public void attackNormal(Marcos hero) {
        hero.attackedByGoomba(this);
    }

    @Override
    public void attackNormal(Luis hero) {
        hero.attackedByGoomba(this);
    }
}
