/**
 * Created by Ebrar on 23/11/15.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permute {

    public static ArrayList<String> permute(String word){
        ArrayList<String> result = new ArrayList<>();
        if(word.length() <= 1){
            result.add(word);
            return result;
        }
        else{
            for(int i = 0; i < word.length(); i++){
                String shorter = word.substring(0,i);
                if(i!=word.length()-1)
                    shorter += word.substring(i+1);

                ArrayList<String> shorterList = permute(shorter);
                for(String s: shorterList){
                    result.add(word.charAt(i)+ s);
                }
            }
        }
        return result;
    }

    public static void main(String[]args){
        ArrayList<String> t = permute("eat");
        for(String i : t){
            System.out.println(i);
        }
    }
}
