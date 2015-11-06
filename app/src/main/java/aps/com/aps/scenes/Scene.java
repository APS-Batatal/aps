package aps.com.aps.scenes;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;

import aps.com.aps.Helper.Sound;

/**
 * Created by dihgg on 05/11/15.
 */
//TODO: criar classe padrão para cenas
public abstract class Scene extends CCLayer implements iScene {
    protected Sound sound;

    public Scene() {
        sound = new Sound();
    }

    public CCScene scene() {
        CCScene scene = CCScene.node();
        scene.addChild(this);
        return scene;
    }

}
