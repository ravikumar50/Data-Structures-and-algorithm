import java.sql.SQLOutput;
import java.util.Scanner;
public class RajaBabu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to our programme Raja Babu");
        System.out.println("How are you feeling?");
        System.out.println("1.Happy     2.Sad      3.Other");
        int a = sc.nextInt();

        if(a==1){
            System.out.println("What is the reason behind your happiness?");
            System.out.println("1.Momos khilaya tha usko isiliye");
            System.out.println("2.Tailor ke pass gaya tha uska kapda silwane isiliye");
            System.out.println("3.Bisleri ka bottle kharid ke diya tha usko isiliye");
            int b= sc.nextInt();
            if(b>0 && b<4) {
                System.out.println("Focus nhi hai tumhara study ko lekar");
                System.out.println("Coding karo Raja Babu");
            } else{
                System.out.println("Focus nhi hai tumhara");
                System.out.println("Teen hi option hai bsdk##***");
                System.out.println("Aankh me Lauda dhasa hai kya chutiye");
            }
        } else if (a==2){
            System.out.println("What is the reason behind your sadness");
            System.out.println("1.Bimar ho gaya tha coca-cola pi kar isiliye");
            System.out.println("2.Naha kar gay tha to docter ne daat lagaya tha isiliye");
            System.out.println("3.Ladki ke chakar me paisa kharch ho gaya isiliye");
            int b= sc.nextInt();
            if(b>0 && b<4){
                System.out.println("Focus nhi hai tumhara Health ko lekar");
                System.out.println("Aaram kar laude");
            } else{
                System.out.println("Focus nhi hai tumhara");
                System.out.println("Teen hi option hai bsdk##***");
                System.out.println("Aankh me Lauda dhasa hai kya chutiye");
            }
        } else if(a==3){
            System.out.println("feeling HORNY");
            System.out.println("1.Yes      2.No");
            int c = sc.nextInt();

            if (c == 1) {
                System.out.println("Whom do do want?");
                System.out.println("1.Male     2.Female");
                System.out.println("3.Koi bhi chalega");
                int d=sc.nextInt();

                if(d==1){
                    System.out.println("Sabka favorite JONNY SINS chalega");
                    System.out.println("1.Yes    2.No");
                    int e= sc.nextInt();

                    if(e==1){
                        System.out.println("JONNY SINS ko kis roop me dekhna chahta hai");
                        System.out.println("1.Docter    2.Plumber    3.Astronaut");
                        int f= sc.nextInt();
                        System.out.println("Focus nhi hai tumhara study ko lekar");
                        System.out.println("Ja kar padhayi karo");
                    } else if (e==2){
                        System.out.println("Focus nhi hai tumhara PORN par");
                        System.out.println("Ja kar PORN dekho");
                    } else{
                        System.out.println("Focus nhi hai tumhara");
                        System.out.println("Do hi option hai bsdk##***");
                        System.out.println("Aankh me Lauda dhasa hai kya chutiye");
                    }
                 } else if (d==2){
                    System.out.println("1.Sabki favorite DANI DANIALS");
                    System.out.println("2.Ya phir tumhari SUNNY LEONE");
                    System.out.println("3.Ya phir chasmish MIA KHALIFA");
                    int g=sc.nextInt();
                    if (g<4 && g>0){
                        System.out.println("kitne min ka video chahiye");
                        System.out.println("1.10sec me kaam chal jayega");
                        System.out.println("2.Ya kuch lamba chahiye");
                        int h = sc.nextInt();

                        if(h==1){
                            System.out.println("Focus nhi hai tumhara padhayi ko lekar");
                            System.out.println("Padhayi bhi 10 sec karta hai kya");
                        } else if (h==2){
                            System.out.println("Focus nhi hai tumhara life ko lekar");
                            System.out.println("Sirf Lamba-Lamba chahiye");
                        } else{
                            System.out.println("Focus nhi hai tumhara");
                            System.out.println("Do hi option hai bsdk##***");
                            System.out.println("Aankh me Lauda dhasa hai kya chutiye");
                        }
                    } else {
                        System.out.println("Focus nhi hai tumhara");
                        System.out.println("Teen hi option hai bsdk##***");
                        System.out.println("Aankh me Lauda dhasa hai kya chutiye");
                    }
                } else if(d==3){
                    System.out.println("Pant kholo hum tumhara Gaand mar lete hai");
                } else{
                    System.out.println("Focus nhi hai tumhara");
                    System.out.println("Teen hi option hai bsdk##***");
                    System.out.println("Aankh me Lauda dhasa hai kya chutiye");
                }
            } else if(c==2){
                System.out.println("Ja kar padhayi par focus kar BSDK**##");
                System.out.println("Yaha kya gaand marwane aaya hai");
            } else{
                System.out.println("Focus nhi hai tumhara");
                System.out.println("Do hi option hai bsdk##***");
                System.out.println("Aankh me Lauda dhasa hai kya chutiye");
            }
        }else{
            System.out.println("Focus nhi hai tumhara");
            System.out.println("Teen hi option hai bsdk##***");
            System.out.println("Aankh me Lauda dhasa hai kya chutiye");
        }
    }
}
