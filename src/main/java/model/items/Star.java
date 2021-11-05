package model.items;

import model.abstracts.AbstractHero;
import model.enums.ItemsType;
import model.interfaces.IHero;
import model.interfaces.IItems;

/**
 * First item available for a hero. The effect make that a hero
 * will be invincible for a short period of time (actually it will do soon).
 */
public class Star implements IItems {
    private final ItemsType dType;

    /**
     * Star Constructor. Create a Star Object item.
     */
    public Star() {
        dType = ItemsType.STAR;
    }

    /**
     * Attributing effect of the Star item on a hero.
     *
     * @param hero type of hero that receive the effect.
     */
    @Override
    public void effect(IHero hero) {
        //it'll do something soon
    }

    //Javadoc inherited
    @Override
    public ItemsType getType() {
        return dType;
    }
}
