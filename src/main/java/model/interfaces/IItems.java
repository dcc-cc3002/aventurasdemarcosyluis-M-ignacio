package model.interfaces;

import model.abstracts.AbstractHero;
import model.enums.ItemsType;

public interface IItems {
    /**
     * grants a Character Hero the effects of Items.
     *
     * @param hero blessed character
     */
    void effect(IHero hero);

    /**
     * Get a Type
     * @return Items Type
     */
    ItemsType getType();
}
