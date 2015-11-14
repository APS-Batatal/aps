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
import aps.com.aps.assets.Title;
import aps.com.aps.components.Lixo;
import aps.com.aps.core.Global;
import aps.com.aps.engines.LixosEngine;
import aps.com.aps.engines.LixosEngineDelegate;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.settings.Device;


/**
 * Created by CNOVanessa on 03/11/2015.
 */

public class GameScene extends Scene implements LixosEngineDelegate{
    //TODO: Alterar
    private CCSprite background;
    private CCLabel scoreLbl,vidasLbl,nivelLbl,highscoreLbl;
    private LixosEngine lixosEngine;
    private CCLayer lixosLayer;
    private ArrayList<Lixo> lixosArray;

    private GameScene() {

        this.background = new CCSprite(Game.BACKGROUND);
        this.background.setPosition(Device.center());
        this.addChild(this.background);

        this.lixosLayer = CCLayer.node();
        this.addChild(this.lixosLayer);

        //HIGHSCORE

        this.highscoreLbl= CCLabel.makeLabel(" ",CGSize.make(100, 20), CCLabel.TextAlignment.RIGHT,Fonts.PRESS_START_2P,14);
        //this.highscoreLbl= CCLabel.makeLabel(Integer.toString(Global.score.getHighscore()), Fonts.PRESS_START_2P, 14);
        this.highscoreLbl.setPosition(Device.width() - 60, Device.height() - 20);

        this.highscoreLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.highscoreLbl);

        //SCORE
        this.scoreLbl = CCLabel.makeLabel(" ",CGSize.make(100, 20), CCLabel.TextAlignment.RIGHT,Fonts.PRESS_START_2P,14);
        this.scoreLbl.setPosition(Device.width() - 60, Device.height() - 40);
        this.scoreLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.scoreLbl);

        //VIDAS
        this.vidasLbl= CCLabel.makeLabel(" ", Fonts.PRESS_START_2P, 14);
        this.vidasLbl.setPosition(Device.width() - 25, Device.height() - 70);
        this.vidasLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.vidasLbl);

        CCSprite vidaIcon = CCSprite.sprite(Game.HEART);
        vidaIcon.setPosition(this.vidasLbl.getPosition().x - 30, this.vidasLbl.getPosition().y);
        vidaIcon.setScale(vidaIcon.getScale()/12);
        this.addChild(vidaIcon);

        //NÍVEL
        this.nivelLbl= CCLabel.makeLabel(" ",CGSize.make(200, 20), CCLabel.TextAlignment.LEFT,Fonts.PRESS_START_2P,14);
        this.nivelLbl.setPosition(110, Device.height()-20);
        this.nivelLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.nivelLbl);




        this.lixosArray = new ArrayList<>();
        this.lixosEngine = new LixosEngine();

        this.setIsTouchEnabled(true);


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
    //TODO: acabar com esses delegades
    public void remove(Lixo lixo) {
        //this.lixosArray.remove(lixo);
    }

    @Override
    public void onEnter() {
        super.onEnter();
        this.schedule("update");
        this.startEngines();
    }

    private void startEngines(){
        this.addChild(this.lixosEngine);
        this.lixosEngine.setDelegate(this);
    }

    @Override
    public boolean ccTouchesEnded(MotionEvent event) {
        CGPoint location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(event.getX(), event.getY()));
        for (Lixo lixo:lixosArray) {
            if (CGRect.containsPoint((lixo.getBoundingBox()), location)) {
                if(!lixo.getClicked()){
                    if(lixo.reciclavel){
                        Global.score.add(10);
                    } else {
                        Global.vidas.remove(1);
                    }
                }
                lixo.remove();
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
                        Global.vidas.remove(1);
                    }
                    lixosArray.remove(i);
                }
            }
        }
        if(Global.vidas.getVidas() <= 0 && !Global.over){
            Global.over = true;
            Global.gotoScene(GameOverScene.createScene());
        }
        this.scoreLbl.setString("pts: "+Integer.toString(Global.score.getPontos()));
        this.vidasLbl.setString(Integer.toString(Global.vidas.getVidas()));
        this.nivelLbl.setString("nível: " + Integer.toString(Global.score.getNivel()));
        this.highscoreLbl.setString("HI: " + Integer.toString(Global.score.getHighscore()));
    }

}