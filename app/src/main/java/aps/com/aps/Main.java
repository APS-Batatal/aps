package aps.com.aps;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.sound.SoundEngine;

import aps.com.aps.core.Global;
import aps.com.aps.scenes.TitleScene;


public class Main extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //pegar highscore salvo
        SharedPreferences preferences = getSharedPreferences("score", Context.MODE_PRIVATE);
        Global.score.setHighscore(preferences.getInt("score",0));



        // configura a tela
        CCGLSurfaceView glSurfaceView = new CCGLSurfaceView(this);
        setContentView(glSurfaceView);
        CCDirector.sharedDirector().attachInView(glSurfaceView);
        // configura CCDirector
        CCDirector.sharedDirector().setScreenSize(320, 480);
        // abre tela principal
        CCScene scene = new TitleScene().scene();
        CCDirector.sharedDirector().runWithScene(scene);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SoundEngine.sharedEngine().pauseSound();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SoundEngine.sharedEngine().resumeSound();
    }

    //Todo:Quando usado método onStop, audio não é pausado ao sair do app!!!

   /* @Override
    protected  void onStop(){
        super.onStop();
        SoundEngine.sharedEngine().pauseSound();
        //salvar highscore quando encerrar o app
        if(Global.score.getPontos()> Global.score.getHighscore()){
            SharedPreferences settings = getSharedPreferences("score", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("score", Global.score.getHighscore());
            editor.commit();

        }
        Global.gotoScene(new TitleScene().scene());

    }*/
}