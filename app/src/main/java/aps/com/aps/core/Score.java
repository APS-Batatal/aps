package aps.com.aps.core;

/**
 * Created by dihgg on 11/11/15.
 */
public class Score implements IReset{
    private final int DEFAULT_PONTOS = 0, DEFAULT_NIVEL = 1, DEFAULT_PROX_NIVEL = 30;

    private int pontos,nivel,proxNivel;

    //Todo: criar sistema de highscore
    private int highscore = 0;


    public Score(){
        this.reset();
    }
    public void add(int qty){
        this.pontos += qty;
        if(this.highscore <= this.pontos){
            this.highscore = this.pontos;
        }
        calculaNivel();
    }
    public void subtract(int qty){
        if((this.pontos -qty) <= 0){
            this.pontos = 0;
        } else {
            this.pontos -= qty;
        }
    }

    private int calculaNivel(){

        if(this.pontos >= this.proxNivel){
            this.proxNivel = this.proxNivel * 2;
            this.nivel++;
        }
        return nivel;
    }

    //GETTERS AND SETTERS
    public int getPontos(){
        return this.pontos;
    }
    public int getNivel(){return  this.nivel;}
    public int getHighscore(){return this.highscore;}

    @Override
    public void reset() {
        this.pontos = DEFAULT_PONTOS;
        this.nivel = DEFAULT_NIVEL;
        this.proxNivel = DEFAULT_PROX_NIVEL;
    }
}
