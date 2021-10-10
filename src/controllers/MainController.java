package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import models.NodoAB;

import java.util.ArrayList;

public class MainController {

    @FXML
    private MenuBar mnuBar;
    @FXML
    private Menu mnuCrearArbolNuevo;
    @FXML
    private Menu mnuCrearArbolAleatorio;
    @FXML
    private Menu mnuMostrarArbol;
    @FXML
    private Menu mnuSalir;
    @FXML
    private Menu mnuAyuda;
    @FXML
    private Menu mnuAcerca;



    ArrayList<NodoAB> nodos = new ArrayList<NodoAB>();

    @FXML
    private void initialize(){
        return;



    }

    @FXML
    public void mnuCrearArbolNuevo_action(){
        return;
    }

    @FXML
    public void mnuCrearArbolAleatorio_action(){
        return;
    }

    @FXML
    public void mnuMostrarArbol_action(){
        return;
    }

    @FXML
    public void mnuSalir_action(){
        System.exit(0);
    }

    @FXML
    public void mnuAyuda_action(){
        return;
    }

    @FXML
    public void mnuAcerca_action(){
        return;
    }

}
