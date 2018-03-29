package Lab3OOP.Cards.StandardCards;


import Lab3OOP.Cards.Card;

abstract public class StandardCard extends Card {
    int balanceOnCard;
    public void setBalanceOnCard(int balanceOnCard){
        this.balanceOnCard = balanceOnCard > 0 ? balanceOnCard : 0;
        validateCard();
    }
    int getBalanceOnCard() {
        return this.balanceOnCard;
    }

    {
        setBalanceOnCard(5);
    }

    protected StandardCard(){super();}
    protected    StandardCard(boolean isActive){super(isActive);}
    protected StandardCard(boolean isActive, int balanceOnCard){
        this(isActive);
        setBalanceOnCard(balanceOnCard);
    }

    public boolean isHasResourcesOnBalance(){
        return getBalanceOnCard() > 0;
    }

    @Override    public void validateCard() {
        super.validateCard();
        if(this.isAllowToActivate()){
            if(this.getStatus() != this.isHasResourcesOnBalance()){
                this.setStatus(this.isHasResourcesOnBalance());
            }
        }
    }
    @Override    public boolean isCanDoTrip() {
        return super.isCanDoTrip() && isHasResourcesOnBalance();
    }

    @Override    public void DeactivateCard() {
        super.DeactivateCard();
        this.balanceOnCard = 0;
    }
}

