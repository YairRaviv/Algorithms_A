package Exam_2021_A_A;

import java.util.Arrays;

public class Q2
{
    public static int longestOfOne(int[] arr)
    {
        int n=arr.length;
        int [] help=new int [n];
        help[0]=arr[0];
        int max=0;
        for(int i=1;i<n;i++)
        {
            if(arr[i]==1)
            {
                help[i]=help[i-1]+1;
                if(help[i]>max)
                {
                    max=help[i];
                }
            }
            else
            {
                help[i]=0;
            }
        }
        return max;
    }

    public static int imaginaryPlus(int[][] arr)
    {
        int n=arr.length;
        int m=arr[0].length;
        int [][] from_up=new int[n][m];
        int [][]from_down=new int[n][m];
        int [][] from_left=new int[n][m];
        int [][]from_right=new int[n][m];
        //from_up[0][0]=arr[0][0];
        for(int i=0;i<m;i++)
        {
            from_up[0][i]=arr[0][i];
        }
        for(int i=0;i<m;i++)
        {
            from_down[n-1][i]=arr[n-1][i];
        }
        for(int i=0;i<n;i++)
        {
            from_left[i][0]=arr[i][0];
        }
        for(int i=0;i<n;i++)
        {
            from_right[i][m-1]=arr[i][m-1];
        }
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(arr[i][j]==1)
                {
                    //from_up[i][j]=from_up[i-1][j]+1;
                    from_left[i][j]=from_left[i][j-1]+1;
                }
                else
                {
                   // from_up[i][j]=0;
                    from_left[i][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==1)
                {
                    from_up[i][j]=from_up[i-1][j]+1;
                    //from_left[i][j]=from_left[i][j-1]+1;
                }
                else
                {
                    from_up[i][j]=0;
                   //from_left[i][j]=0;
                }
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-2;j>=0;j--)
            {
                if(arr[i][j]==1)
                {
                   // from_down[i][j]=from_down[i+1][j]+1;
                    from_right[i][j]=from_right[i][j+1]+1;
                }
                else
                {
                  //  from_down[i][j]=0;
                    from_right[i][j]=0;
                }
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(arr[i][j]==1)
                {
                    from_down[i][j]=from_down[i+1][j]+1;
                    //from_right[i][j]=from_right[i][j+1]+1;
                }
                else
                {
                    from_down[i][j]=0;
                    //from_right[i][j]=0;
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(max<from_down[i][j]+from_left[i][j]+from_right[i][j]+from_up[i][j])
                {
                    max=from_down[i][j]+from_left[i][j]+from_right[i][j]+from_up[i][j];
                }
            }
        }
        return max-3;

    }

    public static void main(String[] args) {
        int [][] matrix={
                {1,1,1,0,1},
                {1,0,1,0,1},
                {0,0,0,0,1},
                {1,1,0,0,1},
                {1,1,0,0,1},
        };
        System.out.println(imaginaryPlus(matrix));
    }

}





