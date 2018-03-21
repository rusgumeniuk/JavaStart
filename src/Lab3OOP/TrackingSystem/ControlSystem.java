package Lab3OOP.TrackingSystem;

import Lab3OOP.Cards.Card;
import Lab3OOP.Cards.StandardCards.MoneyDependCard;
import Lab3OOP.Cards.StandardCards.TimeDependCard;
import Lab3OOP.Cards.StandardCards.TripDependCard;
import Lab3OOP.Cards.StudyingCards.PupilCard;
import Lab3OOP.Cards.StudyingCards.StudentCard;

import java.time.YearMonth;
import java.util.*;


public class ControlSystem
{
    public static HashMap<UUID, Card> cardsInSystem = new HashMap<>();
    public static HashMap<UUID, Turnstile> turnstileInSystem = new HashMap<>();

    private static int costOfTrip = 4;
    public static int getCostOfTrip() {
        return costOfTrip;
    }
    public static void setCostOfTrip(int costOfTrip){
        ControlSystem.costOfTrip = costOfTrip > 0 ? costOfTrip : 4;
    }

    public static int getCountOfActiveCard(){
        int res = 0;
        for(Card card : cardsInSystem.values()) {
            if (card.getStatus())
                ++res;
        }
        return res;
    }
    public static int getCountOfAllTrips(){
        int res = 0;
        for(Turnstile turnstile : turnstileInSystem.values())
            res+=turnstile.tripsInTurnstile.size();
        return res;
    }
    public static int getCountOfAllAllowTrips(){
        int res = 0;
        for(Turnstile turnstile : turnstileInSystem.values()){
            res += turnstile.getAllAllowTrip() != null ? turnstile.getAllAllowTrip().size() : 0;
        }
        return res;
    }
    public static int getCountOfNotAllowTrips(){
        int res = 0;
        for(Turnstile turnstile : turnstileInSystem.values()){
            res += turnstile.getAllNotAllowTrip().size();
        }
        return res;
    }

    public static String getInfoAboutAllCards(){
        Collection<Card> list = cardsInSystem.values();
        if(list == null || list.size() < 1 ) return "No one cards";

        StringBuilder info = new StringBuilder();
        for (Card card : list)
        {
            info.append(card.toString()).append("\n");
        }
        return info.toString();//(info.length() > 0 ? info : info.append("No one cards")).toString();
    }
    public static String getInfoAboutAllTripsInAllTurnstiles(){
        if(turnstileInSystem.size() < 1) return "No one turnstile in system";
        StringBuilder info = new StringBuilder();
        for(Turnstile turnstile : turnstileInSystem.values())
        {
            info.append(turnstile.getInfoAboutAllTrips()).append("\n");
        }
        return info.toString();
    }
    public static String getInfoAboutCardsOfThisClass(Class clas){
        List<Card> list = getListOfThisType(clas);
        if(list == null || list.size() < 1)return "No one card";

        StringBuilder info = new StringBuilder();
        for (Card card: list)
            info.append(card.toString()).append("\n");

        return info.toString();
    }

    public static List<Card> getListOfThisType(Class clas){
        if(cardsInSystem.size() < 1) return null;
        List<Card> list = new ArrayList<>();
        for(Card card : cardsInSystem.values())
        {
            if(card.getTypeOfCard() == clas)
                list.add(card);
        }
        return list;
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
