package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file gives functionality to the the fxml elements and sets up connection to the
 * database.
 * */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * public class controller that controls functionality for fxml elements.
 */
@SuppressWarnings("unchecked")
public class ProductionLineController {


  /**
   * private class fields.
   */
  @FXML
  public Button addProduct;
  @FXML
  public Button recordProduction;
  @FXML
  public Button empAccount;
  @FXML
  public Label threeLetterName;
  @FXML
  private TextField employeeName;
  @FXML
  private PasswordField employeePassword;
  @FXML
  private TextArea employeeTextArea;
  @FXML
  private TextField nameValue;
  @FXML
  private TextField manValue;
  @FXML
  private ListView productListView;
  @FXML
  private TextArea prodLogTextArea;
  @FXML
  private ComboBox<Integer> myCmbBox;
  @FXML
  private ChoiceBox<ItemType> myChoiceBox;
  @FXML
  private TableView<Product> prodTableView;
  @FXML
  private TableColumn<?, ?> prodName;
  @FXML
  private TableColumn<?, ?> prodMan;
  @FXML
  private TableColumn<?, ?> prodType;

  private Connection conn;
  private Statement stmt;
  private ObservableList<Product> productLine;
  private ArrayList<RecordProduction> prodRecordArray;
  private Employee employeeDetails;


  /**
   * Sets up the connection to the database.
   */
  private void setConn() {
    try {
      String jdbcDriver = "org.h2.Driver";
      Class.forName(jdbcDriver);
      String dbUrl = "jdbc:h2:./res/ProductDatabase";
      String user = "";
      String pass = "";
      try {
        Properties prop = new Properties();
        prop.load(new FileInputStream("res/properties"));
        pass = prop.getProperty("password");
      } catch (Exception e) {
        System.out.println("Database password error.");
      }
      conn = DriverManager.getConnection(dbUrl, user, pass);
      stmt = conn.createStatement();
      System.out.println("Database Connection Established.");

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * The initialize method populates the combobox, choice box and calls other functions.
   */
  @FXML
  public void initialize() throws SQLException {
    for (ItemType item : ItemType.values()) {
      myChoiceBox.getItems().add(item);
    }
    myCmbBox.setEditable(true);
    for (int i = 1; i <= 10; i++) {
      myCmbBox.getItems().add(i);
    }
    myCmbBox.getSelectionModel().selectFirst();

    setConn();
    setupProductLineTable();
    loadProductList();
    loadProductionLog();
    showProduction();
  }

  /**
   * addProduct method adds a new product into the product database table.
   *
   * @throws SQLException Checks if sql statement is valid
   */
  @FXML
  public void addProductToDB() throws SQLException {
    String name = nameValue.getText();
    String manufacturer = manValue.getText();
    ItemType type = myChoiceBox.getValue();

    if (!name.trim().isEmpty() && !manufacturer.trim().isEmpty() && !String
        .valueOf(type).equals("null")) {
      if (manufacturer.length() >= 3) {
        threeLetterName.setText("");
        String productQuery = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES (?,?,?)";
        PreparedStatement addProdToDb = conn
            .prepareStatement(productQuery, Statement.RETURN_GENERATED_KEYS);
        addProdToDb.setString(1, name);
        addProdToDb.setString(2, String.valueOf(type));
        addProdToDb.setString(3, manufacturer);
        addProdToDb.executeUpdate();
        nameValue.clear();
        manValue.clear();
        myChoiceBox.getSelectionModel().clearSelection();
        productLine.clear();
        loadProductList();
        addProdToDb.close();
      } else {
        threeLetterName.setText("Name must be more than 3 letters");
      }
    } else {
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame.getContentPane(),
          "Name, Manufacturer and Item Type cannot be empty. Please enter/select values",
          "Empty fields",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * The loadProductList method gets product items from the database and adds them to the
   * productline observable list.
   *
   * @throws SQLException Checks if the sql statement is valid.
   */
  private void loadProductList() throws SQLException {
    String sql = "SELECT * FROM PRODUCT";
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
      // these lines correspond to the database table columns
      String nameFromDb = rs.getString(2);
      ItemType typeFromDb = ItemType.valueOf(rs.getString(3));
      //emType convertStringToType = typeFromDb.getClass().getGenericSuperclass();
      String manFromDb = rs.getString(4);
      // create object
      Product productFromDB = new Widget(nameFromDb, manFromDb, typeFromDb);
      // save to observable list
      productLine.add(productFromDB);
      productListView.getItems().clear();
      for (Product products : productLine) {
        productListView.getItems().add(products);
      }
    }
    rs.close();
  }

  /**
   * The setupProductLineTable method sets up the table view.
   */
  private void setupProductLineTable() {
    productLine = FXCollections.observableArrayList();
    prodName.setCellValueFactory(new PropertyValueFactory("name"));
    prodMan.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    prodType.setCellValueFactory(new PropertyValueFactory("type"));
    prodTableView.setItems(productLine);
  }

  /**
   * The addToProdcutionDB adds record details into the production record table.
   *
   * @param productionArray receives an array list that carries record production type objects.
   * @throws SQLException Checks if the sql statement is valid.
   */
  private void addToProductionDB(ArrayList<RecordProduction> productionArray) throws SQLException {
    String productQuery = "INSERT INTO "
        + "PRODUCTIONRECORD(product_name, serial_num, date_produced, username) VALUES (?,?,?,?)";
    PreparedStatement addRecordToDb = conn
        .prepareStatement(productQuery, Statement.RETURN_GENERATED_KEYS);
    for (RecordProduction production : productionArray) {
      addRecordToDb.setString(1, production.getName());
      addRecordToDb.setString(2, production.getSerialNum());
      addRecordToDb.setTimestamp(3, new Timestamp(production.getProdDate().getTime()));
      addRecordToDb.setString(4, employeeDetails.getUsername());
      addRecordToDb.executeUpdate();
    }
    addRecordToDb.close();
  }

  /**
   * The recordProduction method adds record production objects created to an array list of same
   * data type.
   */
  @FXML
  public void recordProduction() throws SQLException {
    Product selectFromList = (Product) productListView.getSelectionModel().getSelectedItem();
    String quantity = String.valueOf(myCmbBox.getValue());
    int numProduced = Integer.parseInt(quantity);  // this will come from the combobox in the UI
    ArrayList<RecordProduction> myProductRecords = new ArrayList();
    for (int productionRunProduct = 0; productionRunProduct < numProduced;
        productionRunProduct++) {
      RecordProduction prodRecord = new RecordProduction(selectFromList, productionRunProduct);
      myProductRecords.add(prodRecord);
    }
    try {
      if (employeeDetails.getUsername().isEmpty() && employeeDetails.getPassword()
          .isEmpty()) {
        throw new NullPointerException();
      } else {
        addToProductionDB(myProductRecords);
        loadProductionLog();
        showProduction();
      }
    } catch (NullPointerException e) {
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(frame.getContentPane(),
          "Employee account not detected. Please enter information in employee tab to "
              + "record production.",
          "Account needed",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * loadProductionLog method stores record production objects from the database into a record
   * production array.
   *
   * @throws SQLException Checks if the sql statement is valid.
   */
  private void loadProductionLog() throws SQLException {
    prodRecordArray = new ArrayList<>();
    String sql = "SELECT * FROM PRODUCTIONRECORD";
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
      // corresponds to database table columns
      int productNumDB = rs.getInt(1);
      String prodNameDB = rs.getString(2);
      String serialNumDB = rs.getString(3);
      Date dateProducedDB = new Date(rs.getTimestamp(4).getTime());
      // create object
      RecordProduction prodLogFromDB = new RecordProduction(productNumDB, prodNameDB, serialNumDB,
          dateProducedDB);
      // save to observable list
      prodRecordArray.add(prodLogFromDB);
    }
    rs.close();
  }

  /**
   * showProduction method outputs record production items from the database to the production log
   * text area.
   */
  private void showProduction() {
    prodLogTextArea.clear();
    for (RecordProduction production : prodRecordArray) {
      prodLogTextArea.setWrapText(true);
      prodLogTextArea
          .appendText(production.toString() + "\n");
    }
  }

  /**
   * employeeAccount method adds employee objects created into the employee table in the database.
   *
   * @throws SQLException Checks if the sql statement used is valid.
   */
  private void employeeAccount() throws SQLException {
    String employeeFullName = employeeName.getText();
    String employeePass = employeePassword.getText();
    employeeDetails = new Employee(employeeFullName, employeePass);

    String productQuery = "INSERT INTO EMPLOYEE(NAME, PASSWORD, USERNAME, EMAIL) VALUES (?,?,?,?)";
    PreparedStatement addEmployee = conn
        .prepareStatement(productQuery, Statement.RETURN_GENERATED_KEYS);
    addEmployee.setString(1, employeeFullName);
    addEmployee.setString(2, employeePass);
    addEmployee.setString(3, employeeDetails.getUsername());
    addEmployee.setString(4, employeeDetails.getEmail());
    addEmployee.executeUpdate();

    employeeName.clear();
    employeePassword.clear();
    employeeTextArea.appendText(employeeDetails.toString() + "\n\n");
    addEmployee.close();
  }

  /**
   * createAccount method executes employeeAccount method when the create account button is
   * clicked.
   *
   * @param event receives a mouse event value as an argument.
   * @throws SQLException Checks if the sql statement int the called method is valid.
   */
  public void createAccount(MouseEvent event) throws SQLException {
    employeeAccount();
  }
}
