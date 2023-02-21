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
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 *
 * @author warne
 */
public class Termofilas extends Thread implements Bacteria {

    private String nombre;
    @FXML
    private Image Imgtermofilas;
    
    private Image ImgtermofilasH1;
    
    private Image ImgtermofilasH2;
    
    private Image ImgtermofilasH3;
    @FXML
    private ImageView portalImgTermofilas;
    @FXML
    private TranslateTransition Tt;

    private ScaleTransition scale;

    private RotateTransition rotate;

    private FadeTransition fade;
    @FXML
    private Pane PaneImageViews;

    private Animacion animacionesAux;

    private int numeroBacteria;

    private int nvlbacteria;

    private int bacteriecitas; //cantidad de bacterias hijas

    private boolean presencia02;

    private boolean humedad;

    private int temperatura;

    private boolean presenciaCo2;

    private int hemuerto;

    private int comprobacionSurvive;

    public Termofilas(int numeroBacteriaP) {
        nombre = "Thermus thermophilus";
        this.numeroBacteria = numeroBacteriaP;
        this.bacteriecitas = 0;
        this.nvlbacteria = 0;
        this.comprobacionSurvive = 0;
        Imgtermofilas = new Image(getClass().getResourceAsStream("/Imagenes/bacteria3.png"));
        ImgtermofilasH1= new Image(getClass().getResourceAsStream("/Imagenes/bacteria3H1.png"));
        ImgtermofilasH2= new Image(getClass().getResourceAsStream("/Imagenes/bacteria3H2.png"));
        ImgtermofilasH3= new Image(getClass().getResourceAsStream("/Imagenes/bacteria3H3.png"));
        portalImgTermofilas = new ImageView(Imgtermofilas);
        portalImgTermofilas.setFitHeight(80);
        portalImgTermofilas.setFitWidth(80);
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
    
    public int getHemuerto() {
        return hemuerto;
    }

     @Override
    public void setPresenciaO2(boolean presenciaO2) {
        this.presencia02 = presenciaO2;
    }

    @Override
    public void setHumedad(boolean humedad) {
        this.humedad = humedad;
    }
    
    @Override
    public void live() {
        PaneImageViews.getChildren().add(portalImgTermofilas);
        animacionesAux = new Animacion(portalImgTermofilas);
    }

    @Override
    public void develop() {
        if (nvlbacteria < 3 && (temperatura >= 45 && temperatura <= 70)) {
            this.nvlbacteria++;
            animacionesAux.getScale().play();
        }
    }

    @Override
    public void survive() {
        if (this.comprobacionSurvive != 0) {
            if (this.presenciaCo2) {
                animacionesAux.getTt().pause();
            } else {
                animacionesAux.getTtfxfy().stop();
                animacionesAux.getTt().play();
            }
        } else if (this.comprobacionSurvive == 0) {
            if (this.presenciaCo2) {
                animacionesAux.getTtfxfy().play();
            } else {
                animacionesAux.getTt().play();
            }
        }
        this.comprobacionSurvive++;
    }

    @Override
    public void breed() {
        if(humedad){
            bacteriecitas++;
            switch(bacteriecitas){
                case 1:
                    portalImgTermofilas.setImage(ImgtermofilasH1);
                    break;
                case 2:
                    portalImgTermofilas.setImage(ImgtermofilasH2);
                    break;
                case 3:
                    portalImgTermofilas.setImage(ImgtermofilasH3);
            }   
        }
    }

    @Override
    public void die() {
        if (temperatura >= 0 && temperatura <= 20 && this.hemuerto == 0) {
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
