package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.ArbolBinario;
import models.Model;

import javax.swing.*;
import java.io.IOException;

public class MainController {
    @FXML
    AnchorPane PantallaInicial;
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
    private void initialize() {
        //PantallaInicial.setStyle("-fx-background-color: radial-gradient(center 50px 50px, radius 100px, azul, #02b674);");
        PantallaInicial.setStyle("-fx-background-color:#02b674");
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
                String j = "(B(B(O(N(,W(S,B)),R(Q(I,E),Y(,U))),A(P(,K(R,K)),R(B(G,Ñ)))),H(R(X(J(Y,M),P(V,J)),T(F(R,T),D(,E))),L(R(I(E,G),P(B,I)),Z(U,W(Ñ))))))";
                //JOptionPane.showInputDialog("Ingrese recorrido por Comas:");
                ArbolBinario ab = new ArbolBinario();
                ab.construyeAB(j);
                Model p = new Model(ab,0);
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
        stage.getIcons().add(new Image("assets/icons/tree.png"));
        stage.getIcons().add(new Image("assets/icons/tree.png"));
        stage.setTitle("Arbol Nuevo");
        Stage myStage= (Stage) this.mnuBar.getScene().getWindow();
        myStage.close();

    }

    @FXML
    public void mnuCrearArbolAleatorio_action() throws IOException {
        int tamaño = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arbol: "));
        Model p = new Model(new ArbolBinario(),tamaño);

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/views/arbolAleatorio.fxml"));
        Parent root2 = loader2.load();
        ArbolAleatorioController controlador2 = loader2.getController();

        Scene scene2 = new Scene(root2);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.setResizable(false);
        stage2.getIcons().add(new Image("assets/icons/tree.png"));
        stage2.setTitle("Arbol Aleatorio");
        stage2.show();
        Stage myStage= (Stage) this.mnuBar.getScene().getWindow();
        myStage.close();

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
