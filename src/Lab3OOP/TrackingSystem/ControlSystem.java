package Lab3OOP.TrackingSystem;

import Lab3OOP.Cards.Card;
import Lab3OOP.Cards.StandardCards.MoneyDependCard;
import Lab3OOP.Cards.StandardCards.TimeDependCard;
import Lab3OOP.Cards.StandardCards.TripDependCard;
import Lab3OOP.Cards.StudyingCards.PupilCard;
import Lab3OOP.Cards.StudyingCards.StudentCard;

import java.time.YearMonth;
import java.util.Date;

import java.util.HashMap;
import java.util.UUID;


public class ControlSystem
{
    private static int costOfTrip = 4;
    public static int getCostOfTrip() {
        return costOfTrip;
    }
    public static void setCostOfTrip(int costOfTrip){
        ControlSystem.costOfTrip = costOfTrip > 0 ? costOfTrip : 4;
    }


    public static HashMap<UUID, Card> cardsInSystem = new HashMap<>();
    public static HashMap<UUID, Turnstile> turnstileInSystem = new HashMap<>();

    public static String getInfoAboutAllCards(){
        StringBuilder info = new StringBuilder();
        if(cardsInSystem.size() < 1) return info.append("No one cards in Archive").toString();
        for (Card card: cardsInSystem.values())
        {
            info.append(card.toString()).append("\n");
        }
        return (info.length() > 0 ? info : info.append("No one cards")).toString();
    }
    public static String getInfoAboutAllTrips(){
        if(turnstileInSystem.size() < 1) return "No one turnstile in system";
        StringBuilder info = new StringBuilder();
        for(Turnstile turnstile : turnstileInSystem.values())
        {
            info.append(turnstile.getInfoAboutAllTrips());
        }
        return info.toString();
    }
    public static String getInfoAboutCardsOfThisClass(Class clas){
        StringBuilder info = new StringBuilder();
        if(cardsInSystem.size() < 1) return info.append("No one cards in Archive").toString();
        for (Card card: cardsInSystem.values())
        {
            if(card.getClass().equals(clas))
            {
                info.append(card.toString()).append("\n");
            }

        }
        return (info.length() > 0 ? info : info.append("No one cards")).toString();
    }



    public static StudentCard createStudentCard(){return new StudentCard();}
    public static StudentCard createStudentCard(boolean isActive){
        return new StudentCard(isActive);
    }
    public static StudentCard createStudentCard(boolean isActive, YearMonth endOfStudying) {
        return new StudentCard(isActive,endOfStudying);
    }

    public static PupilCard createPupilCard(){
        return new PupilCard();
    }
    public static PupilCard createPupilCard(boolean isActive){
        return new PupilCard(isActive);
    }
    public static PupilCard createPupilCard(boolean isActive, YearMonth endOfStudying) {
        return new PupilCard(isActive,endOfStudying);
    }

    public static MoneyDependCard createMoneyDependCard(){
        return new MoneyDependCard();
    }
    public static MoneyDependCard createMoneyDependCard(boolean isActive){
        return new MoneyDependCard(isActive);
    }
    public static MoneyDependCard createMoneyDependCard(boolean isActive, int moneyOnCard){
        return new MoneyDependCard(isActive, moneyOnCard);
    }

    public static TripDependCard createTripDependCard(){
        return new TripDependCard();
    }
    public static TripDependCard createTripDependCard(boolean isActive){
        return new TripDependCard(isActive);
    }
    public static TripDependCard createTripDependCard(boolean isActive, int tripsOnCard){
        return new TripDependCard(isActive, tripsOnCard);
    }

    public static TimeDependCard createTimeDependCard(){
        return new TimeDependCard();
    }
    public static TimeDependCard createTimeDependCard(boolean isActive){
        return new TimeDependCard(isActive);
    }
    public static TimeDependCard createTimeDependCard(boolean isActive, int daysForTrips){
        return new TimeDependCard(isActive,daysForTrips);
    }
    public static TimeDependCard createTimeDependCard(boolean isActive, Date endOfAbonement){
        return new TimeDependCard(isActive, endOfAbonement);
    }
}
