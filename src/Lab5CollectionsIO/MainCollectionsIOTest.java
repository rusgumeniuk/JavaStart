package Lab5CollectionsIO;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

public class MainCollectionsIOTest {

    private String firstFilePath;
    private String secondFilePath;
    private String[] inputAr;

    @Before
    public void setUp() {
         firstFilePath = "C://Users//Omman//Desktop//input.txt";
         secondFilePath = "C://Users//Omman//Desktop//output.txt";
         inputAr = MainCollectionsIO.getStrArFromFile(secondFilePath);
    }

    @Test
    public void getSortedArrayByLength() {
        String[] ar = inputAr.clone();
        String[] sortedAr = MainCollectionsIO.getSortedArrayByLength(ar);
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

        MainCollectionsIO.writeTextToFile(secondFilePath, MainCollectionsIO.getStringFromArray(array));

        String[] arrayFromFile = MainCollectionsIO.getStrArFromFile(secondFilePath);

        assertArrayEquals(array, arrayFromFile);
    }

    @Test
    public void getStringArrayFromFile() {
        String[] text = new String[3];
        text[0] = "TEST #1.1_";
        text[1] = "TEST #1.2";
        text[2] = new Date().toString();

        MainCollectionsIO.writeTextToFile(secondFilePath, MainCollectionsIO.getStringFromArray(text));

        inputAr = MainCollectionsIO.getStrArFromFile(secondFilePath);

        assertEquals(text.length, inputAr.length);
        assertArrayEquals(text, inputAr);
    }
    @Test
    public void getStringFromFile() throws IOException {
        String testText = "TEST getStringFromFile " + new Date();
        MainCollectionsIO.writeTextToFile(secondFilePath,testText);
        assertEquals(testText.trim(), MainCollectionsIO.getStringFromFile(secondFilePath).trim());
    }

    @Test
    public void testWritingAndReading() throws IOException {

        MainCollectionsIO.writeTextToFile(secondFilePath, MainCollectionsIO.getStringFromFile(firstFilePath));
        assertEquals(MainCollectionsIO.getStringFromFile(firstFilePath), MainCollectionsIO.getStringFromFile(secondFilePath));

        MainCollectionsIO.writeTextToFile(secondFilePath, MainCollectionsIO.getStringFromFile(secondFilePath) + "TEST#2" + new Date());

        MainCollectionsIO.writeTextToFile(firstFilePath, MainCollectionsIO.getStringFromFile(secondFilePath));
        assertEquals(MainCollectionsIO.getStringFromFile(firstFilePath), MainCollectionsIO.getStringFromFile(secondFilePath));
    }
    @Test
    public void writeTextFromOneToSecondFile() throws IOException{
        MainCollectionsIO.writeTextFromOneToSecondFile(firstFilePath,secondFilePath);
        assertEquals(
                MainCollectionsIO.getStringFromArray(
                        MainCollectionsIO.getSortedArrayByLength(
                                MainCollectionsIO.getStrArFromFile(firstFilePath))),
                MainCollectionsIO.getStringFromFile(secondFilePath));
    }


}