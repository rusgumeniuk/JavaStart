package Lab6Lambda;
import java.util.Arrays;
import java.util.List;

public class MainLambda {

     static String[] getWordsWithRisingSymbols(String words) throws IllegalArgumentException{
         if(words == null || words.isEmpty() || words.trim().isEmpty()) throw new IllegalArgumentException();
        return  List.of(words.split(" ")).stream()
                .filter(word -> {
                    char[] array = word.toCharArray();
                    for(int i = 0; i < word.length()-1; ++i)
                    {
                        if((int)array[i+1] <= (int)array[i])return  false;
                    }
                    return true;
                })
                .toArray(String[]::new);
    }
}


