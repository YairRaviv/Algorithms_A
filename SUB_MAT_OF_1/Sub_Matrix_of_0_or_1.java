package SUB_MAT_OF_1;

public class Sub_Matrix_of_0_or_1
{
    public static int sub_matrix_of_0_or_1(int [][] mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        int [][]mat_0=new int[n][m];
        int [][]mat_1=new int[n][m];
        int max_1=0;
        int max_0=0;
        //init
        for(int i=0;i<n;i++)
        {
            mat_1[i][0]=mat[i][0];
            if(mat[i][0]==1)
            {
                mat_0[i][0]=0;
            }
            else
            {
                mat_0[i][0]=1;
            }
        }
        for(int j=0;j<m;j++)
        {
            mat_1[0][j]=mat[0][j];
            if(mat[0][j]==1)
            {
                mat_0[0][j]=0;
            }
            else
            {
                mat_0[0][j]=1;
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    mat_1[i][j]=0;
                    mat_0[i][j]=1+Math.min(mat_0[i-1][j-1],Math.min(mat_0[i][j-1],mat_0[i-1][j]));
                    if(mat_0[i][j]>max_0)max_0=mat_0[i][j];
                }
                else
                {
                    mat_0[i][j]=0;
                    mat_1[i][j]=1+Math.min(mat_1[i-1][j-1],Math.min(mat_1[i][j-1],mat_1[i-1][j]));
                    if(mat_1[i][j]>max_1)max_1=mat_1[i][j];
                }
            }
        }
        return Math.max(max_0,max_1);
    }

    public static void main(String[] args) {
        int[][] mat={{0,0,0,0,1},{0,0,0,1,0},{0,0,1,1,1},{0,1,1,1,1},{0,0,1,0,0}};
       // int[][] mat2={{1,0,1,1,1},{0,0,1,1,1},{0,0,1,1,1},{1,0,1,0,1}};
        System.out.println(sub_matrix_of_0_or_1(mat));
      //  System.out.println(sub_matrix_of_0_or_1(mat2));

    }
}
