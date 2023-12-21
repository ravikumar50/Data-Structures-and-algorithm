class abd{
    void list(){
        String word[]={"ab", "bc", "cd", "de", "ef", "fg", "gh", "hi","ij"};
         int arr[]={2,-3,5,8,1,-4,0};


         int min =0;
         for(int n=0; n<=6; n++) {
             if (min > arr[n]) {
                 min = arr[n];
             }
         }
        System.out.println(min);


 //       for (int n=0; n<=8; n++){
 //           if(n%2==0){
 //               System.out.println(word[n]);
            }
        }


public class Practice28 {
    public static void main(String[] args) {
        abd obj = new abd();
        obj.list();
    }
}
