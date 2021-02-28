package Implementations;

import java.io.FileReader;

public class Pow_Fibonachi
{
    public static double pow_logn(int x,int n)
    {
        double result=1;
        while(n!=0)
        {
            if(n%2!=0)
            {
                result*=x;
            }
            x*=x;
            n/=2;
        }
        return result;
    }
    public static int Fibonachi_logn(int n)
    {
        int [][] ans={{1,1},{1,0}};
        int [][] A={{1,1},{1,0}};
        n-=2;
        while(n>0)
        {
            if(n%2!=0)
            {
                ans = matrix_mul(ans,A);
            }
            A=matrix_mul(A,A);
            n/=2;
        }
        return ans[0][0];
    }
    public static int [][] matrix_mul(int[][] a,int [][] b)
    {
        int n=a.length;
        int [][] c =new int[n][n];
        for(int i=0;i<n;i++)
        {
            for (int j = 0; j < n; j++)
            {
                c[i][j] = 0;
                for (int k = 0; k < n; k++)
                {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }


    public static void main(String [] args)
    {
        int a=2;
        int b=5;
        System.out.println(Fibonachi_logn(30));
    }
}
