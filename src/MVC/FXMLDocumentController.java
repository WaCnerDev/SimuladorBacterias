/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import JavaClass.Animacion;
import JavaClass.Bacteria;
import JavaClass.Mesofilas;
import JavaClass.Psicrofilas;
import JavaClass.Termofilas;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author warne
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Slider sliderTemp;

    @FXML
    private Text infotemp;

    @FXML
    private RadioButton rb_CO2;

    @FXML
    private RadioButton rb_Humedad;

    @FXML
    private RadioButton rb_O2;

    @FXML
    private ComboBox<String> cb_listbacteria;

    @FXML
    private Button buttonAdd;

    @FXML
    private Pane Paneimage;

    private ObservableList<String> nombrebacterias;

    private ObservableList<Bacteria> ListBacterias;

    private int contadorDbacteriaTermofila = 0;

    private int contadorDbacteriaMesofila = 0;

    private int contadorDbacteriaPsicrofila = 0;

    private Animacion AnimacionBBM;

    private Image burbujAzul;

    private Image burbujaOscura;

    private Image musgo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //instanciamos la clase animacion para acceder a las animaciones que se presentan 
        //directamente en el panel donde se agregan la bacterias(musgo y burbujas)
        AnimacionBBM = new Animacion();
        //seteamos a la clase el Pane donde se insertaran las imagenes y sus animaciones
        AnimacionBBM.setPaneimage(Paneimage);
        nombrebacterias = FXCollections.observableArrayList();
        ListBacterias = FXCollections.observableArrayList();
        //Creacion de listas de bacterias
        nombrebacterias.addAll("Psychrobacter cryohalolentis", "Stenotrophomonas maltophilia", "Thermus thermophilus");
        cb_listbacteria.setItems(nombrebacterias);
        //Imagen de burbujas azules
        burbujAzul = new Image(getClass().getResourceAsStream("/Imagenes/burbujaAzul.png"));

        //Imagen de burbujas Oscuras
        burbujaOscura = new Image(getClass().getResourceAsStream("/Imagenes/burbujaOsc.png"));

        //Imagen de musgo
        musgo = new Image(getClass().getResourceAsStream("/Imagenes/MusgoColgante.PNG"));

    }

    /**
     * Esta vinculado con el boton de agregar
     * cada vez que se preciona, toma el valor del ComboBox , segun
     * el valor que tenga se instancia la bacteria  que indica el ComboBox
     * @param event 
     */
    @FXML
    private void agregarbacteria(ActionEvent event) {
        switch (cb_listbacteria.getValue()) {
            case "Psychrobacter cryohalolentis":
                this.contadorDbacteriaPsicrofila++;
                Psicrofilas psicrofila1 = new Psicrofilas(this.contadorDbacteriaPsicrofila);
                ListBacterias.add(psicrofila1);
                psicrofila1.setPaneImageViews(Paneimage);
                //Este metodo agrega la bacteria al pane
                psicrofila1.live();
                break;
            case "Stenotrophomonas maltophilia":
                this.contadorDbacteriaMesofila++;
                Mesofilas mesofila1 = new Mesofilas(this.contadorDbacteriaMesofila);
                ListBacterias.add(mesofila1);
                mesofila1.setPaneImageViews(Paneimage);
                //Este metodo agrega la bacteria al pane
                mesofila1.live();
                break;
            case "Thermus thermophilus":
                this.contadorDbacteriaTermofila++;
                Termofilas termofila1 = new Termofilas(this.contadorDbacteriaTermofila);
                ListBacterias.add(termofila1);
                termofila1.setPaneImageViews(Paneimage);
                //Este metodo agrega la bacteria al pane
                termofila1.live();
        }
    }

    @FXML
    private void cambioTempClicked(MouseEvent event) {
        int temperatura = (int) sliderTemp.getValue();
        infotemp.setText(String.valueOf(temperatura) + "°C");
        Iterator It = ListBacterias.iterator();
        while (It.hasNext()) {
            Bacteria z = (Bacteria) It.next();
            z.setTemperatura(temperatura);
            z.develop();
            z.die();
        }
        if (temperatura < 20) {
            Paneimage.setStyle("-fx-background-color: #9cd9ff;-fx-border-width: 10;-fx-border-color: #3d4757");
        } else if (temperatura > 30 && temperatura <= 50) {
            Paneimage.setStyle("-fx-background-color: #ffb0b0;-fx-border-width: 10;-fx-border-color: #3d4757");
        } else if (temperatura >= 20 && temperatura < 30) {
            Paneimage.setStyle("-fx-background-color: #ffffff;-fx-border-width: 10;-fx-border-color: #3d4757");
        } else if (temperatura > 50 && temperatura <= 75) {
            Paneimage.setStyle("-fx-background-color: #ff5c5c;-fx-border-width: 10;-fx-border-color: #3d4757");
        }
    }

    @FXML
    private void ActivarCo2(ActionEvent event) {
        Iterator It = ListBacterias.iterator();
        while (It.hasNext()) {
            Bacteria z = (Bacteria) It.next();
            z.setPresenciaCo2(rb_CO2.isSelected());
            z.survive();
        }
        if (rb_CO2.isSelected()) {
            AnimacionBBM.aparece_burbujasCO2(burbujaOscura);
        } else {
            AnimacionBBM.desaparece_burbujaCo2();
        }
    }

    @FXML
    private void ActivarHumedad(ActionEvent event) {
        Iterator It = ListBacterias.iterator();
        while (It.hasNext()) {
            Bacteria z = (Bacteria) It.next();
            z.setHumedad(rb_Humedad.isSelected());
            z.breed();
        }
        if (rb_Humedad.isSelected()) {
            AnimacionBBM.aparece_musgo(musgo);
            AnimacionBBM.getRotateMusgo().play();
            AnimacionBBM.getTtMusgo().play();
            AnimacionBBM.getRotateMusgo2().play();
            AnimacionBBM.getTtMusgo2().play();
            AnimacionBBM.getRotateMusgo3().play();
            AnimacionBBM.getTtMusgo3().play();
        } else {
            AnimacionBBM.desaparece_musgo();
        }
    }

    @FXML
    private void ActivarO2(ActionEvent event) {
        int temperatura = (int) sliderTemp.getValue();
        Iterator It = ListBacterias.iterator();
        while (It.hasNext()) {
            Bacteria z = (Bacteria) It.next();
            z.setPresenciaO2(rb_O2.isSelected());
            z.setPresenciaCo2(rb_CO2.isSelected());
            z.setTemperatura(temperatura);
            z.survive();
            z.die();
        }
        if (rb_O2.isSelected()) {
            AnimacionBBM.aparece_burbujasO2(burbujAzul);
        } else {
            AnimacionBBM.desaparece_burbujao2();
        }
    }

    @FXML
    private void enviarInfo() {
        (new Thread() {
            @Override
            public void run() {
                    Iterator It = ListBacterias.iterator();
                    while (It.hasNext()) {
                        Bacteria z = (Bacteria) It.next();
                        z.RecibirInfo(rb_CO2.isSelected(), rb_O2.isSelected(), (int) sliderTemp.getValue(), rb_Humedad.isSelected());
                        z.survive();
                        z.setHumedad(rb_Humedad.isSelected());
                        z.breed();
                        z.die();
                        z.develop();
                    }

            }
        }).start();
    }

}
