package Crystal_Balls_Problem;

import java.util.Arrays;

public class Crystal_2_Balls
{
    public static int Crystal_2_Balls(int [] arr,int break_floor)
    {
        int num=1;
        int n=arr.length;
        while(n>(num*(num+1)/2))
        {
            num++;
        }
        int curr=num;
        int step=num-1;
        int num_of_checks=0;
        while(arr[curr]<break_floor)
        {
            num_of_checks++;
            curr+=step;
            step--;
            if(curr>=n)curr=n-1;
        }
        num_of_checks++;
        System.out.println("the first ball break at floor: "+curr);
        curr-=step-1;
        while (arr[curr]<break_floor)
        {
            num_of_checks++;
            curr++;
        }
        num_of_checks++;
        System.out.println("the min floor of ball breaking is : "+curr);
        System.out.println("num of checks is : "+num_of_checks);
        return curr;
    }
    public static int Crystal_Balls(int balls,int floors)
    {
        if(floors==0||balls==0)return 0;
        int [][] mat=new int[balls+1][floors+1];
        for(int i=0;i<floors+1;i++)
        {
            mat[0][i]=0;
            mat[1][i]=i;

        }

        for(int i=0;i<balls+1;i++)
        {
            mat[i][0]=0;
            mat[i][1]=1;

        }
        mat[0][1]=0;

        int res;
        for(int i=2;i<balls+1;i++)
        {
            for(int j=2;j<floors+1;j++)
            {
                mat[i][j]=Integer.MAX_VALUE;
                for(int k=1;k<=j;k++)
                {
                    res=1+Math.max(mat[i-1][k-1],mat[i][j-k]);
                    if(res<mat[i][j])mat[i][j]=res;
                }
            }

        }
        for(int i=0;i<balls+1;i++)
        {
            System.out.println(Arrays.toString(mat[i]));
        }
        return mat[balls][floors];

    }




    public static void main(String [] args)
    {
        int [] arr = new int[100];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=i+1;
        }
        int a=Crystal_Balls(3,6);
        System.out.println(a);
    }
}
