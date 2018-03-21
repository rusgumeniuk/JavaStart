package Lab5CollectionsIO;


import java.io.*;
import java.util.*;

/*
Написати програму, яка зчитує дані з текстового файлу та записує рядки в інший файл в порядку зменшення
рядок з найменшою кількістю символів записується першим, рядок із найбільшою кількістю символів записується останнім.
 */
public class MainIO {
    public static void main(String[] args) {

        String firstFilePath = "C://Users//Omman//Desktop//input.txt";
        String secondFilePath = "C://Users//Omman//Desktop//output.txt";

        String[] inputInfo = getStringArrayFromFile(firstFilePath);
        String[] sortedInfo = getSortedArrayByLength(inputInfo);

        StringBuilder textToWrite = new StringBuilder();
        for (String str: sortedInfo)
        {
            textToWrite.append(str).append("\r\n");
        }

        writeTextToFile(secondFilePath,textToWrite.toString());

        System.out.println(textToWrite.toString().equals(getStringFromFile(secondFilePath)));
        System.out.println(getStringFromFile(firstFilePath).equals(getStringFromFile(secondFilePath)));
        System.out.println(Arrays.toString(inputInfo));
        System.out.println(Arrays.toString(sortedInfo));
    }

    private static void printTask(int i){
        System.out.println(("\n" + "Task #" + i).toUpperCase());
    }

    protected static String[] getSortedArrayByLength(String[] array){
        String[] newArray = array.clone();
        for(int i = 0; i < newArray.length; ++i)
        {
            for(int j = 0; j < newArray.length; ++j)
            {
                if(newArray[i].length() < newArray[j].length()){
                    String s = newArray[j];
                    newArray[j] = newArray[i];
                    newArray[i] = s;
                }
            }
        }
        return newArray;
    }
    protected static String[] getStringArrayFromFile(String path){
        ArrayList<String> inputData = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String s;
            while((s  = reader.readLine()) != null)
            {
                s = s.trim();
                if(s.length() > 0) inputData.add(s);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return inputData.toArray(new String[inputData.size()]);
    }
    protected static String getStringFromFile(String path){
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
            System.out.println(ex.getMessage());
        }
        return info.toString();
    }
    protected static boolean writeTextToFile(String path, String text){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path)))
        {
            writer.write(text);
            return true;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
