package LCS;

public class LCS_num_of_changes
{
    public static String lcs(String a,String b)
    {
        int n=a.length();
        int m=b.length();
        int [][] mat=new int [n+1][m+1];
//        for(int i=0;i<n+1;i++)
//        {
//            mat[i][0]=0;
//        }
//        for(int i=0;i<m+1;i++)
//        {
//            mat[0][m]=0;
//        }
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
        System.out.println("the length of lcs is : "+ mat[n][m]);
        String ans="";
        int i=n;
        int j=m;
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

    public static int num_of_changes(String a,String b)
    {
        int lcs=lcs(a,b).length();
        return a.length()-lcs+b.length()-lcs;
    }

//    public static String num_of_changes(String a,String b)
//    {
//      String lcs=lcs(a,b);
//      int index_of_a=0;
//      int index_of_b=0;
//      int index_of_lcs=0;
//      int changes=0;
//      String ans="";
//      while(index_of_a<a.length()&&index_of_lcs<lcs.length())
//      {
//          if(a.charAt(index_of_a)==lcs.charAt(index_of_lcs))
//          {
//              ans+=a.charAt(index_of_a);
//              index_of_a++;
//              index_of_lcs++;
//          }
//          else
//          {
//              index_of_a++;
//              changes++;
//          }
//      }
//      index_of_lcs=0;
//
//      while(index_of_a<a.length())
//      {
//          changes++;
//          index_of_a++;
//      }
//
//
//
//    }



    public static void main(String [] args)
    {
        String a="yairaviv";
        String b="eranraiv";
        System.out.println(num_of_changes(a,b));
    }
}
