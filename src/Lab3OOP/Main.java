package Lab3OOP;


import Lab3OOP.Cards.StandardCards.MoneyDependCard;
import Lab3OOP.Cards.StandardCards.TimeDependCard;
import Lab3OOP.Cards.StandardCards.TripDependCard;
import Lab3OOP.Cards.StudyingCards.PupilCard;
import Lab3OOP.Cards.StudyingCards.StudentCard;
import Lab3OOP.TrackingSystem.ControlSystem;
import Lab3OOP.TrackingSystem.Turnstile;

import java.time.YearMonth;
import java.util.Date;

public class Main {
    public static void main(String[] args)
    {
        Turnstile tr1 = new Turnstile();
        ControlSystem.setCostOfTrip(5);

        StudentCard sc1 = ControlSystem.createStudentCard(true, YearMonth.now().plusMonths(1));
        PupilCard pc1 = ControlSystem.createPupilCard(true, YearMonth.now().plusMonths(1));
        MoneyDependCard mc1 = ControlSystem.createMoneyDependCard(true,6);
        TimeDependCard timeC1 = ControlSystem.createTimeDependCard(true,new Date(new Date().getTime() + 1000*60*60*60));
        TripDependCard tripC1 = ControlSystem.createTripDependCard(true,1);

        System.out.println(tr1.getInfoAboutTripWithCard(timeC1));

        tr1.allowPass(sc1);
        tr1.allowPass(pc1);
        tr1.allowPass(mc1);
        tr1.allowPass(timeC1);
        tr1.allowPass(tripC1);

        printTask(1);
        //System.out.println(Turnstile.getInfoAboutAllTrips());
        System.out.println(tr1.getInfoAboutTripWithCard(timeC1));

        tr1.allowPass(sc1);
        tr1.allowPass(pc1);
        tr1.allowPass(mc1);
        tr1.allowPass(timeC1);
        tr1.allowPass(tripC1);
        System.out.println("#2");

        System.out.println(tr1.getInfoAboutTripWithCard(timeC1));

        sc1.setEndOfExploitation(YearMonth.of(1999,2));
        pc1.setTimeOfEnding(YearMonth.of(1999,2));

        System.out.println(sc1.getStatus() + " "  + sc1.isActivated() +" " + sc1.isStudying());
        System.out.println(pc1.getStatus() + " " + pc1.isStudying() + " " + pc1.isCanDoTrip());

        tr1.allowPass(sc1);
        tr1.allowPass(pc1);
        tr1.allowPass(mc1);
        tr1.allowPass(timeC1);
        tr1.allowPass(tripC1);
        System.out.println("#2");
        //System.out.println(Turnstile.getInfoAboutAllTrips());
        System.out.println(tr1.getInfoAboutAllTrips());

        printTask(2);
        //System.out.println(ControlSystem.getInfoAboutAllCards());

        sc1.ActivateCard(YearMonth.now().minusMonths(1));
        pc1.ActivateCard(YearMonth.now().plusMonths(1));

        System.out.println(sc1.getStatus() + " "  + sc1.isActivated() +" " + sc1.isStudying());
        System.out.println(pc1.getStatus() + " " + pc1.isStudying() + " " + pc1.isCanDoTrip());

        tr1.allowPass(sc1);
        tr1.allowPass(pc1);
        tr1.allowPass(mc1);
        tr1.allowPass(timeC1);
        tr1.allowPass(tripC1);
    }

    private static void printTask(int i){
        System.out.println(("\n" + "Task #" + i).toUpperCase());
    }
}

