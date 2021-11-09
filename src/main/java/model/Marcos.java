package model;

import model.abstracts.AbstractHero;
import model.enums.HeroType;
import model.interfaces.Character;
import model.interfaces.IMarcos;

/**
 * The model.items.main character of the game. It's controlled by players.
 */
public class Marcos extends AbstractHero implements IMarcos, Character {

    /**
     *  Hero Marcos constructor. It allows to create a new "Marcos" Object initialized with
     *  any atributte initial.
     * @param dRank rank initialized
     * @param dHitPoint define hit points
     * @param dDefPoint define defense points
     * @param dHealthPoint define health points
     * @param dFightPoint define fight points
     * @param dType define heroType
     */
    public Marcos(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, int dFightPoint, HeroType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint, dFightPoint, dType);
    }

    /**
     * Hero Marcos constructor. It allows to create a new "Marcos" objects initialized with atributte given the Rank
     * entered.
     *
     * @param dRank define Rank
     * @param dType define heroType
     */
    public Marcos(int dRank, HeroType dType) {
        super(dRank, dType);
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
        return 10 + (rank - 1) * 5;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void maxUpStats(int rank) {
        setHitPoints(maxHit(rank));
        setDefPoints(maxDefense(rank));
        setFightPoint(maxFight(rank));
        setHealthPoint(maxHealth(rank));
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
    public int maxFight(int rank) {
        return 10 + (rank - 1) * 5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackJump(Boo opponent) {
        if (allowAttack(100, 1)) {
            opponent.attackedByJumpMarcos(this);
            spendFightPoint(1);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void attackJump(Goomba opponent) {
        if (allowAttack(100, 1)) {
            opponent.attackedByJumpMarcos(this);
            spendFightPoint(1);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void attackJump(Spiny opponent) {
        if (allowAttack(100, 1)) {
            opponent.attackedByJumpMarcos(this);
            spendFightPoint(1);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void attackHammer(Boo opponent, Integer seed) {
        if (allowAttack(75, 2, seed)) {
            opponent.attackedByHammerMarcos(this);
        }
        spendFightPoint(2);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void attackHammer(Goomba opponent, Integer seed) {
        if (allowAttack(75, 2, seed)) {
            opponent.attackedByHammerMarcos(this);
        }
        spendFightPoint(2);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void attackHammer(Spiny opponent, Integer seed) {
        if (allowAttack(75, 2, seed)) {
            opponent.attackedByHammerMarcos(this);
        }
        spendFightPoint(2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackedByGoomba(Goomba goomba) {
        int damage = calculateDamage(goomba, this, 0.75);
        doHurt(damage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackedBySpiny(Spiny spiny) {
        int damage = calculateDamage(spiny, this, 0.75);
        doHurt(damage);
    }
}
