import java.util.Arrays;
import java.util.Scanner;
public class DD_DaysProgram {

     /**  @author Dolunay Dagci
      * Date: 2/5/19
      * Fixed Code
     *  Course: CISS 111-360
      * Assignment Name = Days
      * This program takes a string of months from the user, and prints out a line from a poem.
      */
            //As you can see it also automatically compiles when I run the program just like eclipse
    public static void main(String[] strings) {

        //Scanner method to get input from the user
        Scanner keyboard = new Scanner(System.in);

        //String Array that consists of the 12 months. It will be used to validate user's input
        String[] monthsArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};

        //The number of Days in each month is set to 0 at first
        int number_Of_DaysInMonth = 0;

        // The String variable which will receive the user's input so it is null at first
        String MonthOfName = null;

        //The year is set to 0 in the beginning
        int year = 0;

        //Prompt the user for a month String
        System.out.println("Input a month String: ");
        MonthOfName = keyboard.next();

           /* To validate the input user entered, I used the if-statement. If the input the user entered is a month value in monthsArray, the input that the user entered
        is a valid input. If it is not, then it prompts again for a valid input.*/
        if (Arrays.asList(monthsArray).contains(MonthOfName)) {
            System.out.print("Input a year: ");
            year = keyboard.nextInt();
        }
        else {
            while (!(Arrays.asList(monthsArray).contains(MonthOfName))) {
                System.out.println("The String entered is not a valid month. Please try again.");
                MonthOfName = keyboard.next(); //I changed this part. The user will enter until the input is valid
            }
        }

       /* I used switch-statement to have valid month inputs output phrases from the poem. I assigned number of days in each month, and placed each month into arrays in order
        just in case.*/
        switch (MonthOfName) {
            case "January":
            case "March":
            case  "May":
            case "July":
            case "August":
            case "October":
            case "December":
                number_Of_DaysInMonth = 31;
                System.out.println("all the rest have thirty-one"); //they are all in one block of statements
                break;

            case  "February":
                /*If-statement is used to determine leap years and print different phrases if the year is leap or not if the user inputs "February".*/
                if (isLeapYear(year)) { //I created a method below outside of main method and it determines if year is leap or not.
                    number_Of_DaysInMonth = 29;
                    System.out.println("Leap Year happening one in four, Gives February one day more.");
                } else {
                    number_Of_DaysInMonth = 28;
                    System.out.println("with February's 28 to make it fun.");
                }
                break;

            case "April":
            case "June":
            case "November":
                number_Of_DaysInMonth = 30;
                System.out.println("April, June, and November"); // Same I did about first cases
                //When I run it it automatically compiles like eclipse
                break;
            case "September":
                number_Of_DaysInMonth = 30;
                System.out.println("Thirty days hath September");
                break; //I also deleted array assignments because they were unnecessary

        }


    }

    /**
     *
     * @param year the user entered as an input
     * @return  a boolean value depending on if the year is leap or not.
     */
    public static boolean isLeapYear(int year) { //this will be used to determine if a year is leap
        boolean status;
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

}