package NUMBERS_GAME;

import java.util.Arrays;

public class Numbers_Game
{
    public static void game(int [] arr)
    {
        int [][] mat = build_mat(arr);
        int n=arr.length-1;
        int moves=(int)(n/2)+1;
        int i=0;
        int j=n;
        int first_sum=0;
        int second_sum=0;
        int f_index;
        int s_index;
        for(int k=0;k<moves;k++)
        {
            if(i==j)
            {
                first_sum+=arr[i];break;
            }
            if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1])
            {
               first_sum+=arr[i];
               f_index=i;
               i++;
            }
            else
            {
                f_index=j;
                first_sum+=arr[j];
                j--;
            }

            if(i!=j)
            {
                if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1])
                {
                    s_index=i;
                    second_sum+=arr[i];
                    i++;
                }
                else
                {
                    s_index=j;
                    second_sum+=arr[j];
                    j--;
                }
            }
            else
            {
                s_index=j;
                second_sum+=arr[j];
                break;
            }

            System.out.println("first player take: arr["+f_index+"], = "+arr[f_index]+"" +
                    "second player take : arr["+s_index+"], ="+arr[s_index]);
        }

        System.out.println("first sum is : "+first_sum+" second sum is : "+second_sum+
                "final result is : "+(first_sum-second_sum));
    }

    public static int [][] build_mat(int [] arr)
    {

        int n=arr.length;
        int [][] mat=new int [n][n];
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
        System.out.println("the matrix is : ");
        for(int i=0;i< mat.length;i++)
        {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println();
        return mat;
    }

    public static void main(String [] args)
    {
        int [] arr={4,5,1,2,3};
        System.out.println("the array is : "+ Arrays.toString(arr));
        game(arr);



    }
}
