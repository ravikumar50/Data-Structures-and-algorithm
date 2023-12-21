import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int roll = sc.nextInt();
        String interest = sc.next();
        System.out.println("name is : "+name);
        System.out.println("roll is : "+roll);
        System.out.println("My interest is in : "+interest);
    }
}
