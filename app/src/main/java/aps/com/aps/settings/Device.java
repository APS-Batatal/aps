package aps.com.aps.settings;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

/**
 * Created by CNOVanessa on 23/10/2015.
 */
public abstract class Device {

    //Sizes
    public static float width() {
        return CCDirector.sharedDirector().winSize().width;
    }

    public static float height() {
        return CCDirector.sharedDirector().winSize().height;
    }

    //Points
    public static CGPoint center(){
        return CGPoint.ccp(width()/2.0f,height()/2.0f);
    }
}