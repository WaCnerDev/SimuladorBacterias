/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import javafx.scene.image.ImageView;

/**
 *
 * @author warne
 */
public interface Bacteria{
    
    //De esta interfaz se crean los distintos tipos de bacterias

    public void live();
    
    public void develop();

    public void survive();

    public void breed();

    public void die();
    
    public void setPresenciaCo2(boolean presenciaCo2);
    
    public void setPresenciaO2(boolean presenciaO2);
    
    public void setTemperatura(int temperatura);
    
    public void setHumedad(boolean humedad);
    
    public void RecibirInfo(boolean presenciaCo2,boolean presenciaO2,int temperatura,boolean humedad);

}
