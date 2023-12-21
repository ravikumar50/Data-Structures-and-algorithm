import java.util.Scanner;

public class BinarySearchOn2D {

    static boolean binarySearch(int arr[], int k){
        int n= arr.length;
        int i = 0;
        int j = n-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]==k) return true;
            else if(arr[mid]>k){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return false;
    }

    static boolean binarySearch2D(int[][] arr, int k){
        int n = arr.length;
        int m = arr[0].length;

        for(int x=0; x<n; x++){                //tc= O(nlog(m))
            if(k>=arr[x][0] && k<=arr[x][m-1]){
                return binarySearch(arr[x],k);
            }
        }
        return false;
    }
    static boolean binarySearch2DBinaryApproach(int[][] arr, int k){
        int n = arr.length;
        int m = arr[0].length;                 // TC = O(log(mn));
        int i=0;
        int j=n*m-1;

        while(i<=j){
            int mid = i+(j-i)/2;
            int midEle=arr[mid/m][mid%m];
            if(midEle==k) return true;
            else if(midEle>k){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return false;
    }

    static boolean findindAElementInRowAndColumnWiseBothSorted(int arr[][], int k){
        int n = arr.length;
        int m = arr[0].length;
        int i=0,j=m-1;

        while(i<n && j>=0){
            if(arr[i][j]==k) return true;
            else if(arr[i][j]>k){
                j--;
            }else if(arr[i][j]<k){
                i++;

            }
        }
        return false;
    }

    static int PeakElement(int arr[]){
        int n = arr.length;

        int i=0,j=n-1;
        int ans = -1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid]>arr[mid-1]){
                ans = mid;
                i=mid+1;
            }else if(arr[mid]<arr[mid-1]){
                j=mid-1;
            }
        }
        return ans;

    }

    static int MultiplePeak(int arr[]){
        int n = arr.length;
        int i=0,j=n-1;
        int ans =-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if((mid==0 || arr[mid]>arr[mid-1]) && (mid==n-1 ||arr[mid]>arr[mid+1])){
                return mid;
            }
            else if(arr[mid]<arr[mid-1]){
                j=mid-1;
            }else if(arr[mid]>arr[mid]-1){
                ans = mid;
                i=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();
//        System.out.println("Enter the number of rows and column of Array");
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        int[][] arr = new int[n][m];
//        System.out.println("Enter "+m*n+" elements");
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                arr[i][j]=sc.nextInt();
//            }
//        }
//        System.out.println("Enter the target element");
//        int k = sc.nextInt();


        System.out.println(MultiplePeak(arr));
    }
}
