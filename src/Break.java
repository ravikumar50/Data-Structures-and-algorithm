import java.util.Scanner;
public class Break {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number");
        int a = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();
//        for(int n=5; n>=5; n++){
//            if(n%5==0 && n%7==0){
//                System.out.println(n);
//                break;
//            }
        for (int n = 1; n <= a * b; n++) {
            if (n % a == 0 && n % b == 0) {
                System.out.println(n);
                break;
            }
        }

    }
}