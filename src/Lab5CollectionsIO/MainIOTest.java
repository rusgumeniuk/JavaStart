package Lab5CollectionsIO;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainIOTest {

    private String firstFilePath;
    private String secondFilePath;
    private String[] inputAr;

    @Before
    public void setUp() {
         firstFilePath = "C://Users//Omman//Desktop//input.txt";
         secondFilePath = "C://Users//Omman//Desktop//output.txt";
         inputAr = MainIO.getStringArrayFromFile(firstFilePath);
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
    public void getStringArrayFromFile() {
        String[] text = new String[2];
        text[0] = "first";
        text[1] = "second";

        MainIO.writeTextToFile(secondFilePath, Arrays.toString(text));

        System.out.println(Arrays.toString(text));
        System.out.println(Arrays.toString(MainIO.getStringArrayFromFile(firstFilePath)));

        assertArrayEquals(text, MainIO.getStringArrayFromFile(firstFilePath));

    }

//    @Test
//    public void testWritingAndReading() {
//
//        MainIO.writeTextToFile(secondFilePath, MainIO.getStringFromFile(firstFilePath) + "\nTEST1");
//        assertEquals(MainIO.getStringFromFile(firstFilePath), MainIO.getStringFromFile(secondFilePath));
//
//
//        MainIO.writeTextToFile(firstFilePath, MainIO.getStringFromFile(secondFilePath) + "\nTEST2");
//        assertEquals(MainIO.getStringFromFile(firstFilePath), MainIO.getStringFromFile(secondFilePath));
//    }
}