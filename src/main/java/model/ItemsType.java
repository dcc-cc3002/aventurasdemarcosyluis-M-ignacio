package model;

public enum ItemsType {
    /**
     * First item available for a hero. The effect make that a hero will be invincible
     * for a short period of time.
     */
    STAR {
        /**
         * attributing effect of the Star item on a hero.
         * @param hero type fo hero that receive the effect.
         */
        @Override
        public void effect(Hero hero) {
            //it'll do something soon
        }

    },
    /**
     * Second item available for a hero. The effect heals hero ten percent
     * of his maximum health. It's exist a limit to the amount points health
     * he can recover it given by his maximum health for his actual level.
     */
    RED_MUSHROOM {
        /**
         * attributing effect of the Red Mushroom item on a hero.
         *
         * @param hero type fo hero that receive the effect.
         */
        @Override
        public void effect(Hero hero) {
            int max = hero.maxHealth();
            int plus = hero.getHealthPoints() + (int) (max * 0.10);
            if (plus >= max) {
                hero.setHealthPoint(max);
            } else {
                hero.setHealthPoint(plus);
            }
        }

    },
    /**
     * Third item available for a hero. The effect give the hero a three
     * fighting points. The hero only can recover fighting points up to
     * maximum fighting points by his actual level.
     */
    HONEY_SYRUP {
        /**
         * attribute effect to Honey Syrup item on a hero.
         *
         * @param hero type fo hero that receive the effect.
         */
        @Override
        public void effect(Hero hero) {
            int max = hero.maxFight();
            int plus = hero.getFightPoints() + 3;
            if (plus >= max) hero.setFightPoints(max);
            else hero.setFightPoints(plus);
        }

    };

    /**
     * attributing effect of the star item on a hero.
     *
     * @param hero type fo hero that receive the effect.
     */
    public abstract void effect(Hero hero);
}
