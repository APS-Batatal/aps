package aps.com.aps.core;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;

/**
 * Created by dihgg on 11/11/15.
 */
public class Global{
    public static Score score = new Score();
    public static Vidas vidas = new Vidas();
    public static boolean over = false;

    public static void restart(){
        score.reset();
        vidas.reset();
        over = false;
    }

    public static void gotoScene(CCScene scene){
        CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(1.0f, scene));
    }
}
