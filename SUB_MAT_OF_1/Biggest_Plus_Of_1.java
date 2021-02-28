package SUB_MAT_OF_1;

import java.util.Arrays;

public class Biggest_Plus_Of_1
{
    public static int plus_of_1(int [][] mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        int [][] up= new int[n][m];
        int [][] down= new int[n][m];
        int [][] left= new int[n][m];
        int [][] right= new int[n][m];
        int [][] ans= new int[n][m];
            //init help mats
            for(int i=0;i<n;i++)
            {
                left[i][0]=mat[i][0];
                right[i][m-1]=mat[i][m-1];
                ans[i][0]=mat[i][0];
                ans[i][m-1]=mat[i][m-1];
            }
            for(int i=0;i<m;i++)
            {
                up[0][i]=mat[0][i];
                down[n-1][i]=mat[n-1][i];
                ans[0][i]=mat[0][i];
                ans[n-1][i]=mat[n-1][i];
            }

            //fill help matrixs
            for(int i=1;i<n;i++)
            {
                for(int j=1;j<m;j++)
                {
                    if(mat[i][j]!=0)
                    {
                        up[i][j]=up[i-1][j]+1;
                        left[i][j]=left[i][j-1]+1;
                    }
                }
            }
            for(int i=n-2;i>=0;i--)
            {
                for(int j=m-2;j>=0;j--)
                {
                    if(mat[i][j]!=0)
                    {
                        down[i][j]=down[i+1][j]+1;
                        right[i][j]=right[i][j+1]+1;
                    }
                }
            }

            for(int i=1;i<n-1;i++)
            {
                for(int j=1;j<m-1;j++)
                {
                    if(mat[i][j]!=0)
                    {
                        int min_u_d=Math.min(up[i][j],down[i][j]);
                        int min_l_r=Math.min(right[i][j],left[i][j]);
                        ans[i][j]=Math.min(min_l_r,min_u_d);
                    }
                }
            }

            int index_i=0;
            int index_j=0;
            int max=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(ans[i][j]>max)
                    {
                        max=ans[i][j];
                        index_i=i;
                        index_j=j;
                    }
                }
            }
            return 4*(ans[index_i][index_j]-1)+1;
        }

    public static void main(String [] args)
    {
        int [][] mat={
                {1,0,1,1,1,1,0,1,1,1},
                {1,0,1,0,1,1,1,0,1,1},
                {1,1,1,0,1,1,0,1,0,1},
                {0,0,0,0,1,0,0,1,0,0},
                {1,0,0,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,0},
                {1,0,0,0,1,0,0,1,0,1},
                {1,0,1,1,1,1,0,0,1,1},
                {1,1,0,0,1,0,0,0,0,1},
                {1,0,1,1,1,1,0,1,0,0}
        };
        System.out.println("the mat is");
        for(int i=0;i<mat.length;i++)
        {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println(plus_of_1(mat));
    }

}
