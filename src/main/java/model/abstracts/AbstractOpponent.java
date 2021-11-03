package model.abstracts;

import model.enums.OpponentType;
import model.interfaces.IOpponent;

/**
 * CLass that define constructor and methods implemented by Opponent object.
 * The opponents are controlled by computer. They attack the heroes and don't get
 * to hit between them.
 */
public abstract class AbstractOpponent extends AbstractCharacters implements IOpponent {
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
    public AbstractOpponent(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
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
    public AbstractOpponent(int dRank, OpponentType dType) {
        super(dRank, 0, 0, 0);
        this.type = dType;
        maxUpStats(dRank);
    }

    /**
     * Get Opponent Type
     *
     * @return Opponent Type
     */
    public OpponentType getType() {
        return type;
    }

    @Override
    public void maxUpStats(int rank){
        setHitPoints(maxHit(rank));
        setDefPoints(maxDefense(rank));
        setHealthPoint(maxHealth(rank));
    }

}