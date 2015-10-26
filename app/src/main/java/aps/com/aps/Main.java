package aps.com.aps;

import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import aps.com.aps.scenes.TitleScreen;
import aps.com.aps.settings.Device;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //ANDROID
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//retrato
        requestWindowFeature(Window.FEATURE_NO_TITLE);//sem título
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscreen

        //COCOS 2D
        CCGLSurfaceView glSurfaceView = new CCGLSurfaceView(this);
        setContentView(glSurfaceView);
        CCDirector.sharedDirector().attachInView(glSurfaceView);

        CCScene scene = new TitleScreen().scene();
        CCDirector.sharedDirector().setScreenSize(Device.width(), Device.height());
        CCDirector.sharedDirector().runWithScene(scene);

        super.onCreate(savedInstanceState);
    }
}
