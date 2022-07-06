package streams.countLongWords;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException{
        var contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\Master\\Desktop\\X\\streamEx.txt")), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\\PL+"));
        System.out.println(words);


        long count = 0;
        for (String w: words){
            if(w.length()>6){
                count++;
            }
        }
        System.out.println(count);

        count = words.stream()
                .filter(w -> w.length()>6).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length()>6).count();
        System.out.println(count);
    }
}
