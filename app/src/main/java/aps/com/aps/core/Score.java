package aps.com.aps.core;

/**
 * Created by dihgg on 11/11/15.
 */
public class Score {
    private int pontos = 0;
    private int nivel = 1;

    private int proxNivel = 30;

    //Todo: criar sistema de highscore
    private int highscore = 0;


    public void add(int qty){
        this.pontos += qty;
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
}
