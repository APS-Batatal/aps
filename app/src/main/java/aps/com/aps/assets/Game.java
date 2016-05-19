package aps.com.aps.assets;

import java.util.ArrayList;

/**
 * Created by dihgg on 04/11/15.
 */
public class Game {
    //TODO: alterar
    public static String BACKGROUND  = "background.png";
    public static String HEART       = "heart.png";
    public static String SOUND         = "sound.png";
    public static String PAUSE         = "pause.png";

    public static String COCA        = "coca.png";
    public static String LEITE       = "leite.png";
    public static String BANANA      = "banana.png";
    public static String MACA        = "maca.png";

    public static ArrayList<String> getLixosReciclaveis(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add(COCA);
        lista.add(LEITE);
        return lista;
    }
    public static ArrayList<String> getLixosNaoReciclaveis(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add(BANANA);
        lista.add(MACA);
        return lista;
    }
}
