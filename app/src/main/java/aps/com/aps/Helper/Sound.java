package aps.com.aps.Helper;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.sound.SoundEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dihgg on 28/10/15.
 */
public class Sound {
    private ArrayList<Integer> sounds;
    //EFFECT
    public Sound(){
        sounds = new ArrayList<Integer>();
    }
    public void add(int resource){
        sounds.add(resource);

        //SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(),resource);
    }
    public void load(){
        for (int sound : sounds)
            SoundEngine.sharedEngine().preloadEffect(CCDirector.sharedDirector().getActivity(), sound);
    }
    public void play(int resource){
        //sounds.indexOf(resource);
        SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), resource,true);
    }

}
