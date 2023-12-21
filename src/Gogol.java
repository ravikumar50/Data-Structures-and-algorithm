import java.util.Scanner;
public class Gogol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("G O G O L   T I M E S");
        System.out.println("Welcome to GOGOL TIMES");
        System.out.println("Are you interested in taking premium membership");
        System.out.println("1.Yes   2.No");
        int a = sc.nextInt();

        if (a == 1) {
            System.out.println("Current Plan");
            System.out.println("1.Rs 31 for one month");
            System.out.println("2.Rs 85 for three months");
            int b = sc.nextInt();

            if (b == 1) {
                System.out.println("Pay Rs 31 using this UPI ID- 6207754310536@paytm or using paytm number - 6207754310");
                System.out.println("Take screenshot and send it to the telegram ID @gogol_times");
                System.out.println("Thank you for contacting us ");
            } else if (b == 2) {
                System.out.println("Pay Rs 85 using this UPI ID- 6207754310536@paytm or using paytm number - 6207754310");
                System.out.println("Take screenshot and send it to the telegram ID @gogol_times");
                System.out.println("Thank you for contacting us ");
            } else {
                System.out.println("Invalid Request");
            }
        }
        else if (a == 2) {
            System.out.println("Thank you for contacting us ");
            System.out.println("Have a nice day Sir");
        } else {
            System.out.println("Invalid Request");
        }
    }
}

