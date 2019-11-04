package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file contains the attributes and functionality for each audioplayer object.
 * */

/**
 * The AudioPlayer class is a template for all audio objects and it inherits from the product class
 * which implements the MultiMediaControl interface.
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private final String audioSpecification;      // Class attribute.
  private final String mediaType;               // Class attribute.

  /**
   * The class constructor that is called when the corresponding number of arguments are passed.
   *
   * @param name               AudioPlayer name.
   * @param manufacturer       AudioPlayer manufacturer's name.
   * @param audioSpecification Supported audio formats.
   * @param mediaType          Type of media.
   */
  public AudioPlayer(String name, String manufacturer, String audioSpecification,
      String mediaType) {
    super(name, manufacturer, ItemType.AUDIO);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * Play function.
   */
  public void play() {
    System.out.println("Playing");
  }

  /**
   * Stop function.
   */
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * Previous function.
   */
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * Next function.
   */
  public void next() {
    System.out.println("Next");
  }

  /**
   * The toString method formats the output for the values required.
   *
   * @return The method returns a String value(output).
   */
  public String toString() {
    return String
        .format("%s\nSupported Audio Formats: %s\nSupported Playlist Formats: %s", super.toString(),
            audioSpecification, mediaType);
  }
}
