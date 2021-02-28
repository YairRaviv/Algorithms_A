package LIS;

import java.util.Arrays;

public class LIS_diff_1
{
    public static int diff_1_lis(int [] arr)
    {
        int n=arr.length;
        int [] counter=new int[n];
        for(int i=0;i<n;i++)
        {
            counter[i]=1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(condition(arr[i],arr[j])&&counter[j]+1>counter[i])counter[i]=counter[j]+1;
            }
        }
        int max=0;
        int index=0;
        for(int i=0;i<n;i++)
        {
            if(counter[i]>max)
            {
                index=i;
                max=counter[i];
            }
        }
        int ans[]=new int [max];
        System.out.println("the max subserial with 1 diff length is : "+max);
        max--;
        while(max>=0)
        {
            if(index==0)
            {
                ans[0]=arr[0];
                break;
            }
            for(int j=0;j<index;j++)
            {
                if(condition(arr[index],arr[j])&&counter[index]==counter[j]+1)
                {
                    ans[max]=arr[index];
                    max--;
                    index=j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(ans));
        return 0;
    }

    public static boolean condition(int a,int b)
    {
        return(Math.abs(a-b)<=1);
    }
    public static void main(String [] args)
    {
        int [] arr={2,3,4,9,5,10,4,11,10};
        System.out.println("the condition lis is : "+ diff_1_lis(arr));
    }
}





