package com.kensoftph.filechooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+ "/Desktop"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG Image","*.jpg"), new FileChooser.ExtensionFilter("PNG Image", "*.png"), new FileChooser.ExtensionFilter("All image files","*.jpg","*.png"));
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file","*.txt"));
        // this is for saving a file. remove the setInitialFileName if you are opening a file
        //fileChooser.setInitialFileName("Untitled");
        //File selectedFile = fileChooser.showOpenDialog(stage);
        Stage stage = (Stage) button.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if(selectedFile != null){

            // this is for saving a file
            /*try {
                FileWriter fileWriter = new FileWriter(selectedFile);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write("Learning how to use the JavaFX FileChooser");
                writer.close();
                System.out.println("The file has been saved in "+ selectedFile.getAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/

                //this is for opening a file
                label.setText(selectedFile.getName());
                Image image = new Image(selectedFile.getPath());
                imgView.setImage(image);


                /* This is for reading a text file
                try {
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
    }
}