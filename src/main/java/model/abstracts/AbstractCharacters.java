package model.abstracts;

import model.interfaces.Character;


/**
 * Abstract class is common for any type of character.
 */
public abstract class AbstractCharacters implements Character {
    private int rank;
    private int hitPoint;
    private int defPoint;
    private int healthPoint;

    /**
     * Abstract constructor allows us to associate initial attributes
     * to a character.
     *
     * @param dRank        define rank
     * @param dHitPoint    define HitPoints
     * @param dDefPoint    define DefensePoints
     * @param dHealthPoint define healthPoints
     */
    public AbstractCharacters(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint) {
        this.rank = dRank;
        this.hitPoint = dHitPoint;
        this.defPoint = dDefPoint;
        this.healthPoint = dHealthPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRank() {
        return rank;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHitPoints() {
        return hitPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHitPoints(int hp) {
        this.hitPoint = hp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDefPoints() {
        return defPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDefPoints(int defPoint) {
        this.defPoint = defPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHealthPoints() {
        return healthPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }


    /**
     * Calculate the damage done by a Character A attack upon Character B
     *
     * @param A attacker character
     * @param B character attacked
     * @param K damage constant
     * @return damage carry out by a certain attack
     */
    public int calculateDamage(Character A, Character B, double K) {
        return (int) (K * partialCalculate(A) / B.getDefPoints());
    }

    /**
     * Calculate the damage partial given Character A
     *
     * @param A attacker character
     * @return partial damage
     */
    private int partialCalculate(Character A) {
        return A.getHitPoints() * A.getRank();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void KO() {
        if (this.cDefeated()) this.setHitPoints(0);
    }

    /**
     * Checks that his health Points are zero.If it
     * is, Character was defeated.
     *
     * @return true if He's defeated. False otherwise
     */
    public boolean cDefeated() {
        return getHealthPoints() == 0;
    }


    /**
     * {@inheritDoc}
     */
    public int maxHealth() {
        return maxHealth(this.getRank());
    }


    /**
     * give out health point for some Hero or Opponent attacked.
     *
     * @param damage magnitude attack
     */
    public void doHurt(int damage) {
        int hp = getHealthPoints() - damage;
        this.setHealthPoint(Math.max(hp, 0));
    }

    /**
     * Determines maximum HitPoints for a Hero or Opponent given his current level.
     *
     * @param rank current Rank
     * @return maximum Health Points
     */
    public abstract int maxHit(int rank);

    /**
     * determines maximum Health Points for Hero given his current level.
     *
     * @param rank current Rank
     * @return maximum Health Points
     */
    public abstract int maxHealth(int rank);

    /**
     * Determines maximum DefPoints for a Hero given his current level.
     *
     * @param rank current Rank
     * @return maximum Defense Points
     */
    public abstract int maxDefense(int rank);

    /**
     * determine increased the point health when leveling up
     *
     * @param atributte value actual atributte
     * @param prob      increased factor
     * @return (delta)  increased health points
     */
    public int update(int atributte, double prob) {
        return (int) (prob * atributte);
    }

    /**
     * determine the point health when leveling up
     *
     * @param rank character level
     * @param prob increment factor
     * @return new health points
     */
    public int updateHealth(int rank, double prob) {
        return (int) (prob * this.maxHealth(rank - 1));
    }


    /**
     * Promotes character to new level and upgrade all his attributes
     * given the new level.
     *
     * @param lvl level amount that character is promoted
     */
    public void maxLvlUp(Integer lvl) {
        lvl = lvl != null ? lvl : 1;
        setRank(getRank() + lvl); // update next level
        maxUpStats(getRank());
    }

    /**
     * Set character attributes to maximum by his new level.
     *
     * @param rank new character level
     */
    public abstract void maxUpStats(int rank);


}
