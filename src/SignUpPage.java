import Subscriber.*;


import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;


public class SignUpPage {
    public static void main(String[] args) {
        //Register new user
        Subscriber sub = new Subscriber("Jacob", "Smith",
                "+16307767485", "jacobsmithevans@gmail.com",
                LocalDate.of(1997,10,07));

        System.out.println("Email Validation: " + isEmailValid.apply(sub)
                            + "\nPhoneNumber Validation: " + isPhoneNumValid.apply(sub)
                            + "\nAge Validation: " + isOfAge.apply(sub));


        //Pick subscription plan
        sub.subPlanMenu();
        sub.setSubPlan(2);
        if(sub.getSubPlan() == Subscriber.SubPlan.NULL)
            System.out.println("Free trial isn't available, " +
                               "please make another selection.");
        else{
            sub.setSubDate(LocalDate.now());
            sub.setIsSub(true);
        }

        System.out.println("\nThanks for subscribing!");

    }

    private static Function<Subscriber, ValidationResult> isEmailValid = sub -> {
        if(sub.getEmail().contains("@"))
            return ValidationResult.SUCCESS;
        return ValidationResult.EMAIL_NOT_VALID;
       };


    private static Function<Subscriber, ValidationResult> isPhoneNumValid = sub -> {
       if(sub.getPhoneNumber().contains("+1"))
           return ValidationResult.SUCCESS;

       return ValidationResult.PHONE_NUMBER_NOT_VALID;
       };

    private static Function<Subscriber, ValidationResult> isOfAge = sub -> {
       if(Period.between(sub.getDOB(), LocalDate.now()).getYears() >= 16)
           return ValidationResult.SUCCESS;

       return ValidationResult.AGE_NOT_VALID;

    };




    enum ValidationResult{
        SUCCESS,
        EMAIL_NOT_VALID,
        PHONE_NUMBER_NOT_VALID,
        AGE_NOT_VALID
    }

}


