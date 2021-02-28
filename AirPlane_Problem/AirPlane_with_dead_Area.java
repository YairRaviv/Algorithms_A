package AirPlane_Problem;

import Test_2015_A_A.Test_2016_A_A.Node;

import java.awt.*;

public class AirPlane_with_dead_Area
{
    public static int min_cost(Node[][] mat, Point p1, Point p2)
    {
        int n=mat.length;
        int m=mat[0].length;
        mat[0][0].min_cost=0;
        mat[0][0].num_of_paths=1;
        for(int i=1;i<n;i++)
        {
            if(i>=p1.x&&i<=p2.x&&0<=p1.y&&0>=p2.y)
            {
                mat[i][0].x=Math.abs((int)(Double.POSITIVE_INFINITY));
                mat[i][0].x=Math.abs((int)(Double.POSITIVE_INFINITY));
                mat[i][0].min_cost=Math.abs((int)(Double.POSITIVE_INFINITY));
                mat[i][0].num_of_paths=0;
            }
            else
            {
                mat[i][0].min_cost=mat[i-1][0].min_cost+mat[i-1][0].y;
                mat[i][0].num_of_paths=mat[i-1][0].num_of_paths;
            }
        }
        for(int i=1;i<m;i++)
        {
            if(0>=p1.x&&0<=p2.x&&i<=p1.y&&i>=p2.y)
            {
                mat[0][i].x=Math.abs((int)(Double.POSITIVE_INFINITY));
                mat[0][i].x=Math.abs((int)(Double.POSITIVE_INFINITY));
                mat[0][i].min_cost=Math.abs((int)(Double.POSITIVE_INFINITY));
                mat[0][i].num_of_paths=0;
            }
            else
            {
                mat[0][i].min_cost=mat[0][i-1].min_cost+mat[0][i-1].x;
                mat[0][i].num_of_paths= mat[0][i-1].num_of_paths;
            }
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(i>=p1.x&&i<=p2.x&&j<=p1.y&&j>=p2.y)
                {
                    mat[i][j].x=Math.abs((int)(Double.POSITIVE_INFINITY));
                    mat[i][j].x=Math.abs((int)(Double.POSITIVE_INFINITY));
                    mat[i][j].min_cost=Math.abs((int)(Double.POSITIVE_INFINITY));
                    mat[i][j].num_of_paths=0;
                }
                else
                {
                    int from_up=mat[i-1][j].min_cost+mat[i-1][j].y;
                    int from_left=mat[i][j-1].min_cost+mat[i][j-1].x;
                    if(from_up<from_left)
                    {
                        mat[i][j].min_cost=from_up;
                        mat[i][j].num_of_paths=mat[i-1][j].num_of_paths;
                    }
                    else if(from_left<from_up)
                    {
                        mat[i][j].min_cost=from_left;
                        mat[i][j].num_of_paths=mat[i][j-1].num_of_paths;
                    }
                    else
                    {
                        mat[i][j].min_cost=from_up;
                        mat[i][j].num_of_paths=mat[i-1][j].num_of_paths+mat[i][j-1].num_of_paths;
                    }
                }
            }
        }

        System.out.println("the min cost is : "+mat[n-1][m-1].min_cost);
        System.out.println("the num of ways is : "+mat[n-1][m-1].num_of_paths);
        return 0;

    }


    public static void main(String[] args)
    {
        Point p1=new Point(-1,-1);
        Point p2=new Point(-1,-1);
        Node[][] matrix=
                {{new Node(1,2),new Node(2,3),new Node(3,4),new Node(4,1)},
                {new Node(2,1),new Node(1,1),new Node(3,2),new Node(1,3)},
                {new Node(2,1),new Node(2,3),new Node(1,1),new Node(2,1)},
                {new Node(3,1),new Node(3,2),new Node(1,1),new Node(1,2)}};

        min_cost(matrix,p1,p2);
    }
}
