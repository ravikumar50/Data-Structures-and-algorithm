import java.util.Scanner;

class array{

    void sum(){
        int[] arr= {1,5,3,4,6,2,1,3,4};

//        int sum =0;
//        for(int i=0; i<3; i++){
//            sum=sum+arr[i];
//        }
//        System.out.println("Sum of all elements of the array is : "+sum);
//          int max = 0;
//          for(int i=0; i<9; i++){
//              if(max<arr[i]){
//                  max=arr[i];
//              }
//          }
//        System.out.println(max);
 }

    void finding(){
        int[] arr = {2,4,6,7,8,7};
        Scanner sc = new Scanner(System.in);
 //   int x=7;

        int ans=-1;
        System.out.println("Enter the number");
        int a = sc.nextInt();
        for(int i=0; i<=5; i++){
            if(arr[i]==a){
                ans=i; break;
            }
            }
        System.out.println(ans);
            }
        }



public class Practice26 {
    public static void main(String[] args) {
        array obj = new array();
        obj.sum();
        obj.finding();




    }
}
