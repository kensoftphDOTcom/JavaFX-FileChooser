package com.kensoftph.filechooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class FileChooserController {
    @FXML
    Button button = new Button("Open a file");
    @FXML
    Label label = new Label();
    ImageView imgView = new ImageView();
    @FXML
    void button(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a file");
        fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File","*.txt"));
        Stage stage = (Stage) button.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if(selectedFile != null){
            label.setText(selectedFile.getName());
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line).append("\n");
                }
                System.out.println(stringBuilder.toString());
            } catch (FileNotFoundException ee) {
                throw new RuntimeException(ee);
            } catch (IOException eeee) {
                throw new RuntimeException(eeee);
            }
        }else{
            System.out.println("No file has been selected");
        }
    }
}