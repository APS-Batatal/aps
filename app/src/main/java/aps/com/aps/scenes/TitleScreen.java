package aps.com.aps.scenes;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import aps.com.aps.settings.Device;

/**
 * Created by CNOVanessa on 23/10/2015.
 */
public class TitleScreen extends CCLayer {
    public CCScene scene() {

        CCScene scene = CCScene.node();
        scene.addChild(this);

        CCSprite background = new CCSprite("background.png");
        background.setPosition(Device.center());


        this.addChild(background);
        //this.screenBg.setPosition(Device.center());
        //this.screenBg.setPosition(CGPoint.ccp(0,0));

        /*this.screenBg = new CCSprite("background.png");
        this.screenBg.setPosition(Device.center());
        this.addChild(screenBg);*/
        return scene;
    }

    /*public TitleScreen(){
    }*/


}
