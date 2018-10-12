package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileObservable {
    private final SimpleStringProperty mapName;
    private final SimpleIntegerProperty totalFiles;
    private final SimpleIntegerProperty mapSize;
    private final SimpleStringProperty mapDate;

    public FileObservable(FileObservable files) {
        this.mapName = new SimpleStringProperty(files.getMapName());
        this.totalFiles = new SimpleIntegerProperty(files.getTotalFiles());
        this.mapSize = new SimpleIntegerProperty(files.getMapSize());
        this.mapDate = new SimpleStringProperty(files.getMapDate());
    }
    public FileObservable(String mapName, int totalFiles, int mapSize, String mapDate) {
        this.mapName = new SimpleStringProperty(mapName);
        this.totalFiles = new SimpleIntegerProperty(totalFiles);
        this.mapSize = new SimpleIntegerProperty(mapSize);
        this.mapDate = new SimpleStringProperty(mapDate);
    }


    public String getMapName() {
        return mapName.get();
    }

    public void setMapName(String newName) {
        this.mapName.set(newName);
    }

    public int getTotalFiles() {
        return totalFiles.get();
    }

    public void setTotalFiles(int totalFiles) {
        this.totalFiles.set(totalFiles);
    }

    public int getMapSize() {
        return mapSize.get();
    }


    public void setMapSize(int mapSize) {
        this.mapSize.set(mapSize);
    }

    public String getMapDate() {
        return mapDate.get();
    }


    public void setMapDate(String mapDate) {
        this.mapDate.set(mapDate);
    }

}
