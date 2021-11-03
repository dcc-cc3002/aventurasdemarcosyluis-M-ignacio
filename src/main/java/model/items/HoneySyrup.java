package model.items;

import model.abstracts.AbstractHero;
import model.enums.ItemsType;
import model.interfaces.IHero;
import model.interfaces.IItems;

/**
 * Third item available for a hero. The effect give the hero a three
 * fighting points. The hero only can recover fighting points up to
 * maximum fighting points by his actual level.
 */
public class HoneySyrup implements IItems {
    private final ItemsType dType;

    public HoneySyrup(){
        this.dType = ItemsType.HONEY_SYRUP;
    }

    /**
     * attribute effect to Honey Syrup item on a hero.
     *
     * @param hero type of hero that receive the effect.
     */
    @Override
    public void effect(IHero hero) {
        int max = hero.maxFight();
        int plus = hero.getFightPoint() + 3;
        if (plus >= max) hero.setFightPoint(max);
        else hero.setFightPoint(plus);
    }

    public ItemsType getType() {
        return dType;
    }
}