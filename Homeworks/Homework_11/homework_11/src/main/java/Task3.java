import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static String[] arr = {"1, 2, 0", "4, 5"};
    public static List<String> list = List.of(arr);

    public static String convertNamesToNamesString(List<String> list){
        return list.stream()
                .map(str ->List.of(str.split(", ")))
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        String deliver = ", ";
//
//        for (int i = 0; i < arr.length; i++) {
//            if (i != arr.length - 1) {
//                sb.append(arr[i]);
//                sb.append(", ");
//            } else {
//                sb.append(arr[i]);
//            }
//        }
//        System.out.println("sb = "+sb);
//
//        String [] array = sb.toString().split(", ");
//
//        List<Integer> numbers = new ArrayList<>();
//
//        for (int j = 0; j < array.length; j++) {
//            numbers.add(Integer.parseInt(array[j]));
//        }
//
//        List<Integer> numbersStream = numbers.stream().sorted().collect(Collectors.toList());

          System.out.println(convertNamesToNamesString(list));
    }
}
