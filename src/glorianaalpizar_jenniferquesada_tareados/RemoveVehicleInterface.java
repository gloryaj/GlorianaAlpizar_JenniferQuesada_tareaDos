package glorianaalpizar_jenniferquesada_tareados;

import file.VehicleFile;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class RemoveVehicleInterface {
    File file = new File("Vehiculos.dat");
    VehicleFile vf ;

    public StackPane RemoveVehicle() {

        GridPane gp_removeV = new GridPane();
        gp_removeV.setAlignment(Pos.CENTER_LEFT);


        Label lb_searchSeries = new Label("Ingrese la serie del vehículo que desea eliminar");
        lb_searchSeries.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");
        Label lb_delete = new Label("Vehiculo eliminado correctamente");
        lb_delete.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");
        Label lb_error = new Label("Serie no encontrada");
        lb_error.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");

        TextField tf_searchSeries = new TextField();

        Button btn_remove = new Button("Eliminar");
        btn_remove.setStyle("-fx-background-color: linear-gradient( #ff0000,#cc0000); -fx-font-size: 14px; \n"
                + "-fx-font-family:\"Berlin Sans FB\";-fx-text-fill:#ffffff;-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.6),5,0.0,0,1);\n"
                + "");

        Image image = new Image("FondoEditado.jpg");
        ImageView fondo = new ImageView();
        fondo.setImage(image);
        fondo.setFitHeight(920);
        fondo.setFitWidth(1500);

        //ACCION DEL BOTON
        btn_remove.setOnAction((ActionEvent event) -> {
            try {
                vf= new VehicleFile(file);
                if(vf.deleteVehicleSeries(Integer.parseInt(tf_searchSeries.getText()))==true){
                    gp_removeV.add(lb_delete, 5, 6);
                }else{
                    gp_removeV.add(lb_error, 5,8);
                }
                tf_searchSeries.clear();
            } catch (IOException ex) {
                System.out.println("Error btn_remove");
            }
        });
        //AÑADIR AL GRID PANE
        gp_removeV.add(lb_searchSeries, 5, 2);
        gp_removeV.add(tf_searchSeries, 5, 3);
        gp_removeV.add(btn_remove, 5, 4);

        //ESPACIO ENTRE CADA ELEMENTO DEL GRID PANE
        gp_removeV.setVgap(2);
        gp_removeV.setHgap(2);

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().addAll(fondo, gp_removeV);
        return root;
    }

}
