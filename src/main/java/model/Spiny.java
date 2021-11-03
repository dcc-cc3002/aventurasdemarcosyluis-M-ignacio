package model;

import model.abstracts.AbstractOpponent;
import model.enums.OpponentType;
import model.interfaces.ISpiny;

/**
 * He's character with a red spiky shell. If a main character attacks
 * Spiny  with a jumping then the attacker receives damage to five percent
 * of his HP and Spiny don't receive any damage. Spiny can be injured
 * fby any other attack.
 */
public class Spiny extends AbstractOpponent implements ISpiny {

    public Spiny(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dType);
    }

    public Spiny(int dRank, OpponentType dType) {
        super(dRank, dType);
    }

    //Javadoc inherited
    @Override
    public int maxHealth(int rank) {
        return 20 + (rank - 1) * 5;
    }

    //Javadoc inherited
    @Override
    public int maxHit(int rank) {
        return 40 + (rank - 1) * 5;
    }

    //Javadoc inherited
    @Override
    public int maxDefense(int rank) {
        return 30 + (rank - 1) * 3;
    }


    @Override
    public void attackedByJumpLuis(Luis luis) {
        int damage = luis.boundAttack(0.05);
        luis.doHurt(damage);
    }

    @Override
    public void attackedByHammerLuis(Luis luis) {
        int damage = calculateDamage(luis, this, 1.5);
        this.doHurt(damage);
    }

    @Override
    public void attackedByJumpMarcos(Marcos marcos) {
        int damage = marcos.boundAttack(0.05);
        marcos.doHurt(damage);
    }

    @Override
    public void attackedByHammerMarcos(Marcos marcos) {
        int damage = calculateDamage(marcos, this, 1.5);
        this.doHurt(damage);
    }

    @Override
    public void attackNormal(Marcos marcos) {
        marcos.attackedBySpiny(this);
    }

    @Override
    public void attackNormal(Luis luis) {
        luis.attackedBySpiny(this);
    }
}


