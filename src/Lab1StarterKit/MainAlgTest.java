package Lab1StarterKit;

import static org.junit.Assert.*;

public class MainAlgTest {

    @org.junit.Test
    public void mbTrueCountSuperPrimes()
    {
        assertEquals(0,(long) MainAlg.CountSuperPrimes(0));
        assertEquals(4, (long) MainAlg.CountSuperPrimes(10) );//2,3,5,7
        assertEquals(13,(long) MainAlg.CountSuperPrimes(100));//2,3,5,7,11,13,17,31,37,71,73,79,97
        assertEquals(34,(long) MainAlg.CountSuperPrimes(500));
        assertEquals(56, (long) MainAlg.CountSuperPrimes(1000));
    }
    @org.junit.Test
    public void mbFalseCountSuperPrimes1()
    {
        assertNotEquals(10,(long) MainAlg.CountSuperPrimes(50));//mb 9//2,3,5,7,11,13,17,31,37
    }
    @org.junit.Test
    public void mbFalseCountSuperPrimes2()
    {
        assertNotEquals(20,(long) MainAlg.CountSuperPrimes(150));//mb 18// 149, 131,113,107,101,97,79,73,71,37,31,17,13,11,7,5,3,2,
    }
    @org.junit.Test
    public void mbFalseCountSuperPrimes3()
    {
        assertNotEquals(6,(long) MainAlg.CountSuperPrimes(11));//mb 5
    }

    // перевірка на простоту
    @org.junit.Test
    public void mbTrueIsPrimeNumber()
    {
        assertEquals(true, MainAlg.IsPrimeNumber(11));
        assertEquals(true, MainAlg.IsPrimeNumber(13));
        assertEquals(true, MainAlg.IsPrimeNumber(71));
        assertEquals(true, MainAlg.IsPrimeNumber(991));
        assertEquals(true, MainAlg.IsPrimeNumber(3491));

        assertEquals(false, MainAlg.IsPrimeNumber(4));
        assertEquals(false, MainAlg.IsPrimeNumber(8));
        assertEquals(false, MainAlg.IsPrimeNumber(120));
        assertEquals(false, MainAlg.IsPrimeNumber(1000));
        assertEquals(false, MainAlg.IsPrimeNumber(5000));
    }
}