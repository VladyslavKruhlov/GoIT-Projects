import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        List<Integer> zip = zip(first, second).collect(Collectors.toList());
        System.out.println(zip);
    }

    public static Stream<Integer> first = Stream.of(1, 2, 3, 4, 5);
    public  static Stream<Integer> second = Stream.of(6, 7, 8, 9, 0, 1, 2);

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> result = new ArrayList<>();
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            result.add(iterator1.next());
            result.add(iterator2.next());
        }
        return result.stream();
    }
}
