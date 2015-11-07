/**
 * Tester program for testing the several methods of assignment1.MyDate class
 * This program can check a date whether it is leap year or not,
 * and can calculate the number of days passed between two date
 *
 * Created by Muhammed Ebrar Erdem on 11/09/15.
 */
package assignment1;

import java.util.Scanner;

public class DateTester {


    public static void main(String[] args){
        // basic string input until user interrupts it
        String wannaContinue;
        /**
         * In case of "keyboard" scanner wouldn't closed after scanning integer,
         * also created a stringScanner object to scan for just strings with System.in
         */
        Scanner keyboard = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in); // in case of "keyboard" scanner wouldnt closed,
        MyDate date1, date2;  // creating references for date objects
        int option;  // declaring an integer "option" for user's choice
        int day, month, year;  // declaring the variables for date objects
        System.out.println("Welcome!"); // simple greeting message

        do {
            System.out.print("1- Enter a date to check that if year is leap or not \n" +
                    "2-Enter two dates two calculate the days passed between them(including starting date but excluding ending date) \n" +
                    "Enter : ");  // listing the options that program has
            option = keyboard.nextInt();
            switch (option){
                // case 1 for checking the input date is leap year or not
                case 1:
                    System.out.print("Enter the day of the date: ");
                    day = keyboard.nextInt();
                    System.out.print("Enter the month of the date: ");
                    month = keyboard.nextInt();
                    System.out.print("Enter the year of the date: ");
                    year = keyboard.nextInt();
                    date1 = new MyDate(day, month, year); // storing the date that user inputs to assignment1.MyDate object date1
                    if (MyDate.isLeapYear(date1.getYear())){        // checking whether date1's year is leap or not
                        System.out.println(date1 + " is leap year.");
                    }
                    else {
                        System.out.println(date1 + " is NOT leap year.");
                    }
                    break;

                // case 2 for getting two date inputs and calculate the number of days passed between them
                case 2:
                    System.out.print("Enter the day for starting the date: ");
                    day = keyboard.nextInt();
                    System.out.print("Enter the month for starting the date: ");
                    month = keyboard.nextInt();
                    System.out.print("Enter the year for starting the date: ");
                    year = keyboard.nextInt();
                    date1 = new MyDate(day, month, year); // storing first date that user inputs to assignment1.MyDate object date1
                    System.out.print("Enter the day for ending the date: ");
                    day = keyboard.nextInt();
                    System.out.print("Enter the month for ending the date: ");
                    month = keyboard.nextInt();
                    System.out.print("Enter the year for ending the date: ");
                    year = keyboard.nextInt();
                    date2 = new MyDate(day, month, year); // storing second date that user inputs to assignment1.MyDate object date2

                    System.out.println("Number of days passed between " + date1 + " and " + date2 + " is " + date1.numDaysPassed(date2));
                    break;
                // Default case for informing user about wrong input
                default:
                    System.out.println("You've entered a wrong input...");
            }

            // ask user to run program again or not
            System.out.print("Do you want to run the program again? (y/n)");
            wannaContinue = stringScanner.nextLine();
        } while(wannaContinue.equalsIgnoreCase("y"));  // depending upon "wannaContinue" string, program runs again or not
    }
}
