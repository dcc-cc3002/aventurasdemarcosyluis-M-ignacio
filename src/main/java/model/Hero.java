package model;

import java.util.ArrayList;
import java.util.Random;

public class Hero extends AbstractCharacters{
    private HeroType type;
    private int fightPoints;
    private ArrayList<ItemsType> weapons;

    public Hero(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, HeroType dType){
        super(dRank,dHitPoint,dDefPoint, dHealthPoint);
        this.type = dType;
        weapons = new ArrayList<>();
    }

    //prob es la probabilidad de exito
    public boolean effectiveHit(int prob){
        Random r = new Random();
        int aux = (int)(r.nextFloat()*100);
        return prob < aux;
    }
    public boolean enoughFightPoints(int fp){
        return (fightPoints - fp) > 0;
    }
    public boolean allowAttack(int prob,int fp){
        return effectiveHit(prob) && enoughFightPoints(fp);
    }
    public void jumpAttack(Opponent opponent){
        int damage = calculateDamage(this,opponent,1);
        if(allowAttack(100,1)) {
            opponent.setHealthPoint(getHealthPoint() - damage);
        }
    }
    public void hammerAttack(Opponent opponent){
        int damage = calculateDamage(this,opponent,1);
        if(allowAttack(75,2)) {
            opponent.setHealthPoint(getHealthPoint() - damage);
        }
    }

    public ArrayList<ItemsType> getWeapons() {
        return weapons;
    }

    public int getFightPoints() {
        return fightPoints;
    }

    public void setFightPoints(int fightPoints) {
        this.fightPoints = fightPoints;
    }

    public HeroType getType() {
        return type;
    }

    public void addItem(ItemsType nItem){
        weapons.add(nItem);
    }
    public int getItemIndex(ItemsType testStar) {
        return weapons.indexOf(testStar);
    }

    public void SpendItemTest(ItemsType type){
        weapons.remove(getItemIndex(type));
        type.effect(this);
    }

    public int maxHealth(HeroType hero){
        return hero.MaxHealth(this.getRank());
    }


}

