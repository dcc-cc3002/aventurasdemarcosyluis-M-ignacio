package phases;

import controller.GameController;
import model.interfaces.IHero;
import model.interfaces.IOpponent;

/**
 * Clase Phase. Permite controlar las acciones que se permiten para cada jugador y en cada
 * instante del juego.
 */
public class Phase {
    protected GameController controller;
    protected boolean canStart;
    protected boolean canFight;
    protected boolean selectOpponent;
    protected boolean selectAttack;
    protected boolean useItem;
    protected boolean selectItem;
    protected boolean canFinish;

    /**
     * Se set el controlador asociado a la lógica de fases.
     *
     * @param c controlador de juego
     */
    public void setController(GameController c) {
        this.controller = c;
    }

    /**
     * se entrega el nombre de la fase
     *
     * @return nombre de la fase
     */
    public String toString() {
        return "Phases";
    }

    /**
     * se cambia la fase actual por una nuevo fase
     *
     * @param p nueva fase a ingresar
     */
    public void changePhase(Phase p) {
        controller.setPhase(p);
    }

    /**
     * Se cambia la fase a EndTurnPhase
     *
     * @throws InvalidTransitionException excepción de transición
     */
    public void toEndTurnPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "You can't move from " + this.toString() + " to EndTurn Phase");
    }

    /**
     * Se cambia la fase a FightPhase
     *
     * @throws InvalidTransitionException excepción de transición
     * @throws InvalidSelectException     excepción de selección
     */
    public void toFightPhase() throws InvalidTransitionException, InvalidSelectException {
        throw new InvalidTransitionException(
                "You can't move from " + this.toString() + " Fight Phase");
    }

    /**
     * Se cambia la fase a StartPhase.
     *
     * @throws InvalidTransitionException excepción de transición
     */
    public void toStartPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "You can't move from " + this.toString() + " StartPhase Phase");
    }

    /**
     * Se cambia la fase a TurnEnemyPhase.
     *
     * @throws InvalidTransitionException excepción de transición
     */
    public void toTurnEnemy() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "You can't move from " + this.toString() + " TurnEnemy Phase");
    }

    /**
     * Se cambia la fase a WaitBattlePhase
     *
     * @param isPlaying Se ingresa el jugador atacante
     * @throws InvalidTransitionException excepción de transición
     */
    public void toWaitBattlePhase(IHero isPlaying) throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "You can't move from " + this.toString() + " WaitBattle Phase");
    }

    /**
     * Se cambia la fase a WaitUseItemPhase.
     *
     * @throws InvalidTransitionException excepción de transición
     */
    public void toWaitUseItemPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "You can't move from " + this.toString() + " WaitUseItem Phase");
    }
////

    /**
     * End current player's turn.
     */
    public void endTurn() throws InvalidMovementException {
        if (!canFinish) {
            throw new InvalidMovementException(" no puedes terminar desde la etapa" + this.toString());
        }
        controller.finishTurn();
    }

    /**
     * se genera un ataque martillo sobre un oponente.
     *
     * @param seed     seed para definir la efectividad del ataque
     * @param opponent oponente atacado
     * @throws InvalidMovementException excepción de movimiento
     */
    public void generateAttackHammer(int seed, int opponent) throws InvalidMovementException {
        if (!canFight) {
            throw new InvalidMovementException("No puedes atacar desde la etapa" + this.toString());
        }
    }

    /**
     * Se genera aun ataque Salto sobre el oponente.
     *
     * @param opponent oponente atacado
     * @throws InvalidMovementException excepción de movimiento
     */
    public void generateAttackJump(int opponent) throws InvalidMovementException {
        if (!canFight) {
            throw new InvalidMovementException("No puedes atacar desde la etapa" + this.toString());
        }
    }

    /**
     * Se escoge un enemigo a partir de los que participan en la partida.
     *
     * @param n indice del enemigo seleccionado
     * @throws InvalidSelectException excepción de movimiento
     */
    public void selectEnemy(int n) throws InvalidSelectException {
        if (!selectOpponent) {
            throw new InvalidSelectException(("No se puede seleccionar un enemigo en la etapa " + this.toString()));
        }
    }

    /**
     * Se selecciona un hero random de la partida.
     *
     * @param seed seed para definir la efectividad del ataque
     * @return un hero de la partida
     * @throws InvalidMovementException excepción de movimiento
     */
    public IHero selectRandomHero(Integer seed) throws InvalidMovementException {
        if (!selectOpponent) {
            throw new InvalidMovementException("No se puede seleccionar a un hero en la etapa " + this.toString());
        }
        return null;
    }

    /**
     * Se ataca a un hero seleccionado.
     *
     * @param hero Hero atacado
     * @throws InvalidMovementException Excepción de movimiento
     * @throws InvalidSelectException   Excepción de selección
     */
    public void attackHero(IHero hero) throws InvalidMovementException, InvalidSelectException {
        if (!canFight) {
            throw new InvalidMovementException("No se puede atacar un hero desde la etapa " + this.toString());
        }
    }

    /**
     * se obtiene el oponente asociado a la fase
     *
     * @return oponente seleccionado
     * @throws InvalidMovementException Excepción de movimiento.
     */
    public IOpponent getOpponent() throws InvalidMovementException {
        if (!canFight) {
            throw new InvalidMovementException("No se puede obtener un oponente desde la etapa " + this.toString());
        }
        return null;
    }
}

