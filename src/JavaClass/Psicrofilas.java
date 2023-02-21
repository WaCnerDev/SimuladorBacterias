/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author warne
 */
public class Psicrofilas extends Thread implements Bacteria {

    //Elementos de javafx
    //distintas imagenes que puede tomar las Psicrofilas
    private Image Imgpsicrofila;

    private Image ImgpsicrofilaH1;

    private Image ImgpsicrofilaH2;

    private Image ImgpsicrofilaH3;

    //espacio donde se colocan las imagenes ("Observatorio")
    private Pane PaneImageViews;

    //Contenedor de las imagenes
    private ImageView portalImgPsicrofilas;

    //Clase de animaciones de aqui se extraen todas las animaciones
    private Animacion animacionesAux;

    //Atributo para diferenciar una bacteria de las demas
    private int numeroBacteria;

    //Datos del estado del ecosistemas 
    private boolean presenciaCo2;

    private boolean presencia02;

    private boolean humedad;
    
    private int temperatura;

    private int nvlbacteria;

    //cantidad de bacterias hijas
    private int bacteriecitas; 

    //nombre de las bacterias
    private final String nombre="Psychrobacter cryohalolentis";

    //comprobacion de que la bacteria sigue viva o no.
    private int hemuerto;

    //comprobacion de en que estado de sobrevivencia esta la bacteria
    private int comprobacionSurvive;

    public Psicrofilas(int numeroBacteriaP) {
        //Atributos de la bacteria
        bacteriecitas = 0;
        hemuerto = 0;
        comprobacionSurvive = 0;
        this.numeroBacteria = numeroBacteriaP;  //diferenciador entre bacterias (una marca)
        this.nvlbacteria = 0;  //lleva control sobre el estado de crecimiento de la bacteria inicia en 0 y nvlbacteria++
        //carga la imagen a imageview
        Imgpsicrofila = new Image(getClass().getResourceAsStream("/Imagenes/bacteria1.png"));
        ImgpsicrofilaH1 = new Image(getClass().getResourceAsStream("/Imagenes/Bacteria1H1.png"));
        ImgpsicrofilaH2 = new Image(getClass().getResourceAsStream("/Imagenes/Bacteria1H2.png"));
        ImgpsicrofilaH3 = new Image(getClass().getResourceAsStream("/Imagenes/Bacteria1H3.png"));
        portalImgPsicrofilas = new ImageView(Imgpsicrofila);
        portalImgPsicrofilas.setFitHeight(80);
        portalImgPsicrofilas.setFitWidth(80);
    }

    //Setter y getter (algunos sobre escritos porque se utiliza la interfaz Bacteria para ejecutarlos)
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

    //Comportamientos de la bacteria
    @Override
    public void live() {
        animacionesAux = new Animacion(portalImgPsicrofilas);
        PaneImageViews.getChildren().add(portalImgPsicrofilas);
    }

    @Override
    public void develop() {
        if (nvlbacteria < 3 && temperatura <= 20) {
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
        if (humedad) {
            bacteriecitas++;
            switch (bacteriecitas) {
                case 1:
                    portalImgPsicrofilas.setImage(ImgpsicrofilaH1);
                    break;
                case 2:
                    portalImgPsicrofilas.setImage(ImgpsicrofilaH2);
                    break;
                case 3:
                    portalImgPsicrofilas.setImage(ImgpsicrofilaH3);
            }
        }
    }

    @Override
    public void die() {
        if (temperatura >= 40 && temperatura <= 75 && this.hemuerto == 0 || this.presencia02 && this.hemuerto == 0) {
            this.hemuerto++;
            animacionesAux.getRotate().play();
            animacionesAux.getFade().play();
        }
    }

    //este proceso es como un conjunto se seteos, es una forma de comprimir el seteo de datos por medio del hilo.
    
    @Override
    public void RecibirInfo(boolean presenciaCo2, boolean presenciaO2, int temperatura, boolean humedad) {
            this.presenciaCo2 = presenciaCo2;
            this.presencia02 = presenciaO2;
            this.temperatura = temperatura; 
    }
    
    //NOTA: Los demas tipos de bacteria tienen un comportamiento muy parecido, lo unico que cambia es
    //las condiciones en las que tienen cierto comportamiento.


}
