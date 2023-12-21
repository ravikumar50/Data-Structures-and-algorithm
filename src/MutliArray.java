class Example {
    void demoMulti(){
        int[][] ages = new int[2][3];
        int[][] arr ={{12,23},{24,54},{76,45}};

        ages[0][0] = 24;
        ages[0][1] = 45;
        ages[0][2] = 34;
        ages[1][0] = 54;
        ages[1][1] = 65;
        ages[1][2] = 12;

        for(int i=0; i< arr.length; i++){         // arr.lenght =3
            for(int j=0; j<arr[i].length; j++)    // arr[i].lenght =2
                System.out.println(arr[i][j]);
            }
        }

//        System.out.println(ages[1][2]);
//        System.out.println(arr[1][1]);
//        System.out.println(ages.length);
//        System.out.println(arr.length);
    }


public class MutliArray {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.demoMulti();


    }
}

