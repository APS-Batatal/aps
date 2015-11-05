package aps.com.aps.components;

import org.cocos2d.nodes.CCSprite;

import aps.com.aps.Assets.Game;
import aps.com.aps.settings.Device;

/**
 * Created by dihgg on 04/11/15.
 */
//Lixeira do jogo
public class Lixeira extends CCSprite {
    private float x = Device.width()/2;
    private float y = 50;

    public  Lixeira(){
        super(Game.LIXEIRA);
        setPosition(x, y);
    }
     public void moveLeft(){
        x-=10;
        x = (x<0)? 0 : (x>Device.width())? Device.width() : x;

        setPosition(x,y);
    }
    public void moveRight(){
        x+=10;
        x = (x<0)? 0 : (x>Device.width())? Device.width() : x;

        setPosition(x,y);
    }
}
