import java.util.Scanner;
public class AgeGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age");
        int age=sc.nextInt();

        if(age<=12)
        if (age<=5){
            System.out.println("Baby");
        } else {
            System.out.println("child");
        }else if (age>12 && age<=18) {
            System.out.println("Teenage");
        } else {
            System.out.println("Adult");
        }
    }
}
