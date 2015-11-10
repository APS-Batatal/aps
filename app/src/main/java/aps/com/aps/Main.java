package aps.com.aps;


import android.app.Activity;
import android.os.Bundle;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import aps.com.aps.scenes.TitleScreen;


public class Main extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // configura a tela
        CCGLSurfaceView glSurfaceView = new CCGLSurfaceView(this);
        setContentView(glSurfaceView);
        CCDirector.sharedDirector().attachInView(glSurfaceView);
        // configura CCDirector
        CCDirector.sharedDirector().setScreenSize(320, 480);
        // abre tela principal
        CCScene scene = new TitleScreen().scene();
        CCDirector.sharedDirector().runWithScene(scene);
    }
}
