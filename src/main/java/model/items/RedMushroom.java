package model.items;

import model.enums.ItemsType;
import model.interfaces.IHero;
import model.interfaces.IItems;


/**
 * Second item available for a hero. The effect heals hero ten percent
 * of his maximum health. It's exist a limit to the amount points health
 * he can recover it given by his maximum health for his actual level.
 */
public class RedMushroom implements IItems {
    private final ItemsType dType;

    /**
     * redMushroom constructor. Create a redMushroom object item
     */
    public RedMushroom() {
        this.dType = ItemsType.RED_MUSHROOM;
    }


    /**{@inheritDoc}*/
    @Override
    public ItemsType getType() {
        return dType;
    }

    /**
     * Attributing effect of the Red Mushroom item on a hero.
     *
     * @param hero type of hero that receive the effect.
     */
    @Override
    public void effect(IHero hero) {
        int max = hero.maxHealth();
        int plus = hero.getHealthPoints() + (int) (max * 0.10);
        hero.setHealthPoint(Math.min(plus, max));
    }

}
