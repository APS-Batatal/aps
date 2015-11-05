package aps.com.aps;

<<<<<<< HEAD

import android.app.Activity;
=======
import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
>>>>>>> 2b59293ae0db07adf8d1cec2400b9f0e3f3a5726
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
<<<<<<< HEAD
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;
import aps.com.aps.scenes.TitleScene;


public class Main extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // definindo orientacao como landscape

        setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // configura a tela
        CCGLSurfaceView glSurfaceView = new CCGLSurfaceView(this);
        setContentView(glSurfaceView);
        CCDirector.sharedDirector().attachInView(glSurfaceView);
        // configura CCDirector
        CCDirector.sharedDirector().setScreenSize(320, 480);
        // abre tela principal
        CCScene scene = new TitleScene().scene();
        CCDirector.sharedDirector().runWithScene(scene);
=======

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
>>>>>>> 2b59293ae0db07adf8d1cec2400b9f0e3f3a5726
    }
}
