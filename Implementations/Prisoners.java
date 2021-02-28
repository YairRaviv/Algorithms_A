package Implementations;

import java.util.Arrays;

public class Prisoners
{
    public static boolean prisoners(boolean [] arr)
    {
        boolean light=false;
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=false;
        }
        int counter=0;
        System.out.println("im here 2");
        while(counter<arr.length)
        {
            int prisoner=(int)(Math.random()*(arr.length));
            if(prisoner==0)
            {
                if(!arr[0])
                {
                    //counter++;
                    arr[0]=true;
                }
                if(!light)
                {
                    light=true;
                    counter++;
                }
            }
            else
            {
                if(arr[prisoner]==false&&light)
                {
                    arr[prisoner]=true;
                    light=false;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("im here 2");
        for(int i=0;i< arr.length;i++)
        {
            if(!arr[i])return false;
        }
        return true;
    }


    public static void main(String [] args)
    {
        boolean [] arr=new boolean[5];
        System.out.println(prisoners(arr));
    }
}
