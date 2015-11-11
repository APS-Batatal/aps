package aps.com.aps.scenes;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.transitions.CCFadeTransition;

import aps.com.aps.assets.Title;
import aps.com.aps.settings.control.Button;
import aps.com.aps.settings.control.IButtons;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.scenes.abstracts.iScene;
import aps.com.aps.settings.Device;

/**
 * Created by CNOVanessa on 23/10/2015.
 */
public class TitleScreen extends Scene implements iScene, IButtons {
    private CCSprite background;
    private Button playButton;


    public TitleScreen() {
        super();
        /*sound.add(Music.RAMONA);
        sound.load();
        sound.play(Music.RAMONA, true);*/


        this.background = new CCSprite(Title.BACKGROUND);
        this.background.setPosition(Device.center());
        this.addChild(this.background);

        playButton = new Button(Title.PLAY, this);
        playButton.setPosition(Device.width() / 2, Device.height() - 250);
        this.addChild(playButton);

    }

    @Override
    public CCScene scene() {
        return super.scene();
    }
    @Override
    public void buttonClicked(Button sender) {
        if (sender.equals(playButton)) {
            CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(1.0f, GameScene.createGame()));
        }
    }
}