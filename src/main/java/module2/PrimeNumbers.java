package module2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {
    private static long range_from;
    private static long range_to;
    private static List<Long> primes;

    private static void input (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter range parameter - from:");
        range_from = scanner.nextInt();
        System.out.println("Enter range parameter - to:");
        range_to = scanner.nextInt();
    }

    private static void isPrimeNumber(){
        primes = new ArrayList<Long>();
        for (long i=range_from; i<= range_to; i++){

            boolean isPrime = true;
            if( i==0 || i==1){
                continue;
            }

            for(long j=2; j*j<=i; j++ ){
                if (i%j==0){
                    isPrime=false;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
        }
    }

    private static void output (){
        String msg = "All prime numbers in range from : %s to: %s are %s";
        System.out.printf(msg,range_from,range_to,primes);
    }


    public static void main (String[] args){
        input();
        isPrimeNumber();
        output ();
    }
}

