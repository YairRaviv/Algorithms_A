package Crystal_Balls_Problem;

public class Q1_Crystal_Ball
{
    public int [] x;
    public int a;

    public Q1_Crystal_Ball(int [] x, int a)
    {
        this.x=x;
        this.a=a;
    }

    public int numberOfBreaks()
    {
        return this.x.length-floorIndex()-1;
    }

    public int floorIndex()
    {
        int [] x=this.x;
        int a=this.a;
        int n=x.length;
        int num=1;
        while(n>(num*(num+1)/2))
        {
            num++;
        }
        int curr_floor=num;
        int step=curr_floor-1;
        int num_of_checks=0;

        while(x[curr_floor]<a)
        {
            num_of_checks++;
            curr_floor+=step;
            step--;
            if(curr_floor>=n)curr_floor=n-1;
        }
        num_of_checks++;
        curr_floor-=(step+1);
        while(x[curr_floor]<a)
        {
            num_of_checks++;
            curr_floor++;
        }
        num_of_checks++;
        return curr_floor;
    }

    public int numberOfChecking()
    {
        int [] x=this.x;
        int a=this.a;
        int n=x.length;
        int num=1;
        while(n>(num*(num+1)/2))
        {
            num++;
        }
        int curr_floor=num;
        int step=curr_floor-1;
        int num_of_checks=0;

        while(x[curr_floor]<a)
        {
            num_of_checks++;
            curr_floor+=step;
            step--;
            if(curr_floor>=n)curr_floor=n-1;
        }
        curr_floor-=(step+1);
        while(x[curr_floor]<a)
        {
            num_of_checks++;
            curr_floor++;
        }

        return num_of_checks;
    }
    public static void main(String [] args)
    {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = i + 1;
        }
        Q1_Crystal_Ball tower = new Q1_Crystal_Ball(arr, 99);
        System.out.println("the ball break at floor : " + tower.floorIndex());
        System.out.println("the number of checking is : " + tower.numberOfChecking());
        System.out.println("the number of breaks floors  is : " + tower.numberOfBreaks());
    }
}
