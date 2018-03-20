package Lab3OOP.TrackingSystem;


import Lab3OOP.Cards.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Turnstile
{
    private UUID turnstileId;
    public UUID getTurnstileId() {
        return turnstileId;
    }

    public HashMap<UUID, Trip> Trips;
    {
        turnstileId = UUID.randomUUID();
        Trips  = new HashMap<>();
        ControlSystem.turnstileInSystem.put(this.getTurnstileId(),this);
    }

    public  boolean allowPass(Card card){
        Trip newTrip = Trip.makeNewTrip(this, card);
        return newTrip.getStatus();
    }

    public List<Trip> getAllTrips(){
        if(Trips.size() < 1) return null;
        List<Trip> list = new ArrayList<>();
        for (Trip trip : Trips.values())
        {
            list.add(trip);
        }
        return list;
    }
    public List<Trip> getAllAllowTrip(){
        return getTripOfStatus(true);
    }
    public List<Trip> getAllNotAllowTrip(){ return getTripOfStatus(false);}
    private List<Trip> getTripOfStatus(boolean tf){
        if(Trips.size() < 1) return null;
        List<Trip> list = new ArrayList<>();
        for (Trip trip : Trips.values())
        {
            if(trip.getStatus() == tf)
                list.add(trip);
        }
        return list;
    }

    public String getInfoAboutAllTrips(){
        List<Trip> tripList = getAllTrips();
        if(tripList == null) return "No one trips in Turnstile";
        StringBuilder info = new StringBuilder();
        for (Trip tr:tripList)
        {
            info.append(new StringBuilder().append(tr.toString()).append("\n"));
        }
        return info.toString();
    }
    public String getInfoAboutTripWithCard(Card card){
        List<Trip> tripList = getAllTrips();
        if(tripList == null) return "No one trip";

        StringBuilder info = new StringBuilder();
        for (Trip trip:tripList)
        {
            if(trip.getCardId().equals(card.getId()))
            {
                info.append(trip.toString()).append("\n");
            }
        }
        return info.length() > 0 ? info.toString() : "No one trip";
    }
    public String getInfoAboutTripWithType(Class thisClass){
        List<Trip> tripList = getAllTrips();
        if(tripList == null) return "No one trips in Turnstile"; //може перевіряти через card.amounOfAllTrips()?
        StringBuilder info = new StringBuilder();
        for (Trip trip : tripList)
        {
            if(ControlSystem.cardsInSystem.get(trip.getCardId()).getClass().equals(thisClass))
            {
                info.append(trip.toString()).append("\n");
            }
        }
        return info.length() > 0 ? info.toString() : "No one trip";
    }

    public String getAllAllowTrips(){
        return getInfoThroughStatus(true);
    }
    public String getAllNotAllowTrips(){
        return getInfoThroughStatus(false);
    }
    private String getInfoThroughStatus(boolean status){
        List<Trip> tripList = getTripOfStatus(status);
        if(tripList == null) return "No one trips in Turnstile";
        StringBuilder info = new StringBuilder();
        for (Trip trip: tripList)
        {
            info.append(trip.toString()).append("\n");
        }
        return info.length() > 0 ? info.toString() : "No one trip";
    }

}
