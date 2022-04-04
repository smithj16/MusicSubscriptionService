package Subscriber;

import java.time.LocalDate;

public class Subscriber {

    private final String firstName;
    private final String lastName;
    private String phoneNumber;
    private String email;
    private final LocalDate DOB;
    private LocalDate subDate;
    private boolean freeTrialAvailable;
    private SubPlan subPlan;
    private boolean isSub;

    public Subscriber(String firstName, String lastName, String phoneNumber, String email, LocalDate DOB){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.DOB =  DOB;
        this.subDate = LocalDate.now();
        this.freeTrialAvailable = true;
        this.isSub = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public LocalDate getSubDate() {
        return subDate;
    }

    public boolean isFreeTrialAvailable() {
        return freeTrialAvailable;
    }

    public void setFreeTrialAvailable(boolean freeTrialAvailable) {
        this.freeTrialAvailable = freeTrialAvailable;
    }

    public SubPlan getSubPlan() {
        return subPlan;
    }

    public void setSubPlan(int plan) {
        switch(plan) {
            case (1): this.subPlan = SubPlan.STUDENT;
                      break;

            case (2): this.subPlan = SubPlan.INDIVIDUAL;
                      break;

            case (3): this.subPlan = SubPlan.FAMILY;
                      break;
            case (4):
                      if(freeTrialAvailable) {
                          this.subPlan = SubPlan.FREETRIAL;
                          this.freeTrialAvailable = false;
                      }
                      else
                        this.subPlan = SubPlan.NULL;


                      break;
        }

    }

    public boolean getIsSub() {
        return isSub;
    }

    public void setIsSub(boolean sub) {
        isSub = sub;
    }

    public void subPlanMenu(){
        System.out.println("\n1. Student Plan"
                           + "\n2. Individual Plan"
                           + "\n3. Family Plan"
                           + "\n4. FreeTrial Plan");
    }

    public void setSubDate(LocalDate date){
        this.subDate = date;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", DOB=" + DOB +
                ", subDate=" + subDate +
                ", freeTrialAvailable=" + freeTrialAvailable +
                ", subPlan='" + subPlan + '\'' +
                ", isSub=" + isSub +
                '}';
    }

    public enum SubPlan{
        STUDENT,
        INDIVIDUAL,
        FAMILY,
        FREETRIAL,
        NULL
    }


}
