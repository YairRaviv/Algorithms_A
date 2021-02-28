package LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS
{
    public static List<Integer> LIS(int [] arr)
    {
        int n=arr.length;
        int [][] mat=new int [n][n];
        mat[0][0]=arr[0];
        int current_index_at_diognal=0;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>mat[current_index_at_diognal][current_index_at_diognal])
            {
                mat[current_index_at_diognal+1][current_index_at_diognal+1]=arr[i];
                current_index_at_diognal++;
                for(int j=0;j<current_index_at_diognal;j++)
                {
                    mat[current_index_at_diognal][j]=mat[current_index_at_diognal-1][j];
                }

            }
            else
            {
                int index=Binary_search_diognal(mat,arr[i]);
                mat[index][index]=arr[i];
                // if(index==current_index_at_diognal)current_index_at_diognal++;
                for(int k=0;k<index;k++)
                {
                    if(index==0)break;
                    mat[index][k]=mat[index-1][k];
                }
            }


        }
        int indesx_of_raw=0;
        for(int i=n-1;i>=0;i--)
        {
            if(mat[i][i]>0)
            {
                indesx_of_raw=i;
                break;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<indesx_of_raw+1;i++)
        {
            ans.add(mat[indesx_of_raw][i]);
        }
        return ans;
    }

    public static int Binary_search_diognal(int [][] mat,int n)
    {
        for(int i=0;i<mat.length;i++)
        {
            if(n<mat[i][i])return i;
        }
        return mat.length-1;
    }

    public static List<Integer> Circle_LIS(int [] arr)
    {
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int [] circle=new int[n+n];
        for(int i=0;i<n;i++)
        {
            circle[i]=arr[i];
        }
        for(int i=n;i<n+n;i++)
        {
            circle[i]=circle[i-n];
        }
        for(int i=0;i<n;i++)
        {
            int [] tmp_arr=new int [n];
            for(int j=0;j<n;j++)
            {
                tmp_arr[j]=circle[i+j];
            }
            System.out.println(Arrays.toString(tmp_arr));
            List<Integer> tmp_list=LIS(tmp_arr);
            System.out.println(Arrays.asList(tmp_list));
            if(tmp_list.size()>ans.size())ans=tmp_list;
        }
        return ans;
    }
}
