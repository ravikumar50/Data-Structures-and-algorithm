import java.util.Scanner;

public class RandomNumber {

    static void RandomInteger(int a, int b, int n){
        int x = b-a;
        for(int i=0; i<n; i++){
            System.out.print(a+(int)(Math.random()*x)+" ");
        }
    }

    static void RandomLong(int a, int b, int n){
        int x = b-a;
        for(int i=0; i<n; i++){
            System.out.print(a+(int)(Math.random()*x)+" ");
        }
    }

    static void RandomFloat(int a, int b, int n){
        int x = b-a;

        for(int i=0; i<n; i++){
            System.out.print((double) a+(Math.random()*(double)x)+" ");
        }
    }

    static void RandomDouble(int a, int b, int n){
        int x = b-a;

        for(int i=0; i<n; i++){
            System.out.print(a+(Math.random()*x)+" ");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the range of Numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter how many numbers you want");
        int n = sc.nextInt();

        System.out.println("Random Integer numbers between "+a+" to "+b);
        RandomInteger(a,b,n);

        System.out.println();
        System.out.println();

        System.out.println("Random Long numbers between "+a+" to "+b);
        RandomLong(a,b,n);

        System.out.println();
        System.out.println();

        System.out.println("Random Float numbers between "+a+" to "+b);
        RandomFloat(a,b,n);

        System.out.println();
        System.out.println();

        System.out.println("Random Float numbers between "+a+" to "+b);
        RandomDouble(a,b,n);

    }
}
