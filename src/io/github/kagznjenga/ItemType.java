package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file contains a list of constants that set the type of media product.
 * */

/**
 * An enumerator class with constant variables(elements).
 */
public enum ItemType {
  AUDIO("AU"),          // Constant element
  VISUAL("VI"),         //         *
  AUDIO_MOBILE("AM"),   //         *
  VISUAL_MOBILE("VM");  //         *

  private final String code;     // Class field.

  /**
   * Sets the code field to a string value from the elements.
   *
   * @param code Element's string arguments passed into parameter.
   */
  ItemType(String code) {
    this.code = code;
  }

  /**
   * Method for accessing code value.
   *
   * @return Returns a string value.
   */
  public String getCode() {
    return code;
  }
}
