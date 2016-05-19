package aps.com.aps.scenes;

import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.types.ccColor4B;

import aps.com.aps.scenes.abstracts.Scene;

/**
 * Created by silmara on 17/11/2015.
 */
public class PauseScene extends Scene{

    private CCColorLayer background;

    public PauseScene(){

        this.background = CCColorLayer.node(ccColor4B.ccc4(0,0,0,175));
        this.addChild(this.background);
    }
}