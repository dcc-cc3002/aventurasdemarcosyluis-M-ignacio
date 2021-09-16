package model;

public enum HeroType {
    MARCOS,LUIS;


    //determina el maximo de la vida
    public int MaxHealth(int lvl) {
        return 30 + (lvl-1)*5;
    }
}
