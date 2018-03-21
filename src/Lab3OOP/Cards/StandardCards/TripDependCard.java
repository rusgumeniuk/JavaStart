package Lab3OOP.Cards.StandardCards;


public class TripDependCard  extends StandardCard {

    public TripDependCard() {super();}
    public TripDependCard(boolean isActive){super(isActive);}
    public TripDependCard(boolean isActive, int tripsOnCard){
        super(isActive,tripsOnCard);
    }

    @Override    public void takeTrip() {
        --this.balanceOnCard;
        super.takeTrip();
    }
}
