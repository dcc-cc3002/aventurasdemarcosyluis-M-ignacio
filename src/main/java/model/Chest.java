package model;

import java.util.Enumeration;
import java.util.Hashtable;

import model.enums.ItemsType;
import model.interfaces.*;


public class Chest {
    private final Hashtable<ItemsType, Integer> itemChest;
    private final ItemsType redMushroom = ItemsType.RED_MUSHROOM;
    private final ItemsType HoneySyrup = ItemsType.HONEY_SYRUP;


    public Chest() {
        this.itemChest = new Hashtable<>(2);
    }

    private Hashtable<ItemsType, Integer> getChest() {
        return itemChest;
    }

    public int getValue(ItemsType type) {
        if (getChest().get(type) == null) {
            return 0;
        }return getChest().get(type);
    }

    public void putValue(ItemsType type, int value) {
        getChest().put(type, value);
    }

    public void replaceValue(ItemsType type, int value) {
        getChest().replace(type, value);
    }

    public boolean search(IItems item) {
        return getValue(item.getType()) != 0;
    }

    public void initial(int n) {
        getChest().put(redMushroom, n);
        getChest().put(HoneySyrup, n);
    }

    public int capacity() {
        int sum = 0;
        Enumeration<Integer> numerate = getChest().elements();
        while (numerate.hasMoreElements()) {
            sum = sum + numerate.nextElement();
        }
        return sum;
    }

    public void add(IItems item) {
        int n = getValue(item.getType());
        if (n != 0) {
            n = n + 1;
        } else {
            n = 1;
        }
        putValue(item.getType(), n);
    }

    public void remover(IItems item) {
        int n = getValue(item.getType());
        if (n != 0) {
            replaceValue(item.getType(), n - 1);
        }
    }

    public boolean isEmpty() {
        return capacity() == 0;
    }

    public void spend(IItems item, IHero hero) {
        int n = getValue(item.getType());
        if (n != 0) {
            remover(item);
            hero.spendItem(item);
        }
    }
}
