package Lab3OOP;

import Lab3OOP.Cards.StandardCards.MoneyDependCard;
import Lab3OOP.Cards.StandardCards.TimeDependCard;
import Lab3OOP.Cards.StandardCards.TripDependCard;
import Lab3OOP.Cards.StudyingCards.PupilCard;
import Lab3OOP.Cards.StudyingCards.StudentCard;
import Lab3OOP.TrackingSystem.ControlSystem;
import Lab3OOP.TrackingSystem.Turnstile;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.time.YearMonth;
import java.util.Date;
import java.util.Objects;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTurnstileSystem {
    
    private static Turnstile turnstile1;
    private static Turnstile turnstile2;

    private static StudentCard studentCard1;
    private static StudentCard studentCard2;
    private static StudentCard studentCard3;

    private static PupilCard pupilCard1;
    private static PupilCard pupilCard2;
    private static PupilCard pupilCard3;

    private static MoneyDependCard moneyCard1;
    private static MoneyDependCard moneyCard2;
    private static MoneyDependCard moneyCard3;


    private static TripDependCard tripCard1;
    private static TripDependCard tripCard2;
    private static TripDependCard tripCard3;

    private static TimeDependCard timeCard1;
    private static TimeDependCard timeCard2;
    private static TimeDependCard timeCard3;
    private static TimeDependCard timeCard4;

    @BeforeClass
    public static void letsGetIt(){
         turnstile1 = new Turnstile();
         turnstile2 = new Turnstile();

         studentCard1= ControlSystem.createStudentCard();
         studentCard2 = ControlSystem.createStudentCard(true);
         studentCard3 = ControlSystem.createStudentCard(true, YearMonth.of(2018,6));

         pupilCard1 = ControlSystem.createPupilCard();
         pupilCard2 = ControlSystem.createPupilCard(true);
         pupilCard3 = ControlSystem.createPupilCard(true, YearMonth.of(2018,5));

         moneyCard1 = ControlSystem.createMoneyDependCard();
         moneyCard2 = ControlSystem.createMoneyDependCard(true);
         moneyCard3 = ControlSystem.createMoneyDependCard(true,7);


         tripCard1 = ControlSystem.createTripDependCard();
         tripCard2 = ControlSystem.createTripDependCard(true);
         tripCard3 = ControlSystem.createTripDependCard(true,2);

         timeCard1 = ControlSystem.createTimeDependCard();
         timeCard2 = ControlSystem.createTimeDependCard(true);
         timeCard3 = ControlSystem.createTimeDependCard(true, new Date( new Date().getTime() + 1000*60*60*96));
         timeCard4 = ControlSystem.createTimeDependCard(true,4);
    }

    @Test
    public void aFirstTestTurnstilesAndSystem(){
        assertEquals(16, ControlSystem.getCountOfCard());
        assertEquals(16, ControlSystem.getCountOfActiveCard());
        assertEquals(0, turnstile1.getCountOfAllowTrips());
        assertEquals(0, turnstile2.getCountOfAllTrips());
        assertEquals(0, ControlSystem.getCountOfAllTrips());
    }
    @Test
    public void bFirstTrips(){

        assertTrue(turnstile1.allowPass(studentCard1));
        assertTrue(turnstile1.allowPass(studentCard2));
        assertTrue(turnstile1.allowPass(studentCard3));

        assertTrue(turnstile1.allowPass(pupilCard1));
        assertTrue(turnstile1.allowPass(pupilCard2));
        assertTrue(turnstile1.allowPass(pupilCard3));

        ControlSystem.setCostOfTrip(3);

        assertTrue(turnstile1.allowPass(moneyCard1));
        assertTrue(turnstile1.allowPass(moneyCard2));
        assertTrue(turnstile1.allowPass(moneyCard3));

        assertTrue(turnstile1.allowPass(timeCard1));
        assertTrue(turnstile1.allowPass(timeCard2));
        assertTrue(turnstile1.allowPass(timeCard3));
        assertTrue(turnstile1.allowPass(timeCard4));

        assertTrue(turnstile1.allowPass(tripCard1));
        assertTrue(turnstile1.allowPass(tripCard2));
        assertTrue(turnstile1.allowPass(tripCard3));

        assertEquals(16, turnstile1.getCountOfAllTrips());
        assertEquals(16, turnstile1.getCountOfAllowTrips());
        assertEquals(16, ControlSystem.getCountOfAllTrips());
        assertEquals(16, ControlSystem.getCountOfAllAllowTrips());
    }
    @Test
    public void cChangeStandardCards(){

        tripCard1.setBalanceOnCard(-5);
        tripCard2.setEndOfExploitation(YearMonth.of(2018,2));
        tripCard3.DeactivateCard();

        timeCard1.setEndOfAbonement(new Date(new Date().getTime() - 1000));
        timeCard2.setEndOfAbonement(-2);
        timeCard3.setBalanceOnCard(-5);
        timeCard4.setEndOfExploitation(YearMonth.of(2018,1));

        moneyCard1.setBalanceOnCard(-5);
        moneyCard2.setStatus(false);
        moneyCard3.setEndOfExploitation(YearMonth.of(2018,1));

        assertFalse(tripCard1.isCanDoTrip());
        assertFalse(tripCard2.isHasResourcesOnBalance());
        assertFalse(tripCard3.getStatus());

        assertFalse(timeCard1.isHasResourcesOnBalance());
        assertFalse(timeCard2.getStatus());
        assertFalse(timeCard3.getEndOfAbonement().after(new Date()));
        assertFalse(timeCard4.isCanDoTrip());

        assertFalse(moneyCard1.isCanDoTrip());
        assertTrue(moneyCard2.getStatus());
        assertTrue(moneyCard3.isActivated());


    }
    @Test
    public void dChangeStudyingCards(){
        studentCard1.setStudying(false);
        studentCard2.setStatus(false);
        studentCard3.setTimeOfEnding(YearMonth.of(2018,2));        
        pupilCard1.setEndOfExploitation(YearMonth.of(2018,1));
        
        assertFalse(studentCard1.isStudying());
        assertFalse(studentCard2.isCanDoTrip());
        assertFalse(studentCard3.isStudying());
        assertFalse(pupilCard1.isStudying());
    }
    @Test
    public void eSecondTrips(){

        assertTrue( turnstile2.allowPass(moneyCard3));
        assertTrue( turnstile2.allowPass(pupilCard2));
        assertTrue(turnstile2.allowPass(pupilCard3));

        assertFalse( turnstile2.allowPass(moneyCard1));
        assertFalse( turnstile2.allowPass(moneyCard2));
        assertFalse( turnstile2.allowPass(timeCard1));
        assertFalse( turnstile2.allowPass(timeCard2));
        assertFalse( turnstile2.allowPass(timeCard3));
        assertFalse( turnstile2.allowPass(timeCard4));
        assertFalse( turnstile2.allowPass(tripCard1));
        assertFalse( turnstile2.allowPass(tripCard2));
        assertFalse( turnstile2.allowPass(tripCard3));
        assertFalse( turnstile2.allowPass(studentCard1));
        assertFalse( turnstile2.allowPass(studentCard2));
        assertFalse( turnstile2.allowPass(studentCard3));
        assertFalse( turnstile2.allowPass(pupilCard1));

    }
    @Test
    public void fSecondTestTurnstilesAndSystem(){
        assertEquals(16, ControlSystem.getCountOfCard());
        assertEquals(4, ControlSystem.getCountOfActiveCard());
        assertEquals(16, turnstile1.getCountOfAllowTrips());
        assertEquals(3, turnstile2.getCountOfAllowTrips());
        assertEquals(32, ControlSystem.getCountOfAllTrips());

        assertEquals(1,pupilCard1.getAmountOfAllDoneTrips());
        assertEquals(2,pupilCard2.getAmountOfAllDoneTrips());
        assertEquals(4, Objects.requireNonNull(ControlSystem.getListOfThisType(TimeDependCard.class)).size());
        assertEquals(3, Objects.requireNonNull(ControlSystem.getListOfThisType(StudentCard.class)).size());
    }

}