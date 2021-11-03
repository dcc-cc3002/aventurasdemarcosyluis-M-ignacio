package model.interfaces;

import model.Luis;
import model.Marcos;

public interface IGoomba extends IOpponent {
    //se heredan las condiciones de IOpponent

    void attackedByJumpLuis(Luis luis);
    void attackedByHammerLuis(Luis luis);
    void attackedByJumpMarcos(Marcos marcos);
    void attackedByHammerMarcos(Marcos marcos);

    void attackNormal(Marcos marcos);


}
