package aps.com.aps.settings;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

/**
 * Created by CNOVanessa on 23/10/2015.
 */
public class Device {
    public static CGPoint center(){
        CGSize size = CCDirector.sharedDirector().winSize();
        return CGPoint.ccp(size.width/2.0f,size.height/2.0f);
    }
}
