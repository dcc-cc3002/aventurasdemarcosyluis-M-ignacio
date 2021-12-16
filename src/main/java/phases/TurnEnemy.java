package phases;
import model.Hero.IHero;
import java.util.Random;

/**
 * Clase TurnEnemy, Corresponde a una fase del juego
 */
public class TurnEnemy extends Phase {
    final Random random = new Random();
    float prob;

    /**
     * Constructor de la fase TurnEnemy. Se generan los atributos
     * characteristics de la fase
     */
    public TurnEnemy() {
        canStart = true;
        canFight = true;
        selectOpponent = true;
        selectAttack = true;
        useItem = false;
        selectItem = false;
        canFinish = true;
        prob = nextNumber();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IHero selectRandomHero(Integer seed){
        if(seed != null){
            plantSeed(seed);
            prob = nextNumber();
        }
        if(prob > 0.50){
            return controller.getPlayers().get(0);
        }
        return controller.getPlayers().get(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attackHero(IHero hero) throws InvalidSelectException {
        controller.attackHero(hero);
    }

    /**
     * se genera el siguiente número
     * @return número float
     */
    public float nextNumber() {
        return getRandom().nextFloat();
    }

    /**
     * se setea el atributo Random
     * @return atributo random
     */
    public Random getRandom() {
        return random;
    }

    /**
     * The value of the random variable is defined.
     *
     * @param seed number seed
     */
    public void plantSeed(int seed) {
        random.setSeed(seed);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TurnEnemyPhase";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurnPhase());
    }
}
