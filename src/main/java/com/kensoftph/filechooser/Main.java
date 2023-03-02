package com.kensoftph.filechooser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane layout = new BorderPane();

        Button button = new Button("Open a file");
        Label label = new Label();
        ImageView imgView = new ImageView();

        button.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open a file");
            fileChooser.setInitialDirectory(new File("C:\\"));
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG Image","*.jpg"),
                    new FileChooser.ExtensionFilter("PNG Image", "*.png"), new FileChooser.ExtensionFilter("All image file","*.jpg","*.png"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            if(selectedFile != null){
                label.setText(selectedFile.getName());
                Image image = new Image(selectedFile.getPath());
                imgView.setImage(image);
                /*try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while((line = bufferedReader.readLine()) != null){
                        stringBuilder.append(line).append("\n");
                    }
                    System.out.println(stringBuilder.toString());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }*/
            }else{
                System.out.println("No file has been selected");
            }
        });

        layout.setTop(button);
        layout.setCenter(imgView);
        layout.setBottom(label);
        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setAlignment(label, Pos.CENTER);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("file-chooser.fxml"));
        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("JavaFX FileChooser");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}