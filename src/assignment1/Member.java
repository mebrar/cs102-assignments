/**
 * assignment1.Member class for storing member information for a sports center
 *
 * Created by Muhammed Ebrar Erdem on 11/09/15.
 */
package assignment1;

public class Member {

    /**
     * Instance variables for each member of sports center
     */
    private int memberID;
    private String firstName, lastName, membershipStatus, membershipType;
    private MyDate membershipStartDate, membershipExpirationDate;

    private static int memberCount = 0; // static variable for holding number of assignment1.Member object created

    /**
     * Default constructor, takes no input,
     * membershipType and membershipStatus declared as default, "regular" and "inactive"
     * and memberCount is incremented by one for holding number of members
     */
    public Member() {
        membershipType = "regular";
        membershipStatus = "inactive";
        memberCount++;
    }

    

    /**
     * Constructor that takes member's firstName, lastName and memberID as an integer
     * also membershipType and membershipStatus declared as default, "regular" and "inactive"
     * and memberCount is incremented by one for holding number of members
     */
    public Member(String firstName, String lastName, int memberID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberID = memberID;
        membershipType = "regular";
        membershipStatus = "inactive";
        memberCount++;
    }

    /**
     * Constructor that takes member's firstName, lastName,
     * membershipStartDate and membershipExpiration date as assignment1.MyDate object
     * also membershipType and membershipStatus declared as default, "regular" and "inactive"
     * and memberCount is incremented by one for holding number of members
     */
    public Member(String firstName, String lastName, MyDate membershipStartDate, MyDate membershipExpirationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.membershipStartDate = membershipStartDate;
        this.membershipExpirationDate = membershipExpirationDate;
        membershipType = "regular";
        membershipStatus = "inactive";
        memberCount++;
    }

    /**
     * Getter methods for every data field that class has
     */

    public int getMemberID() {
        return memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public MyDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public MyDate getMembershipExpirationDate() {
        return membershipExpirationDate;
    }

    /**
     * Setter methods for setting up every data field that class has
     */

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public void setMembershipStartDate(MyDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public void setMembershipExpirationDate(MyDate membershipExpirationDate) {
        this.membershipExpirationDate = membershipExpirationDate;
    }

    /**
     * updateMembershipStatus method takes the current date as input,
     * checks that the date is later than membershipExpirationDate,
     * if yes, it changes the membershipStatus to "inactive"
     * if no, membershipStatus should be "active"
     * --**in case of having NULL value for membershipStatus, it overwrites it as "active" in else condition**--
     */

    public void updateMembershipStatus(MyDate date){
        if (membershipExpirationDate.compareTo(date) < 0){
            membershipStatus = "inactive";
        }
        else{
            membershipStatus = "active";
        }
    }

    /**
     * updateMembershipType method gets input as today,
     * and checks whether the customer is member for 2 years or so,
     * if yes, customer's membershipType changing to "premium"
     */

    public void updateMembershipType(MyDate date){
        if (membershipStartDate.numDaysPassed(date) >= 730){
            membershipType = "premium";
        }
    }

    /**
     * Overriding toString method with a proper one in order to print necessary info about member
     */
    @Override
    public String toString() {
        return "assignment1.Member Name: " + firstName + " " + lastName + "\nMembership Status: " + membershipStatus +
                "\nMembership Type: " + membershipType + "\nMembership Start Date: " + membershipStartDate +
                "\nMembership Expiration Date: " + membershipExpirationDate;
    }
}
