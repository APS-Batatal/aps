package aps.com.aps.components;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCScaleBy;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.actions.interval.CCSpawn;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import aps.com.aps.core.Global;

import java.util.ArrayList;
import java.util.Random;

import aps.com.aps.core.Score;
import aps.com.aps.scenes.GameScene;
import aps.com.aps.settings.Device;

/**
 * Created by silmara on 07/11/2015.
 */
public class Lixo extends CCSprite {

    private float x, y;
    public boolean reciclavel;
    private boolean clicked = false;

    public Lixo(String image,boolean reciclavel){
        super(image);
        this.x = new Random().nextInt(Math.round(Device.width()));
        this.y = Device.height();
        this.reciclavel = reciclavel;
    }

    public void start(){
        this.schedule("update");
    }

    public void update(float dt){

        this.y -= 1+(0.5* Global.score.getNivel());
        this.setPosition(CGPoint.ccp(this.x, this.y));

    }

    public void remove(){
        clicked = true;
        float dt = 0.2f;
        CCScaleBy a1 = CCScaleBy.action(dt,0.5f);
        CCFadeOut a2 = CCFadeOut.action(dt);
        CCSpawn s1 = CCSpawn.actions(a1, a2);

        //Função a ser executada após efeitos
        CCCallFunc c1 = CCCallFunc.action(this,"removeMe");

        //Roda efeito
        this.runAction(CCSequence.actions(s1, c1));
    }
    public void removeMe(){
        this.removeFromParentAndCleanup(true);
    }

    //GETTERS E SETTERS
    public boolean getClicked(){
        return  this.clicked;
    }
}