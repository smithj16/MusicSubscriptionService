import Subscriber.*;


import java.time.LocalDate;
import java.util.*;

import Validation.SubscriberValidation;


public class SignUpPage {


    public static void main(String[] args) {
        //Register new user
        Scanner scan = new Scanner(System.in);
        Subscriber sub = new Subscriber("Jacob", "Smith",
                "+16307767485", "jacobsmithevans@gmail.com",
                LocalDate.of(1997,10,07));

        List<String> validation = new ArrayList<>();

        //valid subscriber's information and print
        validation = SubscriberValidation.validate(sub);

        validation.stream()
                  .forEach(System.out::println);


        //Pick subscription plan
        sub.subPlanMenu();

        List<Subscriber> subscribers = new ArrayList<Subscriber>();
        subscribers.add(sub);

        subscribers.stream()
                   .forEach(subscriber -> subscriber.setSubPlan(scan.nextInt()));

        //check if free trial is available for subscriber
        subscribers.stream()
                   .map(subscriber -> SubscriberValidation.isFreeTrialAvailable);

        System.out.println("\nThanks for subscribing!");


    }

}


