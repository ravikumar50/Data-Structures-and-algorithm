import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class New{

    public static float BODMAS(ArrayList<String> arr) {
        float ans = 0;
        for(int i=0; i<arr.size(); i++){
            String s = arr.get(i);

            if(s.equals("*") || s.equals("/")){
                float a = Float.valueOf(arr.remove(i-1));
                String op = arr.remove(i-1);
                float b = Float.valueOf(arr.remove(i-1));

                if(op.equals("*")) ans = a*b;
                else{
                    if(b==0){
                        System.out.println("Can't divide by 0");
                        return -1;
                    }
                    ans = a/b;
                }
                arr.add(i-1,String.valueOf(ans));
                i--;
            }

            if(i==arr.size()-2) break;
        }
        while(arr.size()!=1){

            float a = Float.valueOf(arr.remove(0));
            String s = arr.remove(0);
            float b = Float.valueOf(arr.remove(0));


            if(s.equals("+")) ans = a+b;
            else if(s.equals("-")) ans = a-b;
            else if(s.equals("*")) ans = a*b;
            else if(s.equals("/")) ans = a/b;
            else {
                System.out.println("You have entered wrong operator");
                return -1;
            }

            arr.add(0,String.valueOf(ans));
        }

        return Float.valueOf(arr.get(0));
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();

        System.out.println("Enter the expression to be evaluated");

        String str = sc.nextLine();


        for(int i=0; i<str.length(); i++){
            if((str.charAt(i)<48 || str.charAt(i)>57) && (str.charAt(i+1)<48 || str.charAt(i+1)>57)){
                System.out.println("You have Entered wrong Operator");
                return;
            }

            if(str.charAt(i)<48 || str.charAt(i)>57){
                arr.add(String.valueOf(str.charAt(i)));
            }else {
                String s = "";
                while ((str.charAt(i) >= 48 && str.charAt(i) <= 57) || str.charAt(i)=='.') {
                    if(str.charAt(i)=='.' && str.charAt(i+1)=='.'){
                        System.out.println("You have Entered Wrong expression");
                        return;
                    }
                    s = s + str.charAt(i);
                    if(i== str.length()-1) break;
                    i++;
                }
                arr.add(s);
                if(i==str.length()-1) break;
                i--;
            }
        }

        if(arr.size()>9) {
            System.out.println("You have Enter extra expression than reqiured");
            System.out.println("Please enter upto 9 expression");
        }

        float ans = BODMAS(arr);
        System.out.println(ans);
    }

    public static class new1 {

        public static void main(String[] args) {
            try {
                // (i) Input '50' unsorted signed integers from text file 'input.txt' into object of NewSortedArrList
                Scanner scanner = new Scanner(new File("input.txt"));
                NewSortedArrList newList = new NewSortedArrList();
                while (scanner.hasNext()) {
                    newList.add(scanner.nextInt());
                }
                scanner.close();

                // (ii) Display all unsorted integers in NewSortedArrList object at that moment
                System.out.println("Unsorted List: ");
                System.out.println(newList);

                // (iii) Perform merge sort on them
                // (iv) Display ascending order list of 50 integers in NewSortedArrList object
                System.out.println("Ascending Order List: ");
                System.out.println(NewSortedArrList.ascending(newList));
                // (v) Add another integer to that NewSortedArrList object
                newList.add(123);

                // (vi) Re-display ascending order list of '51' integers in NewSortedArrList object
                System.out.println("Updated Ascending Order List: ");
                System.out.println(NewSortedArrList.ascending(newList));
                // (vii) Save the sorted list of 51 integers in text file 'output.txt'
                FileWriter writer = new FileWriter("output.txt");
                for (Integer num : newList) {
                    writer.write(num + " ");
                }
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
