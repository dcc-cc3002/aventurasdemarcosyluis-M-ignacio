package phases;

/**
 * clase WaitUseItemPhase, correspond a una fase de juego
 */
public class WaitUseItemPhase extends Phase{

    /**
     * Constructor de la clase, se generan los atributos characteristics de la fase.
     */
    public WaitUseItemPhase() {
        canStart = false;
        canFight = false;
        selectOpponent = false;
        selectAttack = false;
        useItem = true;
        selectItem = true;
        canFinish = false;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "WaitUseItemPhase";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurnPhase());
    }
}
