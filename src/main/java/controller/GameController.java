package controller;

import model.Hero.IHero;
import model.Hero.Marcos;
import model.Opponent.Goomba;
import model.Hero.Luis;
import model.Opponent.Boo;
import model.Opponent.IOpponent;
import model.Opponent.Spiny;
import model.Hero.HeroType;
import model.items.*;
import model.Opponent.OpponentType;
import model.factory.OpponentRandomFactory;
import model.Character;
import phases.*;

import java.util.*;

/**
 * the controller acts as an intermediary between the objects
 * of the model and the graphical interface of the application.
 */
public class GameController {

    private final List<IOpponent> attackByMarcos;
    private List<IOpponent> attackByLuis;
    private final List<Character> orderOfPlayers;
    private final List<IHero> players;
    private final List<IOpponent> opponents;
    int turn;
    private Character isPlaying;
    private Character isNextPlayer;
    private final OpponentRandomFactory factory;
    private int stateBattle;
    private int option;
    private int optionItem;
    private Phase phase;
    private int enemySelect;
    private Chest sharedChest;


    /**
     * Controller constructor. Allows you to use the methods to use
     * with the functionality of the model.
     */
    public GameController() {
        orderOfPlayers = new ArrayList<>();
        factory = new OpponentRandomFactory();
        turn = 0;
        stateBattle = 0;
        players = new ArrayList<>();
        opponents = new ArrayList<>();
        attackByLuis = new ArrayList<>();
        attackByMarcos = new ArrayList<>();
        phase = new Phase();
        setPhase(new StartPhase());
    }

    /**
     * se obtiene la lista de personajes de la partida
     *
     * @return lista de personajes de la partida
     */
    public List<Character> getOrderOfPlayers() {
        return orderOfPlayers;
    }

    /**
     * se setea el atributo Option item
     *
     * @param optionItem option item
     */
    public void setOptionItem(int optionItem) {
        this.optionItem = optionItem;
    }

    /**
     * se obtiene la fase
     *
     * @return phase actual de juego
     */
    public Phase getPhase() {
        return this.phase;
    }

    /**
     * se setea la fase de juego
     *
     * @param p nueva fase
     */
    public void setPhase(Phase p) {
        this.phase = p;
        phase.setController(this);
    }

    /**
     * Obtener lista de Heroes
     *
     * @return list
     */
    public List<IOpponent> getOpponents() {
        return opponents;
    }

    /**
     * obtener lista de Opponents
     *
     * @return list
     */
    public List<IHero> getPlayers() {
        return players;
    }

    /**
     * Get Factory Opponent.
     *
     * @return OpponentRandomFactory
     */
    public OpponentRandomFactory getFactory() {
        return factory;
    }

    /**
     * Set next Player.
     *
     * @param isNextPlayer new next player
     */
    public void setIsNextPlayer(Character isNextPlayer) {
        this.isNextPlayer = isNextPlayer;
    }

    /**
     * Get next player.
     *
     * @return next player
     */
    public Character getIsNextPlayer() {
        return isNextPlayer;
    }

    /**
     * Get Turn.
     *
     * @return actual turn
     */
    private int getTurn() {
        return turn;
    }

    /**
     * Set Turn. Update current shift.
     *
     * @param turn new turn
     */
    private void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * Set actual player.
     *
     * @param isPlaying new actual player
     */
    private void setIsPlaying(Character isPlaying) {
        this.isPlaying = isPlaying;
    }

    /**
     * Get actual player.
     *
     * @return actual player
     */
    public Character getIsPlaying() {
        return isPlaying;
    }

    /**
     * creates a new hero of the specified type.
     *
     * @param rank define rank
     * @param type define heroType
     * @return new Hero
     */
    public IHero createHero(int rank, HeroType type) {
        IHero hero;
        hero = type.equals(HeroType.MARCOS) ? new Marcos(rank, type) : new Luis(rank, type);
        addListHero(hero);
        actualPlayer();
        return hero;
    }


    /**
     * a new enemy is created in the game of a specified rank.
     * It is added to the shift list.
     *
     * @param rank define rank
     * @return new Opponent object
     */
    public IOpponent addEnemies(int rank) {
        OpponentRandomFactory f = getFactory();
        IOpponent opponent = f.createOpponent(rank);
        addListOpponent(opponent);
        addParticularEnemy(opponent);
        return opponent;
    }

    private void addParticularEnemy(IOpponent opponent) {
        defineOpponentType(opponent);
    }


    /**
     * Se añade un hero a la lista de Jugadores
     *
     * @param h nuevo hero
     */
    public void addListHero(IHero h) {
        addOrderPlayers(h);
        players.add(h);
    }

    private void addOrderPlayers(IHero h) {
        orderOfPlayers.add(h);
    }

    /**
     * Se añade a un Oponente a la lista de Opponent
     *
     * @param o nuevo oponente
     */
    public void addListOpponent(IOpponent o) {
        orderOfPlayers.add(o);
        opponents.add(o);
    }


    /**
     * insert a seed in the variable "random" in order to determine
     * a particular value.
     *
     * @param seed class random seed
     */
    public void factoryPlantSeed(int seed) {
        factory.plantSeed(seed);
    }

    /**
     * Chest object is created to store the items during the game.
     *
     * @return Chest object
     */
    public Chest addChest() {
        sharedChest = new Chest();
        return sharedChest;
    }

    /**
     * se retorna el Chest
     *
     * @return retorna el chest
     */
    public Chest getChest() {
        return sharedChest;
    }

    /**
     * The same quantity of the items available in itemType is added.
     *
     * @param chest specific chest
     * @param n     value initial
     */
    public void fillChestInitial(int n) {
        sharedChest.initial(n);
    }

    /**
     * An item is obtained from a certain Chest.
     *
     * @param chest specific chest
     * @return item of the chest
     */
    public Hashtable<ItemsType, Integer> getItem() {
        return sharedChest.getItemsChest();
    }

    /**
     * Perform the effect of an item on a hero.
     *
     * @param chest specific chest
     * @param item  select item
     * @param hero  select hero
     */
    public void spendItem(IItems item, IHero hero) throws InvalidSelectException {
        assertItem(item.getType());
        sharedChest.spend(item, hero);

    }

    /**
     * corrobora que existe el item
     */
    private void assertItem(ItemsType item) throws InvalidSelectException {
        if (sharedChest.getValue(item) == 0) {
            throw new InvalidSelectException("No existe una unidad de este Item en el Chest");
        }
    }

    /**
     * creates a new item object based on the current
     * ones available in ItemType.
     *
     * @param item specific item
     * @return new item
     */
    public IItems createItem(ItemsType item) {
        if (item.equals(ItemsType.RED_MUSHROOM)) {
            return new RedMushroom();
        }
        return new HoneySyrup();
    }

    /**
     * an item is added to the inventory of a chest.
     *
     * @param chest specific chest
     * @param item  select item
     */
    public void addItem(IItems item) {
        sharedChest.add(item);
    }


    /**
     * implements the rotating shifts of the game system. set current player
     * considering rotating rounds
     */
    public void actualPlayer() {
        if (turn == 0) {
            setIsPlaying(orderOfPlayers.get(0));
        } else {
            setIsPlaying(getIsNextPlayer());
        }
        nextPlayer();
    }

    /**
     * Set the next current player considering rotating rounds.
     */
    public void nextPlayer() {
        setIsNextPlayer(orderOfPlayers.get((getTurn() + 1) % orderOfPlayers.size()));
    }

    /**
     * Sets the logic for the end of a shift. Player attributes
     * and current turn are updated.
     */
    public void finishTurn() {
        setTurn(getTurn() + 1);
        actualPlayer();
    }


    /**
     * Checks if a certain object exists in the list.
     *
     * @param c object searched.
     * @return true if it contains it
     */
    public boolean existCharacter(Character c) {
        return getOrderOfPlayers().contains(c);
    }


    /**
     * if the character us KO, his fight points
     * are equal to 0. In that case the character
     * is eliminated from the playerList.
     */
    public void defeatedCharacter() {
        getOrderOfPlayers().removeIf(c -> c.getHealthPoints() == 0);
    }

    /**
     * Updates the value of the winner attribute.
     */
    public void checkWinner() {
        setStateBattle(winner());
    }

    /**
     * Compare the type of Character object with a specific type.
     *
     * @param c     Character object
     * @param hero1 typeHero
     * @return true if they are of the same type
     */
    public boolean compareHeroType(Character c) {
        for (HeroType heroes : HeroType.values()) {
            if (heroes.name().equals(c.getType().toString())) return true;
        }
        return false;
    }


    /**
     * Determine game status by reviewing the turn list. State 0 is maintained when
     * the game is active. 1 for a win. -1 for a loss.
     *
     * @return int game status
     */
    public int winner() {
        int a = 0;
        ListIterator<Character> n = getOrderOfPlayers().listIterator();
        while (n.hasNext()) {
            Character m = n.next();
            if (compareHeroType(m)) a++;
        }
        if (a == getOrderOfPlayers().size()) {
            return 1;
        }
        return a == 0 ? -1 : 0;
    }

    /**
     * Get the game state variable.
     *
     * @return integer stateBattle.
     */
    public int getStateBattle() {
        return stateBattle;
    }

    /**
     * Set the game state variable
     *
     * @param stateBattle new stateBattle
     */
    public void setStateBattle(int stateBattle) {
        this.stateBattle = stateBattle;
    }

    /**
     * Auxiliary method for the development stage. A 100 degree knife
     * appears and pierces the throat of a selected character. The
     * character is instantly killed and out of the battle.
     *
     * @param c convicted character
     */
    public void knifeInWindpipe(Character c) {
        c.setHealthPoint(0);
        defeatedCharacter();
        checkWinner();
    }


    /**
     * selecciona un enemigo de la lista de personajes en el combate
     * <p>
     * si el personaje no es tipo Marcos o Luis, necesariamente es un oponente lo que justifica el cast.
     *
     * @param n index
     * @return oponente
     */
    public IOpponent selectEnemies(int n) {
        IOpponent o = getOpponents().get(n);
        enemySelect = n;
        return o;
    }

    /**
     * Se lee el movimeinto del personaje principal dentro de sus posibilidades
     * 0 atacar
     * 1 usar un item
     * 2 terminar el turno
     *
     * @param n option seleccionada
     */
    public void readMovement(int n) {
        try {
            if (n >= 0 && n <= 2) {
                setOption(n);
                readOption();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * se entrega el nombre de la fase actual
     *
     * @return nombre de la fase
     */
    public String getActualPhase() {
        return getPhase().toString();
    }

    /**
     * define el tipo de jugador actual
     *
     * @return 1 si es un hero, 0 si es un Opponent
     */
    public int definePlayer() {
        return typeCharacter(getIsPlaying());
    }

    /**
     * selecciona el tipo de jugadas posibles dependiendo de hero o opponent
     *
     * @throws InvalidMovementException excepción de movimiento
     */
    public void playerHeroOrEnemy(Integer seed) throws InvalidMovementException, InvalidSelectException {
        if (definePlayer() == 0) battleEnemy(seed);
    }

    /**
     * El enemigo ataca a un hero en particular
     *
     * @throws InvalidMovementException exception de movimiento
     */
    public void battleEnemy(Integer seed) throws InvalidMovementException, InvalidSelectException {
        tryToTurnEnemy();
        IHero hero = phase.selectRandomHero(seed);
        phase.attackHero(hero);
    }

    /**
     * Se escoge entra las tres posibilidades que tiene un hero en su turno.
     */
    public void readOption() {
        if (option == 0) {
            tryToWaitBattle();
        } else if (option == 1) {
            tryToSelectItem();
        }
    }

    /**
     * se asigna si el valor del item especificado es correcto.
     *
     * @param n index del item
     */
    public void readSelectItem(int n) {
        try {
            if (n == 0 || n == 1) {
                setOptionItem(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * se lee la opción del item escogido y se aplica al hero dado
     *
     * @param hero hero para aplicar efecto
     */
    public void readOptionItem(IHero hero) {

        try {
            if (optionItem == 0) {
                spendItem(new HoneySyrup(), hero);
            } else if (optionItem == 1) {
                spendItem(new RedMushroom(), hero);
            }
        } catch (InvalidSelectException e) {
            e.printStackTrace();
        }
    }

    /**
     * Se intenta cambiar a la fase de partida. Solo es posible si si esta en EndTurn Phase.
     */
    public void tryStartTurn() {
        try {
            phase.toStartPhase();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * se setea la opción escogida
     *
     * @param n optción escogida
     */
    public void setOption(int n) {
        option = n;
    }

    /**
     * Se setean al atacante y al oponente
     *
     * @param n index
     */
    public void tryToWaitBattle() {
        try {
            phase.toWaitBattlePhase((IHero) getIsPlaying());
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * se comunica con la fase para seleccionar un enemigo
     *
     * @param n index del enemigo
     * @throws InvalidSelectException excepción de Selección
     */
    public void selectEnemy(int n) throws InvalidSelectException {
        phase.selectEnemy(n);
    }

    /**
     * Se intenta atacar a un personaje. Solo ocurre cuando se está en FightPhase.
     */
    public void tryToAttackHammer(int seed) throws InvalidMovementException {
        phase.generateAttackHammer(seed, typeOpponent(phase.getOpponent()));
    }

    /**
     * Se intenta realizar un ataque tipo Jump.
     *
     * @throws InvalidMovementException exception
     */
    public void tryToAttackJump() throws InvalidTransitionException, InvalidSelectException, InvalidMovementException {
        phase.toFightPhase();
        phase.generateAttackJump(typeOpponent(phase.getOpponent()));

    }

    /**
     * Se intenta finalizar el turno. Solo ocurre cuando se está en EndTurnPhase o WaitActionPhase.
     */
    public void tryToEndTurn() {
        try {
            defeatedCharacter();
            phase.toEndTurnPhase();
            phase.endTurn();

        } catch (InvalidMovementException | InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * se intetna pasar a la fase de TurnEnemy
     */
    public void tryToTurnEnemy() {
        try {
            phase.toTurnEnemy();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * se intenta pasar a la fase de pelea
     */
    public void tryToFightPhase() {
        try {
            phase.toFightPhase();
        } catch (InvalidTransitionException | InvalidSelectException e) {
            e.printStackTrace();
        }
    }

    /**
     * se intenta pasaar a la fase de selección de item
     */
    public void tryToSelectItem() {
        try {
            phase.toWaitUseItemPhase();
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
    }

    /**
     * define la lista de personajes atacables por cada hero
     *
     * @param o oponente genérico
     */
    public void defineOpponentType(IOpponent o) {
        if (o.getType().equals(OpponentType.BOO)) {
            attackByMarcos.add(o);
        } else {
            attackByMarcos.add(o);
            attackByLuis.add(o);
        }
    }

    /**
     * define el tipo de IHero a uno concreto
     *
     * @param c hero generic
     * @return hero concreto
     */
    public int typeCharacter(Character c) {
        if (c.getType().equals(HeroType.MARCOS)) return 1;
        else if (c.getType().equals(HeroType.LUIS)) return 2;
        return 0;
    }

    /**
     * se asocia un digito al oponente para identificarlo
     *
     * @param c tipo de peros naje
     * @return numero identificador
     */
    public int typeOpponent(Character c) {
        if (c.getType().equals(OpponentType.BOO)) return -1;
        else if (c.getType().equals(OpponentType.GOOMBA)) return -2;
        return -3;
    }

    /**
     * retorna una lsita con los index de cada personaje
     *
     * @param hero     hero buscado
     * @param opponent oponente buscado
     * @return retorna la lista con los subindices
     */
    public List<Integer> typeFinal(Character hero, Character opponent) {
        List<Integer> num = new ArrayList<>();
        num.add(typeCharacter(hero));
        num.add(typeOpponent(opponent));
        return num;
    }

    /**
     * se busca un oponente en la lista de oponentes disponibles en la partida
     *
     * @param opponent personaje buscado
     * @param list     lista de oponentes
     * @return true si el oponente esta en la lista
     */
    public boolean searchOpponent(IOpponent opponent, List<IOpponent> list) {
        for (IOpponent o : list) {
            if (o.equals(opponent)) {
                return true;
            }
        }
        return false;
    }

    /**
     * conprueba si un enemigo es atacable por un Hero
     *
     * @param attacker Hero atacante
     * @param opponent personaje atacado
     * @return función de verdad true si el oponente es posible atacarlo
     */
    public boolean assertEnemy(IHero attacker, IOpponent opponent) {
        if (attacker.getType().equals(HeroType.MARCOS)) {
            return searchOpponent(opponent, attackByMarcos);
        }
        return searchOpponent(opponent, attackByLuis);
    }

    /**
     * función auxiliary se obtienen los tipos de hero y oponente para
     * establecer el tipo de objeto.
     *
     * @param hero hero seleccionado para atacar
     * @throws InvalidSelectException excepción de selección
     */
    public void attackHero(IHero hero) throws InvalidSelectException {
        List<Integer> list = typeFinal(hero, getIsPlaying());
        attackOneHero(list.get(0), list.get(1), hero);
    }

    /**
     * se ataca a un hero en particular
     *
     * @param n    index hero
     * @param m    index opponent
     * @param hero clase de hero
     * @throws InvalidSelectException excepción de Selección
     */
    private void attackOneHero(Integer n, Integer m, IHero hero) throws InvalidSelectException {
        if (n == 1) {
            attackNormalMarcos(m, (Marcos) hero);
        } else {
            attackNormalLuis(m, (Luis) hero);
        }

    }

    /**
     * ataca a luis con un ataque normal
     *
     * @param m    index opponent
     * @param hero Hero
     */
    private void attackNormalLuis(Integer m, Luis hero) {
        if (m == -2) {
            Goomba attacker = (Goomba) getIsPlaying();
            attacker.attackNormal(hero);
        } else if (m == -3) {
            Spiny attacker = (Spiny) getIsPlaying();
            attacker.attackNormal(hero);
        } else {
            Boo attacker = (Boo) getIsPlaying();
            attacker.attackNormal(hero);
        }
    }

    /**
     * ataca a marcos con un ataque normal
     *
     * @param m    index opponent
     * @param hero hero atacado
     * @throws InvalidSelectException excepción de selección
     */
    private void attackNormalMarcos(Integer m, Marcos hero) throws InvalidSelectException {
        if (m == -2) {
            Goomba attacker = (Goomba) getIsPlaying();
            attacker.attackNormal(hero);
        } else if (m == -3) {
            Spiny attacker = (Spiny) getIsPlaying();
            attacker.attackNormal(hero);
        } else {
            throw new InvalidSelectException("Boo no puede atacar a Marcos");
        }
    }

    /**
     * se sube en nivel de todos los personajes una vez que una batalla a terminado.
     */
    public void lvlUp() {
        for (IHero heros : players) {
            heros.lvlUp();
        }

    }

}