package SUB_MAT_OF_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Sub_matrix
{


    public static int sub_mat(int [][] g_arr)
    {
        int n= g_arr[0].length;
        int sqr[][]=new int [n][n];
        for(int i=0;i<n;i++)
        {
            sqr[i][0]=g_arr[i][0];
            sqr[0][i]=g_arr[0][i];
        }


          for(int i=1;i<n;i++)
          {
              for(int j=1;j<n;j++)
              {
                  if(g_arr[i][j]==0)sqr[i][j]=0;
                  else
                  {
                      sqr[i][j]=Math.min(sqr[i-1][j],Math.min(sqr[i][j-1],sqr[i-1][j-1]))+1;
                  }
              }
          }
        int max=0;
        int index_i=0;
        int index_j=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(sqr[i][j]>max)
                {
                    max = sqr[i][j];
                    index_i = i;
                    index_j = j;
                }
            }
        }

       // System.out.println("index i="+index_i+"index j="+index_j);
        //System.out.println("max ="+max);
        for(int i=index_j+1-max;i<max;i++)
        {
            for(int j=index_j+1-max;j<max;j++)
            {
                System.out.print("1  ");
            }
            System.out.println();
        }

        return max;

    }


    public static int num_of_2_mat (int [][] g_arr) {
        int n = g_arr[0].length;
        int sqr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            sqr[i][0] = g_arr[i][0];
            sqr[0][i] = g_arr[0][i];
        }

        int counter = 0;
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (g_arr[i][j] == 0) sqr[i][j] = 0;
                else
                    {
                    sqr[i][j] = Math.min(sqr[i - 1][j], Math.min(sqr[i][j - 1], sqr[i - 1][j - 1])) + 1;
                    if (sqr[i][j] >= 2)
                    {
                        sqr[i][j] = 2;
                        counter++;
                    }
                }
            }
        }
        return counter;
    }


    public static void main(String [] args)
    {
        //int mat[][]={{1,0,1,1,0},{1,1,1,0,0},{1,1,1,0,0},{1,1,1,0,1},{1,0,1,0,0}};
        //int max=sub_mat(mat);
       // System.out.println("num of 2*2 mat is :"+num_of_2_mat(mat));
        int [] lis={8,4,12,2,3,10,14,7};

       // List<Integer> list=Circle_LIS(lis);
      // Iterator<Integer> itr= list.iterator();
      //  while(itr.hasNext())
      //  {
       //     System.out.println(itr.next());
      // }
    }
}
