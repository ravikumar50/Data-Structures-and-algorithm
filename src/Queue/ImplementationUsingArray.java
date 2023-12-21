package Queue;

import java.util.Queue;

public class ImplementationUsingArray {

    static class queue{
        int arr[] = new int[100];
        int rear=0;
        int size=0;
        int front = 0;


        void add(int a){
            if(rear==arr.length) {
                System.out.print("Queue is full");
                return;
            }
            arr[rear++]=a;
            size++;
        }
        int peek(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

        int remove(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            int a = arr[front++];
            size--;
            return a;
        }

        void print(){
            if(size==0){
                System.out.println("Queue is Empty");
                return;
            }

            for(int i=front; i<rear; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        queue q = new queue();
        q.remove();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        q.print();
        q.remove();
        q.print();
        System.out.println(q.size);
        System.out.println(q.peek());
    }
}
