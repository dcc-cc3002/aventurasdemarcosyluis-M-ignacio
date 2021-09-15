package model;

public class Opponent extends AbstractCharacters{
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
}
