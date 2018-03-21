package Lab3OOP.Cards;

import Lab3OOP.TrackingSystem.ControlSystem;

import java.time.YearMonth;
import java.util.UUID;

public abstract class Card{
    protected boolean isActive;
    private UUID id;

    public Class getTypeOfCard() {
        return typeOfCard;
    }

    private Class typeOfCard;
    private int amountOfAllDoneTrips;
    private YearMonth endOfExploitation;
    private boolean isAllowToActivate;
    {
        typeOfCard = this.getClass();
        id = UUID.randomUUID();
        amountOfAllDoneTrips = 0;
        endOfExploitation = YearMonth.of( 2018,12);
        isActive = true;
        isAllowToActivate = true;
    }

    protected Card(){
        ControlSystem.cardsInSystem.put(this.getId(),this);
    }
    protected Card(boolean isActive){
        this();
        setStatus(isActive);
    }

    public UUID getId() {
        return id;
    }
    public int getAmountOfAllDoneTrips() {return this.amountOfAllDoneTrips;}
    public boolean getStatus(){return this.isActive;}
    public YearMonth getEndOfExploitation() {
        return endOfExploitation;
    }
    protected boolean isAllowToActivate(){return this.isAllowToActivate;}
    public boolean isActivated(){ return isAllowToActivate();}

    public void setEndOfExploitation(YearMonth endOfExploitation) {
        if(!isAllowToActivate())return;
        this.endOfExploitation = endOfExploitation;
        this.checkOnActivate();
    }
    public void setStatus(boolean isActive){
        if(!this.isAllowToActivate())return;
        this.isActive = isActive;
        this.checkOnActivate();
    }

    public void checkOnActivate(){
        if(this.isAllowToActivate() && getEndOfExploitation().isBefore(YearMonth.now()))
        {
            this.DeactivateCard();
            return;
        }
    }
    public boolean isCanDoTrip(){
        return this.getStatus();
    }
    public void takeTrip(){
        this.amountOfAllDoneTrips++;
        this.checkOnActivate();
    }

    public void DeactivateCard(){
        this.isActive = false;
        this.isAllowToActivate = false;
        System.out.println(new StringBuilder().append("Card: ").append(this.getId()).append(" was deactivated!"));
    }
    public void ActivateCard(YearMonth endOfExploitation){
        this.isActive = true;
        this.isAllowToActivate = true;
        this.endOfExploitation = endOfExploitation;
        checkOnActivate();
        if(getStatus())System.out.println(new StringBuilder().append("Card: ").append(this.getId()).append(" activated!"));
    }

    @Override    public String toString() {
        return new StringBuilder()
                .append("Id: ").append(id)
                .append(" type: ").append(typeOfCard)
                .append(" is ").append(((isActive)?(""):("not"))).append(" active.\n")
                .append("Count of trips: ").append(amountOfAllDoneTrips)
                .toString();
    }
}
