package io.github.kagznjenga;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * @author Samuel Njenga.
 * @brief This file is the entry point for running the program (driver class) and sets the
 * stage of the user interface.
 * */

/**
 * Driver class Main that extends the Application class.
 */
public class Main extends Application {

  /**
   * The start method sets the stage for the GUI program.
   *
   * @param primaryStage The main stage where elements are contained
   * @throws Exception caught by the compiler.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProductionLine.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    Scene scene = new Scene(root, 700, 500);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    primaryStage.setScene(scene);
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
