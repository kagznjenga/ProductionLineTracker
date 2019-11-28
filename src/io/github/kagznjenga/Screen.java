package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file contains attributes and functionality for screen objects.
 * */

/**
 * The screen class is a template for all screen objects created. It also implements the ScreenSpec
 * interface.
 */
public class Screen implements ScreenSpec {

  private final String resolution;      // Class fields.
  private final int refreshrate;        // Class fields.
  private final int responsetime;       // Class fields.

  /**
   * The class constructor that is called when the corresponding number of arguments are passed.
   *
   * @param resolution   Value for screen resolution.
   * @param refreshrate  Value for screen's refresh rate.
   * @param responsetime Value for screen's response time.
   */
  public Screen(String resolution, int refreshrate, int responsetime) {
    this.resolution = resolution;
    this.refreshrate = refreshrate;
    this.responsetime = responsetime;
  }

  /**
   * Accessor for resolution field.
   *
   * @return Returns a string value (resolution).
   */
  public String getResolution() {
    return resolution;
  }

  /**
   * Accessor for refresh rate.
   *
   * @return Returns an integer value (refreshrate)
   */
  public int getRefreshRate() {
    return refreshrate;
  }

  /**
   * Accessor for response time.
   *
   * @return Returns an integer value (responsetime).
   */
  public int getResponseTime() {
    return responsetime;
  }

  /**
   * The toString method formats the output for the values required.
   *
   * @return The method returns a String value (output).
   */
  public String toString() {
    return String
        .format("%nResolution: %s %nRefresh Rate: %s %nResponse Time: %s", resolution, refreshrate,
            responsetime);
  }
}
