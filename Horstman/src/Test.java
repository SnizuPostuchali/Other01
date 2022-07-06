import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String n = null;

//        String name = Objects.requireNonNullElse(n, "not null");
//        System.out.println(name);

        Stream<String> echos
                = Stream.generate(() -> "Echo");
        System.out.println(List.of(echos));

    }
}
