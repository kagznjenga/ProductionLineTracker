package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 *  * @author Samuel Njenga.
 * @brief This program maintains a database containing information on products and allows
 * various operations to be performed on the data stored.
 * */

public class Main extends Application {

    /**
     * The start method sets the stage for the GUI program.
     *
     * @param primaryStage The main stage where elements are contained
     * @throws Exception caught by the compiler.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Production Line Tracker");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();

    }

    /**
     * Main method where program execution begins.
     *
     * @param args contains supplied command-line arguments as an array.
     */
    public static void main(String[] args) {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/ProductDatabase";


        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        /**
         * try block for checking connection
         */
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Database Connection Established.");

            stmt.close();
            conn.close();

            /**
             * catch block for exception
             */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            /**
             * catch block for exception
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }

        launch(args);
    }
}
