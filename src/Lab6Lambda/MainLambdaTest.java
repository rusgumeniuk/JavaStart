package Lab6Lambda;

import com.sun.tools.javac.Main;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainLambdaTest {
    private String inputWords;
    private String[] resultArray;

    @Test
    public void getWordsWithRisingSymbols_ABC_ReturnsOneWord() {
         inputWords = "ABC";
         resultArray = MainLambda.getWordsWithRisingSymbols(inputWords);

        assertEquals(1, resultArray.length);
        assertEquals(inputWords, resultArray[0]);
    }

    @Test
    public void getWordsWithRisingSymbols_CBA_ReturnsEmptyArray() {
        inputWords = "CBA";
        resultArray = MainLambda.getWordsWithRisingSymbols(inputWords);
        assertEquals(0, resultArray.length);
    }

    @Test
    public void getWordsWithRisingSymbols_ABCandCBAandAAAAandCDRW_ReturnsTwoWords() {
        inputWords = "ABC cba aaaa CDRW";
        resultArray = MainLambda.getWordsWithRisingSymbols(inputWords);

        assertEquals(2, resultArray.length);
        assertEquals("ABC", resultArray[0]);
        assertEquals("CDRW",resultArray[1]);
    }

    @Test
    public void getWordsWithRisingSymbols_CBAandTEXTandTEST_ReturnsEmptyArray() {
        inputWords = "cba text test";
        resultArray = MainLambda.getWordsWithRisingSymbols(inputWords);

        assertEquals(0, resultArray.length);
    }

    @Test
    public void getWordsWithRisingSymbols_WordsWithDifferentCase_ReturnsThreeWords() {
        inputWords = "ESet Yes Tru";
        resultArray = MainLambda.getWordsWithRisingSymbols(inputWords);

        assertEquals(3, resultArray.length);
        assertEquals("ESet", resultArray[0]);
        assertEquals("Yes", resultArray[1]);
        assertEquals("Tru", resultArray[2]);
    }



    @Test (expected = IllegalArgumentException.class)
    public void getWordsWithRisingSymbols_Null_ReturnsException() {
        resultArray = MainLambda.getWordsWithRisingSymbols(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWordsWithRisingSymbols_EmptyWord_ReturnsException() {
        resultArray = MainLambda.getWordsWithRisingSymbols("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWordsWithRisingSymbols_WhiteSpace_ReturnsException() {
        resultArray = MainLambda.getWordsWithRisingSymbols("\t\n");
    }

}