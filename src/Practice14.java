import java.util.Scanner;
public class Practice14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the marks obtained by the student");
        int marks = sc.nextInt();

        if (marks>=90){
            System.out.println("A+");
        } else if (marks>=80){
            System.out.println("A");
        } else if (marks>=70){
            System.out.println("B");
        } else if (marks>=60){
            System.out.println("C");
        } else if (marks>=50){
            System.out.println("D");
        } else if (marks>=40){
            System.out.println("E");
        } else {
            System.out.println("Fail");
        }

        }

    }
