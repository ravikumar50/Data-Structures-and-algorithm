import java.util.Scanner;

public class BinarySearch {

    static int binarySearchUsingRecursion(int arr[],int st, int end,int target){

        if(st>=end) return -1;

        int ans = -1;
        int mid=(st+end)/2;


        if(arr[mid]==target){
            ans=mid;
        }else if(arr[mid]>target){
            ans = binarySearchUsingRecursion(arr,st,mid-1,target);
        }else if(arr[mid]<target){
             ans = binarySearchUsingRecursion(arr,mid+1,end,target);
        }
        return ans;
    }

    static int binarySearch(int arr[], int target){
        int n = arr.length;
        int st=0;
        int end=n-1;

       int ans =-1;

        while(st<=end){
            int mid=(st+end)/2;
            if(arr[mid]==target) {
                ans=mid;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans;
    }

    static int findingSquareRoot(int num){

        int ans =0;
        int st =0;
        int end=num;
        while(st<=end){
            int mid=st+(end-st)/2;
            int x = mid*mid;
            if(x==num){
                return mid;
            }
            else if(x>num){
                end=mid-1;
            }
            else{
                st=mid+1;
                ans=mid;
            }
        }
        return ans;
    }

    static int binarySearchFirstOccurance(int arr[], int target){
        int n = arr.length;
        int st=0;
        int end=n-1;

        int ans =-1;

        while(st<=end){
            int mid=(st+end)/2;
            if(arr[mid]==target) {
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[]=obj.Array();
        int n= arr.length;
        int k = sc.nextInt();

        System.out.println(binarySearchUsingRecursion(arr,0,n-1,k));

    }
}
