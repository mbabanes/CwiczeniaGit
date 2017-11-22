package pckg;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) throws Exception
    {

        wordCounter();


    }

    private static void wordCounter() throws IOException
    {
        String txt = new String(Files.readAllBytes(Paths.get(Main.class.getResource("/text.txt").getPath().substring(1))), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(txt.split("\\PL+"));

        findLongesWord(words);
        long counter = words.stream().filter( s -> s.length() > 5).count();
//        System.out.println(counter);
    }


    private static void findLongesWord(List<String> words)
    {
        Optional<String> longesWord = words.stream().max(String::compareToIgnoreCase);
//        String length = longesWord.
        System.out.println("Najdluzszy wyraz to: " + longesWord + " posiada: " + longesWord.get().length() + " znaków.");
    }
}
