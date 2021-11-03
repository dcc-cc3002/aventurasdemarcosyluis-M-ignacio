package model.abstracts;

import model.enums.HeroType;
import model.interfaces.IItems;

import java.util.ArrayList;
import java.util.Random;

/**
 * CLass that define constructor and methods implemented by Hero object.
 */
public abstract class AbstractHero extends AbstractCharacters implements model.interfaces.IHero {
    private final HeroType type;
    private int fightPoint;
    private final ArrayList<IItems> weapons;

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
        weapons = new ArrayList<>();
    }
//

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
        weapons = new ArrayList<>();
        maxUpStats(rank);
    }


    /**
     * Get Hero Type.
     *
     * @return Hero Type
     */
    public HeroType getType() {
        return type;
    }

    /**
     * get Fight Points.
     *
     * @return current Fight Points
     */
    public int getFightPoint() {
        return fightPoint;
    }

    /**
     * set Fight Points.
     *
     * @param fightPoint new Fight Points
     */
    public void setFightPoint(int fightPoint) {
        this.fightPoint = fightPoint;
    }

    /**
     * get Weapons List.
     *
     * @return Weapon list
     */
    public ArrayList<IItems> getWeapons() {
        return weapons;
    }

    /**
     * add a new items into available inventory for Hero.
     *
     * @param nItem new Item
     */
    public void addItem(IItems nItem) {
        weapons.add(nItem);
    }

    /**
     * Searching a particular item inside inventory. In case
     * of finding it return his index, otherwise it returns number -1.
     *
     * @param testStar item that want to be used
     * @return index fo the item
     */
    public int getItemIndex(IItems testStar) {
        return weapons.indexOf(testStar);
    }

    /**
     * Select an item to be used from available inventory.
     *
     * @param type item selected to be used
     */
    public void SpendItem(IItems type) {
        weapons.remove(getItemIndex(type));
        type.effect(this);
    }


    public int maxFight() {
        return this.maxFight(this.getRank());
    }


    public int updateFight(int rank, double prob) {
        return (int) (prob * this.maxFight(rank - 1));
    }

    /**
     * increase character level and his stats.
     */
    public void lvlUp() {
        setRank(getRank() + 1);
        upStats(getRank());
    }

    //Javadoc inherited
    protected void upStats(int rank) {
        setHitPoints(getHitPoints() + update(getHitPoints(), 0.15));
        setDefPoints(getDefPoints() + update(getDefPoints(), 0.15));
        setHealthPoint(getHealthPoints() + updateHealth(rank, 0.15));
        setFightPoint(getFightPoint() + updateFight(rank, 0.15));
    }

    public void spendFightPoint(int point) {
        setFightPoint((getFightPoint() - point));
    }


    /**
     * compare if Hero can do an attack.
     *
     * @param p  success probability
     * @param fp spend fight points
     * @return true if it's possible.
     */
    public boolean allowAttack(int p, int fp) {
        return probability(p) && isNotZero(fp);
    }

    /**
     * given probability the attack will be effective de 0 a 100
     *
     * @param probability define probability
     * @return if attack is effective, it will return True.
     */
    public boolean probability(int probability) {
        Random r = new Random();
        int aux = (int) (r.nextFloat() * 100);
        return probability >= aux;
    }

    public boolean isNotZero(int point) {
        int fp = getFightPoint();
        return fp > point - 1;
    }

    public int boundAttack(double percentage) {
        return (int) (this.getHealthPoints() * percentage);
    }

    public  abstract int maxFight(int rank);
}

