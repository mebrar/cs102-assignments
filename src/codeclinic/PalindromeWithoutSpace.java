/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

import java.util.Scanner;

public class PalindromeWithoutSpace {

    public static void main(String[]args){
        Scanner stringScan = new Scanner(System.in);
        System.out.print("Enter something to check it is palindrome or not: ");
        String input = stringScan.nextLine();
        input = input.replaceAll("\\p{Space}", "");
        if(checkPalindrome(input)){
            System.out.println("Your input is palindrome...");
        }
        else{
            System.out.println("Your input is NOT palindrome...");
        }
    }

    public static boolean checkPalindrome(String input){
        for(int index = 0; index < input.length()/2; index++){
            if(input.charAt(index) != input.charAt(input.length()-1-index)){
                return false;
            }
        }
        return true;
    }
}
