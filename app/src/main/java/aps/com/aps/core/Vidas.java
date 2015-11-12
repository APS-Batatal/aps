package aps.com.aps.core;

/**
 * Created by dihgg on 11/11/15.
 */
public class Vidas implements IReset{
    private final int DEFAULT_VIDAS=5;
    private int vidas;

    public Vidas(){
        this.reset();
    }

    public void add(int qty){
        vidas += qty;
    }
    public void remove(int qty){
        vidas -= qty;
    }
    public int getVidas(){
        return this.vidas;
    }

    @Override
    public void reset() {
        vidas = DEFAULT_VIDAS;
    }
}
