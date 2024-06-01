import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

public class Main extends Application {
    private TextField directoryPathField;
    private TextField searchField;
    private TextArea resultArea; 

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       
        primaryStage.setTitle("File Browser and Search");

        directoryPathField = new TextField();
        directoryPathField.setPromptText("Enter directory path");

        
        searchField = new TextField();
        searchField.setPromptText("Enter search phrase");

       
        resultArea = new TextArea();
        resultArea.setPrefHeight(400); 

     
        Button browseButton = new Button("Browse");
        browseButton.setOnAction(e -> browseDirectory(primaryStage));

        
        Button searchButton = new Button("Search");

        
        HBox hBox = new HBox(10, directoryPathField, browseButton);

    
        VBox vBox = new VBox(10, hBox, searchField, searchButton, resultArea);
        vBox.setPrefSize(600, 600); 

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void browseDirectory(Stage primaryStage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Directory");

        File selectedDirectory = directoryChooser.showDialog(primaryStage);

        if (selectedDirectory != null) {
            directoryPathField.setText(selectedDirectory.getAbsolutePath());
        }
    }
}
