package model.abstracts;

import model.enums.HeroType;
import model.interfaces.Character;
import model.interfaces.IHero;
import model.interfaces.IItems;

import java.util.Random;

/**
 * CLass that define constructor and methods implemented by Hero object.
 */
public abstract class AbstractHero extends AbstractCharacters implements IHero, Character {
    private final HeroType type;
    private int fightPoint;

    /**
     * Constructor that allows to create a new "Hero" object initialized with any
     * desired stats.
     *
     * @param dRank        define Rank
     * @param dHitPoint    define Hit Points
     * @param dDefPoint    define Defense Points
     * @param dHealthPoint define Health Points
     * @param dFightPoint  define Fight Points
     * @param dType        define Hero Type
     */
    public AbstractHero(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, int dFightPoint, HeroType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint);
        this.type = dType;
        this.fightPoint = dFightPoint;
    }

    /**
     * Constructor that allows to create a new "Hero" object initialized
     * with the maximum stats (attribute) given the Rank entered.
     *
     * @param rank  define Rank
     * @param dType define Hero Type
     */
    public AbstractHero(int rank, HeroType dType) {
        super(rank, 0, 0, 0);
        this.type = dType;
        this.fightPoint = maxFight(rank);
        maxUpStats(rank);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HeroType getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFightPoint() {
        return fightPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFightPoint(int fightPoint) {
        this.fightPoint = fightPoint;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int maxFight() {
        return this.maxFight(this.getRank());
    }

    /**
     * Increase fight Points by increasing rank.
     *
     * @param rank new rank
     * @param prob increment factor
     * @return new fight points
     */
    public int updateFight(int rank, double prob) {
        return (int) (prob * this.maxFight(rank - 1));
    }

    /**
     * Increase character level and his stats.
     */
    @Override
    public void lvlUp() {
        setRank(getRank() + 1);
        upStats(getRank());
    }


    /**
     * Increase stats when hero levels up.
     *
     * @param rank new rank
     */
    protected void upStats(int rank) {
        setHitPoints(getHitPoints() + update(getHitPoints(), 0.15));
        setDefPoints(getDefPoints() + update(getDefPoints(), 0.15));
        setHealthPoint(getHealthPoints() + updateHealth(rank, 0.15));
        setFightPoint(getFightPoint() + updateFight(rank, 0.15));
    }

    /**
     * Set the new attack points.
     *
     * @param point point spent
     */
    public void spendFightPoint(int point) {
        setFightPoint(getFightPoint() - point);
    }


    /**
     * Compare if Hero can do an attack. Attack Jump.
     *
     * @param probability success probability
     * @param fp          spend fight points
     * @return true if it's possible.
     */
    public boolean allowAttack(int probability, int fp) {
        return probability(probability) && isNotZero(fp);
    }

    /**
     * Compare if Hero can do an attack. Attack Hammer.
     *
     * @param probability success probability
     * @param fp          spend fight points
     * @param seed          class Random seed
     * @return true if it's possible.
     */
    public boolean allowAttack(int probability, int fp, Integer seed) {
        return probability(probability, seed) && isNotZero(fp);
    }

    /**
     * Given probability the attack will be effective de 0 a 100.
     *
     * @param probability define probability
     * @return if attack is effective, it will return True.
     */
    public boolean probability(int probability) {
        Random r = new Random();
        int aux = (int) (r.nextFloat() * 100);
        return probability >= aux;
    }

    /**
     * To control the result of the random class, enter the variable
     * seed.
     *
     * @param probability probability of success
     * @param seed        seed class random
     * @return true if the attack is effective
     */
    public boolean probability(int probability, Integer seed) {
        Random r = new Random();
        if (seed != null) {
            r.setSeed(seed);
        }
        int aux = (int) (r.nextFloat() * 100);
        return probability >= aux;
    }

    /**
     * Confirms that you have enough hit points.
     *
     * @param point hit points needed
     * @return true if there are
     */
    public boolean isNotZero(int point) {
        int fp = getFightPoint();
        return fp > point - 1;
    }

    /**
     * Calculates the damage taken when attacking Spiny with jump attack.
     *
     * @param percentage damage factor
     * @return damage received
     */
    public int boundAttack(double percentage) {
        return (int) (this.getHealthPoints() * percentage);
    }

    /**
     * Determines maximum attack points.
     *
     * @param rank actual rank.
     * @return maximum attack points.
     */
    public abstract int maxFight(int rank);

    /**
     * {@inheritDoc}
     */
    @Override
    public void spendItem(IItems item) {
        item.effect(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHitPoints(int hp) {
        super.setHitPoints(hp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int maxHealth() {
        return super.maxHealth();
    }
}

