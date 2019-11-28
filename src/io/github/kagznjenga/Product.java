package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file contains the attributes and functionality for all product objects created.
 * */

/**
 * The product class is a an abstract superclass that implements an interface named Item.
 */
public abstract class Product implements Item {

  private int id;                 // Class attribute.
  private ItemType type;          //      *
  private String manufacturer;    //      *
  private String name;            //      *

  /**
   * product class constructor that accepts three arguments.
   *
   * @param name         Pass a string value for product name.
   * @param manufacturer Pass a string value for manufacturer's name.
   * @param type         Pass an ItemType value for type of product.
   */
  Product(String name, String manufacturer, ItemType type) {
    this.name = name;                   // Assigns values to the class fields.
    this.manufacturer = manufacturer;   //                 *
    this.type = type;                   //                 *
  }

  /**
   * Public setter for Id.
   *
   * @param id Pass an integer value for Id.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * public setter for type of item.
   *
   * @param type Pass an ItemType value for type of item.
   */
  public void setType(ItemType type) {
    this.type = type;
  }

  /**
   * public setter for product name.
   *
   * @param name A string value is passed as an argument
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * public setter for manufacturer's name.
   *
   * @param manufacturer A string value is passed as an argument.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * public getter for accessing field id.
   *
   * @return return an integer value.
   */
  public int getId() {
    return id;
  }

  /**
   * public getter for accessing field type.
   *
   * @return return ItemType object.
   */
  public ItemType getType() {
    return type;
  }

  /**
   * public getter for accessing field name.
   *
   * @return return a string value.
   */
  public String getName() {
    return name;
  }

  /**
   * public getter for accessing field manufacturer.
   *
   * @return return a string value.
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * public toString method for formatting output.
   *
   * @return return a string value.
   */
  public String toString() {
    return String.format("Name: %s %nManufacturer: %s %nType: %s", name, manufacturer, type);
  }
}

