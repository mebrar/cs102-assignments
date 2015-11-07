/**
 * This class provides a testing enviroment for assignment2.MyCrypto class.
 * Asks a key from user and provides encryption and decryption options unless user interrupts.
 * Also checks whether encryption key is positive or not, if not positive, then asks again.
 *
 * Created by Muhammed Ebrar Erdem on 30/09/15.
 */
package assignment2;

import java.util.Scanner;

public class MyCryptoTester {


    public static void main(String[]args){

        /**
         * In case of "keyboard" scanner wouldn't closed after scanning integer,
         * also created a stringScanner object to scan for just strings with System.in
         */
        Scanner integerScan = new Scanner(System.in);
        Scanner stringScan = new Scanner(System.in);

        int key;
        int option;
        String plainText;
        String wannaContinue;

        System.out.println("Welcome!"); // simple greeting message

        System.out.print("Enter a positive key for encryption: ");
        key = integerScan.nextInt();
        //while loop for being sure that key is positive
        while(key < 1){
            System.out.print("You've entered a wrong input \n" +
                    "Please try again with a positive integer: ");
            key = integerScan.nextInt();
        }

        do {
            System.out.print("1- Enter a plain text to encrypt with key\n" +
                    "2-Enter a ciphered text to decipher with key \n" +
                    "Enter : ");  // listing the options that program has
            option = integerScan.nextInt();
            // switch case statement for running the desired thing
            switch(option){
                // case 1 for encrypting plain text
                case 1:
                    System.out.print("Enter a string to be encrypted: ");
                    plainText = stringScan.nextLine();
                    System.out.print("Encrypted as: " + MyCrypto.encryptString(plainText, key));
                    break;
                // case 2 for decrypting ciphered text
                case 2:
                    System.out.print("Enter a string to be decrypted: ");
                    plainText = stringScan.nextLine();
                    System.out.println("Decrypted as: " + MyCrypto.decipherString(plainText, key));
                    break;
            }
            // asking user if wants to run another encryption/decryption
            System.out.print("\n********\nDo you want to encrypt/decrypt something again? (y/n)");
            wannaContinue = stringScan.nextLine();

        }while(wannaContinue.equalsIgnoreCase("y"));
    }
}
