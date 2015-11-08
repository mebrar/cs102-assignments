/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

import java.util.Scanner;

public class TheaterSeats {
    static int[][] seats = {{10,10,10,10,10,10,10,10,10,10},{10,10,10,10,10,10,10,10,10,10},
            {10,10,10,10,10,10,10,10,10,10},{10,10,20,20,20,20,20,20,10,10},{10,10,20,20,20,20,20,20,10,10},
            {20,20,30,30,40,40,30,30,20,20},{20,30,30,40,50,50,40,30,30,20},{30,40,50,50,50,50,50,50,40,30}};
    static Scanner stringScan = new Scanner(System.in);
    static Scanner integerScan = new Scanner(System.in);
    static String input;

    public static void printSeats(){
        for(int rowIndex = 0; rowIndex < seats.length; rowIndex++){
            for(int columnIndex = 0; columnIndex < seats[rowIndex].length; columnIndex++){
                System.out.print(seats[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }

    public static void searchAndSellByPrice(int price){
        boolean isSold;
        for(int rowIndex = seats.length-1 ; rowIndex >= 0; rowIndex--){
            for(int columnIndex = seats[rowIndex].length-1; columnIndex >= 0; columnIndex--){
                if(price == seats[rowIndex][columnIndex]){
                    System.out.println("Best option is seat " + rowIndex + "-" + columnIndex + "\nAre you sure to want to buy it?(y/n): ");
                    input = stringScan.nextLine();
                    if(input.equalsIgnoreCase("y")){
                        seats[rowIndex][columnIndex] = 0;
                        System.out.println("You have successfully bought the seat" + rowIndex + "-"+ columnIndex);
                        break;
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[]args){
        int seatRow;
        int seatColumn;
        int price;
        do{
            printSeats();
            System.out.print("Hello!\nPick either seat or price by write 'seat' or 'price': ");
            input = stringScan.nextLine();
            if(input.equalsIgnoreCase("seat")){
                System.out.print("Enter the seat's row number: ");
                seatRow = integerScan.nextInt()-1;
                System.out.print("Enter the seat's column number: ");
                seatColumn = integerScan.nextInt()-1;
                if(seats[seatRow][seatColumn] != 0){
                    System.out.println("Seat "+ seatRow + "-"+ seatColumn + " is available.\nAre you sure to want to buy it?(y/n): ");
                    input = stringScan.nextLine();
                    if(input.equalsIgnoreCase("y")){
                        seats[seatRow][seatColumn] = 0;
                        System.out.println("You have successfully bought the seat" + seatRow + "-"+ seatColumn);
                    }
                }
            }
            else if(input.equalsIgnoreCase("price")){
                System.out.print("Enter the price to be bought seat: ");
                price = integerScan.nextInt();
                searchAndSellByPrice(price);
            }
            else{
                System.out.println("You have entered a wrong input...");
            }
            System.out.print("Do you want to buy another seat?(y/n): ");
            input = stringScan.nextLine();
        }while(input.equalsIgnoreCase("y"));
    }
}
