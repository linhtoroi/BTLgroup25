package Main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Group root = new Group();
            root.getChildren().add(root1);
            //Canvas canvas = new Canvas();
            //GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
            //graphicsContext.drawImage();
            MainController mainController = new MainController();
            //root.getChildren().add(canvas);
            mainController.createTower(root);

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);

            primaryStage.show();
        }
        catch (Exception e) {
            System.out.println("Ex");
            e.printStackTrace();
        }
    }
}
