package io.github.kagznjenga;

import java.util.Date;

/*
 * @author Samuel Njenga.
 * @brief This file contains attributes and functionality for keeping a record of products created.
 * */

/**
 * The RecordProduction class contains data and functionality for keeping track of production.
 */
public class RecordProduction {

  private int productionNumber;      // Class attributes.
  private int productID;             //       *
  private String prodName;
  private String serialNumber;       //       *
  private final Date dateProduced;         //       *

  /**
   * A class constructor that accepts one argument.
   *
   * @param productID Pass an integer value as the argument.
   */
  public RecordProduction(int productID) {
    this.productID = productID;     // Assign value to corresponding class field.
    this.productionNumber = 0;      //                  *
    this.serialNumber = "0";        //                  *
    this.dateProduced = new Date(); //                  *
  }

  /**
   * A class constructor that accepts two arguments.
   *
   * @param product   pass a Product object as an argument.
   * @param itemCount pass an integer value as an argument.
   */
  RecordProduction(Product product, int itemCount) {
    String idNumber = String.format("%05d", itemCount);
    productID = Integer.parseInt(idNumber);
    productionNumber = itemCount;
    serialNumber =
        product.getManufacturer().substring(0, 3) + product.getType().getCode() + idNumber;
    dateProduced = new Date();
    this.prodName = product.getName();
  }

  /**
   * A class constructor that has four parameters.
   *
   * @param productionNumber pass an integer value as an argument.
   * @param prodName         Pass a string value as an argument.
   * @param serialNumber     pass a string as an argument
   * @param dateProduced     pass a date type argument.
   */
  RecordProduction(int productionNumber, String prodName, String serialNumber,
      Date dateProduced) {
    this.prodName = prodName;
    this.productionNumber = productionNumber;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /**
   * public setter for setting the productionNumber value.
   *
   * @param productionNumber pass an integer as an argument.
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * public setter for setting the productID value.
   *
   * @param productID pass an integer as an argument.
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * public setter for setting the serialNumber value.
   *
   * @param serialNumber pass a string as an argument.
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * public getter for accessing the productionNumber.
   *
   * @return return an integer value.
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * public getter for accessing the productId.
   *
   * @return return an integer value.
   */
  public int getProductID() {
    return productID;
  }

  /**
   * public getter for getting name.
   *
   * @return returns a string value.
   */
  public String getName() {
    return prodName;
  }

  /**
   * public getter for accessing the serialNumber.
   *
   * @return return a string value.
   */
  String getSerialNum() {
    return serialNumber;
  }

  /**
   * public getter for accessing the date.
   *
   * @return return a date value.
   */
  Date getProdDate() {
    return dateProduced;
  }

  /**
   * Formats the output for the corresponding values to be printed.
   *
   * @return return a string value.
   */
  public String toString() {
    return String
        .format("Prod. Num: %s Product Name: %s Serial Num: %s Date: %s", productionNumber,
            prodName,
            serialNumber, dateProduced);
  }
}
