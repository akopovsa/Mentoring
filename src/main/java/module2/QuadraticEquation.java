package module2;

import java.util.Scanner;

public class QuadraticEquation {
    private static double a;
    private static double b;
    private static double c;


    private static void input (){
        System.out.println("Enter the coefficients of the quadratic equation");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coefficient a");
        a = scanner.nextInt();
        System.out.println("Enter the coefficient b");
        b = scanner.nextInt();
        System.out.println("Enter the coefficient c");
        c = scanner.nextInt();
        System.out.printf("Quadratic equation %s*x*x+%s*x+%s=0",a,b,c);
        System.out.println(" ");
    }

    private static void determinant (){
        double det = Math.pow(b,2) - 4*a*c;
        if(det>0){
            System.out.printf("Roots are %s and %s",(-b+Math.sqrt(det))/2*a,(-b-Math.sqrt(det))/2*a);

        }else if(det==0){
            System.out.printf("There is only one root %s", -b/2*a);

        } else {
            System.out.println("There is no solution");
        }
    }


    public static void main (String[] args){
        input();
        determinant();
    }

}
