package aps.com.aps.scenes;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import aps.com.aps.Helper.Sound;
import aps.com.aps.R;
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
        background.setScaleX((Device.width() / background.getContentSize().width));
        background.setScaleY((Device.height() / background.getContentSize().height));
        this.addChild(background);

        CCSprite nave = new CCSprite("nave.png");
        nave.setPosition(Device.center());
        nave.setScale((Device.width() / nave.getContentSize().width) / 2);
        this.addChild(nave);



        return scene;
    }

    public TitleScreen(){
        Sound sounds = new Sound();
        sounds.add(R.raw.ramona);
        sounds.load();
        sounds.play(R.raw.ramona);
    }


}
