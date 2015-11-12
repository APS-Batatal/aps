package aps.com.aps.scenes;


import android.view.MotionEvent;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.ccColor3B;

import java.util.ArrayList;

import aps.com.aps.assets.Title;
import aps.com.aps.components.Lixo;
import aps.com.aps.core.Global;
import aps.com.aps.engine.LixosEngine;
import aps.com.aps.engine.LixosEngineDelegate;
import aps.com.aps.scenes.abstracts.Scene;
import aps.com.aps.settings.Device;


/**
 * Created by CNOVanessa on 03/11/2015.
 */

public class GameScene extends Scene implements LixosEngineDelegate{
    //TODO: Alterar
    private CCSprite background;
    private CCLabel scoreLbl,vidasLbl,nivelLbl;
    private LixosEngine lixosEngine;
    private CCLayer lixosLayer;
    private ArrayList<Lixo> lixosArray;

    private GameScene() {

        this.background = new CCSprite(Title.BACKGROUND);
        this.background.setPosition(Device.center());
        this.addChild(this.background);

        this.lixosLayer = CCLayer.node();
        this.addChild(this.lixosLayer);

        this.scoreLbl = CCLabel.makeLabel(Integer.toString(Global.score.getPontos()),"Arial",14);
        this.scoreLbl.setPosition(Device.width() - 30, Device.height() - 20);
        this.scoreLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.scoreLbl);

        this.vidasLbl= CCLabel.makeLabel(Integer.toString(Global.vidas.getVidas()),"Arial",14);
        this.vidasLbl.setPosition(Device.width()-30, Device.height()-40);
        this.vidasLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.vidasLbl);

        this.nivelLbl= CCLabel.makeLabel(Integer.toString(Global.score.getPontos()),"Arial",14);
        this.nivelLbl.setPosition(30, Device.height()-20);
        this.nivelLbl.setColor(new ccColor3B(0, 0, 0));
        this.addChild(this.nivelLbl);

        this.addGameObjects();

        this.setIsTouchEnabled(true);


    }

    public static CCScene createGame() {
        Global.reset();
        CCScene scene = CCScene.node();
        GameScene layer = new GameScene();
        scene.addChild(layer);
        return scene;
    }

    @Override
    public void create(Lixo lixo) {
        this.lixosLayer.addChild(lixo);
        lixo.start();
        this.lixosArray.add(lixo);

    }

    @Override
    public void remove(Lixo lixo) {

    }

    private void addGameObjects(){
        this.lixosArray = new ArrayList<>();
        this.lixosEngine = new LixosEngine();
    }

    @Override
    public void onEnter() {
        super.onEnter();
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
                if(lixo.reciclavel){
                    Global.score.add(10);
                } else {
                    Global.vidas.remove(1);

                    if(Global.vidas.getVidas() <= 0){
                        CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(1.0f, GameOverScene.createScene()));
                    }
                }
                lixo.remove();
                this.scoreLbl.setString(Integer.toString(Global.score.getPontos()));
                this.vidasLbl.setString(Integer.toString(Global.vidas.getVidas()));
                this.nivelLbl.setString(Integer.toString(Global.score.getNivel()));

            }
        }
        return super.ccTouchesEnded(event);
    }

}