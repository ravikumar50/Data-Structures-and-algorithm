import java.util.Scanner;

public class SortingQuestions2 {

    static void ques1(int arr[]){
        int n = arr.length;
        int a=-1;
        int b=-1;
        for(int i=1; i<n; i++){
            if(arr[i-1]>arr[i]){
                if(a==-1) {
                   a=i-1;
                   b=i;
                }else{
                    b=i;
                }
            }
        }
        int x =arr[a];
        arr[a]=arr[b];
        arr[b]=x;

    }
    static void swap(int arr[], int a, int b){
        int x =arr[a];
        arr[a]=arr[b];
        arr[b]=x;
    }

    static void ques2(int arr[]){
        int n=arr.length;
        int i=0;
        int j=n-1;
        while(i<j){
            if(arr[i]>0 && arr[j]<0){
                int x =arr[i];
                arr[i]=arr[j];
                arr[j]=x;
                i++;
                j--;
            }
            if(arr[i]<0) i++;
            if(arr[j]>0) j--;
        }
    }

    static void ques3(int arr[]){
        int n = arr.length;
        int max=2;
        int count[] = new int[max+1];

        for(int i=0; i<n; i++){
            count[arr[i]]++;
        }
        int k=0;
        for(int i=0; i<count.length; i++){
            for(int j=0; j<count[i]; j++){
                arr[k++]=i;
            }
        }
    }

    static void sorting0s1s2s(int arr[]){
        int n= arr.length;
        int low=0;
        int high=n-1;
        int mid=0;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,mid,low);
                mid++;
                low++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr,mid,high);
                high--;
            }
        }
    }

    static int rotatedSortedArrayMinimumElement(int arr[]){
        int n = arr.length;
        int ans=-1;
        for(int i=1; i<n; i++){
            if(arr[i-1]>arr[i]){
                ans = i;
            }
        }
        return ans;
    }

    static int rotatedSortedArraydUsingBinarySearchMinimumElement(int arr[]) {
        int n = arr.length;

        int ans = -1;
        int st =0;
        int end = n-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]>arr[n-1]){
                st=mid+1;
                }
            else if(arr[mid]<=arr[n-1]){
                end=mid-1;
                ans = mid;
            }
        }
        return ans;
    }

    static int rotatedSortedArrayfindingTargetElement(int arr[], int target){
        int n = arr.length;
        int st = 0;
        int end = n-1;
        int ans = -1;

        while(st<=end){
            int mid = st +(end-st)/2;
            if(arr[mid]==target) {
                return mid;
            }else if(arr[mid]<arr[end]) {
                if (target > arr[mid] && target <= arr[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }else{
                if(target>=arr[st] && target<arr[mid]){
                    end = mid-1;
                }else{
                    st=mid+1;
                }
            }
        }
        return ans;
    }

    static int rotatedSortedArrayfindingTargetElementWithDuplicate(int arr[], int target){

        int n = arr.length;
        int st = 0;
        int end = n-1;
        int ans = -1;

        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[st]==arr[mid] && arr[mid]==arr[end]){
                st++;
                end--;
            }
            else if(arr[mid]<=arr[end]){
                if(target>arr[mid] && target<=arr[end]){
                    st=mid+1;
                }else{
                    end= mid-1;
                }
            }
            else{
                if(target<arr[mid] && target>=arr[st]){
                    end=mid-1;
                }else{
                    st=mid+1;
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NewArr obj = new NewArr();
        int arr[] = obj.Array();

        System.out.println(rotatedSortedArraydUsingBinarySearchMinimumElement(arr));


    }
}
