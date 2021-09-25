package model;

import java.util.ArrayList;

/**
 * CLass that define constructor and methods implemented by Hero object.
 */
public class Hero extends AbstractCharacters {
    private HeroType type;
    private int fightPoints;
    private ArrayList<ItemsType> weapons;

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
    public Hero(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, int dFightPoint, HeroType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint);
        this.type = dType;
        this.fightPoints = dFightPoint;
        weapons = new ArrayList<>();
    }
//
    /**
     * Constructor that allows to create a new "Hero" object initialized
     * with the maximum stats (attribute) given the Rank entered.
     *
     * @param rank        define Rank
     * @param dType       define Hero Type
     * @param dFightPoint define Fight Points
     */
    public Hero(int rank, HeroType dType, int dFightPoint) {
        super(rank, 0, 0, 0);
        this.type = dType;
        this.fightPoints = dFightPoint;
        weapons = new ArrayList<>();
        upStats(rank);
    }

    /*/
    //prob es la probabilidad de exito
    public boolean effectiveHit(int prob) {
        Random r = new Random();
        int aux = (int) (r.nextFloat() * 100);
        return prob < aux;
    }

    public boolean enoughFightPoints(int fp) {
        return (fightPoints - fp) > 0;
    }

    public boolean allowAttack(int prob, int fp) {
        return effectiveHit(prob) && enoughFightPoints(fp);
    }

    public void jumpAttack(Opponent opponent) {
        int damage = calculateDamage(this, opponent, 1);
        if (allowAttack(100, 1)) {
            opponent.setHealthPoint(getHealthPoints() - damage);
        }
    }

    public void hammerAttack(Opponent opponent) {
        int damage = calculateDamage(this, opponent, 1);
        if (allowAttack(75, 2)) {
            opponent.setHealthPoint(getHealthPoints() - damage);
        }
    }
    */

    /**
     * get Weapons List.
     *
     * @return Weapon list
     */
    public ArrayList<ItemsType> getWeapons() {
        return weapons;
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
    public int getFightPoints() {
        return fightPoints;
    }

    /**
     * set Fight Points.
     *
     * @param fightPoints new Fight Points
     */
    public void setFightPoints(int fightPoints) {
        this.fightPoints = fightPoints;
    }

    /**
     * add a new items into available inventory for Hero.
     *
     * @param nItem new Item
     */
    public void addItem(ItemsType nItem) {
        weapons.add(nItem);
    }

    /**
     * Searching a particular item inside inventory. In case
     * of finding it return his index, otherwise it returns number -1.
     *
     * @param testStar item that want to be used
     * @return index fo the item
     */
    public int getItemIndex(ItemsType testStar) {
        return weapons.indexOf(testStar);
    }

    /**
     * Select an item to be used from available inventory.
     *
     * @param type item selected to be used
     */
    public void SpendItem(ItemsType type) {
        weapons.remove(getItemIndex(type));
        type.effect(this);
    }

    //Javadoc inherited
    @Override
    public int maxHealth() {
        HeroType aHero = getType();
        return aHero.maxHealth(getRank());
    }

    /**
     * Calculate maximum Fight Points given his current level.
     *
     * @return maximum Fight Points
     */
    public int maxFight() {
        HeroType aHero = getType();
        return aHero.maxFight(getRank());
    }

    //Javadoc inherited
    @Override
    public void upStats(int rank) {
        HeroType aHero = getType();
        setHitPoints(aHero.maxHit(rank));
        setDefPoints(aHero.maxDefense(rank));
        setHealthPoint(aHero.maxHealth(rank));
        setFightPoints(aHero.maxFight(rank));
    }

}

