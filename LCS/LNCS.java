package LCS;

public class LNCS
{
    public static int [][] build_mat(String a,String b)
    {

        int n=a.length();
        int m=b.length();
        int [][] mat =new int [n+1][m+1];
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
    public static int LCS_length(String a,String b)
    {
        int [][] mat=build_mat(a,b);
        int n=a.length();
        int m=b.length();
        return mat[n][m];
    }

    public static String LNCS_Of_A(String a, String b)
    {
        if(a.length()>b.length())
        {
            return a;
        }
        else
        {
           int lcs=LCS_length(a,b);
           if(a.length()==lcs)return "";
           else
           {
               return a;
           }
        }
    }
    public static String LNCS_OF_A_Or_B(String a,String b)
    {
        if(a.length()>b.length())return a;
        else if (b.length()>a.length())return b;
        else
        {
            int lcs=LCS_length(a,b);
            if(a.length()==lcs)return "";
            else
            {
                return a;
            }
        }
    }


    public static void main(String [] args)
    {
        String a="yair";
        String b="ybgaikr";
        System.out.println("q 1 is :"+LNCS_Of_A(a,b));
        System.out.println("q2 is : "+LNCS_OF_A_Or_B(a,b));

    }
}
