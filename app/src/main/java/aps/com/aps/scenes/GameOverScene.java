package aps.com.aps.scenes;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.ccColor3B;
import aps.com.aps.assets.Fonts;
import aps.com.aps.assets.Music;
import aps.com.aps.assets.Over;
import aps.com.aps.core.Global;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.settings.Device;
import aps.com.aps.components.Button;
import aps.com.aps.components.IButtons;

/**
 * Created by dihgg on 11/11/15.
 */
public class GameOverScene extends Scene implements IButtons{
    private Button restartBtn;
    private Button musicBtn;
    private Button exitBtn;

    public GameOverScene(){

        sound.add(Music.CLICKSOUND);
        sound.load();

        CCSprite background = new CCSprite(Over.BACKGROUND);

        background.setPosition(Device.center());
        this.addChild(background);

        restartBtn = new Button(Over.RESTART,this);
        restartBtn.setPosition(Device.center().x, Device.center().y - 70);
        this.addChild(restartBtn);

        musicBtn = new Button(Over.SOUND,this);
        musicBtn.setPosition(Device.center().x+140, Device.center().y +215);
        this.addChild(musicBtn);

        exitBtn = new Button(Over.EXIT, this);
        exitBtn.setPosition(Device.width() / 2, Device.height() - 400);
        this.addChild(exitBtn);

        CCSprite highscore = new CCSprite(Over.HIGHSCORE);
        highscore.setPosition(Device.center().x, Device.height()-50);
        this.addChild(highscore);

        CCLabel highscoreLbl = CCLabel.makeLabel(Integer.toString(Global.score.getHighscore()), Fonts.PRESS_START_2P,18);
        highscoreLbl.setColor(new ccColor3B(0, 0, 0));
        highscoreLbl.setPosition(Device.center().x, Device.height() - 100);
        this.addChild(highscoreLbl);

        CCSprite score= new CCSprite(Over.SCORE);
        score.setPosition(Device.center().x, Device.height()-150);
        this.addChild(score);

        CCLabel scoreLbl = CCLabel.makeLabel(Integer.toString(Global.score.getPontos()), Fonts.PRESS_START_2P,18);
        scoreLbl.setColor(new ccColor3B(0, 0, 0));
        scoreLbl.setPosition(Device.center().x, Device.height() - 200);
        this.addChild(scoreLbl);
    }
    public static CCScene createScene(){
        CCScene scene = CCScene.node();
        scene.addChild(new GameOverScene());
        return scene;
    }

    @Override
    public void buttonClicked(Button sender) {
        if(sender.equals(restartBtn)) {
            sound.pauseSound();
            sound.playEffect(Music.STARTGAMEEFFECT);
            if (sound.getIsPlaying()) {
                sound.playSound(Music.GAMEMUSIC, true);
            }
            Global.gotoScene(GameScene.createGame());
        }

        if (sender.equals(musicBtn) && sound.getIsPlaying()){
            sound.pauseSound();
            sound.setIsPlaying(false);
        }else if(sender.equals(musicBtn) && !sound.getIsPlaying()){
            sound.setIsPlaying(true);
            sound.playEffect(Music.CLICKSOUND);
            sound.playSound(Music.GAMEOVERMUSIC, true);
        }

        if (sender.equals(exitBtn)) {
            System.exit(0);
        }
    }

}
