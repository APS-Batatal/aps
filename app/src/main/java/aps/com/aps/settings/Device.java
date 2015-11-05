package aps.com.aps.settings;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

/**
 * Created by CNOVanessa on 23/10/2015.
 */
public abstract class Device {
<<<<<<< HEAD

    //TODO: Remover
    public static CGPoint screenResolution(CGPoint gcPoint)
    {
        return gcPoint;
    }

    //Sizes
    public static float width() {
        return CCDirector.sharedDirector().winSize().width;
    }
    public static float height() {
        return CCDirector.sharedDirector().winSize().height;
    }

    //Points
=======
>>>>>>> 2b59293ae0db07adf8d1cec2400b9f0e3f3a5726
    public static CGPoint center(){
        CGSize size = CCDirector.sharedDirector().winSize();
        return CGPoint.ccp(size.width/2.0f,size.height/2.0f);
    }
<<<<<<< HEAD
=======
    public static Float width(){
        return CCDirector.sharedDirector().displaySize().width;
    }
    public static Float height(){
        return CCDirector.sharedDirector().displaySize().height;
    }
>>>>>>> 2b59293ae0db07adf8d1cec2400b9f0e3f3a5726
}
