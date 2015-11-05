package aps.com.aps.scenes;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import aps.com.aps.Assets.Title;
import aps.com.aps.control.MenuButtons;
import aps.com.aps.settings.Device;

import static aps.com.aps.settings.Device.height;
import static aps.com.aps.settings.Device.screenResolution;
import static aps.com.aps.settings.Device.width;


/**
 * Created by CNOVanessa on 23/10/2015.
 */
public class TitleScene extends CCLayer {
    private CCSprite background;


    public CCScene scene() {

        CCScene scene = CCScene.node();
        scene.addChild(this);



        CCSprite title = CCSprite.sprite("nave.png");
        title.setPosition(screenResolution(
                CGPoint.ccp( width() /2 , height() - 130 )));
        this.addChild(title);


        return scene;
    }

    public TitleScene(){
        //TODO: Classe de som
        //Sound sounds = new Sound();
        //sounds.add(R.raw.ramona);
        //sounds.load();
        //sounds.play(R.raw.ramona);

        this.background = new CCSprite(Title.BACKGROUND);
        this.background.setPosition(Device.center());
        this.addChild(this.background);


        MenuButtons menuLayer = new MenuButtons();
        this.addChild(menuLayer);


    }
}