class Abc {
    void print() {
        int[] arr = {2, 3, 4, -2, -6, 4, -63, 5, 78, 34, 6, 4};

        for (int n = 0; n <= 11; n++) {
            if (arr[n] >= 0) {
                System.out.println(arr[n]);
            }
        }

    }
}


public class Practice27 {
    public static void main(String[] args) {
        Abc obj = new Abc();
         obj.print();

    }
}
