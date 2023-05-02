import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        List<Names> names = List.of(
                new Names("Vova"),
                new Names("Sasha"),
                new Names("Sonya"),
                new Names("Masha"),
                new Names("Lera"),
                new Names("Eli")
        );

//        StringBuilder sb = new StringBuilder();
//        String delim = ", ";
//        int i = 0;
//
//        while (i < nameFilters(names).size()-1) {
//            sb.append(nameFilters(names).get(i));
//            sb.append(delim);
//            i++;
//        }
//        sb.append(nameFilters(names).get(i));
//
//        System.out.println(sb);

        System.out.println(nameFilters(names));
    }

//    public static List<String> nameList (List<Names> names){
//
//        List<String> name = new ArrayList<>();
//
//        for (int i=0; i< names.size(); i++){
//            if(i%2!=0){
//                name.add(i+". "+names.get(i));
//            }
//        }
//        return name;
//    }

    public  static  String nameFilters(List<Names> names){
        return IntStream.range(0, names.size())
                .filter(i ->i%2!=0)
                .mapToObj(i->i+". "+names.get(i))
                .collect(Collectors.joining(", "));
    }
}
