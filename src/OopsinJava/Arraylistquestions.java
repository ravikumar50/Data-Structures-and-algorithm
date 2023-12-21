package OopsinJava;

import java.util.Arrays;

public class Arraylistquestions {

    public static class arraylist{
        int[] arr = new int[2];
        int idx;
        int size;

        public void add(int element){
           if(size==arr.length){
               int[] brr = Arrays.copyOf(arr,arr.length*2);
               arr = brr;
           }
           arr[idx++]=element;
           size++;
        }
        public void set(int index, int value){
            arr[index]=value;
        }

    }
    public static void main(String[] args) {

        arraylist a = new arraylist();
        a.add(2);
        a.add(4);
        a.add(4);
        a.set(2,5);
        System.out.println(a.size);
        System.out.println(a.arr[2]);

    }
}
