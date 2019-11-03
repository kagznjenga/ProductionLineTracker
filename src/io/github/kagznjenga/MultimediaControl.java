package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file contains functionality that is implemented by other classes.
 * */

/**
 * Multimedia interface class with methods that are implemented by other classes.
 */
interface MultimediaControl {

  /**
   * Play function.
   */
  void play();

  /**
   * Stop function.
   */
  void stop();

  /**
   * Previous function.
   */
  void previous();

  /**
   * Next function.
   */
  void next();
}
