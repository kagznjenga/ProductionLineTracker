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
import java.util.ArrayList;


/*
 *  * @author Samuel Njenga.
 * @brief This program maintains a database containing information on products and allows
 * various operations to be performed on the data stored.
 * */

public class Main extends Application {
//this is a side branch

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
        AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
                "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
        Screen newScreen = new Screen("720x480", 40, 22);
        MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
                MonitorType.LCD);
        ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
        productList.add(newAudioProduct);
        productList.add(newMovieProduct);
        for (MultimediaControl p : productList) {
            System.out.println(p);
            p.play();
            p.stop();
            p.next();
            p.previous();
        }

        launch(args);
    }
}
