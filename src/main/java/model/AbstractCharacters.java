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

    public void setHitPoints(int hp) {
        this.hitPoint = hp;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDefPoints() {
        return defPoint;
    }

    public void setDefPoints(int defPoint) {
        this.defPoint = defPoint;
    }

    public int getHealthPoints() {
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
    public void KO(Character A) {
        if (defeated(A)) A.setHitPoints(0);
    }

    public boolean defeated(Character A) {
        return A.getHealthPoints() == 0;
    }

    //definida en una clase superior
    //determina la vida maxima por nivel
    public int maxHealthGeneric() {
        return maxHealth();
    }


    public void updateLvl(Integer lvl) {
        lvl = lvl != null ? lvl : 1;
        setRank(getRank() + lvl); // update next level
        UpStats(getRank());
    }

    /**
     * @param rank object's level
     */
    public abstract void UpStats(int rank);
}
