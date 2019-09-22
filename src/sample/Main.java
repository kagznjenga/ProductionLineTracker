package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * @author Samuel Njenga.
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
    launch(args);
  }
}
