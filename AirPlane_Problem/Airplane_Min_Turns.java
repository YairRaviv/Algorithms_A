package AirPlane_Problem;

import java.util.ArrayList;
import java.util.Iterator;

public class Airplane_Min_Turns
{
    public static void optimal_path(Node[][] mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        mat[0][0].min_cost=0;
        mat[0][0].all_paths.add("");
        for(int i=1;i<n;i++)
        {
            mat[i][0].min_cost=mat[i-1][0].min_cost+mat[i-1][0].y;
            mat[i][0].all_paths.add(mat[i-1][0].all_paths.get(0)+"1");
        }
        for(int j=1;j<m;j++)
        {
            mat[0][j].min_cost=mat[0][j-1].min_cost+mat[0][j-1].x;
            mat[0][j].all_paths.add(mat[0][j-1].all_paths.get(0)+"0");
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                int from_left=mat[i][j-1].min_cost+mat[i][j-1].x;
                int from_up=mat[i-1][j].min_cost+mat[i-1][j].y;
                mat[i][j].min_cost=Math.min(from_left,from_up);
                if(from_left<from_up)
                {
                    Iterator<String>itr =mat[i][j-1].all_paths.iterator();
                    while(itr.hasNext())
                    {
                        mat[i][j].all_paths.add(itr.next()+"0");
                    }
                }
                else if(from_up<from_left)
                {
                    Iterator<String>itr =mat[i-1][j].all_paths.iterator();
                    while(itr.hasNext())
                    {
                        mat[i][j].all_paths.add(itr.next()+"1");
                    }
                }
                else
                {
                    Iterator<String>itr =mat[i][j-1].all_paths.iterator();
                    while(itr.hasNext())
                    {
                        mat[i][j].all_paths.add(itr.next()+"0");
                    }
                    Iterator<String>itr2 =mat[i-1][j].all_paths.iterator();
                    while(itr2.hasNext())
                    {
                        mat[i][j].all_paths.add(itr2.next()+"1");
                    }
                }

            }
        }
        System.out.println("all of the min_cost_paths to n,m is : ");
        Iterator<String>itr=mat[n-1][m-1].all_paths.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
        System.out.println("the best path is : "+best_path(mat[n-1][m-1].all_paths));
    }

    public static String best_path(ArrayList<String> list)
    {
        double min=Double.POSITIVE_INFINITY;
        String ans="";
        Iterator<String> itr = list.iterator();
        while(itr.hasNext())
        {
            String tmp= itr.next();
            int counter=0;
            for(int i=0;i<tmp.length()-1;i++)
            {
                if(tmp.charAt(i)!=tmp.charAt(i+1))
                {
                    counter++;
                }
            }
            if(counter<min)
            {
                min=counter;
                ans=tmp;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Node[][] matrix={{new Node(1,2),new Node(2,3),new Node(3,4),new Node(4,1)},
                {new Node(2,1),new Node(1,1),new Node(3,2),new Node(1,3)},
                {new Node(2,1),new Node(2,3),new Node(1,1),new Node(2,1)},
                {new Node(3,1),new Node(3,2),new Node(1,1),new Node(1,2)}};

        optimal_path(matrix);
    }
}
