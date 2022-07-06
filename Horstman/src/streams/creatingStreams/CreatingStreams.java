package streams.creatingStreams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingStreams {
    public static  <T> void show(String title, Stream<T> stream){
        final int SIZE = 10;
        List<T> firstElements = stream
                .limit(SIZE+1)
                .collect(Collectors.toList());
        System.out.print(title + ": ");
        for (int i=0; i < firstElements.size(); i++){
            if(i>0){
                System.out.print(", ");
            }
            if(i<SIZE){
                System.out.print(firstElements.get(i));
            } else {
                System.out.println("...");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    throws IOException
    {
        Path path = Paths.get("C:\\Users\\Master\\Desktop\\X\\streamEx.txt");
        var contents  = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream <String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);
        Stream<String> silence = Stream.empty();
        show("silemce", silence);

        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);
        Stream<Double> reandoms = Stream.generate(Math::random);
        show("randoms", reandoms);
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers", integers);
        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("words another way", wordsAnotherWay);

        try(Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1))
        {
            show("lines", lines);
        }

        Iterable<Path> iterable =
                FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectories = StreamSupport.stream(
                iterable.spliterator(), false);
        show("rootDirectories", rootDirectories);

        Iterator<Path> iterator = Paths.get("C:\\Users\\Master\\Desktop\\X\\streamEx.txt").iterator();
        Stream<Path> pathComponents = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
        show("pathComponents", pathComponents);
    }
}
