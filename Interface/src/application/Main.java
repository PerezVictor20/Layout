package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static final String[] nombres = {"Juan", "Maria", "Pedro", "Ana", "Luis"};
    private static final String[] apellidos = {"Gomez", "Rodriguez", "Perez", "Fernandez", "Lopez"};

    private static final Map<String, String> imagenesPorNombre = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = new AnchorPane();
            Scene scene = new Scene(root, 500, 500);

            // Crear un ListView vacío
            ListView<String> listView1 = new ListView<>();
            ObservableList<String> items1 = FXCollections.observableArrayList();
            listView1.setItems(items1);

            // Establecer el tamaño y la posición del ListView en el AnchorPane
            listView1.setPrefSize(240, 420);
            AnchorPane.setTopAnchor(listView1, 10.0); // Alineado con la parte superior
            AnchorPane.setRightAnchor(listView1, 10.0); // Alineado con la derecha

            // Crear un TextField
            TextField textField = new TextField();
            textField.setPrefSize(240, 30);
            AnchorPane.setTopAnchor(textField, 450.0); // Dejar espacio para el ListView
            AnchorPane.setRightAnchor(textField, 10.0); // Alineado con la derecha

            // Asignar imágenes para cada nombre
            imagenesPorNombre.put("Juan", "jessie.jpg");
            imagenesPorNombre.put("Maria", "ellie.jpg");
            imagenesPorNombre.put("Pedro", "joel.jpg");
            imagenesPorNombre.put("Ana", "dina.jpg");
            imagenesPorNombre.put("Luis", "tommy.jpg");

            // Crear un VBox para contener las HBox de nombre y foto
            VBox vbox = new VBox();
            vbox.setSpacing(10); // Espacio vertical entre las HBox
            for (int i = 0; i < nombres.length; i++) {
                String nombre = nombres[i];
                String apellido = apellidos[i];
                Label label = new Label(nombre + " " + apellido);
                label.setStyle("-fx-padding: 10 0 70 20;"); // Agregar un pequeño espaciado vertical
                ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagenesPorNombre.get(nombre))));
                imageView.setFitHeight(80); // Ajustar la altura de la imagen
                imageView.setFitWidth(60); // Ajustar el ancho de la imagen
                HBox hbox = new HBox(imageView, label); // Ordenar imagen y etiqueta horizontalmente
                vbox.getChildren().add(hbox); // Agregar la HBox al VBox
            }

            // Crear un ScrollPane para el VBox
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(vbox);
            scrollPane.setPrefSize(220, 470); 
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); 
            AnchorPane.setTopAnchor(scrollPane, 10.0); 
            AnchorPane.setLeftAnchor(scrollPane, 10.0); 
            scrollPane.setFitToWidth(true); 

            // Agregar el ListView y el TextField al AnchorPane
            root.getChildren().addAll(listView1, textField, scrollPane);

            // Agregar hoja de estilos
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
