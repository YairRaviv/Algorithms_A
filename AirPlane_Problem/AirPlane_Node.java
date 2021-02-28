package AirPlane_Problem;

import java.util.ArrayList;

public class AirPlane_Node
{
    public int x;
    public int y;
    public int min_cost;
    public int num_of_paths;
    public ArrayList<String> paths;

    public AirPlane_Node(int x,int y)
    {
        this.x=x;
        this.y=y;
        this.num_of_paths=0;
        this.paths=new ArrayList<>();
    }
}
