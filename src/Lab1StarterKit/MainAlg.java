package Lab1StarterKit;

public class MainAlg {
    //Exercise 8
    public static void main(String[] args)
    {
        System.out.println("count: " + CountSuperPrimes(10));
    }
    public static Integer CountSuperPrimes(Integer n)    {
        Integer k = 0;
        while(n > 0)
        {
            if(IsSuperPrimeNumber((n))) k++;
            n--;
        }
        return k;
    }
    public static Boolean IsPrimeNumber(Integer n)
    {
        return n < 2 ? false : IsPrimeNum(n,n-1);
    }
    private static Boolean IsPrimeNum(Integer n, Integer m)    {
        if(m == 1) return  true;
        if(n % m != 0) return IsPrimeNum(n,m-1);
        return false;
    }
    private static Boolean IsSuperPrimeNumber(Integer n)    {
        return IsPrimeNumber(n) && (IsPrimeNumber(ReverseInt(n)) ? true : false);
    }
    private static Integer ReverseInt(Integer n)    {
        char[] s = n.toString().toCharArray();
        StringBuilder t = new StringBuilder();
        for(Integer i = s.length - 1; i >= 0; i--)
        {
            if(s[i] != '-') t.insert(t.length(), s[i]);
            else t.insert(0,'-');
        }
        return Integer.parseInt(t.toString());
    }
}
 /*
  Розробити функцію, яка визначає кількість надпростих чисел в натуральному ряді
  Функція приймає на вхід натуральне число не більше 1000.
  Надпростим називається число, якщо воно є простим та число,
  яке отримане з нього записом цифр у зворотному порядку, теж є простим.
  */
