package Lab7IO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.CryptoPrimitive;

import static org.junit.Assert.*;

public class MainIOTest {
    // TODO: 02.05.2018 Write test with Exceptions

    private String cryptedFilePath;
    private char key;

    @Before
    public void setUp() throws Exception {
        cryptedFilePath = "C://Users//Omman//Desktop//cryptedInfo.txt";
        key = '0';
    }

    @Test
    public void getCryptedChar_AandKey0_ReturnsQ(){
        char testedChar = 'A';
        char cryptedChar = MainIO.getCryptedChar(testedChar,key);

        assertEquals(cryptedChar,'q');
        assertEquals((int)cryptedChar,(int)testedChar + (int)key);
    }
    @Test
    public void getDecryptedChar_QandKey0_ReturnsA(){
        char testedChar = 'q';
        char deCryptedChar = MainIO.getDecryptedChar(testedChar,key);

        assertEquals(deCryptedChar,'A');
        assertEquals((int)deCryptedChar, (int)testedChar-(int)key);
    }
    @Test
    public void getCryptedString_ABCandKey0_ReturnsQRS() {
        String testedString = "ABC";
        String cryptedString = MainIO.getCryptedString(testedString,key);

        assertEquals("qrs", cryptedString);
    }
    @Test
    public void getDecryptedString_QRSandKey0_ReturnsABC(){
        String testedString = "qrs";
        String decryptedString = MainIO.getDecryptedString(testedString,key);
        assertEquals("ABC", decryptedString);
    }

    @Test
    public void writeCryptTextToFile_ABCandKey0_ReturnsQRS()throws IOException{
        String testedString = "ABC";
        MainIO.writeCryptTextToFile(cryptedFilePath, testedString,key);

        String textFromFile = getStringFromFile(cryptedFilePath);

        assertEquals(MainIO.getCryptedString(testedString, key).toString(), textFromFile);
        assertEquals("qrs", textFromFile);
    }
    @Test
    public void getDecryptedTextFromFile_QRSandKey0_ReturnsABC() throws IOException{
        String decryptedText = MainIO.getDecryptedTextFromFile(cryptedFilePath, key);

        assertEquals("ABC", decryptedText);
        assertEquals(MainIO.getDecryptedString(getStringFromFile(cryptedFilePath), key), decryptedText);
    }
    @Test
    public void textTest_CryptAndDecryptText_OK2ZandKeyA_ReturnsTrue(){
        String text = "0K2Z";

        assertEquals(MainIO.getDecryptedString(MainIO.getCryptedString(text,key),key), text);
    }



    @Test(expected = IllegalArgumentException.class)
    public void getDecryptedString_AAAandKeyB_ReturnsException() {
        String text = MainIO.getDecryptedString("aaa",'b');
    }




    private static String getStringFromFile(String path) throws IOException {
        StringBuilder info = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String s;
            while((s  = reader.readLine()) != null)
            {
                s = s.trim();
                if(s.length() > 0) info.append(s).append("\r\n");
            }
        }
        catch (IOException ex){
            throw new IOException();
        }
        return info.toString().trim();
    }
}