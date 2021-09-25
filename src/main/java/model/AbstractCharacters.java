package model;

import java.util.Objects;

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

    /*
    protected int calculateDamage(Character A, Character B, int K) {
        //implement damage formulate
        return K * partialCalculate(A) / B.getDefPoints();
    }

    private int partialCalculate(Character A) {
        return A.getHitPoints() * A.getRank();
    }
    */


    /**
     * If A was defeated, his HitPoints is set to zero.
     *
     * @param A some type character (Hero or Opponent)
     */
    public void KO(Character A) {
        if (defeated(A)) A.setHitPoints(0);
    }

    /**
     * Checks that his health Points are zero.If it
     * is, Character was defeated.
     *
     * @param A some type character (Hero or Opponent)
     * @return true if He's defeated. False otherwise
     */
    public boolean defeated(Character A) {
        return A.getHealthPoints() <= 0;
    }

    /**
     * Given us the maximum Health Points some Hero orOpponent by
     * his current level.
     *
     * @return maximum Health Points
     */
    public int maxHealthGeneric() {
        return maxHealth();
    }

    /**
     * Promotes character to new level and upgrade all his attributes
     * given the new level.
     *
     * @param lvl level amount that character is promoted
     */
    public void updateLvl(Integer lvl) {
        lvl = lvl != null ? lvl : 1;
        setRank(getRank() + lvl); // update next level
        upStats(getRank());
    }

    /**
     * Set character attributes to maximum by his new level.
     *
     * @param rank new character level
     */
    public abstract void upStats(int rank);

    //no cache que hacer con estoxd. me perdonan:(
    //Javadoc inherited
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCharacters that = (AbstractCharacters) o;
        return rank == that.rank && hitPoint == that.hitPoint && defPoint == that.defPoint && healthPoint == that.healthPoint;
    }

    //Javadoc inherited
    @Override
    public int hashCode() {
        return Objects.hash(rank, hitPoint, defPoint, healthPoint);
    }
}
