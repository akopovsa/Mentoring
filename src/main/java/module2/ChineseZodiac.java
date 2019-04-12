package module2;

import java.util.Scanner;

public class ChineseZodiac {

    private static int year;
    private static String chineseYear;


    private static void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year:");
        year = scanner.nextInt();
    }

    private static void chineseYearCalculator(){

        int reminder = year%12;

        switch (reminder) {
            case 0:
                chineseYear = "Monkey";
                break;
            case 1:
                chineseYear ="Rooster";
                break;
            case 2:
                chineseYear ="Dog";
                break;
            case 3:
                chineseYear ="Pig";
                break;
            case 4:
                chineseYear ="Rat";
                break;
            case 5:
                chineseYear ="Ox";
                break;
            case 6:
                chineseYear ="Tiger";
                break;
            case 7:
                chineseYear ="Rabbit";
                break;
            case 8:
                chineseYear ="Dragon";
                break;
            case 9:
                chineseYear ="Snake";
                break;
            case 10:
                chineseYear ="Horse";
                break;
            case 11:
                chineseYear ="Goat";
                break;
            default:
                chineseYear ="Holy Moly !!! Something go wrong! ";
        }

    }

    private static void output(){
        String msg = "%s year in Gregorian calendar is year of %s in Chinese calendar";
        System.out.printf(msg,year,chineseYear);
    }


    public static void main (String[] args){
        input();
        chineseYearCalculator();
        output();
    }


}
