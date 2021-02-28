package Implementations;

import Test_2015_A_A.Test_2017_B_B.Max_Max_Node;

import java.util.Arrays;

public class Max_Max_rec_ind
{
    public static void max_max_recursive(int [] arr)
    {
        Max_Max_Node[] array=new Max_Max_Node[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            array[i]=new Max_Max_Node(arr[i]);
        }
        int index=find_index_rec(array,0,array.length-1);
        int max_1=array[index].num;
        int max2=array[index].st.pop();
        while(!array[index].st.empty())
        {
            int tmp=array[index].st.pop();
            if(tmp>max2)
            {
                max2=tmp;
            }
        }
        System.out.println("the arr is : "+ Arrays.toString(arr));
        System.out.println("max 1 is :"+max_1+", max 2 is : "+max2);
    }
    public static int find_index_rec(Max_Max_Node[] array, int start, int end)
    {
        if(start<end)
        {
            int index=0;
            int middle=(int)(start+end)/2;
            int i= find_index_rec(array,start,middle);
            int j=find_index_rec(array,middle+1,end);
            if(array[i].num>array[j].num)
            {
                index=i;
                array[i].st.push(array[j].num);
            }
            else
            {
                index=j;
                array[j].st.push(array[i].num);
            }
            return index;
        }
        else
        {
            return start;
        }
    }
    public static void Max_Max_Inductive(int [] arr)
    {
        int max1,max2;
        if(arr[0]>arr[1])
        {
             max1=arr[0];
             max2=arr[1];
        }
        else
        {
             max2=arr[0];
             max1=arr[1];
        }

        for(int i=2;i<arr.length-1;i+=2)
        {
            if(arr[i]>arr[i+1])
            {
                if(arr[i]>max1)
                {
                    if(arr[i+1]>max1)
                    {
                        max1=arr[i];
                        max2=arr[i+1];
                    }
                    else
                    {
                        max2=max1;
                        max1=arr[i];
                    }
                }
                else
                {
                    if(arr[i]>max2)
                    {
                        max2=arr[i];
                    }
                }
            }
            else
            {
                int tmp =arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
                if(arr[i]>max1)
                {
                    if(arr[i+1]>max1)
                    {
                        max1=arr[i];
                        max2=arr[i+1];
                    }
                    else
                    {
                        max2=max1;
                        max1=arr[i];
                    }
                }
                else
                {
                    if(arr[i]>max2)
                    {
                        max2=arr[i];
                    }
                }
            }
        }
        if(arr.length%2!=0)
        {
            if(max1<arr[arr.length-1])max1=arr[arr.length-1];
            else if(max2<arr[arr.length-1])max2=arr[arr.length-1];
        }

        System.out.println("the arr is : "+ Arrays.toString(arr));
        System.out.println("max 1 is :"+max1+", max 2 is : "+max2);


    }

    public static void main(String [] args)
    {
        int [] arr=new int[20];
        for (int i=0;i<20;i++)
        {
            arr[i]=(int)(Math.random()*100)+1;
        }
        Max_Max_Inductive(arr);

    }
}
