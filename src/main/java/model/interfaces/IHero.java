package model.interfaces;

import model.*;

public interface IHero extends Character{
    void attackJump(Goomba opponent);
    void attackJump(Spiny opponent);
    void attackHammer(Goomba opponent);
    void attackHammer(Spiny opponent);

    int maxFight();
    int maxHealth();
    int getFightPoint();
    void setFightPoint(int set);

    void spendItem(IItems item);
}
