package phases;

/**
 * Clase EndPhase. Corresponde a una clase de juego.
 */
public class EndTurnPhase extends Phase {

    /**
     * Constructor de la fase EndTurnPhase. Se generan los atributos characteristics de la fase.
     */
    public EndTurnPhase() {
        canStart = false;
        canFight = false;
        selectOpponent = false;
        selectAttack = false;
        useItem = false;
        selectItem = false;
        canFinish = true;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void endTurn() throws InvalidMovementException {
        super.endTurn();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void toStartPhase() {
        changePhase(new StartPhase());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "EndTurnPhase";
    }
}
