import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
        primaryStage.setTitle("Arboles Binarios");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}



/*
    Lógica
    todo Método que permita que el usuario ingrese el árbol                     ---Ya
    todo Método que cree un arbol binario dada una altura n                     ---Ya
    todo Método que retorne el número de hijos y cuáles son los hijos del nodo  ---Ya
    todo Método que retorne cual es el padre                                    ---Ya
    todo Método que retorno cual el abuelo                                      ---Ya
    todo Método que retorne cuales son los ancestros                            ---Ya
    todo Método que retorne el tio                                              ---Ya
    todo Método que retorne si el nodo es derecho o izquierdo                   ---Ya
    todo Método que retorne el hermano, si es que tiene                         ---Ya

    todo Método que retorne la altura                                           ---Ya
    todo Método que retorne el grado del árbol                                  ---Ya
    todo Método que retorne cuales son las hojas                                ---Ya

    //Recorridos
    todo Métodos de recorrido del el árbol (inorden, posorden, preorden)        ---Listo Preorden
    todo Métodos que permitan leer un árbol en cualquier recorrido y que lo construyan a partir de esto  ---Listo Preorden

    todo Comentar los métodos :c



* */