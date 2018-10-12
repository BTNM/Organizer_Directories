package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class homeController implements Initializable {

    @FXML BorderPane mainPane;
    @FXML Label title;

    @FXML Button fileBtn;
    @FXML Button inputBtn;
    @FXML TextField input;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    public void chooseFile(ActionEvent actionEvent) {
//        FileChooser fileChooser = new FileChooser();
//
//        File selected = fileChooser.showOpenDialog(mainPane.getScene().getWindow());
//        if (selected != null) {
//            System.out.println("name = "+selected.getName());
//        } else {
//            System.out.println("something went wrong");
//        }

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select some directories");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File dir = directoryChooser.showDialog(mainPane.getScene().getWindow());
        if (dir != null) {
            for (String line : dir.list()){
                System.out.println(line);
            }
            System.out.println(dir.getName());
            System.out.println(dir.listFiles().length);
            String mapSize = dir.getTotalSpace()*0.00000095367432+"MB";
            System.out.println(dir.getTotalSpace()*0.00000095367432+"MB");
//            Date date = new Date(dir.lastModified() );
//            System.out.println(date);
            String creationTime = "";
            try {
                BasicFileAttributes attr = Files.readAttributes(dir.toPath(), BasicFileAttributes.class);
                System.out.println("creationTime: "+ attr.creationTime());
                creationTime = attr.creationTime().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileObservable fileObservable = new FileObservable(dir.getName(),dir.listFiles().length,mapSize, creationTime );

        } else {
            System.out.println("something went wrong");
        }


//        File selectedFile = fileChooser.showOpenDialog(primaryStage);

//        fileChooser.setTitle("Choosing File");
//        fileChooser.setInitialDirectory(new File("E//"));
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("All Images", "*.*"),
//                new FileChooser.ExtensionFilter("All Files", "*.*"),
//                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
//                new FileChooser.ExtensionFilter("GIF", "*.gif"),
//                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
//                new FileChooser.ExtensionFilter("PNG", "*.png")
//        );
//
//        fileBtn.setOnAction( event -> {
//            fileChooser.showOpenDialog(new Stage());
////            fileChooser.showOpenDialog(mainPane.getScene().getWindow());
//        });

//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        directoryChooser.setTitle("Open Resource File");
//        directoryChooser.getExtensionFilters().addAll(
//                new ExtensionFilter("Text Files", "*.txt"),
//                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
//                new ExtensionFilter("All Files", "*.*"));
//        File selectedFile = directoryChooser.showDialog(mainStage);
//        if (selectedFile != null) {
//            mainStage.display(selectedFile);
//        }


    }

    public ArrayList<FileObservable> directoryList(File dir) {
        ArrayList<FileObservable> data = new ArrayList<FileObservable>();
        for (File f : dir.listFiles() ) {
            System.out.println(f.getName() );
            FileObservable fileObs = new FileObservable(dir.getName(),dir.listFiles().length,dir.getTotalSpace()*0.00000095367432+"MB",dir.lastModified());
            data.add(fileObs);
        }

        return data;
    }


    public void handleInput(ActionEvent actionEvent) {
        String inText = input.getText();
        System.out.println(inText);
    }
}
