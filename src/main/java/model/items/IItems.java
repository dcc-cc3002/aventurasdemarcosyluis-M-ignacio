package model.items;

import model.Hero.IHero;

/**
 * Items interface. Declare the common methods between existing items.
 */
public interface IItems {

    /**
     * Grants a Character Hero the effects of Items.
     *
     * @param hero blessed character
     */
    void effect(IHero hero);

    /**
     * Get a Type
     *
     * @return Items Type
     */
    ItemsType getType();
}
