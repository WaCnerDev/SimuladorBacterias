/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author warne
 */
public class Mesofilas extends Thread implements Bacteria {

    private String nombre;
    
    private Image Imgmesofila;
    
    private Image ImgmesofilaH1;
    
    private Image ImgmesofilaH2;
    
    private Image ImgmesofilaH3;
    
    private ImageView portalImgMesofila;

    private TranslateTransition Tt;

    private ScaleTransition scale;

    private RotateTransition rotate;

    private FadeTransition fade;

    private Pane PaneImageViews;

    private Animacion animacionesAux;

    private int numeroBacteria;

    private int temperatura;

    private int nvlbacteria;

    private int bacteriecitas; //cantidad de bacterias hijas

    private boolean presenciaCo2;

    private boolean presencia02;

    private boolean humedad;

    private int hemuerto;

    private int comprobacionSurvive;

    public Mesofilas(int numeroBacteriaP) {
        nombre = "Stenotrophomonas maltophilia";
        this.numeroBacteria = numeroBacteriaP;
        this.nvlbacteria = 0;
        bacteriecitas = 0;
        hemuerto = 0;
        comprobacionSurvive = 0;
        Imgmesofila = new Image(getClass().getResourceAsStream("/Imagenes/bacteria2.png"));
        ImgmesofilaH1= new Image(getClass().getResourceAsStream("/Imagenes/bacteria2H1.png"));
        ImgmesofilaH2= new Image(getClass().getResourceAsStream("/Imagenes/bacteria2H2.png"));
        ImgmesofilaH3= new Image(getClass().getResourceAsStream("/Imagenes/Bacteria2H3.png"));
        portalImgMesofila = new ImageView(Imgmesofila);
        portalImgMesofila.setFitHeight(80);
        portalImgMesofila.setFitWidth(80);
    }

    public void setPaneImageViews(Pane PaneImageViews) {
        this.PaneImageViews = PaneImageViews;
    }

    public int getNumeroBacteria() {
        return numeroBacteria;
    }
    
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setPresenciaCo2(boolean presenciaCo2) {
        this.presenciaCo2 = presenciaCo2;
    }

    @Override
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public void setPresenciaO2(boolean presenciaO2) {
        this.presencia02 = presenciaO2;
    }

    @Override
    public void setHumedad(boolean humedad) {
        this.humedad = humedad;
    }
    

    public int getHemuerto() {
        return hemuerto;
    }
    
    @Override
    public void live() {
        animacionesAux = new Animacion(portalImgMesofila);
        PaneImageViews.getChildren().add(portalImgMesofila);
    }

    @Override
    public void develop() {
        if (nvlbacteria < 3 && (temperatura >= 20 && temperatura <= 45)) {
            this.nvlbacteria++;
            animacionesAux.getScale().play();
        }
    }

    @Override
    public void survive() {
        if (this.comprobacionSurvive != 0) {
            if (this.presencia02) {
                animacionesAux.getTt().pause();
            } else {
                animacionesAux.getTtfxfy().stop();
                animacionesAux.getTt().play();
            }
        } else if (this.comprobacionSurvive == 0) {
            if (this.presencia02) {
                animacionesAux.getTtfxfy().play();
            } else {
                animacionesAux.getTt().play();
            }
        }
        this.comprobacionSurvive++;
    }

    @Override
    public void breed() {
        if(!humedad){
            bacteriecitas++;
            switch(bacteriecitas){
                case 1:
                    portalImgMesofila.setImage(ImgmesofilaH1);
                    break;
                case 2:
                    portalImgMesofila.setImage(ImgmesofilaH2);
                    break;
                case 3:
                    portalImgMesofila.setImage(ImgmesofilaH3);
               }   
        }
    }

    @Override
    public void die() {
        if (temperatura <= 10 && this.hemuerto == 0) {
            this.hemuerto++;
            animacionesAux.getRotate().play();
            animacionesAux.getFade().play();
        }
    }   

    @Override
    public void RecibirInfo(boolean presenciaCo2, boolean presenciaO2, int temperatura, boolean humedad) {
            this.presenciaCo2 = presenciaCo2;
            this.presencia02 = presenciaO2;
            this.temperatura = temperatura; 
    }

}
