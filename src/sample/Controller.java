package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * public class controller.
 */
public class Controller {

    /**
     * private class fields
     */
    @FXML
    private Button btn_AddProduct;

    @FXML
    private ComboBox<Integer> myCmbBox;

    @FXML
    private Button btn_recordProduction;

    @FXML
    void chooseQuality(MouseEvent event) {

    }

    /**
     * @param event Executes an action when a mouse event takes place
     */
    @FXML
    void display(MouseEvent event) {
        System.out.println("Add Product Clicked");
    }

    /**
     * @param event A mouse event
     */
    @FXML
    void recordProduction(MouseEvent event) {
        System.out.println("Record Production Clicked.");
    }

    /**
     * combobox initializer
     */
    @FXML
    public void initialize() {
        myCmbBox.setEditable(true);
        myCmbBox.getItems().add(1);
        myCmbBox.getItems().add(2);
        myCmbBox.getItems().add(3);
        myCmbBox.getItems().add(4);
        myCmbBox.getItems().add(5);
        myCmbBox.getItems().add(6);
        myCmbBox.getItems().add(7);
        myCmbBox.getItems().add(8);
        myCmbBox.getItems().add(9);
        myCmbBox.getItems().add(10);
        myCmbBox.getSelectionModel().selectFirst();
    }

}
