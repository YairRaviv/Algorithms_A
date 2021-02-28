package Implementations;

import java.util.Arrays;

public class Max_Max_Array
{
    public static void Max_Max(int [] arr)
    {
        Max_Max_Node[]array=new Max_Max_Node[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            array[i]=new Max_Max_Node(arr[i]);
        }
        int index=max_index_rec(array,0,array.length-1);
        int max_1=array[index].num;
        int max_2=array[index].st.pop();
        while(!array[index].st.empty())
        {
            int tmp=array[index].st.pop();
            if(tmp>max_2)max_2=tmp;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("max_1 is :"+max_1);
        System.out.println("max_2 is :"+max_2);
    }

    public static int max_index_rec(Max_Max_Node[] arr,int start,int end)
    {
        if(start<end)
        {
            int index=0;
            int middle=(int)(start+end)/2;
            int i=max_index_rec(arr,start,middle);
            int j=max_index_rec(arr,middle+1,end);
            if(arr[i].num>arr[j].num)
            {
                index=i;
                arr[i].st.push(arr[j].num);
            }
            else
            {
                index=j;
                arr[j].st.push(arr[i].num);
            }
            return index;
        }
        return start;
    }


    public static void main(String [] args)
    {
        int [] arr=new int[20];
        for (int i=0;i<20;i++)
        {
            arr[i]=(int)(Math.random()*100)+1;
        }
        Max_Max(arr);

    }
}
