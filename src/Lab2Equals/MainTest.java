package Lab2Equals;
import nl.jqno.equalsverifier.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class MainTest {

    @Test
    public void isTrue(){
        EqualsVerifier.forClass(Person.class)
                .withRedefinedSuperclass()
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.TRANSIENT_FIELDS)
                .verify();
    }
}