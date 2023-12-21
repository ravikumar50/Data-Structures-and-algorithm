import java.util.*;
public class Students{

    final String name;
    int roll;

    static int numberOfStidents=0;

    Students(String name, int roll) {
        this.name = name;
        this.roll = roll;
        numberOfStidents++;
    }

    void display() {
        System.out.println(this.name);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Students s = new Students("Ravi", 2206106);
        Students s2 = new Students("Ra", 2206106);
        Students s3 = new Students("Rai", 2206106);
        System.out.println(s.name);
        s.display();
        System.out.println(Students.numberOfStidents);
    }
}

