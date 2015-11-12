package aps.com.aps.engine;

import org.cocos2d.layers.CCLayer;

import java.util.Random;

import aps.com.aps.assets.Game;
import aps.com.aps.components.Lixo;


/**
 * Created by silmara on 07/11/2015.
 */
public class LixosEngine extends CCLayer{

    private LixosEngineDelegate delegate;

    public LixosEngine(){
        this.schedule("lixosEngine", 1.0f / 10f);
    }

    public void lixosEngine(float dt){
        //sorte: 1 em 30 gera um novo meteoro!
        if(new Random().nextInt(10)==0){
            if(new Random().nextBoolean()){
                this.getDelegate().create(new Lixo(Game.LIXO, true));
            } else {
                this.getDelegate().create(new Lixo(Game.LIXO2, false));
            }
        }
    }

    public void setDelegate(LixosEngineDelegate delegate) {
        this.delegate = delegate;
    }

    public LixosEngineDelegate getDelegate() {
        return delegate;
    }
}
