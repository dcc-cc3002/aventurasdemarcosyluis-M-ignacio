package model.items;

import java.util.Enumeration;
import java.util.Hashtable;

import model.Hero.IHero;
import model.items.ItemsType;
import model.items.IItems;

/**
 * Chest that stores the items obtained during a game, which are
 * removed when used. The trunk is shared between the main characters.
 */
public class Chest {
    private final Hashtable<ItemsType, Integer> itemChest;
    private final ItemsType mush = ItemsType.RED_MUSHROOM;
    private final ItemsType honey = ItemsType.HONEY_SYRUP;


    /**
     * Chest Constructor. Create a Chest Object.
     */
    public Chest() {
        this.itemChest = new Hashtable<>(2);
    }

    /**
     * get itemChest implemented by a hashtable.
     *
     * @return get itemChest
     */
    public Hashtable<ItemsType, Integer> getItemsChest() {
        return itemChest;
    }

    /**
     * quantity of the same item in inventory.
     *
     * @param type enter itemType
     * @return item quantity available
     */
    public int getValue(ItemsType type) {
        if (getItemsChest().get(type) == null) {
            return 0;
        }
        return getItemsChest().get(type);
    }

    /**
     * Introduce a new item (key) to Chest.
     *
     * @param type  key chest
     * @param value amount item
     */
    public void putValue(ItemsType type, int value) {
        getItemsChest().put(type, value);
    }

    /**
     * Replaces the quantity of a specific item.
     *
     * @param type  item type
     * @param value quantity of item
     */
    public void replaceValue(ItemsType type, int value) {
        getItemsChest().replace(type, value);
    }

    /**
     * Put a quantity of starting items into inventory.
     *
     * @param n quantity of item
     */
    public void initial(int n) {
        getItemsChest().put(mush, n);
        getItemsChest().put(honey, n);
    }

    /**
     * Total number of items in inventory.
     *
     * @return all items
     */
    public int capacity() {
        int sum = 0;
        Enumeration<Integer> numerate = getItemsChest().elements();
        while (numerate.hasMoreElements()) {
            sum = sum + numerate.nextElement();
        }
        return sum;
    }

    /**
     * add a new item to inventory. If the item does not exist, add
     * the first item.
     *
     * @param item type Item
     */
    public void add(IItems item) {
        int n = getValue(item.getType());
        if (n != 0) {
            n = n + 1;
        } else {
            n = 1;
        }
        putValue(item.getType(), n);
    }

    /**
     * decreases the quantity of the selected item by one. If the
     * quantity is 0, it keeps it.
     *
     * @param item type item
     */
    public void remover(IItems item) {
        int n = getValue(item.getType());
        if (n != 0) {
            replaceValue(item.getType(), n - 1);
        }
    }

    /**
     * check if the inventory is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return capacity() == 0;
    }

    /**
     * use an item from inventory on a hero. When used it
     * is removed from the inventory for any other model.items.main character.
     *
     * @param item type item
     * @param hero type hero
     */
    public void spend(IItems item, IHero hero) {
        int n = getValue(item.getType());
        if (n != 0) {
            remover(item);
            hero.spendItem(item);
        }
    }
}
