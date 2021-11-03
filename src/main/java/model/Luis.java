package model;

import model.abstracts.AbstractHero;
import model.enums.HeroType;
import model.interfaces.ILuis;

/**
 * The second character of the game. Being honest everyone prefers
 * Marcos but if you have bad taste, you can choose it.
 */
public class Luis extends AbstractHero implements ILuis {

    /**
     * Hero Luis constructor. It allows to create a new hero "luis" initialized with any atributte initial.
     *
     * @param dRank        define Rank
     * @param dHitPoint    define Hit Points
     * @param dDefPoint    define Defense Points
     * @param dHealthPoint define Health Points
     * @param dFightPoint  define Fight Points
     * @param dType        define TypeHero
     */
    public Luis(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, int dFightPoint, HeroType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dFightPoint, dType);
    }

    /**
     * Hero Luis constructor. It allows to create a new "Luis" objects initialized with atributte given the Rank
     * entered.
     *
     * @param dRank       define Rank
     * @param dType       define TypeHero
     */
    public Luis(int dRank, HeroType dType){
        super(dRank, dType);
    }

    //Javadoc inherited
    @Override
    public int maxHit(int rank) {
        return 20 + (rank - 1) * 5;
    }

    //Javadoc inherited
    @Override
    public int maxDefense(int rank) {
        return 20 + (rank - 1) * 5;
    }

    @Override
    public int maxFight(int rank) {
        return 20 + (rank - 1) * 5;
    }

    //Javadoc inherited

    @Override
    public int maxHealth(int rank) {
        return 20 + (rank - 1) * 5;
    }
    @Override
    public void maxUpStats(int rank) {
        setHitPoints(maxHit(rank));
        setDefPoints(maxDefense(rank));
        setFightPoint(maxFight(rank));
        setHealthPoint(maxHealth(rank));
    }


    @Override
    public void attackJump(Goomba opponent) {
        if (allowAttack(100, 1))
            opponent.attackedByJumpLuis(this);

        spendFightPoint(1);
    }

    @Override
    public void attackJump(Spiny opponent) {
        if (allowAttack(100, 1))
            opponent.attackedByJumpLuis(this);
        spendFightPoint(1);
    }

    @Override
    public void attackHammer(Goomba opponent) {
        spendFightPoint(2);
        if (allowAttack(100, 2)) {
            opponent.attackedByHammerLuis(this);
        }
    }

    @Override
    public void attackHammer(Spiny opponent) {
        spendFightPoint(2);
        if (allowAttack(100, 2)) {
            opponent.attackedByHammerLuis(this);
        }
    }


    @Override
    public void attackedByGoomba(Goomba goomba) {
        int damage = calculateDamage(goomba, this, 0.75);
        doHurt(damage);
    }

    @Override
    public void attackedByBoo(Boo Boo) {
        int damage = calculateDamage(Boo, this, 0.75);
        doHurt(damage);
    }

    @Override
    public void attackedBySpiny(Spiny spiny) {
        int damage = calculateDamage(spiny, this, 0.75);
        doHurt(damage);
    }
}
