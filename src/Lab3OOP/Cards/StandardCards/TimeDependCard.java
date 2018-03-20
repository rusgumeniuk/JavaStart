package Lab3OOP.Cards.StandardCards;


import java.time.YearMonth;
import java.util.Date;

public class TimeDependCard extends StandardCard {
    private Date endOfAbonement;
    {
        this.endOfAbonement = new Date(new Date().getTime() + getMillisecondFromDays(1));
    }

    public TimeDependCard() {super();}
    public TimeDependCard(boolean isActive){super(isActive);}
    public TimeDependCard(boolean isActive, int daysForTravel){
        this(isActive);
        setEndOfAbonement(daysForTravel);
    }
    public TimeDependCard(boolean isActive, Date endOfAbonement){
        this(isActive);
        setEndOfAbonement(endOfAbonement);
    }

    public void setEndOfAbonement(Date endOfAbonement){
        this.endOfAbonement = endOfAbonement;
        this.balanceOnCard = this.endOfAbonement.getTime() >= new Date ().getTime() ? getDaysFromMilliseconds(this.endOfAbonement.getTime() - new Date().getTime()) : 0;
        checkOnActivate();
    }
    public void setEndOfAbonement(int days){
        if(days > 0)
        {
            this.balanceOnCard = days;
            this.endOfAbonement = new Date(new Date().getTime() + getMillisecondFromDays(days));
            checkOnActivate();
        }
    }

    public Date getEndOfAbonement() {
        return this.endOfAbonement;
    }

    @Override  public void setBalanceOnCard(int balanceOnCard) {
        setEndOfAbonement(balanceOnCard);
    }
    @Override  public void checkOnActivate() {
        super.checkOnActivate();
        try {
            if (this.getStatus() != this.getEndOfAbonement().after(new Date()) || this.isHasResourcesOnBalance() != this.getStatus())
                this.setStatus(this.getEndOfAbonement().after(new Date()));
        }
        catch (NullPointerException ex) {
        }
    }

    private int getDaysFromMilliseconds(long milliseconds){
        return(int)( milliseconds/(1000*60*60*24));
    }
    private long getMillisecondFromDays(int days){ return days * 24 * 60 * 60 *1000; }
}