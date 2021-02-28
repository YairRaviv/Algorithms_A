package LCS;

import java.sql.SQLOutput;

public class LCS_Palyndrom
{
    public static String lcs(String a,String b)
    {
        int n=a.length();
        int m=b.length();
        int [][] mat=new int[n+1][m+1];
        for(int i=0;i<n;i++)
        {
            mat[i][0]=0;
        }
        for(int i=0;i<m;i++)
        {
            mat[0][i]=0;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
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
    public static String lcs_palyndrom(String a)
    {
       String b="";
       int index=a.length()-1;
       while(index>=0)
       {
           b=b+a.charAt(index);
           index--;
       }
        System.out.println("a is : "+a);
        System.out.println("reverse a is : "+b);
        return lcs(a,b);
    }

    public static void main(String [] args)
    {

    }
}
