package Filo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ListViewCell extends ListCell<String> {
    private FXMLLoader mLoader;
    @FXML
    private Label lblName;
    @FXML
    private HBox root;

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || item.isEmpty()) {
            setText(null);
            setGraphic(null);
            return;
        }
        if (mLoader == null) {
            mLoader = new FXMLLoader(getClass().getResource("/fxml/row_movie.fxml"));
            mLoader.setController(this);
            try {
                mLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        lblName.setText(item);
        setGraphic(root);

    }
}
