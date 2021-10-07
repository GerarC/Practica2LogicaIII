import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/main.fxml"));
        Parent root = loader.load();

        MainController mc = loader.getController();

        primaryStage.setTitle("Arboles Binarios");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.getIcons().add(new Image("assets/icons/tree.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}



/*
    //Recorridos
    todo Métodos de recorrido del el árbol (inorden, posorden, preorden)        ---Listo Preorden
    todo Métodos que permitan leer un árbol en cualquier recorrido y que lo construyan a partir de esto  ---Listo Preorden

    todo Comentar los métodos :c



* */