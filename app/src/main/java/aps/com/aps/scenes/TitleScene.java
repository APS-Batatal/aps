package aps.com.aps.scenes;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import aps.com.aps.assets.Music;
import aps.com.aps.assets.Title;
import aps.com.aps.components.Button;
import aps.com.aps.components.IButtons;
import aps.com.aps.core.Global;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.scenes.abstracts.iScene;
import aps.com.aps.settings.Device;

/**
 * Created by CNOVanessa on 23/10/2015.
 */
public class TitleScene extends Scene implements iScene, IButtons {
    private CCSprite background, logo;
    private Button playButton;
    private Button musicButton;
    private Button exitButton;

    public TitleScene() {
        super();
        sound.add(Music.CLICKSOUND);
        sound.load();
        sound.playSound(Music.GAMEMUSIC, true);

        this.background = new CCSprite(Title.BACKGROUND);
        this.background.setPosition(Device.center());
        this.addChild(this.background);

        this.logo = new CCSprite(Title.LOGO);
        this.logo.setPosition(CGPoint.ccp(Device.width()/2,Device.height()-130));
        logo.setScale(logo.getScale()/3);
        this.addChild(logo);

        playButton = new Button(Title.PLAY, this);
        playButton.setPosition(Device.width() / 2, Device.height() - 330);
        this.addChild(playButton);

        musicButton = new Button(Title.SOUND,this);
        musicButton.setPosition(Device.width() - 30, Device.height() - 30);
        this.addChild(musicButton);

        exitButton = new Button(Title.EXIT, this);
        exitButton.setPosition(Device.width() / 2, Device.height() - 400);
        this.addChild(exitButton);
    }

    @Override
    public CCScene scene() {
        return super.scene();
    }
    @Override

    public void buttonClicked(Button sender) {
        if (sender.equals(playButton)) {
            //TODO:remover
            sound.playEffect(Music.CLICKSOUND);
            Global.gotoScene(TutorialScene.createScene());
        }

        if (sender.equals(musicButton) && sound.getIsPlaying()){
            sound.setIsPlaying(false);
            sound.pauseSound();

        }else if(sender.equals(musicButton) && !sound.getIsPlaying()){
            sound.setIsPlaying(true);
            sound.playEffect(Music.CLICKSOUND);
            sound.playSound(Music.GAMEMUSIC, true);
        }

        if (sender.equals(exitButton)) {
            System.exit(0);
        }
    }
}