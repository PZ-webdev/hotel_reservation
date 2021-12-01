import Controllers.GuestController;
import Controllers.RoomController;
import Controllers.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {

//        new RoomController();
//        new UserController();
//        new GuestController();

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            // load launcherScene.fxml in layout of type Parent
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            // Create obj of type scene , add layout in it
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);

//            Image icon = new Image(getClass()
//                    .getResourceAsStream("/img/launcher_icon.png"));
//            stage.getIcons().add(icon);

            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println("Login Scene Error: " + ex.getMessage());
        }
    }
}