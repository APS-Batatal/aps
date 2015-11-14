package aps.com.aps.scenes;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.ccColor3B;

import aps.com.aps.assets.Fonts;
import aps.com.aps.assets.Over;
import aps.com.aps.core.Global;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.settings.Device;
import aps.com.aps.components.control.Button;
import aps.com.aps.components.control.IButtons;

/**
 * Created by dihgg on 11/11/15.
 */
public class GameOverScene extends Scene implements IButtons{
    private Button restartBtn;
    public GameOverScene(){
        CCSprite background = new CCSprite(Over.BACKGROUND);

        background.setPosition(Device.center());
        this.addChild(background);

        restartBtn = new Button(Over.RESTART,this);
        restartBtn.setPosition(Device.center().x, Device.center().y - 60);
        this.addChild(restartBtn);

        CCSprite highscore = new CCSprite(Over.HIGHSCORE);
        highscore.setPosition(Device.center().x, Device.height()-50);
        this.addChild(highscore);

        CCLabel highscoreLbl = CCLabel.makeLabel(Integer.toString(Global.score.getHighscore()), Fonts.PRESS_START_2P,18);
        highscoreLbl.setColor(new ccColor3B(0, 0, 0));
        highscoreLbl.setPosition(Device.center().x, Device.height() - 100);
        this.addChild(highscoreLbl);

        CCSprite score= new CCSprite(Over.HIGHSCORE);
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
        if(sender.equals(restartBtn)){
            Global.gotoScene(GameScene.createGame());
        }
    }
}
