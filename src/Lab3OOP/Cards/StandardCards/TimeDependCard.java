package Lab3OOP.Cards.StandardCards;


import java.time.YearMonth;
import java.util.Date;

public class TimeDependCard extends StandardCard {
    private Date endOfAbonement;
    {
        setEndOfAbonement(new Date(new Date().getTime() + getMillisecondFromDays(2)));
    }

    public TimeDependCard() {super();}
    public TimeDependCard(boolean isActive){super(isActive);}
    public TimeDependCard(boolean isActive, int daysForTravel){
        super(isActive);
        setEndOfAbonement(daysForTravel);
    }
    public TimeDependCard(boolean isActive, Date endOfAbonement){
        super(isActive);
        setEndOfAbonement(endOfAbonement);
    }

    public void setEndOfAbonement(Date endOfAbonement){
        this.endOfAbonement = endOfAbonement;
        this.balanceOnCard = this.endOfAbonement.after(new Date ()) ? getDaysFromMilliseconds(this.endOfAbonement.getTime() - new Date().getTime()) : 0;
        checkOnActivate();
    }
    public void setEndOfAbonement(int days){

            this.balanceOnCard = days > 0 ? days : 0;
            this.endOfAbonement =  days > 0 ? new Date(new Date().getTime() + getMillisecondFromDays(days)) : new Date();
            checkOnActivate();

    }

    public Date getEndOfAbonement() {
        return this.endOfAbonement;
    }

    @Override
    public boolean isHasResourcesOnBalance() {
        return  getBalanceOnCard() > 0;
    }

    @Override  public void setBalanceOnCard(int balanceOnCard) {
        setEndOfAbonement(balanceOnCard);
    }
    /*
    @Override  public void checkOnActivate() {
        super.checkOnActivate();
        try {
            if (this.getStatus() != this.isHasResourcesOnBalance() )
                this.setStatus(isHasResourcesOnBalance());
        }
        catch (NullPointerException ex) {
        }
    }
*/
    private int getDaysFromMilliseconds(long milliseconds){
        return(int)( milliseconds/(1000*60*60*24));
    }
    private long getMillisecondFromDays(int days){ return days * 24 * 60 * 60 *1000; }
}
