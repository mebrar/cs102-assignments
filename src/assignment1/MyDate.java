/**
 *
 * assignment1.MyDate class holds a date information and it has some methods...
 * ...to work with date objects;
 * checking the year is leap or not
 * comparing two date depending on their
 * calculating number of dates passed between two date
 *
 * Created by Muhammed Ebrar Erdem on 11/09/15.
 */
package assignment1;

import java.text.DecimalFormat;

public class MyDate implements Comparable<MyDate> {

    // declaring instance variables that a date should hold
    private int day, month, year;

    /**
     * For having a zero at day and month numbers with one figure,
     * implementing a DecimalFormat object to format output as having at least two figures
     */
    private static DecimalFormat twoDigit = new DecimalFormat("00");

    /**
     * Default constructor that initializes the date to 01/01/1900
     */
    public MyDate(){
        day = 1;
        month = 1;
        year = 1900;
    }

    /**
     * Constructor for creating date object with desired date input
     */
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Getter methods for every data field that class has
     */

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Setter methods for setting up every data field that class has
     */

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Overriding toString method with a proper one with decimal formatting
     */

    @Override
    public String toString() {
        return twoDigit.format(day)+"/"+twoDigit.format(month)+"/"+ year;
    }



    /**
     * compareTo method for comparing anotherDate with object that compareTo invokes to,
     *
     * returns 0 if two dates are the same
     * returns 1 if anotherDate comes earlier
     * return -1 if anotherDate comes later
     */
    @Override
    public int compareTo(MyDate anotherDate){
        if (this.year == anotherDate.year && this.month == anotherDate.month && this.day == anotherDate.day){
            return 0;
        }
        else if (this.year > anotherDate.year || (this.year == anotherDate.year && this.month > anotherDate.month )
                    || (this.year == anotherDate.year && this.month == anotherDate.month && this.day > anotherDate.day)){
            return 1;
        }
        else {
            return -1;
        }
    }


    /**
     * isLeapYear method checks the input "year" whether its leap year or not by simple modulus calculation
     * returns "true" if input is leap year, else returns "false"
     */

    public static boolean isLeapYear(int year){
        if (((year % 100 == 0) && (year % 400 != 0))  ) {
            return false;
        }
        else if (year % 4 == 0) {
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * numDaysPassed method takes one input, anotherDate
     * and calculates the number of days passed between the date that method invokes and input anotherDate
     *
     * returns -1 as an "error" if input anotherDate is earlier than the object that numDaysPassed invokes
     */

    public int numDaysPassed (MyDate anotherDate){
        /**
         * checking whether anotherDate is later than assignment1.MyDate object and reporting if so
         * - also includes equality condition -
         */
        if (this.compareTo(anotherDate) >= 0 ){
            System.out.println("Error! First date argument should be earlier than second date argument!");
            return -1;
        }
        else{
            /**
             * First condition for dates with same month and year, but different days
             * returns the difference between days of two objects
             */
            if (this.year == anotherDate.year && this.month == anotherDate.month){
                return anotherDate.day - this.day;
            }
            // day_month array for holding number of days that a month has for both a leap year or not
            int[][] day_month = {{0,31,28,31,30,31,30,31,31, 30, 31, 30, 31}, {0,31,29,31,30,31,30, 31, 31, 30, 31, 30, 31}};
            int daysPassed = 0, yearIndex;
            /**
             * Second condition for dates with same year but different month
             * At this condition, anotherDate's month should always be later,
             * so its integrates the remaining days at assignment1.MyDate object's month,
             * then adds days upon array index as reaching to anotherDate's month
             * and finally anotherDate's day added...
             */
            if (this.year == anotherDate.year && this.month != anotherDate.month){
                if (MyDate.isLeapYear(this.year)){
                    yearIndex = 1;
                }
                else {
                    yearIndex = 0;
                }
                daysPassed += day_month[yearIndex][this.month] - this.day +1; // adding the days that assignment1.MyDate object's month has
                for(int i = this.month+1; i < anotherDate.month; i++){
                    daysPassed += day_month[yearIndex][i]; // adding days to daysPassed until reaching anotherDate's month
                }
                daysPassed += anotherDate.day; // finally adding anotherDate's day number to daysPassed variable
            }
            else{
                /**
                 * Third and final condition, for dates that have different year
                 * Differs from second condition as adding days that year has if there is more than 1 year between two dates
                 */
                int yearCopy = this.year;  // having a copy of assignment1.MyDate object's year to
                if (MyDate.isLeapYear(yearCopy)){  // checking the year is leap or not to adjust yearIndex variable for array
                    yearIndex = 1;
                }
                else {
                    yearIndex = 0;
                }
                daysPassed += day_month[yearIndex][this.month] - this.day +1;
                for(int i = this.month+1; i < 13; i++){
                    daysPassed += day_month[yearIndex][i];
                }
                yearCopy++;
                /**
                 * Until reaching anotherDate's year, we keep adding a year's day number to daysPassed,
                 * depending upon currently checking year is leap or not, we add 366 or 365, then incrementing the yearCopy by one
                 */
                while(yearCopy != anotherDate.year){

                    if (MyDate.isLeapYear(yearCopy)){
                        daysPassed += 366;
                    }
                    else {
                        daysPassed += 365;
                    }
                    yearCopy++;
                }
                /**
                 * When we reached to anotherDate's year, we check that we are at leap year or not,
                 * then adding days to daysPassed until reaching anotherDate's month,
                 * when reached, we add anotherDate's day number to daysPassed
                 */
                if (MyDate.isLeapYear(yearCopy)){
                    yearIndex = 1;
                }
                else {
                    yearIndex = 0;
                }
                for(int i = 1; i < anotherDate.month; i++){
                    daysPassed += day_month[yearIndex][i];
                }
                daysPassed += anotherDate.day -1;
            }
            return daysPassed;  // returning our final result
        }
    }
}
