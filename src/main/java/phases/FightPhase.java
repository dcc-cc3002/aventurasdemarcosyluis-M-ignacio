package phases;

import model.*;
import model.enums.HeroType;
import model.interfaces.IHero;
import model.interfaces.IOpponent;

/**
 * Clase FightPhase, corresponde a una de las fases del juego.
 */
public class FightPhase extends Phase {
    private final IHero attacker;
    private final IOpponent opponent;

    /**
     * constructor de la fase FightPhase. Se generan los atributos característicos de la fase.
     *
     * @param a personaje atacante
     * @param o personaje atacado
     */
    public FightPhase(IHero a, IOpponent o) {
        canStart = false;
        canFight = true;
        selectOpponent = false;
        selectAttack = false;
        useItem = false;
        selectItem = false;
        canFinish = false;
        attacker = a;
        opponent = o;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IOpponent getOpponent() {
        return opponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void generateAttackHammer(int seed, int opponent) {
        if (opponent == -2) {
            attackGoomba(seed);
        } else if (opponent == -3) {
            attackSpiny(seed);
        } else {
            attackBoo(seed);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void generateAttackJump(int opponent) {
        if (opponent == -2) { //Goomba
            attackJumpGoomba();
        } else if (opponent == -3) { //spiny
            attackJumpSpiny();
        } else {
            attackJumpBoo();
        }
    }

    /**
     * ataca con salto a un enemigo Boo
     */
    private void attackJumpBoo() {
        Marcos marcos = (Marcos) attacker;
        marcos.attackJump((Boo) opponent);
    }

    /**
     * ataca con salto aun enemigo Spiny
     */
    public void attackJumpSpiny() {
        if (equalHero(HeroType.MARCOS)) {
            Marcos marcos = (Marcos) attacker;
            marcos.attackJump((Spiny) opponent);
        } else {
            Luis luis = (Luis) attacker;
            luis.attackJump((Spiny) opponent);
        }
    }

    /**
     * ataca con salto a un enemigo Goomma
     */
    private void attackJumpGoomba() {
        if (equalHero(HeroType.MARCOS)) {
            Marcos marcos = (Marcos) attacker;
            marcos.attackJump((Goomba) opponent);
        } else {
            Luis luis = (Luis) attacker;
            luis.attackJump((Goomba) opponent);
        }
    }

    /**
     * Ataca con martillo a un enemigo Boo
     *
     * @param seed Seed para definir si el ataque es efectivo o no. Dada la probabilidad del ataque.
     */
    private void attackBoo(int seed) {
        Marcos marcos = (Marcos) attacker;
        marcos.attackHammer((Boo) opponent, seed);
    }

    /**
     * Ataca con martillo a un enemigo Spiny
     *
     * @param seed Seed para definir si el ataque es efectivo o no. Dada la probabilidad del ataque.
     */
    private void attackSpiny(int seed) {
        if (equalHero(HeroType.MARCOS)) {
            Marcos marcos = (Marcos) attacker;
            marcos.attackHammer((Spiny) opponent, seed);
        } else {
            Luis luis = (Luis) attacker;
            luis.attackHammer((Spiny) opponent, seed);
        }
    }

    /**
     * Ataca con martillo a un enemigo Goomva
     *
     * @param seed Seed para definir si el ataque es efectivo o no. Dada la probabilidad del ataque.
     */
    private void attackGoomba(int seed) {
        if (equalHero(HeroType.MARCOS)) {
            Marcos marcos = (Marcos) attacker;
            marcos.attackHammer((Goomba) opponent, seed);
        } else {
            Luis luis = (Luis) attacker;
            luis.attackHammer((Goomba) opponent, seed);
        }
    }

    /**
     * se corroba el tipo de hero escogido
     *
     * @param h tipo de hero
     * @return valor de verdad true si es del mismo tipo. En caso contrario false.
     */
    public boolean equalHero(HeroType h) {
        return attacker.getType().equals(h);
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
    public void toEndTurnPhase() {
        changePhase(new EndTurnPhase());
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "FightPhase";
    }

}
