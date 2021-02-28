package Implementations;

import java.util.Arrays;
import java.util.LinkedList;

public class Max_Min_Array
{
    public static void max_min(int [] arr)
    {
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        if(arr[1]>arr[0])
        {
          max=arr[1];
          min=arr[0];
        }
        else
        {
            max=arr[0];
            min=arr[1];
        }

        for(int i=2;i<arr.length-2;i++)
        {
            if(arr[i+1]>arr[i])
            {
                if(arr[i+1]>max)max=arr[i+1];
                if(arr[i]<min)min=arr[i];
            }
            else
            {
                if(arr[i]>max)max=arr[i];
                if(arr[i+1]<min)min=arr[i+1];
            }
        }
        if(arr.length%2!=0)
        {
            if(arr[arr.length-1]>max)max=arr[arr.length-1];
            if(arr[arr.length-1]<min)min=arr[arr.length-1];
        }
        System.out.println("the array is : "+ Arrays.toString(arr));
        System.out.println("max value is: "+max);
        System.out.println("min value is : "+min);
    }

    public static void main(String [] args)
    {
       int [] arr=new int[20];
       for (int i=0;i<20;i++)
       {
           arr[i]=(int)(Math.random()*100)+1;
       }
       max_min(arr);

    }

}
