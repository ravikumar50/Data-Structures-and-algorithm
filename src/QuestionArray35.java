import java.util.Scanner;

public class QuestionArray35 {

     static void area(int[] arr){
         int x = arr.length;

         int area=0;

         for(int i=0; i<x; i++){
             for(int j=0; j<x; j++){
                 if(arr[i]>= arr[j]){
                      int ans=arr[j]*Math.abs((i-j));
                      if(ans>area){
                          area=ans;
                      }
                 }else{
                     int ans=arr[i]*Math.abs((i-j));
                     if(ans>area){
                         area=ans;
                     }
                 }
             }
         }
         System.out.println("Maximum area is "+area);
     }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int [] arr = obj.Array();

        area(arr);

    }
}
