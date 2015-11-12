package aps.com.aps.core;

/**
 * Created by dihgg on 11/11/15.
 */
public class Vidas {
    private int vidas=5;

    public void add(int qty){
        vidas += qty;
    }
    public void remove(int qty){
        vidas -= qty;
    }
    public int getVidas(){
        return this.vidas;
    }
}
