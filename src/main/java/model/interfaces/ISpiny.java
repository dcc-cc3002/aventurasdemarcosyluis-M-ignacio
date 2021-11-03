package model.interfaces;

import model.Marcos;
import model.Luis;
public interface ISpiny extends IOpponent{
    void attackedByJumpLuis(Luis luis);
    void attackedByHammerLuis(Luis luis);

    void attackedByJumpMarcos(Marcos marcos);
    void attackedByHammerMarcos(Marcos marcos);

    void attackNormal(Marcos marcos);
}
