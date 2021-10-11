import controllers.ArbolNuevoController;
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
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("views/arbolNuevo.fxml"));
        Parent root = loader.load();


        MainController mc = loader.getController();
        //ArbolNuevoController mc = loader.getController();

        primaryStage.setTitle("Arboles Binarios");
        primaryStage.setScene(new Scene(root, 600, 300));
        //primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.getIcons().add(new Image("assets/icons/tree.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}



/*
    Todo Hacer que la ventana anterior se cierre




* */