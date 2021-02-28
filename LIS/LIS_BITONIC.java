package LIS;

import java.util.Arrays;

public class LIS_BITONIC
{

    public static int[] lisSize_array_to_i(int[] arr)
    { // only size - O(nlog(n))
        int n = arr.length;
        int[] lis = new int[n];
        lis[0]=arr[0];
        int [] lis_to_i=new int[n];
        lis_to_i[0]=1;
        int k=1;
        for(int i=1;i<n;i++)
        {
            int pos=Arrays.binarySearch(lis,0,k,arr[i]);
            // System.out.println("pos is :"+pos);
            if(pos<0)
            {
                pos=-pos;
                pos--;
            }
            //System.out.println("this is lis array " +Arrays.toString(lis)+", the position for "+arr[i]+" is "+pos );
            lis[pos]=arr[i];
            lis_to_i[i]=pos+1;
            if(pos==k)k++;
        }
        return lis_to_i;
    }

    public static int deacrese_lis(int [] arr)
    {
        int n=arr.length;
        int [] r_arr=new int[n];
        for(int i=0;i<n;i++)
        {
            r_arr[i]=arr[n-1-i];
        }
        System.out.println(Arrays.toString(r_arr));
        return lisSize(r_arr);
    }


        public static int lisSize(int[] arr)
        { // only size - O(nlog(n))
            int n = arr.length;
            int[] lis = new int[n];
            lis[0]=arr[0];
            int [] lis_to_i=new int[n];
            int k=1;
            for(int i=1;i<n;i++)
            {
                int pos=Arrays.binarySearch(lis,0,k,arr[i]);
               // System.out.println("pos is :"+pos);
                if(pos<0)
                {
                    pos=-pos;
                    pos--;
                }
                System.out.println("this is lis array " +Arrays.toString(lis)+", the position for "+arr[i]+" is "+pos );
                lis[pos]=arr[i];
                if(pos==k)k++;
            }
            return k;
        }

//        public static int[] lis(int[] arr)
//        { // O(n^2)
//
//
//        }

    public static int ldis(int [] arr)
    {
        int n=arr.length;
        int [] r_arr=new int[n];
        for(int i=0;i<n;i++)
        {
            r_arr[i]=arr[n-1-i];
        }
        int [] arr_of_deacrese=lisSize_array_to_i(r_arr);
        int [] arr_of_increase=lisSize_array_to_i(arr);
        System.out.println(Arrays.toString(arr_of_deacrese));
        System.out.println(Arrays.toString(arr_of_increase));
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr_of_increase[i]+arr_of_deacrese[n-1-i]-1)
            {
                max=arr_of_increase[i]+arr_of_deacrese[n-1-i]-1;
            }
        }
        return max;

    }

        public static void main(String[] args) {

            int [] arr = {1,3,2,4,3,4,1};
            int [] b_arr={1,4,3,4,2,3,1};
            System.out.println(ldis(arr));
            //System.out.println(Arrays.toString(lis(new int[] {1,9,10,5,6})));
        }


}
