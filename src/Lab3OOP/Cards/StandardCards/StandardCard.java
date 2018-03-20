package Lab3OOP.Cards.StandardCards;


import Lab3OOP.Cards.Card;

abstract public class StandardCard extends Card {
    protected int balanceOnCard;
    public void setBalanceOnCard(int balanceOnCard){
        this.balanceOnCard = balanceOnCard > 0 ? balanceOnCard : 0;
        checkOnActivate();
    }
    public int getBalanceOnCard() {
        return this.balanceOnCard;

    }

    {
        balanceOnCard = 1;
    }

    protected StandardCard(){super();}
    protected StandardCard(boolean isActive){super(isActive);}
    protected StandardCard(boolean isActive, int balanceOnCard){
        this(isActive);
        setBalanceOnCard(balanceOnCard);
    }

    public boolean isHasResourcesOnBalance(){
        return balanceOnCard > 0;
    }

    @Override    public void checkOnActivate() {
        super.checkOnActivate();
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

