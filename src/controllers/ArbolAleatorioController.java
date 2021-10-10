package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class ArbolAleatorioController {
    @FXML
    private javafx.scene.control.MenuBar mnuBar;
    @FXML
    private javafx.scene.control.Menu mnuCrearArbolNuevo;
    @FXML
    private javafx.scene.control.Menu mnuCrearArbolAleatorio;
    @FXML
    private javafx.scene.control.Menu mnuMostrarArbol;
    @FXML
    private javafx.scene.control.Menu mnuSalir;
    @FXML
    private javafx.scene.control.Menu mnuAyuda;
    @FXML
    private javafx.scene.control.Menu mnuAcerca;

    @FXML
    ComboBox NodoCb;
    @FXML
    ComboBox InfoCB;


    ArrayList l = new ArrayList();

    ObservableList<String> InfoList = FXCollections
            .observableArrayList("Hijos", "Hermano", "Lado", "Padre", "Ancestros", "Tío", "Abuelo", "Altura", "Grado", "Nodo-Hoja", "Recorrido-InOrden", "Recorrido-PreOrden", "Recorrido-PosOrden");
    ObservableList<String> NodoList = FXCollections
            .observableArrayList();


    public void initialize() {
        InfoCB.setItems(InfoList);
        NodoCb.setItems(NodoList);

    }

    public void BtnAction() {
        String n = (String) InfoCB.getValue();
        String m = (String) NodoCb.getValue();


    }

    @FXML
    public void mnuCrearArbolNuevo_action() {
        return;
    }

    @FXML
    public void mnuCrearArbolAleatorio_action() {
        return;
    }

    @FXML
    public void mnuMostrarArbol_action() {
        return;
    }

    @FXML
    public void mnuSalir_action() {
        System.exit(0);
    }

    @FXML
    public void mnuAyuda_action() {
        return;
    }

    @FXML
    public void mnuAcerca_action() {
        return;
    }

}
