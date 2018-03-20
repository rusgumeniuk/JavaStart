package Lab3OOP.TrackingSystem;


import Lab3OOP.Cards.Card;

import java.util.Date;
import java.util.UUID;

public class Trip{
    private UUID tripId;
    private UUID cardId;
    private Date tripTime;
    private boolean isAllow;
    {
        tripId = UUID.randomUUID();
    }

    private Trip(Turnstile turnstile,Card card){
        turnstile.Trips.put(this.tripId,this);
        this.tripTime = new Date();
        this.cardId = card.getId();
        this.isAllow = card.isCanDoTrip();
    }

    public UUID getCardId() {
        return cardId;
    }
    public boolean getStatus(){
        return isAllow;
    }

    public static Trip makeNewTrip(Turnstile turnstile,Card card){
        if(card.isCanDoTrip()) card.takeTrip();
        return new Trip(turnstile, card);
    }

    @Override    public String toString() {
        return new StringBuilder()
                .append("Trip: ").append(tripId)
                .append(" was").append(((isAllow)?(""):(" NOT"))).append(" done")
                .append(" with card: ").append(cardId)
                .append(" at ").append(tripTime.toString())
                .toString();
    }

}
