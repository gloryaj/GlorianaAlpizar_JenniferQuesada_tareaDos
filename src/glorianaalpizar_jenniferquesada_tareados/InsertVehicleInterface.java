package glorianaalpizar_jenniferquesada_tareados;

import domain.vehicle;
import file.VehicleFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;

public class InsertVehicleInterface {

    File file = new File("Vehiculos.dat");
    VehicleFile vf ;
    File fileV = new File("Vehiculos.dat");

    ComboBox<String> cbox_american = new ComboBox<>();
    TextField tf_name = new TextField();
    TextField tf_year = new TextField();
    TextField tf_mileage = new TextField();
    TextField tf_series = new TextField();
    boolean american = true;

    public BorderPane InsertVehicle() throws FileNotFoundException, IOException {

        //Declaracion de variables 
        GridPane gp_insertVehicle;
        Label lb_name, lb_year, lb_mileaje, lb_american, lb_series;

        Button btn_insertVehicle;
        Image image = new Image("FondoEditado.jpg");

        ImageView backGround = new ImageView();
        backGround.setImage(image);
        backGround.setFitHeight(920);
        backGround.setFitWidth(1500);

        //Instancia GridPane
        gp_insertVehicle = new GridPane();

        //Instancia de Labels 
        lb_name = new Label("Nombre");
        lb_name.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");
        lb_year = new Label("Año");
        lb_year.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");
        lb_mileaje = new Label("Kilometraje");
        lb_mileaje.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");
        lb_american = new Label("Americano");
        lb_american.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");
        lb_series = new Label("Series");
        lb_series.setStyle("-fx-font-size: 21px; -fx-text-fill: #000000; -fx-font-family:\"Berlin Sans FB\";");
        btn_insertVehicle = new Button("Insertar Vehiculo");
        btn_insertVehicle.setStyle("-fx-background-color: linear-gradient( #ff0000,#cc0000); -fx-font-size: 14px; \n"
                + "-fx-font-family:\"Berlin Sans FB\";-fx-text-fill:#ffffff;-fx-effect: dropshadow(three-pass-box,rgba(0,0,0,0.6),5,0.0,0,1);\n"
                + "");
        cbox_american.getItems().addAll("Si", "No");
        if (!"Si".equals(cbox_american.getValue())) {
            american = false;
        }
            btn_insertVehicle.setOnAction((event) -> {
                try {
                    vf = new VehicleFile(fileV);
                    vehicle car = new vehicle(tf_name.getText(), Integer.parseInt(tf_year.getText()), Float.parseFloat(tf_mileage.getText()), american, Integer.parseInt(tf_series.getText()));
                    vf.addEndRecord(car);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "error boton insertar");
                }
            });

            //Esto nos permite  ingresar  solo numeros en este campo
            tf_year.setOnKeyTyped((event) -> {
                char car = event.getCharacter().charAt(0);
                if (car < '0' || car > '9') {
                    event.consume();
                }

            });
            tf_mileage.setOnKeyTyped((event) -> {
                char car = event.getCharacter().charAt(0);
                if (car < '0' || car > '9') {
                    event.consume();
                }

            });

            tf_series.setOnKeyTyped((event) -> {
                char car = event.getCharacter().charAt(0);
                if (car < '0' || car > '9') {
                    event.consume();
                }

            });
            //Esto nos  permite  ingresar solo letras en este espacio
            tf_name.setOnKeyTyped((event) -> {
                char car = event.getCharacter().charAt(0);
                if (!(Character.isLetter(car) || Character.isSpaceChar(car))) {
                    event.consume();
                }

            });

            //AÑADIMOS ETIQUETAS Y CAMPOS DE TEXTO AL GRID PANE
            gp_insertVehicle.add(lb_name, 13, 6);
            gp_insertVehicle.add(tf_name, 13, 7);
            gp_insertVehicle.add(lb_year, 13, 8);
            gp_insertVehicle.add(tf_year, 13, 9);
            gp_insertVehicle.add(lb_mileaje, 13, 10);
            gp_insertVehicle.add(tf_mileage, 13, 11);
            gp_insertVehicle.add(lb_american, 17, 6);
            gp_insertVehicle.add(cbox_american, 17, 7);
            gp_insertVehicle.add(lb_series, 17, 8);
            gp_insertVehicle.add(tf_series, 17, 9);
            gp_insertVehicle.add(btn_insertVehicle, 15, 15);
            gp_insertVehicle.setVgap(20);
            gp_insertVehicle.setHgap(20);

            StackPane root = new StackPane();
            root.setAlignment(Pos.CENTER);
            root.getChildren().addAll(backGround, gp_insertVehicle);
            BorderPane pane = new BorderPane();
            pane.setCenter(root);
            return pane;
        }
    }
