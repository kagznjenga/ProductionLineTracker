package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * public class controller.
 */
public class Controller {
    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:./res/ProductDatabase";

    private final String USER = "";
    private final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;

    /**
     *@exception ClassNotFoundException if connection is not established.
     */
    public void setConn() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Database Connection Established.");

            stmt.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * private class fields
     */
    @FXML
    private Button btn_AddProduct;

    @FXML
    private ComboBox<Integer> myCmbBox;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private Button btn_recordProduction;

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
        for(int i = 1; i <= 10; i++){
            myCmbBox.getItems().add(i);
        }
        myCmbBox.getSelectionModel().selectFirst();
        for(ItemType item : ItemType.values()){
            myChoiceBox.getItems().add(item + "'" + item.code + "'");
        }
    }

}
