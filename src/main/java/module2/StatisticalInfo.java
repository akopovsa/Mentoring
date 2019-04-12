package module2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticalInfo {

    private static int[] data = {206,430,73,30,293,322,42,36,447,229};

    private static int arithmetic_mean(int[] data){
        int sum=0;
        int result;
        for(int i:data){
            sum+=i;
        }
        result=sum/data.length;
        return result;
    }

    private static double median(int[] data){
        Arrays.sort(data);
        double result;
        if (data.length%2==0){
            result=(double)(data[data.length/2]+data[data.length/2-1])/2;
        }else{
            result=data[data.length/2];
        }
        return result;

    }

    private static void mode(int[] data){
        int maxCount = 0;
        Map<Integer,Integer> modes = new HashMap<Integer,Integer>();

        for(int i=0;i<data.length;i++) {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[i] == data[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                modes.clear();
                modes.put(data[i],count);
            }else if(count == maxCount){
                modes.put(data[i],count);
            }
        }
        if(modes.size()==data.length){
            System.out.println("The are no modes.");
        } else {
            for (Map.Entry<Integer, Integer> entry : modes.entrySet()) {
                System.out.println("Mode is: "+ entry.getKey() + " with count: " + entry.getValue());
            }
        }
    }

    private static double standardDeviation(int[] data){
        int k=0;
        int mean = arithmetic_mean(data);
        double s;

        for (int i:data){
            k+=Math.pow((i - mean),2);
        }
        s=Math.sqrt(k/data.length);
        return s;
    }

    public static void main (String[] args){
        System.out.println("Data set: "+ Arrays.toString(data));
        System.out.println("The arithmetic mean is: " + arithmetic_mean(data));
        System.out.println("The median is: " + median(data));
        mode(data);
        System.out.println("The standard deviation is: "+ standardDeviation(data));
    }
}
