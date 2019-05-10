package module6.codec_rle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodecRLE {

    private static String input = "AA";

//    public static List<Character> convertStringToCharList(String str) {
//        return str
//               .chars()
//               .mapToObj(e -> (char) e)
//               .collect(Collectors.toList());
//    }


    private static String code(String input) {

        System.out.println(input);


        char[] list = input.toCharArray();
        List <String> coded_list = new ArrayList<>();
        int k;
        int count = 1;

        for (int i = 0; i< list.length-1; i++){
            for(k=i+1;k<list.length;k++){
                if(list[i] == list[k]){
                    count++;
                } else {
                    break;
                }
            }
            coded_list.add(Integer.toString(count)+list[i]);
            count=1;
            i=k-1;
        }
        System.out.println(coded_list);
        return null;
    }

    private static String decode() {

        return null;
    }


    public static void main(String[] args) {
        code(input);
    }


}
