import java.util.Scanner;
public class Practice13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the cost price");
        int cp = sc.nextInt();

        System.out.println("Enter the selling price");
        int sp = sc.nextInt();

        int amt;
        if (sp>cp)
        {
           amt=sp-cp;
            System.out.println("The profit is - "+amt);
        } else if (cp>sp)
        {
            amt=cp-sp;
            System.out.println("The loss is - "+amt);
        } else {
            System.out.println("No loss No profit");
        }
    }
}
