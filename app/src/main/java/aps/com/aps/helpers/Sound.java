package aps.com.aps.helpers;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.sound.SoundEngine;

import java.util.ArrayList;

/**
 * Created by dihgg on 28/10/15.
 */
public class Sound {
    //TODO: completar classe de som
    private ArrayList<Integer> sounds;

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

    //Carregar um som específico
    public void load(int resource) {
        SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(), resource);
    }

    //tocar um som (sem loop por padrão)
    public void play(int resource){
        play(resource, false);
    }

    //tocar um som (especificando o loop)
    public void play(int resource, boolean loop) {
        SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), resource, loop);
    }

}
