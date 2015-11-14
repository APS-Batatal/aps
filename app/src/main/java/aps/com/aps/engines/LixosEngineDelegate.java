package aps.com.aps.engines;

import aps.com.aps.components.Lixo;

/**
 * Created by silmara on 07/11/2015.
 */
public interface LixosEngineDelegate {
    public void create(Lixo lixo);
    public void remove(Lixo lixo);
}
