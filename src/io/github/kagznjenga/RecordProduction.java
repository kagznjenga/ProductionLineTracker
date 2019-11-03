package io.github.kagznjenga;

import java.util.Date;

/*
 * @author Samuel Njenga.
 * @brief This file contains attributes and functionality for keeping a record of products created.
 * */

/**
 * The RecordProduction class contains data and functionality for keeping track of production.
 */
class RecordProduction {

  private int productionNumber;      // Class attributes.
  private int productID;             //       *
  private String serialNumber;       //       *
  private Date dateProduced;         //       *

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
  public RecordProduction(Product product, int itemCount) {
    String idNumber = String.format("%05d", itemCount);
    serialNumber =
        product.getManufacturer().substring(0, 3) + product.getType().getCode() + idNumber;
    dateProduced = new Date();
  }

  /**
   * A class constructor that has four parameters.
   *
   * @param productionNumber pass an integer value as an argument.
   * @param productID        Pass an integer value as an argument.
   * @param serialNumber     pass a string as an argument
   * @param dateProduced     pass a date type argument.
   */
  public RecordProduction(int productionNumber, int productID, String serialNumber,
      Date dateProduced) {
    this.productID = productID;
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
   * public setter for setting the date value.
   *
   * @param dateProduced pass a date as an argument.
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
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
   * public getter for accessing the serialNumber.
   *
   * @return return a string value.
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * public getter for accessing the date.
   *
   * @return return a date value.
   */
  public Date getProdDate() {
    return dateProduced;
  }

  /**
   * Formats the output for the corresponding values to be printed.
   *
   * @return return a string value.
   */
  public String toString() {
    return String
        .format("Prod. Num: %d Product ID: %d Serial Num: %s Date: %s", productionNumber, productID,
            serialNumber, dateProduced);
  }
}
