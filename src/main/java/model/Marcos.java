package model;

import model.abstracts.AbstractHero;
import model.enums.HeroType;
import model.interfaces.IMarcos;

/**
 * The main character of the game. It's controlled by players.
 */
public class Marcos extends AbstractHero implements IMarcos {

    public Marcos(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, int dFightPoint, HeroType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dFightPoint, dType);
    }

    public Marcos(int dRank, HeroType dType) {
        super(dRank, dType);
    }

    //Javadoc inherited
    @Override
    public int maxHit(int rank) {
        return 10 + (rank - 1) * 5;
    }

    //Javadoc inherited
    @Override
    public int maxDefense(int rank) {
        return 10 + (rank - 1) * 5;
    }

    @Override
    public void maxUpStats(int rank) {
        setHitPoints(maxHit(rank));
        setDefPoints(maxDefense(rank));
        setFightPoint(maxFight(rank));
        setHealthPoint(maxHealth(rank));
    }

    //Javadoc inherited
    @Override
    public int maxHealth(int rank) {
        return 10 + (rank - 1) * 5;
    }

    //Javadoc inherited
    @Override
    public int maxFight(int rank) {
        return 10 + (rank - 1) * 5;
    }


    @Override
    public void attackJump(Boo opponent) {
        if (allowAttack(100, 1))
            opponent.attackedByJumpMarcos(this);
        spendFightPoint(1);
    }

    @Override
    public void attackJump(Goomba opponent) {
        if (allowAttack(100, 1))
            opponent.attackedByJumpMarcos(this);
        spendFightPoint(1);
    }

    @Override
    public void attackJump(Spiny opponent) {
        if (allowAttack(100, 1))
            opponent.attackedByJumpMarcos(this);
        spendFightPoint(1);
    }

    @Override
    public void attackHammer(Boo opponent) {
        if (allowAttack(100, 2))
            opponent.attackedByHammerMarcos(this);
        spendFightPoint(2);
    }

    @Override
    public void attackHammer(Goomba opponent) {
        if (allowAttack(100, 2))
            opponent.attackedByHammerMarcos(this);
        spendFightPoint(2);
    }

    @Override
    public void attackHammer(Spiny opponent) {
        if (allowAttack(100, 2))
            opponent.attackedByHammerMarcos(this);
        spendFightPoint(2);
    }

    public void attackedByGoomba(Goomba goomba) {
        int damage = calculateDamage(goomba, this, 0.75);
        doHurt(damage);
    }

    @Override
    public void attackedBySpiny(Spiny spiny) {
        int damage = calculateDamage(spiny, this, 0.75);
        doHurt(damage);
    }
}
