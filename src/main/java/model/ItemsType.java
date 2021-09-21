package model;

public enum ItemsType {
    STAR{
        @Override
        public void effect(Hero hero){
            //soon...
        }
    },
    RED_MUSHROOM{
        @Override
        public void effect(Hero hero){
            int max = hero.maxHealth();
            int plus = hero.getHealthPoints() + (int) (max*0.10);
            if(plus >= max){
                hero.setHealthPoint(max);
            }else{
                hero.setHealthPoint(plus);
            }
        }

    },
    HONEY_SYRUP{
        @Override
        public void effect(Hero hero){
            hero.setFightPoints(hero.getFightPoints() + 3);
        }

    };
    public abstract void effect(Hero hero);
}
