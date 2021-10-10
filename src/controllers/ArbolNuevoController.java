package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import models.ArbolBinario;
import models.Model;
import models.NodoAB;

import java.util.ArrayList;

public class ArbolNuevoController {
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






    ArrayList<NodoAB> l = new ArrayList();

    ObservableList<String> InfoList = FXCollections
            .observableArrayList("Hijos","Hermano","Lado","Padre","Ancestros","Tío","Abuelo","Altura","Grado","Nodo-Hoja","Recorrido-InOrden","Recorrido-PreOrden","Recorrido-PosOrden");

    ObservableList<NodoAB> NodoList ;


    public void initialize() {
        ArbolBinario p = Model.getArbolInicial();

        //NodoList = FXCollections.observableList();
        InfoCB.setItems(InfoList);
        NodoCb.setItems(NodoList);

    }
    public void BtnAction(){
        String n= (String) InfoCB.getValue();
        String m= (String) NodoCb.getValue();


    }

    @FXML
    public void mnuCrearArbolNuevo_action()  {
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

    /*
    private JPanel miPanel;
    JTextArea areaDeTexto;
    String texto;
    private JLabel LabelTitulo;

    JScrollPane scrollPane;

    ArbolNuevoController (){
        setTitle (" ArbolNuevo");
        setSize(420,250);               //tamaño por defecto
        setLocationRelativeTo(null);
        iniciarComponentes();


    }

    private  void iniciarComponentes(){
        scrollPane = new JScrollPane();
        scrollPane.setBounds(5,10,380,150);
        miPanel = new JPanel();
        //miPanel.setLayout(null);

        LabelTitulo = new JLabel();
        LabelTitulo.setText("ContenedorJscrollpane");
        LabelTitulo.setBounds(120,20,180,23);

        texto=" Este contenedor";
        areaDeTexto = new JTextArea();
        areaDeTexto.setText(texto);
        areaDeTexto.setBounds(20,50,340,100);
        miPanel.setPreferredSize(new Dimension(350,250));
        scrollPane.setViewportView(miPanel);
        miPanel.add(LabelTitulo);
        miPanel.add(areaDeTexto);
        add(scrollPane);

    }

*/



}
