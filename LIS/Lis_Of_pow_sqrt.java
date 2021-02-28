package LIS;

import java.util.Arrays;

public class Lis_Of_pow_sqrt
{
    public static boolean Condition(int a, int b)
    {
        if(a==(int)Math.pow(b,2)||b==(int)Math.pow(a,2))return true;
        return false;
    }
    public static int lis_of_sqrt_pow_length(int [] arr)
    {
        int n=arr.length;
        int [] counter=new int[n];
        for(int i=0;i<n;i++)
        {
            counter[i]=1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(Condition(arr[i],arr[j])&&counter[j]+1>counter[i])counter[i]=counter[j]+1;
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(counter[i]>max)max=counter[i];
        }
       // System.out.println(Arrays.toString(counter));
        return max;
    }

    public static int [] lis_of_sqrt_pow(int [] arr)
    {
        int n=arr.length;
        int [] counter=new int[n];
        for(int i=0;i<n;i++)
        {
            counter[i]=1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(Condition(arr[i],arr[j])&&counter[j]+1>counter[i])counter[i]=counter[j]+1;
            }
        }
        int max=0;
        int index_max=0;
        for(int i=0;i<n;i++)
        {
            if(counter[i]>max)
            {
                index_max=i;
                max=counter[i];
            }
        }
        int [] ans=new int[max];

        while(max>0)
        {
            for(int i=0;i<index_max;i++)
            {
                if(Condition(arr[i],arr[index_max])&&counter[i]+1==counter[index_max])
                {
                    ans[max-1]=arr[index_max];
                    index_max=i;
                    max--;
                    break;
                }
            }
            if(index_max==0)
            {
                ans[0]=arr[index_max];
                break;
            }
        }
        //System.out.println("hey 2 !!!");
        return ans;

    }

    public static void main(String [] args)
    {
        int [] arr={2,3,4,9,81,16,256};
        System.out.println("the length of condition lis is : "+ lis_of_sqrt_pow_length(arr));
       System.out.println("the condition lis is : "+ Arrays.toString(lis_of_sqrt_pow(arr)));
    }
}
