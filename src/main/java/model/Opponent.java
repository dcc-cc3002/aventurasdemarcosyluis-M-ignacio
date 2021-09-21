package model;

public class Opponent extends AbstractCharacters {
    private OpponentType type;

    public Opponent(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, OpponentType dType) {
        super(dRank, dHitPoint, dDefPoint, dHealthPoint);
        this.type = dType;
    }

    public OpponentType getType() {
        return type;
    }

    public void setType(OpponentType nType) {
        this.type = nType;
    }

    @Override
    public int maxHealth() {
        OpponentType aOpponent = getType();
        return aOpponent.maxHealth(this.getRank());
    }

    public void updateLvl() {
        setRank(getRank() + 1); // update next level
        UpStats(getRank());
    }

    @Override
    public void UpStats(int rank) {
        OpponentType aOpponent = getType();
        setHitPoints(aOpponent.maxHit(getRank()));
        setDefPoints(aOpponent.maxDefense(getRank()));
        setHealthPoint(aOpponent.maxHealth(getRank()));
    }
}
