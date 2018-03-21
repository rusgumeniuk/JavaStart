package Lab3OOP.TrackingSystem;


import Lab3OOP.Cards.Card;

import java.util.Date;
import java.util.UUID;

public class Trip{
    private UUID tripId;
    private UUID cardId;
    private Date tripTime;
    private boolean isDone;

    {
        tripId = UUID.randomUUID();
    }

    private Trip(Turnstile turnstile,Card card, boolean isDone){
        turnstile.tripsInTurnstile.put(this.tripId,this);
        this.tripTime = new Date();
        this.cardId = card.getId();
        this.isDone = isDone;
    }

    public UUID getCardId() {
        return cardId;
    }
    public boolean getStatus(){
        return isDone;
    }

    public static Trip makeNewTrip(Turnstile turnstile,Card card){
        boolean isDone = false;
        if(card.isCanDoTrip()){
            card.takeTrip();
            isDone = true;
        }
        return new Trip(turnstile, card, isDone);
    }

    @Override    public String toString() {
        return new StringBuilder()
                .append("Trip: ").append(tripId)
                .append(" was").append(((isDone)?(""):(" NOT"))).append(" done")
                .append(" with card: ").append(cardId)
                .append(" at ").append(tripTime.toString())
                .toString();
    }

}
