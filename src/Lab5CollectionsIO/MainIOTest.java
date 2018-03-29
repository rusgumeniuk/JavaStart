package Lab5CollectionsIO;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MainIOTest {

    private String firstFilePath;
    private String secondFilePath;
    private String[] inputAr;

    @Before
    public void setUp() {
         firstFilePath = "C://Users//Omman//Desktop//input.txt";
         secondFilePath = "C://Users//Omman//Desktop//output.txt";
         inputAr = MainIO.getStrArFromFile(secondFilePath);
    }

    @Test
    public void getSortedArrayByLength() {
        String[] ar = inputAr.clone();
        String[] sortedAr = MainIO.getSortedArrayByLength(ar);
        boolean tf = true;
        int len = sortedAr[0].length();
        for (String str: sortedAr)
        {
            if(len > str.length()){
                tf = false;
                break;
            }
            len = str.length();
        }
        assertTrue(tf);
    }
    @Test
    public void getStrArFromFile(){
        String[] array = new String[3];
        array[0] = "TEST#0.0";
        array[1] = "TEST#0.1";
        array[2] = "TEST#0.2";

        MainIO.writeTextToFile(secondFilePath, MainIO.getStringFromArray(array));

        String[] arrayFromFile = MainIO.getStrArFromFile(secondFilePath);

        assertArrayEquals(array, arrayFromFile);
    }

    @Test
    public void getStringArrayFromFile() {
        String[] text = new String[3];
        text[0] = "TEST #1.1_";
        text[1] = "TEST #1.2";
        text[2] = new Date().toString();

        MainIO.writeTextToFile(secondFilePath, MainIO.getStringFromArray(text));

        inputAr = MainIO.getStrArFromFile(secondFilePath);

        assertEquals(text.length, inputAr.length);
        assertArrayEquals(text, inputAr);
    }
    @Test
    public void getStringFromFile(){
        String testText = "TEST getStringFromFile " + new Date();
        MainIO.writeTextToFile(secondFilePath,testText);
        assertEquals(testText.trim(), MainIO.getStringFromFile(secondFilePath).trim());
    }

    @Test
    public void testWritingAndReading() {

        MainIO.writeTextToFile(secondFilePath, MainIO.getStringFromFile(firstFilePath));
        assertEquals(MainIO.getStringFromFile(firstFilePath), MainIO.getStringFromFile(secondFilePath));

        MainIO.writeTextToFile(secondFilePath, MainIO.getStringFromFile(secondFilePath) + "TEST#2" + new Date());

        MainIO.writeTextToFile(firstFilePath, MainIO.getStringFromFile(secondFilePath));
        assertEquals(MainIO.getStringFromFile(firstFilePath), MainIO.getStringFromFile(secondFilePath));
    }


}