package Lab3OOP.Cards.StudyingCards;
import java.time.YearMonth;

public class PupilCard extends StudyingPersonCard {
    public PupilCard()
    {
        super();
    }
    public PupilCard(boolean isActive){
        super(isActive);
    }
    public PupilCard(boolean isActive,  YearMonth timeOfEnding) {
        super(isActive, timeOfEnding);
    }
}