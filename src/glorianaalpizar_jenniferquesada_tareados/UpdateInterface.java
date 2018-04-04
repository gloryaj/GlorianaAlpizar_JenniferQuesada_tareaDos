package glorianaalpizar_jenniferquesada_tareados;

import domain.vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class UpdateInterface {

    File file = new File("Vehiculos.dat");
    VehicleFile vf ;
    vehicle car = new vehicle();

    //textfield 
    TextField tf_searchSeries = new TextField();
    TextField tf_mileage = new TextField();
    TextField tf_serie = new TextField();
    TextField tf_changeName = new TextField();
    TextField tf_changeYear = new TextField();
    TextField tf_changeAmerican = new TextField();

    //Interfaz Actualizar vehiculo
    public StackPane updateInterface() {

        GridPane gp_update = new GridPane();
        gp_update.setAlignment(Pos.CENTER_LEFT);

        Label lb_searchSeries = new Label("Ingrese la serie del vehícuclo");
        lb_searchSeries.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");

        Button btn_search = new Button("Buscar");
        btn_search.setStyle("-fx-background-color: linear-gradient( #ff0000,#cc0000); -fx-font-size: 14px; \n"
                + "-fx-font-family:\"Berlin Sans FB\";-fx-text-fill:#ffffff;-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.6),5,0.0,0,1);\n"
                + "");

        Label lb_mileage = new Label("Kilometraje");
        lb_mileage.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");

        Label lb_cangeName = new Label("Nombre");
        lb_cangeName.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");

        Label lb_changeYear = new Label("Año");
        lb_changeYear.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");

        Label lb_series = new Label("Serie");
        lb_series.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");

        Label lb_changeAmerican = new Label("Americano");
        lb_changeAmerican.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");

        Label lb_errorSeries = new Label("Serie no encontrada");
        lb_errorSeries.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");

        Button change = new Button("Modificar");
        change.setStyle("-fx-background-color: linear-gradient( #ff0000,#cc0000); -fx-font-size: 14px; \n"
                + "-fx-font-family:\"Berlin Sans FB\";-fx-text-fill:#ffffff;-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.6),5,0.0,0,1);\n"
                + "");

        //ACCION DEL BOTON
        change.setOnAction((event) -> {
            tf_serie.clear();
            tf_mileage.clear();
        });

        //ACCION DEL BOTON, agrega los campos a cambiar y los que no con la informacion
        btn_search.setOnAction((event) -> {
            tf_searchSeries.clear();
            
            try {
                 vf= new VehicleFile(file);
                if (vf.updateVehicleSeries(Integer.parseInt(tf_searchSeries.getText())) == true) {
                    gp_update.add(lb_cangeName, 90, 3);
                    gp_update.add(tf_changeName, 90, 4);
                    gp_update.add(lb_changeYear, 90, 6);
                    gp_update.add(tf_changeYear, 90, 7);
                    gp_update.add(lb_mileage, 90, 9);
                    gp_update.add(tf_mileage, 90, 10);
                    gp_update.add(lb_series, 100, 3);
                    gp_update.add(tf_serie, 100, 4);
                    gp_update.add(lb_errorSeries, 100, 6);
                    gp_update.add(tf_changeAmerican, 100, 7);
                } else {
                    gp_update.add(lb_errorSeries, 100, 7);
                }
            } catch (IOException ex) {
                System.out.println("Error btn_searchSeries");
            }
        });
        //IMAGEN DE FONDO
        Image image = new Image("FondoEditado.jpg");
        ImageView fondo = new ImageView();
        fondo.setImage(image);
        fondo.setFitHeight(920);
        fondo.setFitWidth(1500);

        gp_update.add(lb_searchSeries, 17, 0);
        gp_update.add(tf_searchSeries, 17, 1);
        gp_update.add(btn_search, 17, 2);

        //ESPACIO ENTRE CADA ELEMENTO DEL GRID
        gp_update.setVgap(3);
        gp_update.setHgap(3);

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(fondo, gp_update);

        return root;
    }

}
