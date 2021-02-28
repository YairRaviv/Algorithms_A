package Implementations;

import java.util.LinkedList;

public class Tourtle_Rabbit
{
    public static int Tourtle_Rabbit(LinkedList<Rabbit_Tourtle_Node> list)
    {
        Rabbit_Tourtle_Node rabbit=list.getFirst();
        Rabbit_Tourtle_Node tourtle =list.getFirst();
        while(true)
        {
            rabbit=rabbit.next.next;
            tourtle=tourtle.next;
            if(tourtle.id==rabbit.id)
            {
                rabbit=list.getFirst();
                break;
            }
        }
        int arm=0;
        int circle=0;
        while(rabbit.id!=tourtle.id)
        {
            rabbit=rabbit.next;
            tourtle=tourtle.next;
            arm++;
        }
        while(true)
        {
            rabbit=rabbit.next;
            circle++;
            if(rabbit.id==tourtle.id)
            {
                break;
            }
        }
        System.out.println("the arm length is : "+arm);
        System.out.println("the circle length is : "+circle);
        return circle;
    }


    public static void main(String [] args)
    {
        LinkedList<Rabbit_Tourtle_Node> list=new LinkedList<Rabbit_Tourtle_Node>();
        Rabbit_Tourtle_Node a=new Rabbit_Tourtle_Node(1);
        Rabbit_Tourtle_Node b=new Rabbit_Tourtle_Node(2);
        Rabbit_Tourtle_Node c=new Rabbit_Tourtle_Node(3);
        Rabbit_Tourtle_Node d=new Rabbit_Tourtle_Node(4);
        Rabbit_Tourtle_Node e=new Rabbit_Tourtle_Node(5);
        Rabbit_Tourtle_Node f=new Rabbit_Tourtle_Node(6);
        Rabbit_Tourtle_Node g=new Rabbit_Tourtle_Node(7);
        Rabbit_Tourtle_Node h=new Rabbit_Tourtle_Node(8);
        Rabbit_Tourtle_Node i=new Rabbit_Tourtle_Node(9);
        Rabbit_Tourtle_Node j=new Rabbit_Tourtle_Node(10);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        g.next=h;
        h.next=i;
        i.next=j;
        j.next=a;
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        list.add(i);
        list.add(j);
        System.out.println(Tourtle_Rabbit(list));


    }

}
