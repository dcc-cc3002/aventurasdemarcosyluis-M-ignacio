package model;

/**
 * Heroes Types available for the game.
 */
public enum HeroType {

    /**
     * The main character of the game. It's controlled by players.
     */
    MARCOS {
        //Javadoc inherited
        @Override
        public int maxHit(int rank) {
            return 10 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxDefense(int rank) {
            return 40 + (rank - 1) * 4;
        }

        //Javadoc inherited
        @Override
        public int maxHealth(int rank) {
            return 30 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxFight(int rank) {
            return 10 + (rank - 1) * 5;
        }
    },
    /**
     * The second character of the game. Being honest everyone prefers
     * Marcos but if you have bad taste, you can choose it.
     */
    LUIS {
        //Javadoc inherited
        @Override
        public int maxHit(int rank) {
            return 30 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxDefense(int rank) {
            return 20 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxHealth(int rank) {
            return 10 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxFight(int rank) {
            return 5 + (rank - 1) * 5;
        }
    };

    /**
     * Determines maximum HitPoints for a Hero given his current level.
     *
     * @param rank current Rank of a hero
     * @return maximum HitPoints
     */
    public abstract int maxHit(int rank);

    /**
     * Determines maximum DefPoints for a Hero given his current level.
     *
     * @param rank current Rank of a hero
     * @return maximum DefPoints
     */
    public abstract int maxDefense(int rank);

    /**
     * Determines maximum HealthPoints for a Hero given his current level.
     *
     * @param rank current Rank of a hero
     * @return maximum HealthPoints
     */
    public abstract int maxHealth(int rank);

    /**
     * determines maximum FightPoints for a Hero given his current level.
     *
     * @param rank current Rank of a hero
     * @return maximum FightPoints
     */
    public abstract int maxFight(int rank);

}
