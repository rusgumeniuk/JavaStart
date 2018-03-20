package Lab1StarterKit;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void mbTrueCountSuperPrimes()
    {
        assertEquals(0,(long) Main.CountSuperPrimes(0));
        assertEquals(4, (long) Main.CountSuperPrimes(10) );//2,3,5,7
        assertEquals(13,(long) Main.CountSuperPrimes(100));//2,3,5,7,11,13,17,31,37,71,73,79,97
        assertEquals(34,(long) Main.CountSuperPrimes(500));
        assertEquals(56, (long) Main.CountSuperPrimes(1000));
    }
    @org.junit.Test
    public void mbFalseCountSuperPrimes1()
    {
        assertNotEquals(10,(long) Main.CountSuperPrimes(50));//mb 9//2,3,5,7,11,13,17,31,37
    }
    @org.junit.Test
    public void mbFalseCountSuperPrimes2()
    {
        assertNotEquals(20,(long) Main.CountSuperPrimes(150));//mb 18// 149, 131,113,107,101,97,79,73,71,37,31,17,13,11,7,5,3,2,
    }
    @org.junit.Test
    public void mbFalseCountSuperPrimes3()
    {
        assertNotEquals(6,(long) Main.CountSuperPrimes(11));//mb 5
    }

    // перевірка на простоту
    @org.junit.Test
    public void mbTrueIsPrimeNumber()
    {
        assertEquals(true, Main.IsPrimeNumber(11));
        assertEquals(true, Main.IsPrimeNumber(13));
        assertEquals(true, Main.IsPrimeNumber(71));
        assertEquals(true, Main.IsPrimeNumber(991));
        assertEquals(true, Main.IsPrimeNumber(3491));

        assertEquals(false, Main.IsPrimeNumber(4));
        assertEquals(false, Main.IsPrimeNumber(8));
        assertEquals(false, Main.IsPrimeNumber(120));
        assertEquals(false, Main.IsPrimeNumber(1000));
        assertEquals(false, Main.IsPrimeNumber(5000));
    }
}