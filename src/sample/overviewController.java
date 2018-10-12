package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class overviewController implements Initializable {

    @FXML BorderPane mainPane;
    @FXML TableView<FileObservable> mainTable;

    @FXML TableColumn<FileObservable, String> mapNameCol;
    @FXML TableColumn<FileObservable, Integer> totalFilesCol;
    @FXML TableColumn<FileObservable, Integer> mapSizeCol;
    @FXML TableColumn<FileObservable, String> mapDateCol;

    ObservableList<FileObservable> dataList = FXCollections.observableArrayList(
            new FileObservable("games", 23,340,"04.05.06"),
            new FileObservable("Anime", 48,440,"04.05.06"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainTable.setEditable(true);

        setupMapNameCol();
        setupTotalFilesCol();
        setupMapSizeCol();
        setupMapDateCol();
        mainTable.setItems(dataList);
        testData();

    }

    public void testData () {
        dataList.add(new FileObservable("games", 23,340,"04.05.06"));
        dataList.add(new FileObservable("Anime", 48,440,"04.05.06"));
        dataList.add(new FileObservable("Manga", 223,1040,"04.05.06"));
    }


    private void fillTable (ArrayList<FileObservable> element) {
        element.forEach(e -> dataList.add(new FileObservable(e)));
    }

    private void setupMapNameCol () {
        mapNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        mapNameCol.setCellFactory(new PropertyValueFactory("mapName"));
        mapNameCol.setOnEditCommit( t -> {

            ((FileObservable) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setMapName(t.getNewValue());
        });
    }

    private void setupTotalFilesCol () {
        totalFilesCol.setCellFactory(TextFieldTableCell.forTableColumn(
                new StringConverter<Integer>() {
                    @Override
                    public String toString(Integer object) {
                        return object.toString();
                    }
                    @Override
                    public Integer fromString(String string) {
                        return Integer.parseInt(string);
                    }
                }
        ));
        totalFilesCol.setOnEditCommit( t -> {


            ((FileObservable) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setTotalFiles(t.getNewValue());
        });
    }

    private void setupMapSizeCol () {
        mapSizeCol.setCellFactory(TextFieldTableCell.forTableColumn(
                new StringConverter<Integer>() {
                    @Override
                    public String toString(Integer object) {
                        return object.toString();
                    }
                    @Override
                    public Integer fromString(String string) {
                        return Integer.parseInt(string);
                    }
                }
        ));
        mapSizeCol.setOnEditCommit( t -> {


            ((FileObservable) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setMapSize(t.getNewValue());
        });
    }

    private void setupMapDateCol () {
        mapDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        mapDateCol.setOnEditCommit( t -> {


            ((FileObservable) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setMapDate(t.getNewValue());
        });
    }


}
