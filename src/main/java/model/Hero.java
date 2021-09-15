package model;
import java.util.Random;

public class Hero extends AbstractCharacters{
    private String name;
    private int fightPoints;

    public Hero(int dRank, int dHitPoint, int dDefPoint, int dHealthPoint, String hisName){
        super(dRank,dHitPoint,dDefPoint,dHealthPoint);
        this.name = hisName;
    }

    public boolean effectiveHit(int prob){
        Random r = new Random();
        int aux = (int)(r.nextFloat()*100);
        return prob < aux;
    }
    public boolean enoughFightPoints(int fp){
        return (fightPoints - fp) > 0;
    }
//d/
    public boolean allowAttack(int prob,int fp){
        return effectiveHit(prob) & enoughFightPoints(fp);
    }
    public void jumpAttack(Opponent opponent){
        int damage = calculateDamage(this,opponent,1);
        if(allowAttack(100,1)) {
            opponent.setHealthPoint(getHealthPoint() - damage);
        }
    }

    public void hammerAttack(Opponent opponent){
        int damage = calculateDamage(this,opponent,1);
        if(allowAttack(25,2)) {
            opponent.setHealthPoint(getHealthPoint() - damage);
        }
    }
}
