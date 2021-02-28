package LCS;

import java.util.Arrays;

public class LCS
{
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


    //return the shortest String length that a and b is substring of
    public static int LCS_Of_AB_length(String a, String b)
    {
        int c=LCS_length(a,b);
        int al=a.length();
        int bl=b.length();
        return (al+bl)-c;
    }

    //return the shortest String that a and b is substring of
    public static String LCS_Of_AB(String a, String b)
    {
        String c=LCS(a,b);
        int index_of_lcs=0;
        int index_of_b=0;
        int index_of_a=0;
        String ans="";
        while(index_of_a<a.length()&&index_of_b<b.length()&&index_of_lcs<c.length())
        {
            if(a.charAt(index_of_a)==b.charAt(index_of_b)&&b.charAt(index_of_b)==c.charAt(index_of_lcs))
            {
                ans+=a.charAt(index_of_a);
                index_of_a++;
                index_of_b++;
                index_of_lcs++;
            }
            else
            {
                if(a.charAt(index_of_a)==c.charAt(index_of_lcs))
                {
                    ans+=b.charAt(index_of_b);
                    index_of_b++;
                }
                else
                {
                    ans+=a.charAt(index_of_a);
                    index_of_a++;
                }
            }
        }
        while(index_of_a<a.length())
        {
            ans+=a.charAt(index_of_a);
            index_of_a++;
        }
        while(index_of_b<b.length())
        {
            ans+=b.charAt(index_of_b);
            index_of_b++;
        }
        return ans;

    }

    public static void main(String [] args)
    {
        String a="yairaviv";
        String b="eranraiv";
        System.out.println(LCS(a,b));
    }
}
