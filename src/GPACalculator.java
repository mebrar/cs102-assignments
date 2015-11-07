/**
 * Created by Ebrar on 20/10/15.
 */
import java.util.*;

public class GPACalculator {

    public static void main(String[]args){

        Scanner intScan = new Scanner(System.in);
        Scanner stringScan = new Scanner(System.in);
        double[] values = {4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.0};
        ArrayList<Double> totals = new ArrayList<Double>();

        int credit;
        int gradeScale;
        double currentGrade;
        String addAgain;
        int totalCredit = 0;

        do{
            System.out.print("Enter the credit: ");
            credit = intScan.nextInt();
            totalCredit += credit;
            System.out.print("Enter the grade scale: ");
            gradeScale = intScan.nextInt();
            currentGrade = credit * values[gradeScale];
            totals.add(currentGrade);

            System.out.print("Do you wanna add again? (y/n)?");
            addAgain = stringScan.nextLine();
        }while(addAgain.equalsIgnoreCase("y"));

        System.out.println("GPA is " + calculateGPA(totals, totalCredit) + "with " + totalCredit + " credits...");
    }



    public static double calculateGPA(ArrayList<Double> list, int sumCredit){
        double sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum / sumCredit;
    }
}
