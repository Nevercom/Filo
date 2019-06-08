package Filo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private ObservableList<String> movies;
    @FXML private ListView listView;
    public Controller() {

        movies = FXCollections.observableArrayList();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Collection<File> files = FileUtils.listFiles(new File(System.getProperty("user.dir")), new String[]{"mkv", "mp4", "avi"}, true);

        files.forEach(m -> {
            System.out.println(m.getName());
            movies.add(m.getName());
        });
        listView.setItems(movies);
        listView.setCellFactory(item->new ListViewCell());

    }
}
