package Lab7IO;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainIOTest {

    String cryptedFilePath;
    String decryptedFilePath;

    @Before
    public void setUp() throws Exception {
        cryptedFilePath = "";
        decryptedFilePath = "";
    }

    @Test
    public void getCryptedText() {

    }

    @Test
    public void getDecryptedText() {

    }

    @Test
    public void testTexts(){
        String text = "0K2Z";
        Character key = 'A';

        assertEquals(MainIO.getDecryptedString(MainIO.getCryptedString(text,key),key), text);
    }

}