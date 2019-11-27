# ProductionLineTracker
**

## Problem Statement

**

**Scenario**

You have been hired to create software for a media player production facility that will keep track of what products are produced.

Without the software, workers on the production floor are physically producing items and having to write down what is produced in a production log book.

Management would like the production tracking to be more automated so the workers don't need to spend as much time recording what was produced, the log will be more accurate, and it will be easier to generate production reports.

In addition to the ability to record production, the software also needs the ability to add to the product line (the catalog of products that are able to be produced).

-   **Goals** (high level intended outcomes; for software, a Product Backlog)
    -   Hypothetical / Real world
        1.  Allow a user to add new products that are able to be produced and store them in a collection.
        2.  The collection of products that can be produced can be displayed at any time.
        3.  Allow a user to track production of products, including specifying how many items of that product were created. The program will then create a record for each of these items and store them in a collection.
        4.  The collection of created items can be displayed at any time.
        5.  Production statistics can be displayed – Total items produced, number of each item type, the number of unique products created etc.
        6.  Employee accounts can be made.
        7.  Allow easy modification to handle different products.
    -   Actual / For class
        1.  Solidify understanding of object oriented programming.
        2.  Practice Java.
        3.  Learn basic graphical user interface (GUI) programming.
        4.  Learn basic database programming.
-   **Boundaries / Scope** (where the functions and responsibilities of the solution start and end / what it should do and what is left to other systems to do)
    -   Hypothetical / Real world
        -   For this particular production facility you will only need to track music and movie players.
        -   The program does not need the ability to place or fulfill orders / reduce stock, just track production.
    -   Actual / For class
        -   TBD
-   **Success criteria** (set of conditions to be satisfied at completion; must be measurable and verifiable, like a test)
    -   Hypothetical / Real world
        -   Pass tests (in repl.it)
        -   Follow rules for documentation, style, and coding conventions
    -   Actual / For class
        -   Grading forms / rubrics (in Canvas)
            -   Documentation (see below)
            -   Style (see below)
            -   Quality (see below)
            -   Assignment Specifications - include full project in your repository so your program can be easily imported and run.
        -   Creation of artifact for portfolio
-   **Constraints** (externally imposed limitations on system requirements, design, or implementation or on the process used to develop or modify a system)
    -   Hypothetical / Real world
        -   The program will be a GUI database program written in Java.
        -   The program must be flexible to allow for future expansion.
        -   Code should be saved to a private GitHub repository.
        -   Follow best practices for style, documentation, and quality.
    -   Actual / For class
        -   Communication and collaboration with classmates is allowed but should not extend to sharing actual code.
-   **Assumptions** (things that are accepted as true or as certain to happen, without proof)
    -   You like to program.
    -   You have foundational knowledge of programming from prerequisite courses.
    -   You will spend at least 4 hours per week on the project.
    -   The project should not require more than 7 hours per week. If so, contact the professor for assistance.
    -   This will help you be successful in future classes and your career.
-   **Stakeholders** (individuals or organizations having a right, share, claim, or interest in a system or in its possession of characteristics that meet their needs and expectations )
    -   Hypothetical / Real world
        -   CEO
        -   CTO
        -   CIO
        -   users
            -   production facility workers
            -   inventory managers
        -   customers
        -   I.T. support
    -   Actual / For class
        -   Yourself
        -   Future potential employers
        -   Professor
-   **Timelines** (a breakdown of the Product Backlog into time-bound smaller, more detailed tasks in Sprint Backlogs)
    -   Three 5-week sprints, detailed below.

## 

Sprint 1

_GUI, basic database_

**Week 1**

-   Create JavaFX project [IntelliJ Help](https://www.google.com/url?q=https%3A%2F%2Fwww.jetbrains.com%2Fhelp%2Fidea%2Fpreparing-for-javafx-application-development.html&sa=D&sntz=1&usg=AFQjCNGfhsMWgBGucMqbhHbov50HxK9IPA)
-   Share to private repository on GitHub
-   Create README, use [https://stackedit.io/](https://www.google.com/url?q=https%3A%2F%2Fstackedit.io%2F&sa=D&sntz=1&usg=AFQjCNHcaAbmEE6xgZ64etrya5GzDSOF4w), review markdown

**Week 2**

-   Add a tab view with three tabs: Product Line, Record Production, and Production Log
-   Quality expectations, Inspect code, FindBugs
-   Style expectations, Google Style, Formatter, CheckStyle
-   Javadoc and other documentation expectations

**Week 3**

-   Add a button to each tab
    -   For now, just have the button print to the console (System.out.println)

**Week 4**

-   Install database software if necessary
-   Create database
    -   Similar to...

```
create table Product
```

```
(
```

```
  id int auto_increment,
```

```
  name varchar,
```

```
  type varchar,
```

```
  manufacturer varchar
```

```
);
```

  

```
create unique index Product_id_uindex
```

```
  on Product (id);
```

  

```
alter table Product
```

```
  add constraint Product_pk
```

```
    primary key (id);
```

  

```
create table ProductionRecord
```

```
(
```

```
 production_num int auto_increment,
```

```
 product_id int,
```

```
 serial_num varchar,
```

```
 date_produced datetime
```

```
);
```

-   Connect to database SELECT

**Week 5**

-   Other database operations
-   Prepare for submission

## 

Sprint 2

**Week 6 Enum, Interface, Abstract Class**

**Issue 1 - Product**

All items will have a pre-set type. Currently there are 4 types. Create an enum called ItemType that will

store the following information.

_Type_

Audio

Visual

AudioMobile

VisualMobile

_Code_

AU

VI

AM

VM

Create a ComboBox to allow the user to select a type.

Create an interface called Item that will force all classes to implement the following functions.

-   A method getId that would return an int
-   A method setName that would have one String parameter
-   A method getName that would return a String
-   A method setManufacturer that would have one String parameter
-   A method getManufacturer that would return a String

Create an abstract type called Product that will implement the Item interface. Product will implement the basic functionality that all items on a production line should have. Add the following fields to Product

-   int id
-   String type
-   String manufacturer
-   String name

Complete the methods from the interface Item.

Add a constructor that will take in the name of the product and set this to the field variable name.

Add a toString method that will return the following: (example data shown).

```
Name: iPod
```

```
Manufacturer: Apple
```

```
Type: AM
```

Create a database table for Product.

To test the Product class, temporarily create a Widget class that extends Product. Store a created Widget object to the database and a productLine collection.

**Week 7 Inheritance**

**Issue 2 - AudioPlayer**

All of the items on this production line will have basic media controls. Create an interface called MultimediaControl that will define the following methods which don't need to return anything.

-   play()
-   stop()
-   previous()
-   next();

We require a concrete class that will allow us to capture the details of an audio player. Create a class called AudioPlayer that is a subclass of Product and implements the MultimediaControl interface.

The class will have 2 fields

-   String audioSpecification
-   String mediaType

Create a constructor that will take in 3 parameters – name, manufacturer, and audioSpecification.

The constructor should call its parents constructor and also setup the media type.

Implement the methods from the MultimediaControl interface by simply writing the action to the console.

E.g. in play `System.out.println("Playing");` Normally we would have code that would instruct the media player to play, but we will simply display a message.

Create a toString method that will display the superclass's toString method, but also add rows for Audio Spec and Type.

Create a driver class for AudioPlayer that will test to see whether we can instantiate occurrences of it, use the media controls and print out their details to the console.

**Week 8 Polymorphism**

**Issue 3 - Production**

Allow the user to record production of a given product. Create a Production class and table. The user should be able to input a quantity. Create a production record for each produced item. Set manufacturedOn as the current date and time. Store each record in a productionRun collection. Store the contents of the collection to a Production table in the database. Display the contents of the Production table in a TextView.

**Week 9 Polymorphism**

**Issue 4 - MoviePlayer**

The production facility will also create portable movie players. The main difference between these and the audio players is that they contain screens. Create an enum called MonitorType that will store

Type

LCD

LED

Create an interface called ScreenSpec. This will define 3 methods:

-   public String getResolution();
-   public int getRefreshRate();
-   public int getResponseTime();

Create a class called Screen that implements ScreenSpec. Add three fields

-   String resolution
-   int refresh rate
-   int response time

Complete the methods from the ScreenSpec interface.

Add a toString method that will return the details of the 3 field in the same format as the Product Class.

Create a Driver class for Screen that tests the functionality of the screen class.

Create a class called MoviePlayer that extends Product and implements MultimediaControl.

Add 2 fields to this class called screen and monitor type and assign appropriate types to them.

Complete the methods from the MultimediaControl interface in a similar fashion to the audio player.

Create a toString method that calls the product toString, displays the monitor and the screen details.

Create a diver class to test the functionality of the movie player.

**Week 10 Encapsulation**

**Issue 5 - MultimediaControl**

The audio players and the movie players share the same control interface on the physical devices. The control interface does not care if the device is a video player or an audio player. Create a driver class that will demonstrate that any class that implements the MultimediaControl Interface would be able to be instantiated and use its methods used no matter if it was an audio or movie player.

## 

Sprint 3

**Week 11 Lists and ArrayLists**

**Issue 6 - Sorting and Searching**

Add functionality to your classes that would allow them to be sorted by name with the Collections.sort method.

Add functionality to your user interface to show production based on factors like product type, manufacturer, name, etc.

**Week 12 Lambda Expressions**

**Issue 7 - EmployeeInfo**

The program is required to create an audit trail on its tests of the production line so that it records which employee ran the test. To accomplish this you will need to create a class named EmployeeInfo that will allow the user to input their full name and then create a user id of their first initial and surname.

The class will have 2 fields

-   StringBuilder name;
-   String code;

The class will have the following methods defined:

-   public StringBuilder getName()
-   public String getCode()
-   private void setName()
-   private void createEmployeeCode(StringBuilder name)
-   private String inputName()
-   private boolean checkName(StringBuilder name)

The setName() method will be called from the constructor which will use inputName() to get a name (first name and surname) as a single input from the user before checkName() is used to make sure that the name supplied has a space in it.

If a valid name is given then createEmployeeCode() is used to take the first initial from the first name and add it to the full surname to create the code. If there is no space then default value of guest is to be used as the value for code.

In the TestProductionLine class create an employee object using the EmployeeInfo class. Using the getCode() method display the employee code at the bottom of the product output.

**Week 13 Strings, Regular Expressions**

**Issue 8 - deptId**

An additional piece of information is required to be produced for the auditing with the users department information being required as well. The department code is made up of four letters and two numbers.

The format of the department code is the first letter must be in uppercase with the following three all being lowercase and no spaces.

The following three fields need to be added to the EmployeeInfo class:

-   String deptId;
-   Pattern p;
-   Scanner in;

The following new methods have to be defined:

-   public String getDeptId()
-   private void setDeptId()
-   private String getId()
-   private boolean validId(String id)

As there will be multiple inputs across the class now the scanner will need to be declared and closed in the constructor. The pattern to control the format of the input will also have to be declared in the constructor. In between opening and closing the scanner, the constructor will need to not only get the name but also the deptId of the user.

setDeptId() will call getDeptId() to get the id from the user before validId() is used to check if the input matches the pattern. If the pattern matches then the given id is set to deptId otherwise a default value of None01 should be assigned.

As there are now two values to be displayed (code, deptId) create a toString() method that will override the output and allow you to simply display the value of the object to the screen.

Update the TestProductionLine class to use the toString() method to display the values to the console.

**Java Documentation**

[JavaDocument](https://kagznjenga.github.io/ProductionLineTracker/docs/index.html)



