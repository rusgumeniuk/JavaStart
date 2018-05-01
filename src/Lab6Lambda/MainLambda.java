package Lab6Lambda;
import java.util.Arrays;
import java.util.List;

public class MainLambda {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getWordsWithRisingSymbols("abc loles yes d cd 123 101 333")));
        System.out.println(Arrays.toString(getWordsWithRisingSymbols("abc loles yes d cd")));
    }

    private static String[] getWordsWithRisingSymbols(String words){
        return  List.of(words.split(" ")).stream()
                .filter(word -> {
                    char[] array = word.toCharArray();
                    for(int i = 0; i < word.length()-1; ++i)
                    {
                        if((int)array[i+1] < (int)array[i])return  false;
                    }
                    return true;
                })
                .toArray(String[]::new);
    }
}


