package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import models.ArbolBinario;
import models.Model;
import models.NodoAB;

import javax.swing.*;
import java.io.IOException;
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
    @FXML
    TextFlow textFlow;
    @FXML
    Label ArbolLbl;



    ArbolBinario p = Model.getArbolInicial();
    int tamaño = Model.getTamaño();
    ObservableList<String> InfoList = FXCollections
            .observableArrayList("Hijos","Hermano","Lado","Padre","Ancestros","Tío","Abuelo","Altura","Grado","Nodo-Hoja","Recorrido-InOrden","Recorrido-PreOrden","Recorrido-PosOrden");

    ObservableList<NodoAB> NodoList ;


    public void initialize() {
        //tamaño;
        //Aqui creamos el arbol de forma aleatoria y lo metemos al label
    }

    public void BtnAction(){
        String n= (String) InfoCB.getValue();
        NodoAB m= (NodoAB) NodoCb.getValue();

        switch (n){
            case "Hijos":
                JOptionPane.showMessageDialog(null, "");
                break;
            case "Hermano":
                JOptionPane.showMessageDialog(null, "");
                break;
            case "Lado":
                JOptionPane.showMessageDialog(null, "");
                break;
            case "Padre":
                JOptionPane.showMessageDialog(null, "");
                break;
            case "Ancestros":
                JOptionPane.showMessageDialog(null, "" + p.ancestrosDelNodo(m));
                break;
            case "Tío":
                JOptionPane.showMessageDialog(null, "");
                break;
            case "Abuelo":
                JOptionPane.showMessageDialog(null, "");
                break;
            case "Altura":
                JOptionPane.showMessageDialog(null, ""+ p.alturaAB(m,1));
                break;
            case "Grado":
                JOptionPane.showMessageDialog(null, ""+p.gradoAB(m));
                break;
            case "Nodo-Hoja":
                JOptionPane.showMessageDialog(null, "" + p.retornaHojasAB(m));
                break;
            case "Recorrido-InOrden":
                JOptionPane.showMessageDialog(null, "" );
                break;
            case "Recorrido-PreOrden":
                JOptionPane.showMessageDialog(null, ""+ p.preordenString(m));
                break;
            case "Recorrido-PosOrden":
                JOptionPane.showMessageDialog(null, "");
                break;
        }






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