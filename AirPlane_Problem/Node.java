package AirPlane_Problem;

import java.util.ArrayList;

public class Node
{
    int x, y,min_cost;
    ArrayList<String> all_paths;
    public Node(int x, int y)
    {
        this.all_paths=new ArrayList<>();
        this.x = x;
        this.y = y;
    }

}
