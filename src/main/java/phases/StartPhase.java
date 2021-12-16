package phases;

import model.Hero.IHero;

/**
 * clase StartPhase, es una fase de juego.
 */
public class StartPhase extends Phase {
    /**
     * constructor de la fase StartPhase. SE generan los atributos characteristics de la fase.
     */
    public StartPhase() {
        canStart = true;
        canFinish = false;
        canFight = false;
        selectOpponent = false;
        selectAttack = false;
        useItem = false;
        selectItem = false;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "StartPhase";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void toTurnEnemy() {
        changePhase(new TurnEnemy());
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void toWaitBattlePhase(IHero c) {
        changePhase(new WaitBattlePhase(c));
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void toWaitUseItemPhase() {
        changePhase(new WaitUseItemPhase());
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public void toEndTurnPhase() {
        changePhase(new EndTurnPhase());
    }

}
