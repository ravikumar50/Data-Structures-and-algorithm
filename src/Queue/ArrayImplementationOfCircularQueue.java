package Queue;

public class ArrayImplementationOfCircularQueue {

    public static class queue {
        int arr[] = new int[5];
        int front = 0;
        int rear = 0;
        int size = 0;

        void add(int a) {
            if (size==arr.length) {
                System.out.println("Queue is Full");
                return;
            }

            if (rear == arr.length && front != 0) rear = 0;

            arr[rear++] = a;
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
                front=rear=0;
                return -1;
            }
            int a = arr[front];
            if(front==arr.length-1) front = 0;
            else front++;

            size--;
            return a;
        }

        void print(){
            if(size==0) {
                System.out.println("Queue is Empty");
                return;
            }

            if(rear<=front){
                for(int i=front; i<arr.length; i++){
                    System.out.print(arr[i]+" ");
                }

                for(int i=0; i<rear; i++){
                    System.out.print(arr[i]+" ");
                }
            }else{
                for(int i=front; i<rear; i++){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }
    }
    public static void main(String[] args) {
        queue q = new queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.print();
        q.remove();
        q.remove();
        q.remove();
        q.print();
        q.add(6);
        q.print();
        q.remove();
        q.remove();
        q.print();
        q.add(7);
        q.add(8);
        q.remove();
        q.print();
        System.out.println(q.size);
    }
}
