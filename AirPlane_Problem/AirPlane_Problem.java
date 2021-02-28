package AirPlane_Problem;

import java.util.ArrayList;
import java.util.Iterator;

public class AirPlane_Problem
{
    public static AirPlane_Node[][] build_airplane_mat(AirPlane_Node[][] mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        mat[0][0].min_cost=0;
        mat[0][0].num_of_paths=0;
        for(int i=1;i<n;i++)
        {
            mat[i][0].min_cost=mat[i-1][0].min_cost+mat[i-1][0].y;
            mat[i][0].num_of_paths=1;
        }
        for(int i=1;i<m;i++)
        {
            mat[0][i].min_cost=mat[0][i-1].min_cost+mat[0][i-1].x;
            mat[0][i].num_of_paths=1;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(mat[i-1][j].min_cost+mat[i-1][j].y==mat[i][j-1].min_cost+mat[i][j-1].x)
                {
                    mat[i][j].min_cost=mat[i-1][j].min_cost+mat[i-1][j].y;
                    mat[i][j].num_of_paths=mat[i-1][j].num_of_paths+mat[i][j-1].num_of_paths;
                }
                else
                {
                    mat[i][j].min_cost=Math.min(mat[i-1][j].min_cost+mat[i-1][j].y,mat[i][j-1].min_cost+mat[i][j-1].x);
                    if(mat[i-1][j].min_cost+mat[i-1][j].y<mat[i][j-1].min_cost+mat[i][j-1].x)
                    {
                        mat[i][j].num_of_paths=mat[i-1][j].num_of_paths;
                    }
                    else
                    {
                        mat[i][j].num_of_paths=mat[i][j-1].num_of_paths;
                    }
                }
            }
        }
        return mat;
    }
    public static String find_1_path(AirPlane_Node[][] mat)
    {

        AirPlane_Node[][] matrix=build_airplane_mat(mat);
        int n=matrix.length;
        int m=matrix[0].length;
        String ans="";
        int i=n-1;
        int j=m-1;
        while(i>0&&j>0)
        {
            if (matrix[i][j].min_cost == matrix[i][j - 1].min_cost + matrix[i][j - 1].x)
            {
                System.out.println("[i][j]= ["+i+"]["+j+"]");
                ans="0"+ans;
                j--;
            }
            else
                {
                    System.out.println("[i][j]= ["+i+"]["+j+"]");
                ans="1"+ans;
                i--;
            }
        }
            if(i>0)
            {
                while(i>0)
                {
                    ans="1"+ans;
                    System.out.println("[i][j]= ["+i+"]["+j+"]");
                    i--;
                }
            }
            if(j>0)
            {
                while(j>0)
                {
                    ans="0"+ans;
                    System.out.println("[i][j]= ["+i+"]["+j+"]");
                    j--;
                }
            }
            return ans;


    }

    public static ArrayList<String> All_Paths(AirPlane_Node[][] mat)
    {

        int n=mat.length;
        int m=mat[0].length;
        mat[0][0].min_cost=0;
        mat[0][0].num_of_paths=0;
        mat[0][0].paths.add("");
        for(int i=1;i<n;i++)
        {
            if(i==0)continue;
            mat[i][0].min_cost=mat[i-1][0].min_cost+mat[i-1][0].y;
            mat[i][0].num_of_paths=1;
            mat[i][0].paths.add(mat[i-1][0].paths.get(0)+"1");
        }
        for(int i=1;i<m;i++)
        {
            if(i==0)continue;
            mat[0][i].min_cost=mat[0][i-1].min_cost+mat[0][i-1].x;
            mat[0][i].num_of_paths=1;
            mat[0][i].paths.add(mat[0][i-1].paths.get(0)+"0");
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(mat[i-1][j].min_cost+mat[i-1][j].y==mat[i][j-1].min_cost+mat[i][j-1].x)
                {
                    mat[i][j].min_cost=mat[i-1][j].min_cost+mat[i-1][j].y;
                    mat[i][j].num_of_paths=mat[i-1][j].num_of_paths+mat[i][j-1].num_of_paths;
                    Iterator<String> itr_1=mat[i-1][j].paths.iterator();
                    while(itr_1.hasNext())
                    {
                        mat[i][j].paths.add(itr_1.next()+"1");
                    }
                    Iterator<String> itr_2=mat[i][j-1].paths.iterator();
                    while(itr_2.hasNext())
                    {
                        mat[i][j].paths.add(itr_2.next()+"0");
                    }
                }
                else
                {
                    mat[i][j].min_cost=Math.min(mat[i-1][j].min_cost+mat[i-1][j].y,mat[i][j-1].min_cost+mat[i][j-1].x);
                    if(mat[i-1][j].min_cost+mat[i-1][j].y<mat[i][j-1].min_cost+mat[i][j-1].x)
                    {
                        mat[i][j].num_of_paths=mat[i-1][j].num_of_paths;
                        Iterator<String> itr_1=mat[i-1][j].paths.iterator();
                        while(itr_1.hasNext())
                        {
                            mat[i][j].paths.add(itr_1.next()+"1");
                        }
                    }
                    else
                    {
                        Iterator<String> itr_2=mat[i][j-1].paths.iterator();
                        while(itr_2.hasNext())
                        {
                            mat[i][j].paths.add(itr_2.next()+"0");
                        }
                        mat[i][j].num_of_paths=mat[i][j-1].num_of_paths;
                    }
                }
            }
        }
        return mat[n-1][m-1].paths;
    }

    public static void main(String [] args)
    {
     AirPlane_Node[][] matrix={{new AirPlane_Node(1,2),new AirPlane_Node(2,3),new AirPlane_Node(3,4),new AirPlane_Node(4,1)},
             {new AirPlane_Node(2,1),new AirPlane_Node(1,1),new AirPlane_Node(3,2),new AirPlane_Node(1,3)},
             {new AirPlane_Node(2,1),new AirPlane_Node(2,3),new AirPlane_Node(1,1),new AirPlane_Node(2,1)},
             {new AirPlane_Node(3,1),new AirPlane_Node(3,2),new AirPlane_Node(1,1),new AirPlane_Node(1,2)}};

         Iterator<String> itr=All_Paths(matrix).iterator();
         while(itr.hasNext())
         {
             System.out.println(itr.next());
         }

        System.out.println(find_1_path(matrix));
//        System.out.println(build_airplane_mat(matrix)[matrix.length-1][matrix[0].length-1].min_cost);
    }

}
