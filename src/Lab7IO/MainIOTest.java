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

        //////////////////////////////////

    @Test(expected = IllegalArgumentException.class)
    public void getCryptedChar_VALUEandKeyNull_ReturnsException(){
        MainIO.getCryptedString(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCryptedString_VALUEisNULL_ReturnsException(){
            MainIO.getCryptedString(null,key);
        }

    @Test(expected = IllegalArgumentException.class)
    public void getCryptedString_VALUEisEmpty_ReturnsExeption(){
            MainIO.getCryptedString("", key);
        }
        //
    @Test(expected = IllegalArgumentException.class)
    public void getDecryptedChar_KEYisNULL_ReturnsExecption(){
            MainIO.getDecryptedChar('n', null);
        }

    @Test(expected = IllegalArgumentException.class)
    public void getDecryptedChar_VALUEisNULL_ReturnsException(){
        MainIO.getDecryptedChar(null,key);
    }
        //
    @Test(expected = IllegalArgumentException.class)
    public void getDecryptedChar_KeyMoreThanChar_ReturnsException() {
        char testedChar = 'a';
        key = 'b';

        char cryptedChar = MainIO.getDecryptedChar(testedChar, key);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDecryptedString_VALUEisNULL_ReturnsException(){
        MainIO.getDecryptedString(null, key);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDecryptedString_VALUEisEmpty_ReturnsExeption(){
        MainIO.getDecryptedString("", key);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDecryptedString_AAAandKeyB_ReturnsException() {
        String text = MainIO.getDecryptedString("aaa",'b');
    }

        //
    @Test(expected = IOException.class)
    public void writeCryptTextToFile_WrongPath_ReturnsIOException() throws IOException{
        MainIO.writeCryptTextToFile("", "text", key);
    }

    @Test(expected = IllegalArgumentException.class)
    public void writeCryptTextToFile_EmptyVALUE_ReturnsIllegalArgumentException() throws IOException{
        MainIO.writeCryptTextToFile(cryptedFilePath, "", key);
    }

        //
    @Test(expected = IOException.class)
    public void getDecryptedTextFromFile_WrongPath_ReturnsIOException () throws IOException{
        MainIO.getDecryptedTextFromFile("", key);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDecryptedTextFromFile_KEYisNULL_ReturnsIllegalException() throws IOException{
        MainIO.getDecryptedTextFromFile(cryptedFilePath, null);
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