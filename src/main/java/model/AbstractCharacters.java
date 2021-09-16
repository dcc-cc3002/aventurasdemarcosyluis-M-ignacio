package model;

public abstract class AbstractCharacters implements Character {
    private int rank;
    private int hitPoint;
    private int defPoint;
    private int healthPoint;

    //constructor
    public AbstractCharacters(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint) {
        this.rank = dRank;
        this.hitPoint = dHitPoint;
        this.defPoint = dDefPoint;
        this.healthPoint = dHealthPoint;
    }

    public int getRank() {
        return rank;
    }

    public int getHitPoints() {
        return hitPoint;
    }

    public void setHitPoints(int hp){
        this.hitPoint = hp;
    }
    public int getDefPoints() {
        return hitPoint;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDefPoint() {
        return defPoint;
    }

    public void setDefPoint(int defPoint) {
        this.defPoint = defPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }


    protected int calculateDamage(Character A, Character B, int K) {
        //implement damage formulate
        return K * partialCalculate(A) / B.getDefPoints();
    }

    private int partialCalculate(Character A) {
        return A.getHitPoints() * A.getRank();
    }


    //personaje KO golpea con 0
    public void KO(Character A){
        if(defeated(A)) A.setHitPoints(0);
    }

    public boolean defeated(Character A){
        return A.getHealthPoint() == 0;
    }


}
    