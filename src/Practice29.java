class acd{
    void peak(){
        int arr[]={1,1,3,4,2,3,5,7,0};

        for (int n=1; n<=arr.length-1; n++){
            if(arr[n-1]<arr[n] && arr[n]>arr[n+1]){
                System.out.println(arr[n]);
                break;
            }
        }
    }
}

public class Practice29 {
    public static void main(String[] args) {
        acd obj = new acd();
        obj.peak();
    }
}
