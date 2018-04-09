package Lab7IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainIO {
    public static void main(String[] args) {
        char s = 65;

        System.out.println(s);
        System.out.println((int)'A');
    }

    public static char getCryptedChar(Character symbol, Character key){
        if(symbol == null || key == null || symbol.toString().isEmpty() || key.toString().isEmpty()) throw new IllegalArgumentException();
        return (char)((int)symbol + (int)key);
    }
    public static char getDecryptedChar(Character symbol, Character key){
        if(symbol == null || key == null || symbol.toString().isEmpty() || key.toString().isEmpty() || (int)symbol < (int)key) throw new IllegalArgumentException();
        return (char)((int)symbol - (int)key);
    }

    public static String getCryptedString(String text, Character keyCharacter){
        if(keyCharacter == null || keyCharacter.toString().isEmpty() || text.isEmpty()) throw new IllegalArgumentException();
        StringBuilder cryptedText = new StringBuilder();
        for (Character symbol:  text.toCharArray()) {
            cryptedText.append(getCryptedChar(symbol,keyCharacter));
        }
        return cryptedText.toString();
    }
    public static String getDecryptedString(String text, Character keyCharacter){
        if(keyCharacter == null || keyCharacter.toString().isEmpty() || text.isEmpty()) throw new IllegalArgumentException();
        StringBuilder deCryptedText = new StringBuilder();
        for (Character symbol:  text.toCharArray()) {
            deCryptedText.append(getDecryptedChar(symbol,keyCharacter));
        }
        return deCryptedText.toString();
    }

    public static String getDecryptedTextFromFile(String path, Character key) throws IOException {
        StringBuilder decryptedText = new StringBuilder();
        try(FileInputStream fis = new FileInputStream(path)){
            int i;
            while((i=fis.read())!=-1)
                decryptedText.append(getCryptedChar((char) i, key));
            return decryptedText.toString();
        }
        catch (IOException ex){
            throw new IOException(ex);
        }
    }
    public static void writeCryptTextToFile(String path, String text, Character key) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(path)){
            byte[] buffer = getCryptedString(text,key).getBytes();
            fos.write(buffer,0,buffer.length);
        }
        catch (IOException ex){
            throw new IOException(ex);
        }
    }
}
