import java.util.Scanner;

class year{
    int a;
}

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int n = 1; 1 < 2; n++) {

            System.out.println("Enter the Year");
            int a = sc.nextInt();
            if (a == 0) break;
            if (a % 100 == 0 && a%400==0 ) {
                System.out.println("It's a Leap Year");
            } else if(a%100!=0 && a%4==0) {
                System.out.println("It's a Leap Year");
            } else{
                System.out.println("It's not a Leap Year");
            }
        }
    }
}
