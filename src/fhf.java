import java.util.Scanner;

public class fhf {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);


        int a=sc.nextInt();
        int b=sc.nextInt();


        for(int i=a; i<=b; i++){
            int count=0;
            for(int j=1; j<=i; j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count==2){
                System.out.println(i);
            }
        }
    }
}
