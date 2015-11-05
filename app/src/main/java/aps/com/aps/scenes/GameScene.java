package aps.com.aps.scenes;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;

import aps.com.aps.Assets.Title;
import aps.com.aps.components.Lixeira;
import aps.com.aps.control.ILayerDelegate;
import aps.com.aps.settings.Device;


/**
 * Created by CNOVanessa on 03/11/2015.
 */
public class GameScene extends CCScene implements ILayerDelegate {
    //TODO: Alterar
    private CCSprite background;

    private CCLayer lixeiraLayer;
    private Lixeira lixeira;


    private GameScene() {

        this.background = new CCSprite(Title.BACKGROUND);
        this.background.setPosition(Device.center());
        this.addChild(this.background);

        this.lixeiraLayer = CCLayer.node();
        this.addChild(lixeiraLayer);
        addGameObjects();
    }
    public static CCScene createGame() {
        CCScene scene = CCScene.node();
        GameScene layer = new GameScene();
        scene.addChild(layer);
        return scene;
    }
    private void addGameObjects(){
        this.lixeira = new Lixeira();
        this.lixeiraLayer.addChild(this.lixeira);
    }
    @Override
    public void buttonClicked(CCLayer sender){
        lixeira.moveLeft();
    }
}