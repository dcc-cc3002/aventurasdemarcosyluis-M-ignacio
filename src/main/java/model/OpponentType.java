package model;

/**
 * Opponent Types available for the game
 */
public enum OpponentType{

    /**
     * Goomba is a recurring and the most common Opponent among all enemies.
     * He's bump into an enemy to hurt them. He attacks Marcos and Luis
     * normally when it is her turn. He can be injured to any attack type.
     */
    GOOMBA {
        //Javadoc inherited
        @Override
        public int maxHealth(int rank) {
            return 30 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxHit(int rank) {
            return 20 + (rank - 1) * 2;
        }

        //Javadoc inherited
        @Override
        public int maxDefense(int rank) {
            return 40 * (rank - 1) * 4;
        }
    },
    /**
     * He's character with a red spiky shell. If a main character attacks
     * Spiny  with a jumping then the attacker receives damage to five percent
     * of his HP and Spiny don't receive any damage. Spiny can be injured
     * fby any other attack.
     */
    SPINY {
        //Javadoc inherited
        @Override
        public int maxHealth(int rank) {
            return 20 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxHit(int rank) {
            return 40 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxDefense(int rank) {
            return 30 * (rank - 1) * 3;
        }
    },
    /**
     * Boo is the most common ghost enemy. He only attacks Luis. If He attacked
     * with a hammer, He dodges it. He can be injured by any other attack.
     */
    BOO {
        //Javadoc inherited
        @Override
        public int maxHealth(int rank) {
            return 10 + (rank - 1) * 5;
        }

        //Javadoc inherited
        @Override
        public int maxHit(int rank) {
            return 30 + 3 * rank;
        }

        @Override
        public int maxDefense(int rank) {
            return 30 * (rank - 1) * 4;
        }
    };

    /**
     * Determines maximum HitPoints for a Hero given his current level.
     *
     * @param rank current Rank
     * @return maximum Health Points
     */
    public abstract int maxHit(int rank);

    /**
     * Determines maximum DefPoints for a Hero given his current level.
     *
     * @param rank current Rank
     * @return maximum Defense Points
     */
    public abstract int maxDefense(int rank);

    /**
     * determines maximum Health Points for Hero given his current level.
     *
     * @param rank current Rank
     * @return maximum Health Points
     */
    public abstract int maxHealth(int rank);
}
