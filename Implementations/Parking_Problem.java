package Implementations;

import java.util.LinkedList;

public class Parking_Problem
{
    public static int num_of_cars(LinkedList<LL_node_parking> list)
    {
        list.getFirst().data='v';
        boolean flag=true;
        LL_node_parking tmp=list.getFirst().next;
        int counter=1;
        while(flag)
        {
            if(tmp.data=='v')
            {
                tmp.data='w';
                int i = counter;
                while (i>0)
                {
                    tmp=tmp.prev;
                    i--;
                }
                if(tmp.data=='w')
                {
                    return counter;
                }
                else
                {
                    counter=1;
                    tmp=list.getFirst();
                }
            }
            else
            {
                tmp=tmp.next;
                counter++;
            }
        }
        return counter;
    }

    public static void main(String [] args)
    {
        LinkedList<LL_node_parking> list=new LinkedList<LL_node_parking>();
        LL_node_parking a=new LL_node_parking('a');
        LL_node_parking b=new LL_node_parking('b');
        LL_node_parking c=new LL_node_parking('c');
        LL_node_parking d=new LL_node_parking('d');
        LL_node_parking e=new LL_node_parking('e');
        LL_node_parking f=new LL_node_parking('f');
        LL_node_parking g=new LL_node_parking('g');
        LL_node_parking h=new LL_node_parking('h');
        LL_node_parking i=new LL_node_parking('i');
        LL_node_parking j=new LL_node_parking('j');
        LL_node_parking k=new LL_node_parking('k');
        a.prev=k;
        a.next=b;
        b.prev=a;
        b.next=c;
        c.prev=b;
        c.next=d;
        d.prev=c;
        d.next=e;
        e.prev=d;
        e.next=f;
        f.prev=e;
        f.next=g;
        g.prev=f;
        g.next=h;
        h.prev=g;
        h.next=i;
        i.prev=h;
        i.next=j;
        j.prev=i;
        j.next=k;
        k.prev=j;
        k.next=a;
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
        list.add(k);
        System.out.println(num_of_cars(list));


    }

}
