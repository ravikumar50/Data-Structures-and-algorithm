public class Continue {
    public static void main(String[] args) {

//        int num=1;
//
//        while(num<=20){
//            if(num%5==0){
//                num++;
//                continue;
//            }
//            System.out.println(num);
//            num++;
//        }
//    }
        for (int num = 1; num <= 20; num++) {
            if (num % 5 == 0) {
                continue;
            }
            System.out.println(num);
        }
    }
}