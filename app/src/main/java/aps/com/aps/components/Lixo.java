package aps.com.aps.components;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import java.util.Random;

import aps.com.aps.control.Button;
import aps.com.aps.control.IButtons;
import aps.com.aps.settings.Device;

/**
 * Created by silmara on 07/11/2015.
 */
public class Lixo extends CCSprite {

    private float x, y;
    public boolean reciclavel;

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
        this.y -= 1;
        this.setPosition(CGPoint.ccp(this.x,this.y));
    }
}
