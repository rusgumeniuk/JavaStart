package Lab7IO;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainIOTest {

    private String cryptedFilePath;
    private String decryptedFilePath;

    @Before
    public void setUp() throws Exception {
        cryptedFilePath = "";
        decryptedFilePath = "";
    }

    @Test
    public void getCryptedChar(){
        char testedChar = 'A';
        char key = '0';
        char cryptedChar = MainIO.getCryptedChar(testedChar,key);

        assertEquals(cryptedChar,'q');
        assertEquals((int)cryptedChar,(int)testedChar + (int)key);
    }
    @Test
    public void getDecryptedChar(){
        char testedChar = 'q';
        char key = '0';
        char deCryptedChar = MainIO.getDecryptedChar(testedChar,key);

        assertEquals(deCryptedChar,'A');
        assertEquals((int)deCryptedChar, (int)testedChar-(int)key);
    }

    @Test
    public void getCryptedString() {
        String testedString = "ABC";
        char key = '0';
        String cryptedString = MainIO.getCryptedString(testedString,key);

        assertEquals(cryptedString,"qrs");
    }
    @Test
    public void getDecryptedString() {

    }

    @Test
    public void testTexts(){
        String text = "0K2Z";
        Character key = 'A';

        assertEquals(MainIO.getDecryptedString(MainIO.getCryptedString(text,key),key), text);
    }
}