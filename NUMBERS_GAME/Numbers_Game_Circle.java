package NUMBERS_GAME;

import java.util.Arrays;
import java.util.LinkedList;

public class Numbers_Game_Circle
{
    public static int[][] build_matrix(int [] arr)
    {
        int n=arr.length;
        int [][] mat =new int[n][n];
        for(int i=0;i<n;i++)
        {
            mat[i][i]=arr[i];
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                mat[i][j]=Math.max(arr[i]-mat[i+1][j],arr[j]-mat[i][j-1]);
            }
        }
        for(int i=0;i< mat.length;i++)
        {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println();
        return mat;
    }
    public static int Circle_game(int [] arr)
    {
        int n=arr.length;
        int [] circle=new int[2*n];
        for(int i=0;i<n;i++)
        {
            circle[i]=arr[i];
        }
        System.out.println("Circle is "+Arrays.toString(circle));
        for(int i=n;i<2*n;i++)
        {
            circle[i]=circle[i-n];
        }
        int max_profit=Integer.MIN_VALUE;
        int start_index=-1;
        for(int i=0;i<n;i++)
        {
            int [] tmp=new int [n];
            for(int j=0;j<n;j++)
            {
                tmp[j]=circle[j+i];
            }
            int prof=game(tmp);
            if(prof>max_profit)
            {
                max_profit=prof;
                start_index=i;
            }
        }
        return start_index;
    }
    public static int game(int [] arr)
    {
        int n=arr.length;
        int [][] mat=build_matrix(arr);
        int i=0;
        int j=n-1;
        int first_sum=0;
        int second_sum=0;
        int moves=(int)(n/2);
        while(n>0)
        {
            //first player turn
            if(i==j)
            {
                first_sum+=arr[j];
                System.out.println("first take :  "+arr[j]);
                break;
            }
            else
            {
                if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1])
                {
                    first_sum+=arr[i];
                    System.out.println("first take :  "+arr[i]);
                    i++;

                }
                else
                {
                    first_sum+=arr[j];
                    System.out.println("first take :  "+arr[j]);
                    j--;
                }
            }
            //second player turn
            if(i!=j)
            {
                if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1])
                {
                    second_sum+=arr[i];
                    System.out.println("second take :  "+arr[i]);
                    i++;
                }
                else
                {
                    second_sum+=arr[j];
                    System.out.println("second take :  "+arr[j]);
                    j--;
                }
            }
            else
            {
                second_sum+=arr[j];
                System.out.println("second take :  "+arr[j]);
                break;
            }
        }
        return first_sum-second_sum;
    }

    public static void main(String [] args)
    {
        int [] arr={1,2,3,4,5};
        System.out.println("the array is : "+ Arrays.toString(arr));
        System.out.println(game(arr));
        System.out.println("the best index fo the first player is : "+ Circle_game(arr));
    }
}
