package LCS;

public class LCS_3D
{
    public static int [][][] build_mat(String a,String b,String c)
    {
        int n=a.length();
        int m=b.length();
        int l=c.length();
        int [][][] mat=new int[n+1][m+1][l+1];
        //init
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
            mat[0][0][l]=0;
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                for(int k=1;k<l+1;k++)
                {
                    if(a.charAt(i-1)==b.charAt(j-1)&&a.charAt(i-1)==c.charAt(k-1))
                    {
                        mat[i][j][k]=mat[i-1][j-1][k-1]+1;
                    }
                    else
                    {
                        mat[i][j][k]=Math.max(Math.max(mat[i][j][k-1],mat[i][j-1][k]),mat[i-1][j][k]);
                    }
                }
            }
        }
        return mat;
    }
    public static String LCS_3D(String a,String b,String c)
    {
        int n=a.length();
        int m=b.length();
        int l=c.length();
        int [][][] mat=build_mat(a,b,c);
        int i=n;
        int j=m;
        int k=l;
        String ans="";
        while(i>0&&j>0&&k>0)
        {

            if(a.charAt(i-1)==b.charAt(j-1)&&a.charAt(i-1)==c.charAt(k-1))
            {
                ans=a.charAt(i-1)+ans;
                i--;
                j--;
                k--;
            }
            else
            {
                if(mat[i-1][j][k]>mat[i][j-1][k]&&mat[i-1][j][k]>mat[i-1][j][k-1])i--;
                else if(mat[i][j-1][k]>mat[i][j][k-1]&&mat[i][j-1][k]>mat[i-1][j][k])j--;
                else k--;
            }
        }
        return ans;
    }
    public static int LCS_3D_length(String a,String b,String c)
    {
        int n=a.length();
        int m=b.length();
        int l=c.length();
        int [][][] mat=build_mat(a,b,c);
        return mat[n][m][l];
    }

    public static void main(String[] args)
    {
      String a="abcd";
        String b="bcde";
        String c="cdef";
        System.out.println(LCS_3D(a,b,c));
    }
}
