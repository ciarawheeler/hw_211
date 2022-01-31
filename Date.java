import java.util.Scanner;
/*
 * In class we learned that comments should be in red... I am not sure how to 
 * do this, and have tried to import the GoogleStyle using source format
 * but it doesn't ever change anything
 */

public class Date {
  private String monthRenamed;  //used the refactor => rename to rename this variable to double check that it would change for ever instance of it both in this class and the DateTest class
  private int day;
  private int year; // a four digit number 

  public Date() {
    monthRenamed = "January";
    day = 1;
    year = 1000;
  }

  public Date(int monthInt, int day, int year) {
    setDate(monthInt, day, year);
  }

  public Date(String monthString, int day, int year) {
    setDate(monthString, day, year);
  }

  public Date(Date aDate) {
    if (aDate == null)// Not a real date.
    {
      System.out.println("Fatal Error.");
      System.exit(0);
    }
    monthRenamed = aDate.monthRenamed;
    day = aDate.day;
    year = aDate.year;
  }

  public void setDate(int monthInt, int day, int year) {
    if (dateIsValid(monthInt, day, year)) {
      this.monthRenamed = monthString(monthInt);
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  public void setDate(String monthString, int day, int year) {
    if (dateIsValid(monthString, day, year)) {
      this.monthRenamed = monthString;
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  public void setYear(int year) {
    if ((year < 1000) || (year > 9999)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      this.year = year;
  }

  public void setMonth(int monthNumber) {
    if ((monthNumber <= 0) || (monthNumber > 12)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      monthRenamed = monthString(monthNumber);
  }

  public void setDay(int day) {
    if ((day <= 0) || (day > 31)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      this.day = day;
  }

  public int getMonth() {
    int monthNum =  switch (monthRenamed.toUpperCase()) {
      case "JANUARY" ->  1;
     case "FEBRUARY" ->  2;
      case "MARCH" ->  3;
      case "APRIL" ->  4;
      case "MAY" ->  5;
      case "JUNE" ->  6;
      case "JULY" ->  7;
      case "AUGUST" ->  8;
      case "SEPTEMBER" ->  9;
      case "OCTOBER" ->  10;
      case "NOVEMBER" ->  11;
      case "DECEMBER" ->  12;
      default -> 0;
    };
    return monthNum;
 }

  public int getDay() {
    return day;
  }

  public int getYear() {
    return year;
  }

  public String toString() {
    return (monthRenamed + " " + day + ", " + year);
  }

  public boolean datesEqual(Date otherDate) {
    return ((monthRenamed.equals(otherDate.monthRenamed)) && (day == otherDate.day) && (year == otherDate.year));
  }

  public boolean datePrecedes(Date otherDate) {
    return ((year < otherDate.year) || (year == otherDate.year && getMonth() < otherDate.getMonth())
        || (year == otherDate.year && monthRenamed.equals(otherDate.monthRenamed) && day < otherDate.day));
  }

  public void readInput() { //changed variable declarations to var rather than the specified type
    var tryAgain = true;
    var sc = new Scanner(System.in);
    while (tryAgain) {
      System.out.println("Enter month, day, and year.");
      System.out.println("Do not use a comma.");
      var monthInput = sc.next();
      var dayInput = sc.nextInt();
      var yearInput = sc.nextInt();
      if (dateIsValid(monthInput, dayInput, yearInput)) {
        setDate(monthInput, dayInput, yearInput);
        tryAgain = false;
      } else
        System.out.println("Illegal date. Reenter input.");
    }
    sc.close();
  }

  private boolean dateIsValid(int monthInt, int dayInt, int yearInt) {      //used Refactor => Rename to change class name from dateOK to dateIsValid
    return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <= 31)
        && (yearInt >= 1000) && (yearInt <= 9999));
  }

  private boolean dateIsValid(String monthString, int dayInt, int yearInt) {    //used Refactor => Rename to change class name from dateOK to dateIsValid
    return (monthIsValid(monthString) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000)
        && (yearInt <= 9999));
  }

  public boolean monthIsValid(String month) {            //had to change to public class so I could test it in JUnit (is this normal?) 
    boolean isMonth = switch (month.toUpperCase()) {    //used Refactor => Rename to change class name from monthOK to monthIsValid
      case "JANUARY" ->  true;                          //renaming this class also carried over to the DateTest.java (JUnit testing class)
      case "FEBRUARY" ->  true;
      case "MARCH" ->  true;
      case "APRIL" ->  true;
      case "MAY" ->  true;
      case "JUNE" ->  true;
      case "JULY" ->  true;
      case "AUGUST" ->  true;
      case "SEPTEMBER" ->  true;
      case "OCTOBER" ->  true;
      case "NOVEMBER" ->  true;
      case "DECEMBER" ->  true;
      default -> false;
    };
    return isMonth;
  }

  public String monthString(int monthNumber) {  //changed class to public for access to JUnit testing
    String monthName = switch (monthNumber) {
      case 1 ->  "January";
      case 2 ->  "February";
      case 3 ->  "March";
      case 4 ->  "April";
      case 5 ->  "May";
      case 6 ->  "June";
      case 7 ->  "July";
      case 8 ->  "August";
      case 9 ->  "September";
      case 10 ->  "October";
      case 11 ->  "November";
      case 12 ->  "December";
      default -> "Fatal Error";
    };
    return monthName;
  }
}
