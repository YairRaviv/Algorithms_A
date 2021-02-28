package LCS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ALL_LCS
{
    public static String LCS(String a, String b)
    {
        int n=a.length();
        int m=b.length();
        int [][] mat =new int [n+1][m+1];

        //init
        for(int i=0;i<=n;i++)
        {
            mat[i][0]=0;
        }
        for(int i=0;i<=m;i++)
        {
            mat[0][i]=0;
        }

        //build matrix

        for (int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    mat[i][j]=mat[i-1][j-1]+1;
                }
                else
                {
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        int i=n;
        int j=m;
        String ans="";
        while(i>0&&j>0)
        {
            if(a.charAt(i-1)==b.charAt(j-1))
            {
                ans=a.charAt(i-1)+ans;
                i--;
                j--;
            }
            else
            {
                if(mat[i-1][j]>mat[i][j-1])
                {
                    i--;
                }
                else
                {
                    j--;
                }
            }
        }
        return ans;
    }
    public static int [][] build_mat(String a,String b)
    {

        int n=a.length();
        int m=b.length();
        int [][] mat =new int [n+1][m+1];

        //init
        for(int i=0;i<=n;i++)
        {
            mat[i][0]=0;
        }
        for(int i=0;i<=m;i++)
        {
            mat[0][i]=0;
        }

        //build matrix

        for (int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    mat[i][j]=mat[i-1][j-1]+1;
                }
                else
                {
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat;
    }
    public static ArrayList<String> ALL_LCS(String a, String b)
    {
        int [][] mat=build_mat(a,b);
        ArrayList<String> lcss=new ArrayList<>();
        System.out.println(new HashSet<>(LCS(a,b,mat.length-1,mat[0].length-1,mat)));
        return lcss;
    }

    public static List<String> LCS(String a, String b, int m, int n,
                                   int[][] mat)
    {

        if (m == 0 || n == 0)
        {
            // create a List with 1 empty string and return
            return new ArrayList<>(Collections.nCopies(1, ""));
        }


        if (a.charAt(m - 1) == b.charAt(n - 1))
        {

            List<String> lcs = LCS(a, b, m - 1, n - 1, mat);

            for (int i = 0; i < lcs.size(); i++) {
                lcs.set(i, lcs.get(i) + (a.charAt(m - 1)));
            }

            return lcs;
        }


        if (mat[m - 1][n] > mat[m][n - 1])
            return LCS(a, b, m - 1, n, mat);

        if (mat[m][n - 1] > mat[m - 1][n])
            return LCS(a, b, m, n - 1, mat);


        List<String> top = LCS(a, b, m - 1, n, mat);
        List<String> left = LCS(a, b, m, n - 1, mat);

        top.addAll(left);

        return top;
    }
    public static int LCS_length(String a,String b)
    {
            int n=a.length();
            int m=b.length();
            int [][] mat =new int [n+1][m+1];

            //init
            for(int i=0;i<=n;i++)
            {
                mat[i][0]=0;
            }
            for(int i=0;i<=m;i++)
            {
                mat[0][i]=0;
            }

            //build matrix

            for (int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    if(a.charAt(i-1)==b.charAt(j-1))
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

    public static void main(String[] args)
    {
        System.out.println(ALL_LCS("abcdef","efcdab"));
    }

}

