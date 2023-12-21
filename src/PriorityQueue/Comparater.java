package PriorityQueue;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Comparater {
    private static class Student{
        String name;
        int roll;
        int marks;

        Student(String name, int roll, int marks){
            this.name = name;
            this.roll = roll;
            this.marks = marks;
        }
    }

    private static class StudentComparator implements Comparator<Student> {

        // overwriting

        public int compare(Student s1, Student s2){
            if(s1.roll>s2.roll) return 1;
            else if(s1.roll<s2.roll) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi",2206106,34);
        Student s2 = new Student("Shubham",2206036,37);
        Student s3 = new Student("Ram",2206076,38);
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());  // min heap;

        pq.add(s1);
        pq.add(s2);
        pq.add(s3);




        System.out.println(pq.peek().name);

    }
}
