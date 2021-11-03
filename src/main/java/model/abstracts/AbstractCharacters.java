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

    //Javadoc inherited
    public int getRank() {
        return rank;
    }

    //Javadoc inherited
    public void setRank(int rank) {
        this.rank = rank;
    }

    //Javadoc inherited
    public int getHitPoints() {
        return hitPoint;
    }

    //Javadoc inherited
    public void setHitPoints(int hp) {
        this.hitPoint = hp;
    }

    //Javadoc inherited
    public int getDefPoints() {
        return defPoint;
    }

    //Javadoc inherited
    public void setDefPoints(int defPoint) {
        this.defPoint = defPoint;
    }

    //Javadoc inherited
    public int getHealthPoints() {
        return healthPoint;
    }

    //Javadoc inherited
    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }


    public int calculateDamage(Character A, Character B, double K) {
        //implement damage formulate
        return (int) K * partialCalculate(A) / B.getDefPoints();
    }


    private int partialCalculate(Character A) {
        return A.getHitPoints() * A.getRank();
    }


    /**
     * If A was defeated, his HitPoints is set to zero.
     *
     * @param A some type character (Hero or Opponent)
     */
    public void KO(Character A) {
        if (this.cDefeated()) A.setHitPoints(0);
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
     * Given us the maximum Health Points some Hero or Opponent by
     * his current level.
     *
     * @return maximum Health Points
     */
    public int maxHealth() {
        return maxHealth(this.getRank());
    }
//rvw

    /**
     * give out health point for some Hero or Opponent attacked.
     *
     * @param damage magnitude attack
     */
    public void doHurt(int damage) {
        int hp = getHealthPoints() - damage;
        if (hp <= 0)
            setHealthPoint(0);
        setHealthPoint(hp);
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


    public int updateActual(int atributte, double prob) {
        return atributte + update(atributte, prob);
    }
}
