import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Names> names = List.of(
                new Names("Vova"),
                new Names("Sasha"),
                new Names("Olga"),
                new Names("Masha")
        );

//        System.out.println(listToUpperCase(names));
        System.out.println(convertNamesToNamesString(names));
    }
//    public static List<String> listToUpperCase (List<Names> names){
//        List<String> upperNames = new ArrayList<>();
//
//        for (int i=0; i<names.size(); i++ ){
//            String s = names.get(i).toString();
//            upperNames.add(s);
//            upperNames.set(i, s.toUpperCase());
//            Collections.sort(upperNames, Comparator.reverseOrder());
//        }
//
//        return upperNames;
//    }

    public static String convertNamesToNamesString(List<Names> names){
        return names.stream()
                .map(Names::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "))
                .toUpperCase();
    }
}
