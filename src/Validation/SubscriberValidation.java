package Validation;


import Subscriber.Subscriber;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class SubscriberValidation{

    private static final  Function<Subscriber, ValidationResult> isEmailValid = sub -> {
        if(sub.getEmail().contains("@"))
            return ValidationResult.SUCCESS;
        return ValidationResult.EMAIL_NOT_VALID;
    };


    private static final  Function<Subscriber, ValidationResult> isPhoneNumValid = sub -> {
        if(sub.getPhoneNumber().contains("+1"))
            return ValidationResult.SUCCESS;

        return ValidationResult.PHONE_NUMBER_NOT_VALID;
    };

    private static final Function<Subscriber, ValidationResult> isOfAge = sub -> {
        if(Period.between(sub.getDOB(), LocalDate.now()).getYears() >= 16)
            return ValidationResult.SUCCESS;

        return ValidationResult.AGE_NOT_VALID;

    };

    public static Consumer<Subscriber> isFreeTrialAvailable = sub -> {
        if(sub.getSubPlan().equals(Subscriber.SubPlan.NULL))
            System.out.println(("Free trial isn't available, " +
                    "please make another selection."));
        else{
            sub.setSubDate(LocalDate.now());
            sub.setIsSub(Boolean.TRUE);
        }
    };

    public static List validate(Subscriber sub){
        List<String> newlist = new ArrayList<>();
        newlist.add("Email Validation:" + String.valueOf(SubscriberValidation.isEmailValid.apply(sub)));
        newlist.add("Phone Validation:" + String.valueOf(SubscriberValidation.isPhoneNumValid.apply(sub)));
        newlist.add("Age Validation:" + String.valueOf(SubscriberValidation.isOfAge.apply(sub)));
        return newlist;
    };

    enum ValidationResult{
        SUCCESS,
        EMAIL_NOT_VALID,
        PHONE_NUMBER_NOT_VALID,
        AGE_NOT_VALID
    }
}