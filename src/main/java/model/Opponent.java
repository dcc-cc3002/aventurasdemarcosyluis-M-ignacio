package model;

/**
 * CLass that define constructor and methods implemented by Opponent object.
 * The opponents are controlled by computer. They attack the heroes and don't get
 * to hit between them.
 */
public class Opponent extends AbstractCharacters {
    private OpponentType type;

    /**
     * Constructor that allow to create a new "Opponent" object initialized with
     * any desired stats.
     *
     * @param dRank        define Rank
     * @param dHitPoint    define Hit Points
     * @param dDefPoint    define Defense Points
     * @param dHealthPoint define Health Points
     * @param dType        define Opponent Type
     */
    public Opponent(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint);
        this.type = dType;
    }

    /**
     * Constructor that allows to create a new "Opponent" object initialized with
     * the maximum stats (attribute) given the Rank entered.
     *
     * @param dRank define Rank
     * @param dType define Opponent Type
     */
    public Opponent(int dRank, OpponentType dType) {
        super(dRank, 0, 0, 0);
        this.type = dType;
        upStats(dRank);
    }

    /**
     * Get Opponent Type
     *
     * @return Opponent Type
     */
    public OpponentType getType() {
        return type;
    }

    //Javadoc inherited
    @Override
    public int maxHealth() {
        OpponentType aOpponent = getType();
        return aOpponent.maxHealth(this.getRank());
    }

    //Javadoc inherited
    @Override
    public void upStats(int rank) {
        OpponentType aOpponent = getType();
        setHitPoints(aOpponent.maxHit(rank));
        setDefPoints(aOpponent.maxDefense(rank));
        setHealthPoint(aOpponent.maxHealth(rank));
    }
}