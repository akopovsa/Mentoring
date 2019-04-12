package module2;

import java.util.Arrays;
import java.util.Scanner;

public class SequentialSearch {

    private static int[] arr = {158,207,392,62,315,434,315,268,405,241};
    private static int number;
    private static int found=0;


    private static void input (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to search:");
        number = scanner.nextInt();

    }

    private static void search(int[] arr, int number) {
        System.out.printf("Defined array: %s ", Arrays.toString(arr));
        System.out.println("");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                System.out.printf("Number %s was found on possition %s", number, i);
                System.out.println("");
                found++;
            }
        }
        if (found == 0) {
            System.out.printf("Number %s is not present in defined array.",number);
        }
    }


    public static void main (String[] args){
        input();
        search(arr, number);
    }
}

