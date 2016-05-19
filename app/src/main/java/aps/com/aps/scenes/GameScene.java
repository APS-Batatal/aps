package aps.com.aps.scenes;


import android.view.MotionEvent;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor3B;

import java.util.ArrayList;

import aps.com.aps.assets.Fonts;
import aps.com.aps.assets.Game;
import aps.com.aps.assets.Music;
import aps.com.aps.components.Lixo;
import aps.com.aps.components.Button;
import aps.com.aps.components.IButtons;
import aps.com.aps.core.Global;
import aps.com.aps.core.Runner;
import aps.com.aps.engines.LixosEngine;
import aps.com.aps.engines.LixosEngineDelegate;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.settings.Device;


/**
 * Created by CNOVanessa on 03/11/2015.
 */

public class GameScene extends Scene implements LixosEngineDelegate, IButtons{
    //TODO: Alterar
    private CCSprite background;
    private CCLabel scoreLbl,vidasLbl,nivelLbl;
    private LixosEngine lixosEngine;
    private CCLayer lixosLayer;
    private ArrayList<Lixo> lixosArray;
    private Button musicButton;
    private Button pauseButton;
    private PauseScene pauseScene;
    private CCLayer layerTop;

    private GameScene() {
        sound.add(Music.RECYCLELOSSEFFECT);
        sound.add(Music.WRONGSELECTIONEFFECT);
        sound.add(Music.CORRECTSELECTIONEFFECT);
        sound.load();

        this.background = new CCSprite(Game.BACKGROUND);
        this.background.setPosition(Device.center());
        this.addChild(this.background);

        musicButton = new Button(Game.SOUND,this);
        musicButton.setPosition(Device.width() - 30, Device.height() - 30);
        this.addChild(musicButton);

        pauseButton = new Button(Game.PAUSE,this);
        pauseButton.setPosition(30,Device.height()-20);
        this.addChild(pauseButton);

        this.lixosLayer = CCLayer.node();
        this.addChild(this.lixosLayer);

        //HIGHSCORE

        //SCORE
        this.scoreLbl = CCLabel.makeLabel(" ",CGSize.make(0, 0), CCLabel.TextAlignment.RIGHT,Fonts.PRESS_START_2P,12);
        this.scoreLbl.setPosition(Device.width()/2, Device.height() - 40);
        this.scoreLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.scoreLbl);

        //VIDAS
        this.vidasLbl= CCLabel.makeLabel(" ", Fonts.PRESS_START_2P, 12);
        this.vidasLbl.setPosition((Device.width()/2)+10, Device.height() - 60);
        this.vidasLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.vidasLbl);

        CCSprite vidaIcon = CCSprite.sprite(Game.HEART);
        vidaIcon.setPosition(Device.width()/2-10, Device.height() - 60);
        vidaIcon.setScale(vidaIcon.getScale() / 12);
        this.addChild(vidaIcon);

        //NÍVEL
        this.nivelLbl= CCLabel.makeLabel(" ",CGSize.make(0, 0), CCLabel.TextAlignment.LEFT,Fonts.PRESS_START_2P,12);
        this.nivelLbl.setPosition(Device.width()/2, Device.height()-20);
        this.nivelLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.nivelLbl);

        this.lixosArray = new ArrayList<>();
        this.lixosEngine = new LixosEngine();

        this.setIsTouchEnabled(true);

        this.layerTop = CCLayer.node();
        this.addChild(this.layerTop);


    }

    public static CCScene createGame() {
        Global.restart();
        CCScene scene = CCScene.node();
        scene.addChild(new GameScene());
        return scene;
    }

    @Override
    public void create(Lixo lixo) {
        this.lixosLayer.addChild(lixo);
        lixo.start();
        this.lixosArray.add(lixo);
    }

    @Override
    public void onEnter() {
        super.onEnter();
        this.schedule("update");
        this.startEngines();

        //Configura o status do jogo
        Runner.check().setGamePlaying(true);
        Runner.check().setGamePaused(false);

    }

    private void startEngines(){
        this.addChild(this.lixosEngine);
        this.lixosEngine.setDelegate(this);
    }

    @Override
    public boolean ccTouchesBegan(MotionEvent event) {

        if (Runner.check().isGamePlaying() && !Runner.check().isGamePaused()) {

            CGPoint location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(event.getX(), event.getY()));
            for (Lixo lixo : lixosArray) {
                if (CGRect.containsPoint((lixo.getBoundingBox()), location)) {
                    if (!lixo.getClicked()) {
                        if (lixo.reciclavel) {
                            sound.playEffect(Music.CORRECTSELECTIONEFFECT);
                            Global.score.add(10);
                        } else {
                            sound.playEffect(Music.WRONGSELECTIONEFFECT);
                            Global.vidas.remove(1);
                        }
                    }
                    lixo.remove();
                }
            }
        }
            return super.ccTouchesEnded(event);
        }

    public void update(float dt){

        if(lixosArray.size() > 0){

            for(int i = 0; i< lixosArray.size();i++){
                Lixo lixo = lixosArray.get(i);

                if (lixo.getPosition().y < 0){
                    if(lixo.reciclavel){
                        sound.playEffect(Music.RECYCLELOSSEFFECT);
                        Global.vidas.remove(1);
                    }
                    lixosArray.remove(i);
                }
            }
        }

        if(Global.vidas.getVidas() <= 0 && !Global.over){
            sound.pauseSound();
            sound.playEffect(Music.GAMEOVEREFFECT);
            if (sound.getIsPlaying()){
                sound.playSound(Music.GAMEOVERMUSIC,true);
            }
            Global.over = true;
            Global.gotoScene(GameOverScene.createScene());
        }
        this.scoreLbl.setString("Pontos: "+Integer.toString(Global.score.getPontos()));
        this.vidasLbl.setString(Integer.toString(Global.vidas.getVidas()));
        this.nivelLbl.setString("Nível: " + Integer.toString(Global.score.getNivel()));
    }

    @Override
    public void buttonClicked(Button sender) {

        if (sender.equals(musicButton) && (sound.getIsPlaying())){
            sound.pauseSound();
            sound.setIsPlaying(false);
        }else if(sender.equals(musicButton) && (!sound.getIsPlaying())){
            sound.setIsPlaying(true);
            sound.playEffect(Music.CLICKSOUND);
            sound.playSound(Music.GAMEMUSIC,true);
        }

        if (sender.equals(pauseButton)){
            if (!Runner.check().isGamePaused()){
                Runner.setGamePaused(true);
                this.pauseScene = new PauseScene();
                this.layerTop.addChild(this.pauseScene);
            } else {
                Runner.setGamePaused(false);
                this.setIsTouchEnabled(true);
                this.pauseScene.removeFromParentAndCleanup(true);
            }
        }
    }
}