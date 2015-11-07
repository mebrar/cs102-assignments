/**
 * assignment1.MemberTest class for testing the methods that assignment1.Member class has...
 *
 * Created by Muhammed Ebrar Erdem on 11/09/15.
 */
package assignment1;

public class MemberTest {

    public static void main(String[] args){

        MyDate today = new MyDate(14,9,2015);
        MyDate todayAfterMonth = new MyDate (14,10,2015);

        Member memberEbrar = new Member("Ebrar", "Erdem", new MyDate(11,9,2015),new MyDate(13,12,2015));

        memberEbrar.setMemberID(1234);

        System.out.println(memberEbrar);



        Member defaultMember = new Member();

        System.out.println("Just after creating a member object with default constructor: ");
        System.out.println(defaultMember);

        defaultMember.setFirstName("Altay");
        defaultMember.setLastName("Güvenir");
        defaultMember.setMemberID(1);
        defaultMember.setMembershipType("active");
        defaultMember.setMembershipStartDate(today);
        defaultMember.setMembershipExpirationDate(new MyDate(31,12,2023));

        defaultMember.updateMembershipStatus(today);

        System.out.println("After setting necessary information for defaultMember : ");
        System.out.println(defaultMember);


        Member memberAtalar = new Member("Abdullah", "Atalar", new MyDate(1,1, 2012), new MyDate(15,12,2018));
        memberAtalar.setMemberID(111111111);



        memberAtalar.updateMembershipType(today);

        System.out.println("After updating Membership Type of Abdullah Atalar: ");
        System.out.println(memberAtalar);

        memberEbrar.setMembershipExpirationDate(new MyDate(13,9,2015));

        memberEbrar.updateMembershipStatus(today);

        System.out.println("After setting new Membership Expiration Date for Ebrar Erdem and updating it: ");
        System.out.println(memberEbrar);


        Member differentMember = new Member("Arif", "Işık", 216);

        differentMember.setMembershipStartDate(today);

        differentMember.setMembershipExpirationDate(todayAfterMonth);

        differentMember.updateMembershipStatus(today);

        System.out.println("After updating membership status of Arif Işık : ");
        System.out.println(differentMember);


    }
}
