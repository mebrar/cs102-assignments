package codeclinic;

/**
 * Created by Ebrar on 02/01/16.
 */
public class FindStringOccurence {

    public static boolean find(String text, String str){
        if(text.length() < str.length()){
            return false;
        }
        else if(text.substring(text.length()-str.length()).equals(str)){
            return true;
        }
        return find(text.substring(0,text.length()-1),str);
    }

    public static void main(String[]args){
        System.out.println(find("Mississippi", "sip"));
    }
}
