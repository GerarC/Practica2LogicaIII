package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}



/*
    Lógica
    todo Método que permita que el usuario ingrese el árbol ---- implementación visual
    todo Método que cree un arbol binario dada una altura n
    todo Método que retorne cuales son los hijos del nodo
    todo Método que retorne cual es el padre
    todo Método que retorno el abuelo
    todo Método que retorne cuales son los ancestros
    todo Método que retorne el tio
    todo Método que retorne si el nodo es derecho o izquierdo



* */