package model.interfaces;

import model.Luis;
import model.Marcos;

public interface IBoo extends IOpponent {
    void attackedByJumpMarcos(Marcos marcos);
    void attackedByHammerMarcos(Marcos marcos);
}
