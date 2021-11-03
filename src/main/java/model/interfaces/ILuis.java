package model.interfaces;

import model.Boo;
import model.Goomba;
import model.Spiny;

public interface ILuis extends IHero{

    void attackedByGoomba(Goomba goomba);
    void attackedBySpiny(Spiny spiny);
    void attackedByBoo(Boo Boo);

}
