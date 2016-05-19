package aps.com.aps.scenes;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;

import aps.com.aps.assets.Music;
import aps.com.aps.assets.Tutorial;
import aps.com.aps.components.Button;
import aps.com.aps.components.IButtons;
import aps.com.aps.core.Global;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.settings.Device;

/**
 * Created by dihgg on 14/11/15.
 */
public class TutorialScene extends Scene implements IButtons {
    private Button playBtn;
    private Button musicBtn;

    private TutorialScene(){
        sound.add(Music.CLICKSOUND);
        sound.load();

        CCSprite background = new CCSprite(Tutorial.BACKGROUND);
        background.setPosition(Device.center());
        this.addChild(background);

        playBtn = new Button(Tutorial.PLAY, this);
        playBtn.setPosition(Device.width()/2, Device.height() - 435);
        this.addChild(playBtn);

        musicBtn = new Button(Tutorial.SOUND,this);
        musicBtn.setPosition(Device.width() - 30, Device.height() - 30);
        this.addChild(musicBtn);
    }
    public static CCScene createScene(){
        CCScene scene = CCScene.node();
        scene.addChild(new TutorialScene());
        return scene;
    }

    @Override
    public void buttonClicked(Button sender) {

        if (sender.equals(playBtn)) {
            //sound.pauseSound();
            sound.playEffect(Music.CLICKSOUND);
            sound.playEffect(Music.STARTGAMEEFFECT);
            Global.gotoScene(GameScene.createGame());
        }

        if (sender.equals(musicBtn) && sound.getIsPlaying()){
            sound.pauseSound();
            sound.setIsPlaying(false);
        }else if(sender.equals(musicBtn) && !sound.getIsPlaying()){
            sound.setIsPlaying(true);
            sound.playEffect(Music.CLICKSOUND);
            sound.playSound(Music.GAMEMUSIC, true);
        }
    }
}
