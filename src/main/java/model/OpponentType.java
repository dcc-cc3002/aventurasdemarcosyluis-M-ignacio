package model;

public enum OpponentType {


    GOOMBA{
        @Override
        public int maxHealth(int rank) {
            return 30 + (rank-1)*5;
        }

        @Override
        public int maxHit(int rank) {
            return 20 + (rank - 1)*2;
        }
    },
    SPINY{
        @Override
        public int maxHealth(int rank) {
            return 20 + (rank-1)*5;
        }

        @Override
        public int maxHit(int rank) {
            return 40 + (rank - 1)*5;
        }
    },
    BOO{
        @Override
        public int maxHealth(int rank) {
            return 10 + (rank-1)*5;
        }
        @Override
        public int maxHit(int rank) {
            return 30 + 3*rank;
        }
    };



    public int maxDefense(int rank){
        return 30 + (rank - 1)*4;
    }

    public abstract int maxHealth(int rank);
    public abstract int maxHit(int rank);
}
