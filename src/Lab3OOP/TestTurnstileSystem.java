package Lab3OOP;

import Lab3OOP.Cards.StandardCards.MoneyDependCard;
import Lab3OOP.Cards.StandardCards.TimeDependCard;
import Lab3OOP.Cards.StandardCards.TripDependCard;
import Lab3OOP.Cards.StudyingCards.PupilCard;
import Lab3OOP.Cards.StudyingCards.StudentCard;
import Lab3OOP.TrackingSystem.ControlSystem;
import Lab3OOP.TrackingSystem.Turnstile;
import org.junit.Before;
import org.junit.Test;

import java.time.YearMonth;
import java.util.Date;

import static org.junit.Assert.*;

public class TestTurnstileSystem {

    Turnstile turnstile1 = new Turnstile();
    Turnstile turnstile2 = new Turnstile();

    StudentCard studentCard1= ControlSystem.createStudentCard();
    StudentCard studentCard2 = ControlSystem.createStudentCard(true);
    StudentCard studentCard3 = ControlSystem.createStudentCard(true, YearMonth.of(2018,6));

    PupilCard pupilCard1 = ControlSystem.createPupilCard();
    PupilCard pupilCard2 = ControlSystem.createPupilCard(true);
    PupilCard pupilCard3 = ControlSystem.createPupilCard(true, YearMonth.of(2018,5));

    MoneyDependCard moneyCard1 = ControlSystem.createMoneyDependCard();
    MoneyDependCard moneyCard2 = ControlSystem.createMoneyDependCard(true);
    MoneyDependCard moneyCard3 = ControlSystem.createMoneyDependCard(true,7);


    TripDependCard tripCard1 = ControlSystem.createTripDependCard();
    TripDependCard tripCard2 = ControlSystem.createTripDependCard(true);
    TripDependCard tripCard3 = ControlSystem.createTripDependCard(true,2);

    TimeDependCard timeCard1 = ControlSystem.createTimeDependCard();
    TimeDependCard timeCard2 = ControlSystem.createTimeDependCard(true);
    TimeDependCard timeCard3 = ControlSystem.createTimeDependCard(true, new Date( new Date().getTime() + 1000*60*60*96));
    TimeDependCard timeCard4 = ControlSystem.createTimeDependCard(true,4);

    @Before
    public void setUp() throws Exception {
        //System.out.println(ControlSystem.getInfoAboutAllCards());
    }
/*
    @Test
    public void startedCheck(){
        assertEquals(16, ControlSystem.getCountOfActiveCard());
        assertEquals(0, turnstile1.getCountOfAllowTrips());
        assertEquals(0, turnstile2.getCountOfAllTrips());
        assertEquals(0, ControlSystem.getCountOfAllTrips());
    }
*/
    @Test
    public void checkAfterTrips(){
        assertEquals(16, ControlSystem.getCountOfActiveCard());
        assertEquals(0, turnstile1.getCountOfAllowTrips());
        assertEquals(0, turnstile2.getCountOfAllTrips());
        assertEquals(0, ControlSystem.getCountOfAllTrips());

        ///////////////////////////////////////////////////////////

        assertEquals(true,turnstile1.allowPass(studentCard1));
        assertEquals(true,turnstile1.allowPass(studentCard2));
        assertEquals(true,turnstile1.allowPass(studentCard3));

        ControlSystem.setCostOfTrip(3);

        assertEquals(true,turnstile1.allowPass(moneyCard1));
        assertEquals(true,turnstile1.allowPass(moneyCard2));
        assertEquals(true,turnstile1.allowPass(moneyCard3));

        assertEquals(true,turnstile1.allowPass(timeCard1));
        assertEquals(true,turnstile1.allowPass(timeCard2));
        assertEquals(true,turnstile1.allowPass(timeCard3));
        assertEquals(true,turnstile1.allowPass(timeCard4));

        assertEquals(true,turnstile1.allowPass(tripCard1));
        assertEquals(true,turnstile1.allowPass(tripCard2));
        assertEquals(true,turnstile1.allowPass(tripCard3));

        assertEquals(13, turnstile1.getCountOfAllTrips());
        assertEquals(13, turnstile1.getCountOfAllowTrips());
        assertEquals(13, ControlSystem.getCountOfAllTrips());
        assertEquals(13, ControlSystem.getCountOfAllAllowTrips());
    }




}