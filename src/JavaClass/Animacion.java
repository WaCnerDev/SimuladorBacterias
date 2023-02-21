/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author warne
 */
public class Animacion extends Thread {

    //objetos Translate
    private TranslateTransition Tt;

    private TranslateTransition Ttfxfy;

    private TranslateTransition TtMusgo;

    private TranslateTransition TtburbujaCO2;

    private TranslateTransition TtburbujaCO2_2;

    private TranslateTransition TtburbujaCO2_3;

    private TranslateTransition TtburbujaO2;

    private TranslateTransition TtburbujaO2_2;

    private TranslateTransition TtburbujaO2_3;

    private TranslateTransition TtMusgo2;

    private TranslateTransition TtMusgo3;

    private RotateTransition rotateMusgo;

    private RotateTransition rotateMusgo2;

    private RotateTransition rotateMusgo3;

    private ScaleTransition scale;

    private RotateTransition rotate;

    private FadeTransition fade;

    private boolean estActivoCO2;

    private boolean estActivoO2;

    private Pane Paneimage;

    private ImageView portalImgMusgo;

    private ImageView portalImgMusgo2;

    private ImageView portalImgMusgo3;

    private ImageView portalImgburbujaO2;

    private ImageView portalImgburbuja02_2;

    private ImageView portalImgburbuja02_3;

    private ImageView portalImgburbujaCO2;

    private ImageView portalImgburbujaCO2_2;

    private ImageView portalImgburbujaCO2_3;

    private boolean aparecio_musgo;

    private boolean aparecio_burbujaO2;

    private boolean aparecio_burbujaCO2;

    public Animacion() {
        this.aparecio_burbujaCO2 = false;
        this.aparecio_burbujaO2 = false;
        this.aparecio_musgo = false;
    }

    public Animacion(ImageView PortalImage) {
        //genera numero aleatorio
        int ramdonFx = (int) (Math.random() * (1570 - 80));
        int ramdonFy = (int) (Math.random() * (1080 - 80));
        int ramdonTx = (int) (Math.random() * (1570 - 80));
        int ramdonTy = (int) (Math.random() * (1080 - 80));
        //Translate Transition de movimiento
        Tt = new TranslateTransition(Duration.seconds(6), PortalImage);
        Tt.setAutoReverse(true);
        Tt.setCycleCount(TranslateTransition.INDEFINITE);
        Tt.setFromX(ramdonFx);
        Tt.setFromY(ramdonFy);
        Tt.setToX(ramdonTx);
        Tt.setToY(ramdonTy);
        //Translate Transition de posicion
        Ttfxfy = new TranslateTransition(Duration.INDEFINITE, PortalImage);
        Ttfxfy.setFromX(ramdonFx);
        Ttfxfy.setFromY(ramdonFy);
        //Animacion de crecimiento  (ScaleTransition)
        scale = new ScaleTransition(Duration.seconds(3), PortalImage);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(0.3);
        scale.setByY(0.3);
        //Animacion de muerte de la bacteria (RotateTransition, FadeTransition)
        rotate = new RotateTransition(Duration.seconds(3), PortalImage);
        rotate.setCycleCount(3);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        fade = new FadeTransition(Duration.seconds(3), PortalImage);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(3);
        fade.setToValue(0);
    }

    public void setEstActivoCO2(boolean estActivoCO2) {
        this.estActivoCO2 = estActivoCO2;
    }

    public void setEstActivoO2(boolean estActivoO2) {
        this.estActivoO2 = estActivoO2;
    }

    public void setPaneimage(Pane Paneimage) {
        this.Paneimage = Paneimage;
    }

    public TranslateTransition getTtfxfy() {
        return Ttfxfy;
    }

    public TranslateTransition getTt() {
        return Tt;
    }

    public ScaleTransition getScale() {
        return scale;
    }

    public RotateTransition getRotate() {
        return rotate;
    }

    public FadeTransition getFade() {
        return fade;
    }

    public TranslateTransition getTtMusgo() {
        return TtMusgo;
    }

    public TranslateTransition getTtMusgo2() {
        return TtMusgo2;
    }

    public TranslateTransition getTtMusgo3() {
        return TtMusgo3;
    }

    public RotateTransition getRotateMusgo() {
        return rotateMusgo;
    }

    public RotateTransition getRotateMusgo2() {
        return rotateMusgo2;
    }

    public RotateTransition getRotateMusgo3() {
        return rotateMusgo3;
    }

    public TranslateTransition getTtburbujaCO2() {
        return TtburbujaCO2;
    }

    public TranslateTransition getTtburbujaCO2_2() {
        return TtburbujaCO2_2;
    }

    public TranslateTransition getTtburbujaCO2_3() {
        return TtburbujaCO2_3;
    }

    public TranslateTransition getTtburbujaO2() {
        return TtburbujaO2;
    }

    public TranslateTransition getTtburbujaO2_2() {
        return TtburbujaO2_2;
    }

    public TranslateTransition getTtburbujaO2_3() {
        return TtburbujaO2_3;
    }

    public void aparece_musgo(Image musgo) {
        if (!this.aparecio_musgo) {
            this.aparecio_musgo=true;
            portalImgMusgo = new ImageView(musgo);
            portalImgMusgo.setFitHeight(126);
            portalImgMusgo.setFitWidth(500);
            portalImgMusgo2 = new ImageView(musgo);
            portalImgMusgo2.setFitHeight(125);
            portalImgMusgo2.setFitWidth(450);
            portalImgMusgo3 = new ImageView(musgo);
            portalImgMusgo3.setFitHeight(125);
            portalImgMusgo3.setFitWidth(400);
            Paneimage.getChildren().add(portalImgMusgo);
            Paneimage.getChildren().add(portalImgMusgo2);
            Paneimage.getChildren().add(portalImgMusgo3);
            rotateMusgo = new RotateTransition(Duration.INDEFINITE, portalImgMusgo);
            rotateMusgo.setFromAngle(5);
            TtMusgo = new TranslateTransition(Duration.INDEFINITE, portalImgMusgo);
            TtMusgo.setFromX(500);
            TtMusgo.setFromY(-35);
            rotateMusgo2 = new RotateTransition(Duration.INDEFINITE, portalImgMusgo2);
            rotateMusgo2.setFromAngle(190);
            TtMusgo2 = new TranslateTransition(Duration.INDEFINITE, portalImgMusgo2);
            TtMusgo2.setFromX(350);
            TtMusgo2.setFromY(990);
            rotateMusgo3 = new RotateTransition(Duration.INDEFINITE, portalImgMusgo3);
            rotateMusgo3.setFromAngle(100);
            TtMusgo3 = new TranslateTransition(Duration.INDEFINITE, portalImgMusgo3);
            TtMusgo3.setFromX(1340);
            TtMusgo3.setFromY(600);
            rotateMusgo.play();
            TtMusgo.play();
            rotateMusgo2.play();
            TtMusgo2.play();
            rotateMusgo3.play();
            TtMusgo3.play();
        }
    }

    public void desaparece_musgo() {
        this.aparecio_musgo=false;
        Paneimage.getChildren().remove(this.portalImgMusgo);
        Paneimage.getChildren().remove(this.portalImgMusgo2);
        Paneimage.getChildren().remove(this.portalImgMusgo3);
    }

    public void aparece_burbujasCO2(Image burbujaOscura) {
        if (!this.aparecio_burbujaCO2) {
            this.aparecio_burbujaCO2 = true;
            portalImgburbujaCO2 = new ImageView(burbujaOscura);
            portalImgburbujaCO2.setFitHeight(50);
            portalImgburbujaCO2.setFitWidth(50);
            portalImgburbujaCO2_2 = new ImageView(burbujaOscura);
            portalImgburbujaCO2_2.setFitHeight(70);
            portalImgburbujaCO2_2.setFitWidth(70);
            portalImgburbujaCO2_3 = new ImageView(burbujaOscura);
            portalImgburbujaCO2_3.setFitHeight(90);
            portalImgburbujaCO2_3.setFitWidth(90);
            Paneimage.getChildren().add(portalImgburbujaCO2);
            Paneimage.getChildren().add(portalImgburbujaCO2_2);
            Paneimage.getChildren().add(portalImgburbujaCO2_3);
            int ramdonFx = (int) (Math.random() * (1570 - 100));
            int ramdonFx2 = (int) (Math.random() * (1570 - 100));
            int ramdonFx3 = (int) (Math.random() * (1570 - 100));
            TtburbujaCO2 = new TranslateTransition(Duration.seconds(9), portalImgburbujaCO2);
            TtburbujaCO2.setFromX(ramdonFx);
            TtburbujaCO2.setFromY(1200);
            TtburbujaCO2.setCycleCount(TranslateTransition.INDEFINITE);
            TtburbujaCO2.setToX(ramdonFx);
            TtburbujaCO2.setToY(-100);

            TtburbujaCO2_2 = new TranslateTransition(Duration.seconds(7), portalImgburbujaCO2_2);
            TtburbujaCO2_2.setFromX(ramdonFx2);
            TtburbujaCO2_2.setFromY(1200);
            TtburbujaCO2_2.setCycleCount(TranslateTransition.INDEFINITE);
            TtburbujaCO2_2.setToY(-100);

            TtburbujaCO2_3 = new TranslateTransition(Duration.seconds(8), portalImgburbujaCO2_3);
            TtburbujaCO2_3.setFromX(ramdonFx3);
            TtburbujaCO2_3.setFromY(1200);
            TtburbujaCO2_3.setCycleCount(TranslateTransition.INDEFINITE);
            TtburbujaCO2_3.setToY(-100);
            TtburbujaCO2.play();
            TtburbujaCO2_2.play();
            TtburbujaCO2_3.play();
        }

    }

    public void desaparece_burbujaCo2() {
        this.aparecio_burbujaCO2 = false;
        Paneimage.getChildren().remove(this.portalImgburbujaCO2);
        Paneimage.getChildren().remove(this.portalImgburbujaCO2_2);
        Paneimage.getChildren().remove(this.portalImgburbujaCO2_3);
    }

    public void aparece_burbujasO2(Image burbujAzul) {
        if(!this.aparecio_burbujaO2){
            this.aparecio_burbujaO2=true;
           portalImgburbujaO2 = new ImageView(burbujAzul);
        portalImgburbujaO2.setFitHeight(50);
        portalImgburbujaO2.setFitWidth(50);
        portalImgburbuja02_2 = new ImageView(burbujAzul);
        portalImgburbuja02_2.setFitHeight(70);
        portalImgburbuja02_2.setFitWidth(70);
        portalImgburbuja02_3 = new ImageView(burbujAzul);
        portalImgburbuja02_3.setFitHeight(90);
        portalImgburbuja02_3.setFitWidth(90);
        Paneimage.getChildren().add(portalImgburbujaO2);
        Paneimage.getChildren().add(portalImgburbuja02_2);
        Paneimage.getChildren().add(portalImgburbuja02_3);
        int ramdonFx = (int) (Math.random() * (1570 - 100));
        int ramdonFx2 = (int) (Math.random() * (1570 - 100));
        int ramdonFx3 = (int) (Math.random() * (1570 - 100));
        TtburbujaO2 = new TranslateTransition(Duration.seconds(9), portalImgburbujaO2);
        TtburbujaO2.setFromX(ramdonFx);
        TtburbujaO2.setFromY(1200);
        TtburbujaO2.setCycleCount(TranslateTransition.INDEFINITE);
        TtburbujaO2.setToX(ramdonFx);
        TtburbujaO2.setToY(-100);
        TtburbujaO2_2 = new TranslateTransition(Duration.seconds(7), portalImgburbuja02_2);
        TtburbujaO2_2.setFromX(ramdonFx2);
        TtburbujaO2_2.setFromY(1200);
        TtburbujaO2_2.setCycleCount(TranslateTransition.INDEFINITE);
        TtburbujaO2_2.setToY(-100);
        TtburbujaO2_3 = new TranslateTransition(Duration.seconds(8), portalImgburbuja02_3);
        TtburbujaO2_3.setFromX(ramdonFx3);
        TtburbujaO2_3.setFromY(1200);
        TtburbujaO2_3.setCycleCount(TranslateTransition.INDEFINITE);
        TtburbujaO2_3.setToY(-100);
        TtburbujaO2.play();
        TtburbujaO2_2.play();
        TtburbujaO2_3.play(); 
        }
    }

    public void desaparece_burbujao2() {
        this.aparecio_burbujaO2=false;
        Paneimage.getChildren().remove(this.portalImgburbujaO2);
        Paneimage.getChildren().remove(this.portalImgburbuja02_2);
        Paneimage.getChildren().remove(this.portalImgburbuja02_3);
    }
}
