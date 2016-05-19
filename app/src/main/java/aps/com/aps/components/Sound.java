package aps.com.aps.components;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.sound.SoundEngine;

import java.util.ArrayList;

import aps.com.aps.core.Global;

/**
 * Created by dihgg on 28/10/15.
 */
public class Sound {
    //TODO: completar classe de som
    private ArrayList<Integer> sounds;
    private boolean isPlaying = Global.sounds;

    public Sound(){
        //array para receber os sons
        sounds = new ArrayList<Integer>();
    }

    //Adicionar o resource à lista de sons
    public void add(int resource){
        sounds.add(resource);
    }

    //Carregar todos os sons da lista
    public void load(){
        for (int sound : sounds)
            SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(), sound);
    }

    //toca um efeito
    public void playEffect(int resource){
        if (isPlaying) {
            if(isPlaying){
                SoundEngine.sharedEngine().playEffect(CCDirector.sharedDirector().getActivity(), resource);
            }
        }
    }

    //toca uma musica de fundo
    public void playSound(int resource, boolean loop) {
        if (isPlaying) {
            SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), resource, loop);
        }
    }

    public void pauseSound(){
        SoundEngine.sharedEngine().pauseSound();
    }

    public void setIsPlaying(boolean play){

        this.isPlaying = play;
        Global.sounds = play;
    }

    public boolean getIsPlaying(){
        return isPlaying;
    }

}