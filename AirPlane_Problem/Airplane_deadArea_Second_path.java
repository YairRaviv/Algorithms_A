package AirPlane_Problem;

import Test_2015_A_A.Test_2016_A_B.Node;

import java.awt.*;

public class Airplane_deadArea_Second_path
{
    public static int min_path(Node[][] mat, Point[] dead_area)
    {
        int n=mat.length;
        int m=mat[0].length;
        mat[0][0].min_cost=0;
        mat[0][0].sec_min_cost=0;
        for(int i=0;i<dead_area.length;i++)
        {
            mat[dead_area[i].x][dead_area[i].x].x=Integer.MAX_VALUE;
            mat[dead_area[i].x][dead_area[i].x].y=Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++)
        {
            mat[i][0].min_cost=mat[i-1][0].min_cost+mat[i][0].y;
        }
        for(int i=1;i<m;i++)
        {
            mat[0][i].min_cost=mat[0][i-1].min_cost+mat[0][i-1].x;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                mat[i][j].min_cost=Math.min(Math.abs(mat[i][j-1].min_cost+mat[i][j-1].x),Math.abs(mat[i-1][j].min_cost+mat[i-1][j].y));
            }
        }
        return mat[n-1][m-1].min_cost;
    }
    public static int sec_min_path(Node[][] mat, Point[] dead_area)
    {
        int n=mat.length;
        int m=mat[0].length;
        mat[0][0].min_cost=0;
        mat[0][0].sec_min_cost=0;
        for(int i=0;i<dead_area.length;i++)
        {
            mat[dead_area[i].x][dead_area[i].y].x=Integer.MAX_VALUE;
            mat[dead_area[i].x][dead_area[i].y].y=Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++)
        {
            mat[i][0].min_cost=mat[i-1][0].min_cost+mat[i][0].y;
            mat[i][0].sec_min_cost=mat[i-1][0].sec_min_cost+mat[i][0].y;
        }
        for(int i=1;i<m;i++)
        {
            mat[0][i].min_cost=mat[0][i-1].min_cost+mat[0][i-1].x;
            mat[0][i].sec_min_cost=mat[0][i-1].sec_min_cost+mat[0][i-1].x;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                int min_path_i_j=Math.min(Math.abs(mat[i][j-1].min_cost+mat[i][j-1].x),Math.abs(mat[i-1][j].min_cost+mat[i-1][j].y));
                mat[i][j].min_cost=min_path_i_j;
                if(mat[i][j-1].min_cost+mat[i][j-1].x < mat[i-1][j].min_cost+mat[i-1][j].y)
                {
                    int tmp=Math.min(Math.abs(mat[i][j-1].sec_min_cost+mat[i][j-1].x),Math.abs(mat[i-1][j].min_cost+mat[i-1][j].y));
                    if(tmp==Math.min(Math.abs(mat[i][j-1].min_cost+mat[i][j-1].x),Math.abs(mat[i-1][j].min_cost+mat[i-1][j].y)))
                    {
                        tmp=Math.max(mat[i][j-1].sec_min_cost+mat[i][j-1].x,mat[i-1][j].min_cost+mat[i-1][j].y);
                    }
                    mat[i][j].sec_min_cost=tmp;
                }
                else
                {

                    int tmp=Math.min(Math.abs(mat[i-1][j].sec_min_cost+mat[i-1][j].y),Math.abs(mat[i][j-1].min_cost+mat[i][j-1].x));
                    if(tmp==Math.min(Math.abs(mat[i][j-1].min_cost+mat[i][j-1].x),Math.abs(mat[i-1][j].min_cost+mat[i-1][j].y)))
                    {
                        tmp=Math.max(mat[i-1][j].sec_min_cost+mat[i-1][j].y,mat[i][j-1].min_cost+mat[i][j-1].x);
                    }
                    mat[i][j].sec_min_cost=tmp;
                }

            }
        }
       return mat[n-1][m-1].sec_min_cost;
    }


    public static void main(String [] args)
    {
        Node[][]mat={
                      {new Node(1,2),new Node(2,3),new Node(1,1)},
                      {new Node(3,4),new Node(1,1),new Node(2,1)},
                      {new Node(3,2),new Node(6,3),new Node(9,9)}
                    };
        Point [] arr={new Point(1,1)};
        System.out.println(sec_min_path(mat,arr));
    }
}
