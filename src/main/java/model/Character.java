package model;

/**
 * Interface implemented in the Abstract Characters class.
 */
public interface Character {

    /**
     * get HitPoints.
     *
     * @return current HitPoints
     */
    int getHitPoints();

    /**
     * set HitPoints.
     *
     * @param hp new HitPoints
     */
    void setHitPoints(int hp);

    /**
     * get Rank.
     *
     * @return current Rank
     */
    int getRank();

    /**
     * set Rank
     *
     * @param rank new rank
     */
    void setRank(int rank);

    /**
     * get DefPoints.
     *
     * @return current Defense Points
     */
    int getDefPoints();

    /**
     * set DefPoints.
     *
     * @param defPoint new Defense Points
     */
    void setDefPoints(int defPoint);

    /**
     * get HealthPoints.
     *
     * @return current HealthPoints
     */
    int getHealthPoints();

    /**
     * set HealthPoints.
     *
     * @param healthPoint new Health Points
     */
    void setHealthPoint(int healthPoint);

    /**
     * gives us the maximum character Health Points.
     *
     * @return maximum Health Points
     */
    int maxHealth();

}

