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

    public HashMap<UUID, Trip> tripsInTurnstile;

    {
        turnstileId = UUID.randomUUID();
        tripsInTurnstile = new HashMap<>();
        ControlSystem.turnstileInSystem.put(this.getTurnstileId(),this);
    }

    public  boolean allowPass(Card card){
        Trip newTrip = Trip.makeNewTrip(this, card);
        return newTrip.getStatus();
    }

    public int getCountOfAllTrips(){
        return tripsInTurnstile.size();
    }
    public int getCountOfAllowTrips(){
        return getAllAllowTrip() != null ? getAllAllowTrip().size() : 0;
    }
    public int getCountOfNotAllowTrips(){
        return getAllNotAllowTrip().size();
    }

    public List<Trip> getAllTrips(){
        return tripsInTurnstile.size() > 0 ? new ArrayList<>(tripsInTurnstile.values()) : null;
    }
    public List<Trip> getAllAllowTrip(){
        return getTripOfStatus(true);
    }
    public List<Trip> getAllNotAllowTrip(){ return getTripOfStatus(false);}
    private List<Trip> getTripOfStatus(boolean tf){
        if(tripsInTurnstile.size() < 1) return null;
        List<Trip> list = new ArrayList<>();
        for (Trip trip : tripsInTurnstile.values())
        {
            if(trip.getStatus() == tf)
                list.add(trip);
        }
        return list;
    }

    public String getInfoAboutAllTrips(){
        List<Trip> tripList = getAllTrips();
        if(tripList == null) return new StringBuilder()
                .append("No one trips in this ").append(this.getTurnstileId()).append(" turnstile").toString();
        StringBuilder info = new StringBuilder();
        for (Trip tr : tripList)
        {
            info.append(new StringBuilder().append(tr.toString()).append("\n"));
        }
        return info.toString();
    }
    public String getInfoAboutTripWithType(Class clas){
        List<Trip> tripList = getAllTrips();
        if(tripList == null) return "No one trips in Turnstile"; //може перевіряти через card.amounOfAllTrips()?
        StringBuilder info = new StringBuilder();
        for (Trip trip : tripList)
        {
            if(ControlSystem.cardsInSystem.get(trip.getCardId()).getClass().equals(clas))
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
