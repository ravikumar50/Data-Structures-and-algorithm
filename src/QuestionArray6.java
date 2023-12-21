import java.util.Scanner;

class union {

    public void Array(int[] arr1, int[] arr2) {
        int c = 0;

//        int[] ans = new int[arr1.length + arr2.length];
//        for (int i = 0; i < arr1.length; i++) {
//            ans[i] = arr1[i];
//            c++;
//        }
        int y = 0;
        int x = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    y++;
                }
            }
        }
        System.out.println(arr1.length + arr2.length - y);
    }
}

        public class QuestionArray6 {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter the length of first Array");
                int a = sc.nextInt();

                int[] arr1 = new int[a];
                System.out.println("Enter the elements of first Array");
                for (int n = 0; n < a; n++) {
                    arr1[n] = sc.nextInt();
                }

                System.out.println("Enter the length of second Array");
                int b = sc.nextInt();

                int[] arr2 = new int[b];
                System.out.println("Enter the elements of second Array");
                for (int n = 0; n < b; n++) {
                    arr2[n] = sc.nextInt();
                }
                union obj = new union();
                obj.Array(arr1, arr2);
            }

        }

