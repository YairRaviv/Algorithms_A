package Crystal_Balls_Problem;

import Marathon_Gil.Node_crystal_balls;

import java.util.Arrays;

public class Crystal_ball_with_path
{
    public static String  Crystal_ball_path(int floors,int balls)
    {
        int [][] mat=new int[balls+1][floors+1];
        Node_crystal_balls[][] path=new Node_crystal_balls[balls+1][floors+1];
        //HashMap<String,String> path=new HashMap<>();
        for(int i=1;i<floors+1;i++)
        {
            mat[1][i]=i;
        }
        for(int i=1;i<balls+1;i++)
        {
            mat[i][1]=1;
        }
        for(int i=2;i<balls+1;i++)
        {
            for(int j=2;j<floors+1;j++)
            {
                int min=Integer.MAX_VALUE;
                for(int k=1;k<j;k++)
                {
                    int max=Math.max(mat[i][k-1],mat[i-1][j-k]);
                    if(max<min)
                    {
                        min=max;
                        if(mat[i][k-1]>mat[i-1][j-k])
                        {
                            path[i][j]=new Node_crystal_balls(i,k-1,j-k+1);
                        }
                        else
                        {
                            path[i][j]=new Node_crystal_balls(i-1,j-k,path[i-1][j-k].num_of_floor+j-k+1);
                        }
                    }
                }
                mat[i][j]=min+1;
            }
        }
        for(int i=0;i<balls+1;i++)
        {
            System.out.println(Arrays.toString(mat[i]));
        }
        return Path(path,balls,floors);

    }
    public static String Path(Node_crystal_balls[][] path,int n,int m)
    {
        String ans="";
        int flag=1;
        int i=0;
        int j=0;
        while(path[n][m]!=null)
        {
            i=path[n][m].i;
            j=path[n][m].j;
            ans=ans+"->"+path[n][m].num_of_floor;

            n=i;
            m=j;
        }
        if(j==0||i==0)return ans;
        i=j;
        while(j>0)
        {
            ans=ans+"->"+(i-j+1);
            j--;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(Crystal_ball_path(100,3));
    }
}
