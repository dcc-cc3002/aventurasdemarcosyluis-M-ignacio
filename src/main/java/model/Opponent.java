package model;

public class Opponent extends AbstractCharacters {
    private OpponentType type;

    public Opponent(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint);
        this.type = dType;
    }

    public Opponent(int dRank, OpponentType dType) {
        super(dRank, 0, 0, 0);
        this.type = dType;
        upStats(dRank);
    }


    public OpponentType getType() {
        return type;
    }

    @Override
    public int maxHealth(){
        OpponentType aOpponent = getType();
        return aOpponent.maxHealth(this.getRank());
    }

    @Override
    public void upStats(int rank) {
        OpponentType aOpponent = getType();
        setHitPoints(aOpponent.maxHit(rank));
        setDefPoints(aOpponent.maxDefense(rank));
        setHealthPoint(aOpponent.maxHealth(rank));
    }
}