package glorianaalpizar_jenniferquesada_tareados;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GlorianaAlpizar_JenniferQuesada_tareaDos extends Application {

    InsertVehicleInterface insertVehicle;

    @Override
    public void start(Stage primaryStage) {
        InterfaceMenu menu;
        menu = new InterfaceMenu();
        Scene scene = new Scene(menu.menu(), 1500, 900);
        primaryStage.setTitle("Tarea Dos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
