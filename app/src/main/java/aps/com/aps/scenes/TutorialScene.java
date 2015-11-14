package aps.com.aps.scenes;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;

import aps.com.aps.assets.Over;
import aps.com.aps.components.control.Button;
import aps.com.aps.components.control.IButtons;
import aps.com.aps.core.Global;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.settings.Device;

/**
 * Created by dihgg on 14/11/15.
 */
public class TutorialScene extends Scene implements IButtons {
    private Button playBtn;
    private TutorialScene(){
        CCSprite background = new CCSprite(Over.BACKGROUND);

        background.setPosition(Device.center());
        this.addChild(background);

        playBtn = new Button(Over.RESTART,this);
        playBtn.setPosition(Device.center().x, 60);
        this.addChild(playBtn);
    }
    public static CCScene createScene(){
        CCScene scene = CCScene.node();
        scene.addChild(new TutorialScene());
        return scene;
    }


    @Override
    public void buttonClicked(Button sender) {
        if (sender.equals(playBtn)) {
            Global.gotoScene(GameScene.createGame());
        }
    }
}
