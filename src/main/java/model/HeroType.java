package model;

public enum HeroType  {
    MARCOS {
        @Override
        public int maxHitHero(int rank) {
            return 10 +(rank -1)*5;
        }

        @Override
        public int maxDefenseHero(int rank) {
            return 40 + (rank-1)*4;
        }

        @Override
        public int maxHealthHero(int rank) {
            return 30 + (rank-1)*5;
        }

        @Override
        public int maxFightHero(int rank) {
            return 20 + (rank - 1) * 5;
        }


    },
    LUIS{
        @Override
        public int maxHitHero(int rank) {
            return 30 + (rank - 1)*5;
        }
        @Override
        public int maxDefenseHero(int rank) {
            return 20 + (rank-1)*5;
        }
        @Override
        public int maxHealthHero(int rank) {
            return 10 + (rank-1)*5;
        }
        @Override
        public int maxFightHero(int rank) {
            return 5 + (rank-1)*5;
        }
    };

    public abstract int maxHitHero(int rank);
    public abstract int maxDefenseHero(int rank);
    public abstract int maxHealthHero(int rank);
    public abstract int maxFightHero(int rank);

}
