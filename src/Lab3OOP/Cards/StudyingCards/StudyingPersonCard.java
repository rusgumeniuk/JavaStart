package Lab3OOP.Cards.StudyingCards;


import Lab3OOP.Cards.Card;

import java.time.YearMonth;

abstract public class StudyingPersonCard extends Card {

    private boolean isStudying;
    private YearMonth timeOfEnding;
    {
        isStudying = true;
        timeOfEnding = YearMonth.now().plusYears(4);
    }
     StudyingPersonCard(){
        super();
    }
     StudyingPersonCard(boolean isActive){
        this();
        this.setStatus(isActive);
    }
     StudyingPersonCard(boolean isActive, boolean isStudying){
        this(isActive);
        setStudying(isStudying);
    }
     StudyingPersonCard(boolean isActive, YearMonth timeOfEnding){
        this(isActive);
        setTimeOfEnding(timeOfEnding);
    }

    public YearMonth getTimeOfEnding() {
        return this.timeOfEnding;
    }
    public boolean isStudying(){
        return this.isStudying;
    }

    public void setTimeOfEnding(YearMonth timeOfEnding) {
        this.timeOfEnding = timeOfEnding;
        this.validateCard();
    }
    public void setStudying(boolean studying) {
        this.isStudying = studying;
        this.isActive = studying;
        this.validateCard();
    }


    @Override     public void setStatus(boolean isActive) {
        //super.setStatus(isActive);
        if(!isActivated()) return;
        setStudying(isActive);
    }

    @Override     public void validateCard(){
        super.validateCard();
        if(this.isAllowToActivate())
        {
            if(isStudying() != getStatus()){
                setStatus(isStudying());
            }
            else if(isStudying() && this.getTimeOfEnding().isBefore(YearMonth.now())){
                this.setStudying(this.getTimeOfEnding().isAfter(YearMonth.now()));
            }
           /* if(getTimeOfEnding().isBefore(YearMonth.now())) DeactivateCard();
            if(this.isStudying() != this.getTimeOfEnding().isAfter(YearMonth.now()) || isStudying != getStatus())
            {
                this.setStudying(this.getTimeOfEnding().isAfter(YearMonth.now()));
            }*/
        }
    }
    @Override     public boolean isCanDoTrip() {
        return super.isCanDoTrip() && isStudying();
    }

    @Override     public void DeactivateCard() {
        super.DeactivateCard();
        isStudying = false;
    }
    @Override     public void ActivateCard(YearMonth timeOfEnding)  {
        this.timeOfEnding = timeOfEnding;
        super.ActivateCard(timeOfEnding);
    }
}

