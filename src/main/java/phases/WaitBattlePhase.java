package phases;
import model.Hero.IHero;
import model.Opponent.IOpponent;

/**
 * clase WaitBattlePhase, correspondde a una fase de juego.
 */
public class WaitBattlePhase extends Phase{
    private IHero attacker;
    private IOpponent opponent;


    /**
     * Constructor de la fase WaitBattlePhase. Se generan los atributos
     * characteristics de la fase
     */
    public WaitBattlePhase(IHero hero) {
        canStart = false;
        canFight = false;
        selectOpponent = true;
        selectAttack = false;
        useItem = false;
        selectItem = false;
        canFinish = false;
        attacker = hero;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void selectEnemy(int n) {
        opponent = controller.selectEnemies(n);
    }

    /**
     * Comprueba que el enemigo es atacable por el personaje principal.
     * @throws InvalidSelectException exception
     */
    private void assertValidEnemy() throws InvalidSelectException {
        if(!controller.assertEnemy(attacker,opponent)){
            throw new InvalidSelectException("No puedes atacar a este personaje");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toFightPhase() throws InvalidSelectException {
        assertValidEnemy();
        changePhase(new FightPhase(attacker,opponent));
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString(){
        return "WaitBattlePhase";
    }





}
