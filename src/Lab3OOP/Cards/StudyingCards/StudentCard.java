package Lab3OOP.Cards.StudyingCards;

import java.time.YearMonth;

public class StudentCard extends StudyingPersonCard {
    public StudentCard()
    {
        super();
    }
    public StudentCard(boolean isActive){
        super(isActive);
    }
    public StudentCard(boolean isActive, YearMonth timeOfEnding) {
        super(isActive, timeOfEnding);
    }
}

