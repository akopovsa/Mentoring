package module2;

import java.util.Scanner;

public class NumberToText {

    private static int range_from;
    private static int range_to;
    private static final String[] tensNames = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static final String[] numNames = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static void input (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any range from: 0 to 10000");
        System.out.println("Enter range parameter - from:");
        range_from = scanner.nextInt();
        System.out.println("Enter range parameter - to:");
        range_to = scanner.nextInt();
    }

    private static void converter(int num){
        if(num==0){
            System.out.println("zero");

        }else if (num >=0 && num <=19){
            System.out.println(numNames[num]);

        } else if(num >=20 && num <=99){
            System.out.println(tensNames[num/10]+setTire(num)+numNames[num%10]);

        }else if (num >=100 && num <=999){
            System.out.println(numNames[num/100]+" "+"hundred "+tensNames[(num%100)/10]+setTire(num)+numNames[(num%100)%10]);

        }else if(num >=1000 && num <=9999){
            System.out.println(numNames[num/1000]+" "+"thousand "+numNames[(num%1000)/100]+" hundred "+tensNames[((num%1000)%100)/10]+setTire(num)+numNames[((num%1000)%100)%10]);

        }else if(num ==10000){
            System.out.println("ten thousand");
        }

    }

    private static String setTire(int i){
        String tire = "-";
        if (i%10==0 || (i%100)%10==0 ||((i%1000)%100)%10==0){
            tire = "";
        }
        return tire;
    }

    public static void main (String[] args){
        input();
        for (int i=range_from; i<= range_to; i++){
            converter(i);
        }
    }
}
