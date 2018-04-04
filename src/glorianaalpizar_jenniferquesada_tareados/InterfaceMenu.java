package glorianaalpizar_jenniferquesada_tareados;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class InterfaceMenu {

    RemoveVehicleInterface removeVehicle = new RemoveVehicleInterface();
    InsertVehicleInterface insertVe = new InsertVehicleInterface();
    UpdateInterface updateVehicle = new UpdateInterface();

    public BorderPane menu() {
        Image image = new Image("Fondo.jpg");

        ImageView backGround = new ImageView();
        backGround.setImage(image);
        backGround.setFitHeight(900);
        backGround.setFitWidth(1500);

        MenuBar mb_menu = new MenuBar();
        //Create el Vbox  
        VBox vb_ventanas = new VBox(20);
        BorderPane pane = new BorderPane();


        //add menu bar to vbox 
        vb_ventanas.getChildren().addAll();
        pane.setTop(mb_menu);
        pane.setCenter(vb_ventanas);

        Menu Menu = new Menu("Menu");
        Menu.setStyle("-fx-font-size: 18px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");
        Menu.setMnemonicParsing(true);
        Menu.setAccelerator(KeyCombination.keyCombination("Alt+M"));
        
        MenuItem insertVehicleMenuItem = new MenuItem("Insertar");
        insertVehicleMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
        insertVehicleMenuItem.setMnemonicParsing(true);
        insertVehicleMenuItem.setOnAction((event) -> {
            vb_ventanas.getChildren().clear();
            try {
                vb_ventanas.getChildren().addAll(insertVe.InsertVehicle());
            } catch (IOException ex) {
                System.out.println("Error 100-25");
            }
        });
        
        MenuItem updateMenuItem = new MenuItem("Actualizar");
        updateMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        updateMenuItem.setMnemonicParsing(true);
        updateMenuItem.setOnAction((event) -> {
            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().addAll(updateVehicle.updateInterface());
        });

        MenuItem removeMenuItem = new MenuItem("Borrar");
        removeMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+B"));
        removeMenuItem.setMnemonicParsing(true);
        removeMenuItem.setOnAction((event) -> {
            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().addAll(removeVehicle.RemoveVehicle());
        });
        
        Menu.getItems().addAll(insertVehicleMenuItem, updateMenuItem, removeMenuItem);

//Add to the menu bar each main menu which contains each of their respective menu items
        mb_menu.getMenus().addAll(Menu);

        StackPane root = new StackPane();
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(backGround, vb_ventanas, mb_menu);
        pane.setCenter(root);
        return pane;
    }

}
