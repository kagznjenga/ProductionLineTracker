package io.github.kagznjenga;
/*
 * @author Samuel Njenga.
 * @brief This file contains the attributes and functionality for MoviePlayer objects.
 * */

/**
 * The MoviePlayer class is a template for all visual objects and it inherits from the product class
 * which implements the MultiMediaControl interface.
 */
public class MoviePlayer extends Product implements MultimediaControl {

  private final Screen screen;
  private final MonitorType monitorType;

  /**
   * The class constructor that is called when the corresponding number of arguments are passed.
   *
   * @param name         Value for MoviePlayer's name.
   * @param manufacturer Value for MoviePlayer's manufacturer.
   * @param screen       Value for MoviePlayer's screen.
   * @param monitorType  Value for type of monitor.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * Play function.
   */
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * Stop function.
   */
  public void stop() {
    System.out.println("Stopping movie");
  }

  /**
   * Previous function.
   */
  public void previous() {
    System.out.println("Previous movie");
  }

  /**
   * Next function.
   */
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * The toString method formats the output for the values required.
   *
   * @return The method returns a String value (output).
   */
  public String toString() {
    return String.format("%s\nScreen: %s\nMonitorType: %s", super.toString(), screen, monitorType);
  }
}
