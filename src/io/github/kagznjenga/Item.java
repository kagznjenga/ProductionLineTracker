package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file carries functionality for item details.
 * */

/**
 * Item interface whose methods are implemented by other classes.
 */
public interface Item {

  /**
   * Method for accessing ID value.
   *
   * @return Returns an integer value.
   */
  int getId();

  /**
   * Method for accessing name.
   *
   * @return Returns an String value.
   */
  String getName();

  /**
   * Method for accessing manufacturer.
   *
   * @return Returns an String value.
   */
  String getManufacturer();

  /**
   * Method for setting name.
   *
   * @param name A string value is passed as an argument
   */
  void setName(String name);

  /**
   * Method for setting manufacturer.
   *
   * @param manufacturer A string value is passed as an argument.
   */
  void setManufacturer(String manufacturer);
}
