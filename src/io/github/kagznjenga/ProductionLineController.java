package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file gives functionality to the the fxml elements and sets up connection to the
 * database.
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * public class controller.
 */
public class ProductionLineController {

  /**
   * Sets up the connection to the database.
   */
  public void setConn() {
    try {
      String jdbcDriver = "org.h2.Driver";
      Class.forName(jdbcDriver);
      String dbUrl = "jdbc:h2:./res/ProductDatabase";
      String user = "";
      String pass = "";
      Connection conn = DriverManager.getConnection(dbUrl, user, pass);
      Statement stmt = conn.createStatement();
      System.out.println("Database Connection Established.");

      stmt.close();
      conn.close();


    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();

    }
  }

  /**
   * private class fields.
   */
  @FXML
  private Button addProduct;
  @FXML
  private Button recordProduction;
  @FXML
  private ListView productListView;
  @FXML
  private TextArea prodLogTextArea;
  @FXML
  private ComboBox<Integer> myCmbBox;
  @FXML
  private ChoiceBox<String> myChoiceBox;
  @FXML
  private TableView<Product> prodTableView;
  @FXML
  private TableColumn<?, ?> prodName;
  @FXML
  private TableColumn<?, ?> prodMan;
  @FXML
  private TableColumn<?, ?> prodType;

  private ObservableList<Product> productLine;

  @FXML
  public void addProductToList(MouseEvent event) throws Exception {
    productLine.add(new Widget("Galaxy", "Samsung", ItemType.AUDIO));
    productListView.getItems().add(productLine);
  }

  /**
   * The recordProduction method prints out details of the products created in the production log
   * text area.
   *
   * @param event A mouse event
   */
  @FXML
  public void recordProduction(MouseEvent event) {
    int itemCount = 1;
    int numProduced = myCmbBox.getValue();  // this will come from the combobox in the UI
    for (int productionRunProduct = 1; productionRunProduct <= numProduced;
        productionRunProduct++) {
      RecordProduction prodRecord = new RecordProduction(itemCount++);
      // using the iterator as the product id for testing
      prodLogTextArea.appendText(prodRecord.toString() + "\n");
    }
  }

  /**
   * initialize method that populates the combobox, choice box and sets up the Observable
   * arraylist.
   */
  @FXML
  public void initialize() {
    for (ItemType item : ItemType.values()) {
      myChoiceBox.getItems().add(item + "'" + item.code + "'");
    }
    myCmbBox.setEditable(true);
    for (int i = 1; i <= 10; i++) {
      myCmbBox.getItems().add(i);
    }
    myCmbBox.getSelectionModel().selectFirst();

    productLine = FXCollections.observableArrayList();
    prodName.setCellValueFactory(new PropertyValueFactory("name"));
    prodMan.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    prodType.setCellValueFactory(new PropertyValueFactory("type"));
    prodTableView.setItems(productLine);

  }

}
