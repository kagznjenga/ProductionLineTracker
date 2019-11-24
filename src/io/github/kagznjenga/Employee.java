package io.github.kagznjenga;

/*
 * @author Samuel Njenga.
 * @brief This file contains details about the employee and procedures for each employee object.
 */

import java.util.regex.Pattern;

/**
 * Class employee contains attributes and methods for employee objects.
 */
public class Employee {

  /**
   * private class fields.
   */
  private StringBuilder name;
  private String username;
  private String password;
  private String email;

  /**
   * Employee class constructor with two parameters.
   * @param name receives a string value as an argument.
   * @param password receives a string value as an argument.
   */
  Employee(String name, String password) {
    StringBuilder sBName = new StringBuilder(name);
    StringBuilder defaultUsername = new StringBuilder("default");
    StringBuilder defaultEmail = new StringBuilder("user");
    this.name = sBName;
    this.password = password;
    if (checkName(sBName)) {
      setUsername(sBName);
      setEmail(sBName);
    } else {
      setUsername(defaultUsername);
      setEmail(defaultEmail);
    }
    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * CheckName method  splits the string value parameter.
   * @param name receives a string builder value as an argument.
   * @return returns a boolean value.
   */
  private boolean checkName(StringBuilder name) {
    String[] splitArray = name.toString().split(" ");
    return splitArray.length != 1;
  }

  /**
   * Setusername method has one parameter and sets the username.
   * @param name receives a string builder value as an argument.
   */
  private void setUsername(StringBuilder name) {
    String[] splitArray = name.toString().split(" ");
    if (splitArray.length > 1) {
      this.username = (splitArray[0].substring(0, 1) + splitArray[1]).toLowerCase();
    } else {
      this.username = (splitArray[0]).toLowerCase();
    }
  }

  /**
   * The setEmail method has one parameter and sets the email.
   * @param name receives a string builder value as an argument.
   */
  private void setEmail(StringBuilder name) {
    String[] splitArray = name.toString().split(" ");
    if (splitArray.length > 1) {
      this.email = (splitArray[0] + "." + splitArray[1]).toLowerCase() + "@oracleacademy.Test";
    } else {
      this.email = (splitArray[0]).toLowerCase() + "@oracleacademy.Test";
    }
  }

  /**
   * isValidPassword method has one parameter and checks if password entered is valid.
   * @param password receives a string value as an argument.
   * @return returns a boolean value.
   */
  private boolean isValidPassword(String password) {
    final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$";
    // final Matcher matcher = pattern.matcher(password);
    return Pattern.matches(regex, password);
  }

  /**
   * getName method of string builder type.
   * @return returns a string builder value.
   */
  public StringBuilder getName() {
    return name;
  }

  /**
   * getPassword method of String type.
   * @return returns a string value.
   */
  public String getPassword() {
    return password;
  }

  /**
   * getUsername method of string type.
   * @return returns a string value.
   */
  public String getUsername() {
    return username;
  }

  /**
   * getEmail method of string type.
   * @return returns a string value.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Class toString method outputs the data as set in the string formatter.
   * @return returns a string value.
   */
  public String toString() {
    return String.format(
        "Employee Details" + "\nName : " + name + "\nUsername : " + username + "\nEmail : " + email
            + "\nInitial Password : " + password);
  }
}
