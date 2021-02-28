package Exam_2021_A_A;

public class Q1
{
    public static int lcs(int[] X, int[] Y)
    {
        int n=X.length;
        int m=Y.length;
        int [][] mat=new int [n+1][m+1];

        //init the first row and column
        for(int i=0;i<n+1;i++)
        {
            mat[i][0]=0;
        }
        for(int i=0;i<m+1;i++)
        {
            mat[0][i]=0;
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(X[i-1]==Y[j-1])
                {
                    mat[i][j]=mat[i-1][j-1]+1;
                }
                else
                {
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat[n][m];
    }

    public static int lcs3(int[] X, int[] Y, int[] Z)
    {
        int n=X.length;
        int m=Y.length;
        int l=Z.length;
        int [][][] mat=new int [n+1][m+1][l+1];

        for(int i=0;i<n+1;i++)
        {
            mat[i][0][0]=0;
        }
        for(int i=0;i<m+1;i++)
        {
            mat[0][i][0]=0;
        }
        for(int i=0;i<l+1;i++)
        {
            mat[0][0][i]=0;
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                for(int k=1;k<l+1;k++)
                {
                    if(X[i-1]==Y[j-1]&&X[i-1]==Z[k-1])mat[i][j][k]=mat[i-1][j-1][k-1]+1;
                    else
                    {
                        mat[i][j][k]=Math.max(Math.max(mat[i][j][k-1],mat[i][j-1][k]),mat[i-1][j][k]);
                    }
                }
            }
        }
        return mat[n][m][l];
    }

}

