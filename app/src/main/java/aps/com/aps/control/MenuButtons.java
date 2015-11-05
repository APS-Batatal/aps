package aps.com.aps.control;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;
import aps.com.aps.scenes.GameScene;
import aps.com.aps.Assets.Title;
import static aps.com.aps.settings.Device.height;
import static aps.com.aps.settings.Device.screenResolution;
import static aps.com.aps.settings.Device.width;

/**
 * Created by CNOVanessa on 02/11/2015.
 */
public class MenuButtons extends CCLayer implements IButtonDelegate {
    private Button playButton;
    private Button highscoredButton;
    private Button helpButton;
    private Button soundButton;


    public MenuButtons() {
        this.setIsTouchEnabled(true);
        this.playButton = new Button(Title.PLAY);
        this.highscoredButton = new Button(Title.HIGHSCORE);
        this.helpButton = new Button(Title.HELP);
        this.soundButton = new Button(Title.SOUND);

        this.playButton.setDelegate(this);
        this.highscoredButton.setDelegate(this);
        this.helpButton.setDelegate(this);
        this.soundButton.setDelegate(this);



        // coloca botıes na posicao correta
        setButtonspPosition();
        addChild(playButton);
        addChild(highscoredButton);
        addChild(helpButton);
        addChild(soundButton);
    }
    private void setButtonspPosition() {
    // Buttons Positions
        playButton.setPosition(screenResolution(CGPoint.ccp(width() / 2, height() - 250)));
        highscoredButton.setPosition(screenResolution(CGPoint.ccp(width()/2, height() - 300 )));
        helpButton.setPosition(screenResolution(CGPoint.ccp(width()/2, height()- 350 )));
        soundButton.setPosition(screenResolution(CGPoint.ccp(width()/2-100, height()- 420 )) );
    }

    @Override
    public void buttonClicked(Button sender) {
        if (sender.equals(this.playButton)) {
            System.out.println("Button clicked: Play");
            CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(1.0f, GameScene.createGame()));
        }
        if (sender.equals(this.highscoredButton)) {
            System.out.println("Button clicked: Highscore");
        }
        if (sender.equals(this.helpButton)) {
            System.out.println("Button clicked: Help");
        }
        if (sender.equals(this.soundButton)) {
            System.out.println("Button clicked: Sound");

        }
    }

}
