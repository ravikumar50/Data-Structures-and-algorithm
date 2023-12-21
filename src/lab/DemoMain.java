import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class NewSortedArrList extends ArrayList<Integer> {

    // Default constructor
    public NewSortedArrList() {
        super();
    }

    // Parameterized constructor to initialize with an existing ArrayList
    public NewSortedArrList(ArrayList<Integer> list) {
        super(list);
        ascending(this);
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return super.isEmpty();
    }

    // Method to get the capacity (number of elements) of the list
    public int capacity() {
        return super.size();
    }

    // Method to add a single element in sorted fashion
    public boolean add(Integer element) {
        boolean result = super.add(element);
        // ascending(this);
        return result;
    }

    // Method to add multiple elements in sorted fashion
    public void addAll(ArrayList<Integer> elements) {
        super.addAll(elements);
        ascending(this);
    }

    // Method to convert the list to a string
    public String toString() {
        return super.toString();
    }

    // Static method to perform merge sort on elements of NewSortedArrList
    public static NewSortedArrList ascending(NewSortedArrList list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
            NewSortedArrList left = new NewSortedArrList(new ArrayList<>(list.subList(0, mid)));
            NewSortedArrList right = new NewSortedArrList(new ArrayList<>(list.subList(mid, list.size())));

            ascending(left);
            ascending(right);

            int i = 0, j = 0, k = 0;
            while (i < left.size() && j < right.size()) {
                if (left.get(i) < right.get(j)) {
                    list.set(k++, left.get(i++));
                } else {
                    list.set(k++, right.get(j++));
                }
            }

            while (i < left.size()) {
                list.set(k++, left.get(i++));
            }

            while (j < right.size()) {
                list.set(k++, right.get(j++));
            }
        }
        return list;
    }

}

public class DemoMain {

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