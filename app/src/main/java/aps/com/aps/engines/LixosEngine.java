package aps.com.aps.engines;

import org.cocos2d.layers.CCLayer;

import java.util.Random;

import aps.com.aps.assets.Game;
import aps.com.aps.components.Lixo;
import aps.com.aps.core.Global;
import aps.com.aps.core.Runner;

/**
 * Created by silmara on 07/11/2015.
 */
public class LixosEngine extends CCLayer{

    private LixosEngineDelegate delegate;

    public LixosEngine(){
        this.schedule("lixosEngine", 1.0f / 10f);
    }

    public void lixosEngine(float dt) {
        if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {
            if (new Random().nextInt(5) == 0) {
                if (new Random().nextBoolean()) {
                    this.getDelegate().create(new Lixo(Game.getLixosReciclaveis().get(new Random().nextInt(Game.getLixosReciclaveis().size())), true));
                } else {
                    this.getDelegate().create(new Lixo(Game.getLixosNaoReciclaveis().get(new Random().nextInt(Game.getLixosReciclaveis().size())), false));
                }
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
