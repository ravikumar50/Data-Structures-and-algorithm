import java.util.Scanner;
class Fabo{
    public int fabo(int n){
            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }

        int faboNm1=fabo(n-1);
        int faboNm2=fabo(n-2);
        int faboN=faboNm1+faboNm2;
        return faboN;
    }
}

public class Fabonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter how many fabonacci number you want");
        int n=sc.nextInt();

        Fabo obj = new Fabo();

        System.out.println("fabonacci of "+n+" is "+obj.fabo(n));




    }
}
