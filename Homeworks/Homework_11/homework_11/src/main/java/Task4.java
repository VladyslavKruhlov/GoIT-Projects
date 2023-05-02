import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {

    public static void main(String[] args) {
            System.out.println(generator(2, 1, 3, 7, 8));
    }
    public  static List<Long> generator (long first, long a, long c, long m , int limit){
        return Stream.iterate(first, x ->(a * x + c) % m)
                .limit(limit)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
