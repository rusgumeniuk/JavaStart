package Lab3OOP.Cards.StandardCards;

import Lab3OOP.TrackingSystem.ControlSystem;

import java.time.YearMonth;

public class MoneyDependCard extends StandardCard {
    {
        setEndOfExploitation(YearMonth.of(9999,12));
    }
    public MoneyDependCard() {super();}
    public MoneyDependCard(boolean isActive){super(isActive);}
    public MoneyDependCard(boolean isActive, int moneyOnCard){
        super(isActive,moneyOnCard);
    }

    @Override
    public void setEndOfExploitation(YearMonth endOfExploitation) {
        System.out.println("You can not change exploitation time for card of this type!");
    }

    @Override    public boolean isCanDoTrip() {
        return super.isCanDoTrip() && balanceOnCard >= ControlSystem.getCostOfTrip();
    }
    @Override    public void takeTrip() {
        super.takeTrip();
        this.balanceOnCard -= ControlSystem.getCostOfTrip();
    }
}
