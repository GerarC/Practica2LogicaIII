package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.ArbolBinario;
import models.Model;

import javax.swing.*;
import java.io.IOException;

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

    @FXML
    private void initialize(){
        return;
    }

    @FXML
    public void mnuCrearArbolNuevo_action() throws IOException {
        //recibimos el Arbol y Su forma
        int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero Correspondiente:\n" +
                "1- Si es un Arbol en Inorden-Preorden.\n" +
                "2- Si es un Arbol en Inorden-Posorden.\n" +
                "3- Si es un Arbol por Comas."));

        boolean c = true;
        //Miramos si fue correctamente ingresado
        while(true){
            if (b>3) {
                b = Integer.parseInt(JOptionPane.showInputDialog("Numero Erroneo...\n" +
                        "Ingrese el Numero Correspondiente:\n" +
                        "1- Si es un Arbol en Inorden-Preorden.\n" +
                        "2- Si es un Arbol en Inorden-Posorden.\n" +
                        "3- Si es un Arbol por Comas."));
            }else{
                break;
            }
        }

        switch (b){
            case 1:
                String e = JOptionPane.showInputDialog("Ingrese su Inorden:");
                String h = JOptionPane.showInputDialog("Ingrese su Preorden:");

                break;
            case 2:
                String f = JOptionPane.showInputDialog("Ingrese recorrido Inorden:");
                String g = JOptionPane.showInputDialog("Ingrese recorrido Posorden:");

                break;


            case 3:
                String j = JOptionPane.showInputDialog("Ingrese recorrido por Comas:");
                ArbolBinario ab = new ArbolBinario();
                ab.construyeAB(j);
                Model p = new Model(ab);
                break;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/arbolNuevo.fxml"));
        Parent root = loader.load();
        ArbolNuevoController controlador = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();












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
