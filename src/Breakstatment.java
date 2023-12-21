public class Breakstatment {
    public static void main(String[] args) {


//        while(true){
//            if(num%5==0 && num%7==0){
//                System.out.println(+num);
//                break;
        //num++;

        for (int num = 1; num % 5 == 0 && num % 7 == 0; num++){
            System.out.println(num);
        }
    }
}