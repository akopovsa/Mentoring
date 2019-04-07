package module2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAlgorithm {
    private static Integer[] data  = new Integer[] {206,430,73,30,293,322,42,36,447,229};
    private static List<Integer> list = Arrays.asList(data);


    private static void sort(){
        List<Integer> asc = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sort in ascending order:");
        asc.forEach(l-> System.out.println(l));
        System.out.println("");
        System.out.println("Sort in descending order:");
        List<Integer> desc = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        desc.forEach(l->System.out.println(l));

    }

    public static void main (String[] args){
        sort();
    }
}
