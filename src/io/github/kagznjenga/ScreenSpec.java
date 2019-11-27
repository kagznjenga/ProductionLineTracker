package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file contains functionality that is implemented by the screen class.
 * */

/**
 * Interface for screen specification that is implemented by the screen class.
 */
public interface ScreenSpec {

  /**
   * Accessor for resolution value.
   *
   * @return Returns a string value for resolution.
   */
  String getResolution();

  /**
   * Accessor for refresh rate value.
   *
   * @return Returns an integer value for the refresh rate.
   */
  int getRefreshRate();

  /**
   * Accessor for response time value.
   *
   * @return Returns an integer value for the response time.
   */
  int getResponseTime();
}
