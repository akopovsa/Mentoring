package module6.codec_rle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodecRLE {

    private static void code(String input) {

        List<Character> stringToList = stringToList(input);
        StringBuffer coded = new StringBuffer();
        char slash = '/';
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};

        for (int i=0; i<stringToList.size();i++){
            int count=1;
            if(stringToList.get(i) == slash || new String(numbers).indexOf(stringToList.get(i))>-1){
                coded.append("/");
                coded.append(stringToList.get(i));
                }
            else{
            while (i+1<stringToList.size() && stringToList.get(i)==stringToList.get(i+1)){
                count++;
                i++;
            }
                coded.append(count);
                coded.append(stringToList.get(i));
            }
        }
        System.out.println("Coded: "+ coded.toString());
        System.out.println("\n");

    }

    private static void decode(String input) {
        List<Character> stringToList = stringToList(input);
        StringBuffer decoded = new StringBuffer();

        char slash = '/';
        for (int i=0; i<stringToList.size();i++){

            if(stringToList.get(i) == slash){
                decoded.append(stringToList.get(i+1));
                i++;
            }else{
                int count = 0;
                while(count<Integer.parseInt(String.valueOf(stringToList.get(i)))){
                    decoded.append(stringToList.get(i+1));
                    count++;

                }
                i++;
            }

        }
        System.out.println("Decoded: "+ decoded.toString());
        System.out.println("\n");


    }

    private static List<Character> stringToList(String input){
        System.out.println("Input string: "+ input);
        List<Character> stringToList = input.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        return stringToList;
    }


    public static void main(String[] args) {

        code("AAAAaaaBBBBBB/12");
        code("AaaaBB2");
        code("AaaaBB//2");

        decode("4A3a6B///1/2");
    }




}
