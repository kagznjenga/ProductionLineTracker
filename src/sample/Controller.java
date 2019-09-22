package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * public class controller.
 */
public class Controller {

  /**
   * Fields for class controller.
   */
  @FXML
  private Button btnClick;

  @FXML
  private ComboBox myComboBox;

  /**
   * @param event display method for button click.
   */
  @FXML
  void display(ActionEvent event) {
    String sql = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' )";
  }

}
