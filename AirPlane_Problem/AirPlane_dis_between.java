package AirPlane_Problem;

import Test_2015_A_A.Test_2017_B_B.Airplane_Node;

import java.awt.*;

public class AirPlane_dis_between
{
    public Airplane_Node[][] build_mat(Airplane_Node [][] mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        mat[0][0].min_cost=0;
        mat[0][0].max_cost=0;
        for(int i=1;i<n;i++)
        {
            mat[i][0].min_cost=mat[i-1][0].min_cost+mat[i-1][0].y;
            mat[i][0].max_cost=mat[i-1][0].min_cost+mat[i-1][0].y;
        }
        for(int j=1;j<m;j++)
        {
            mat[0][j].min_cost=mat[0][j-1].min_cost+mat[0][j-1].x;
            mat[0][j].max_cost=mat[0][j-1].max_cost+mat[0][j-1].x;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                mat[i][j].min_cost=Math.min(mat[i-1][j].min_cost+mat[i-1][j].y,mat[i][j-1].min_cost+mat[i][j-1].x);
                mat[i][j].max_cost=Math.max(mat[i-1][j].max_cost+mat[i-1][j].y,mat[i][j-1].max_cost+mat[i][j-1].x);
            }

        }
        return mat;
    }


    public int dis_between(Airplane_Node [][] mat, Point p1,Point p2)
    {
        if(p1.x>=p2.x&&p1.y>=p2.y)
        {
            Point tmp=p1;
            p2=p1;
            p1=tmp;

        }
        else if(p2.x>=p1.x&&p2.y>=p1.y)
        {
            p1=p1;
            p2=p2;
        }
        else
        {
            return -1;
        }
        int n=p2.x;
        int m=p2.y;

        int index_0_i=p1.x;
        int index_0_j=p1.y;
        mat[index_0_i][index_0_j].min_cost=0;
        mat[index_0_i][index_0_j].max_cost=0;
        for(int i=index_0_i+1;i<=n;i++)
        {
            mat[i][index_0_j].min_cost=mat[i-1][index_0_j].min_cost+mat[i-1][index_0_j].y;
            mat[i][index_0_j].max_cost=mat[i-1][index_0_j].max_cost+mat[i-1][index_0_j].y;
        }
        for(int j=index_0_j+1;j<=m;j++)
        {
            mat[index_0_i][j].min_cost=mat[index_0_i][j-1].min_cost+mat[index_0_i][j-1].x;
            mat[index_0_i][j].max_cost=mat[index_0_i][j-1].max_cost+mat[index_0_i][j-1].x;
        }
        for(int i=index_0_i+1;i<=n;i++)
        {
            for(int j=index_0_j+1;j<=m;j++)
            {
                mat[i][j].min_cost=Math.min(mat[i-1][j].min_cost+mat[i-1][j].y,mat[i][j-1].min_cost+mat[i][j-1].x);
            }
        }
        return mat[n][m].min_cost;
    }
    public boolean is_on_path(Airplane_Node [][] mat,Point p1,Point p2)
    {
        if(!((p1.x>=p2.x&&p1.y>=p2.y)||(p2.x>=p1.x&&p2.y>=p1.y))) return false;

        if(p1.x>=p2.x&&p1.y>=p2.y)
        {

            Point tmp=p1;
            p2=p1;
            p1=tmp;
        }
        int n=mat.length;
        int m=mat[0].length;
        int min_path=build_mat(mat)[n-1][m-1].min_cost;
        int to_p1=dis_between(mat,new Point(0,0),p1);
        int to_p2=dis_between(mat,p1,p2);
        int to_nm=dis_between(mat,p2,new Point(n-1,m-1));
        System.out.println("to_p1 :" + to_p1+", to p2 : "+ to_p2+", to n m : "+to_nm+", from 0 0 to n m : "+ min_path);

        return (build_mat(mat)[n-1][m-1].min_cost==to_p1+to_p2+to_nm);
    }

    public int max_differnce(Airplane_Node [][] mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        Airplane_Node[][] matrix=build_mat(mat);
        return mat[n-1][m-1].max_cost-mat[n-1][m-1].min_cost;
    }


    public static void main(String [] args)
    {
        AirPlane_dis_between plane=new AirPlane_dis_between();
        Airplane_Node[][] matrix={{new Airplane_Node(1,2),new Airplane_Node(2,3),new Airplane_Node(3,4),new Airplane_Node(4,1)},
                {new Airplane_Node(2,1),new Airplane_Node(1,1),new Airplane_Node(3,2),new Airplane_Node(1,3)},
                {new Airplane_Node(2,1),new Airplane_Node(2,3),new Airplane_Node(1,1),new Airplane_Node(2,1)},
                {new Airplane_Node(3,1),new Airplane_Node(3,2),new Airplane_Node(1,1),new Airplane_Node(1,2)}};
//
//        System.out.println(plane.is_on_path(matrix,new Point(0,0),new Point(3,3)));
//        System.out.println(plane.is_on_path(matrix,new Point(0,0),new Point(1,1)));
//        System.out.println(plane.is_on_path(matrix,new Point(1,1),new Point(3,3)));

        System.out.println(plane.is_on_path(matrix,new Point(1,1),new Point(3,3)));    }


}
