package aps.com.aps.scenes;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;

import aps.com.aps.Assets.Music;
import aps.com.aps.Assets.Title;
import aps.com.aps.control.MenuButtons;
import aps.com.aps.settings.Device;

/**
 * Created by CNOVanessa on 23/10/2015.
 */
public class TitleScene extends Scene implements iScene {
    private CCSprite background;


    public TitleScene() {
        super();
        sound.add(Music.RAMONA);
        sound.load();
        sound.play(Music.RAMONA, true);


        this.background = new CCSprite(Title.BACKGROUND);
        this.background.setPosition(Device.center());
        this.addChild(this.background);


        MenuButtons menuLayer = new MenuButtons();
        this.addChild(menuLayer);
    }

    @Override
    public CCScene scene() {
        CCSprite title = CCSprite.sprite("nave.png");
        title.setPosition(Device.width(), Device.height() - 130);
        this.addChild(title);

        return super.scene();
    }
}