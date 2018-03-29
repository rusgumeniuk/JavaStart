package Lab3OOP.Cards.StudyingCards;


import Lab3OOP.Cards.Card;

import java.time.YearMonth;

abstract public class StudyingPersonCard extends Card {
    private YearMonth timeOfEnding;
    {
        timeOfEnding = YearMonth.now().plusYears(4);
    }

    protected StudyingPersonCard(){
        super();
    }
    protected StudyingPersonCard(boolean isStudying){
        this();
        this.setStatus(isStudying);
    }
    protected StudyingPersonCard(boolean isStudying, YearMonth timeOfEnding){
        this(isStudying);
        setTimeOfEnding(timeOfEnding);
    }

    public YearMonth getTimeOfEnding() {
        return this.timeOfEnding;
    }
    public boolean isStudying(){
        return this.getStatus();
    }

    public void setTimeOfEnding(YearMonth timeOfEnding) {
        this.timeOfEnding = timeOfEnding;
        this.validateCard();
    }
    public void setStudying(boolean isStudying) {
      setStatus(isStudying);
    }

    @Override     public void setStatus(boolean isStudying) {
        if(!isActivated()) return;
        this.isActive = isStudying;
        this.validateCard();
    }

    @Override     public void validateCard(){
        super.validateCard();
        if(this.isAllowToActivate())
        {
            if(isStudying() && this.getTimeOfEnding().isBefore(YearMonth.now())){
                this.setStudying(this.getTimeOfEnding().isAfter(YearMonth.now()));
            }
        }
    }
    @Override     public boolean isCanDoTrip() {
        return super.isCanDoTrip() && isStudying();
    }

    @Override     public void DeactivateCard() {
        super.DeactivateCard();
        this.isActive = false;
    }
    @Override     public void ActivateCard(YearMonth timeOfEnding)  {
        this.timeOfEnding = timeOfEnding;
        super.ActivateCard(timeOfEnding);
    }
}

