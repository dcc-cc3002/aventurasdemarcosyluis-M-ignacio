package model.interfaces;

import model.Spiny;
import model.*;

public interface IMarcos extends IHero {
    void attackHammer(Boo opponent);
    void attackJump(Boo opponent);

    void attackedByGoomba(Goomba goomba);
    void attackedBySpiny(Spiny spiny);
}
