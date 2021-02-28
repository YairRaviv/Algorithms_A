package Implementations;

import java.util.Arrays;

public class Median
{
    public static int Median(int [] arr)
    {
        if(arr.length<=64)
        {
            return Max_Array.max(arr);
        }
        else
        {
            int [] first_64=new int[64];
            for(int i=0;i<64;i++)
            {
                first_64[i]=arr[i];
            }
            return Max_Array.max(first_64);
        }
    }

    public static int [] merge_median(int [] a,int [] b)
    {
        int n=a.length;
        int [] result=new int [n];

        for(int i=0;i<n;i++)
        {
            result[i]=Math.max(a[i],b[n-i]);
        }
        return result;
    }

    public static void main(String [] args)
    {
        int [] arr=new int[2000];
        for (int i=0;i<2000;i++)
        {
            arr[i]=(int)(Math.random()*10000)+1;
        }
        System.out.println("the array is : "+ Arrays.toString(arr));
        System.out.println("the median is :"+arr[Median(arr)]);



    }
}
