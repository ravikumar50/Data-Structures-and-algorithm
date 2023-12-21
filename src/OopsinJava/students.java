package OopsinJava;

public class students {
    public String name;  // public == can be used in different pacakages also.
    int roll;
    int marks;
    final String schoolName = "SSPS";  // it cannot be changed.
    float cgpa;
    static int noOfStudents;  // using static it is object independent and class dependent.

    public students(String name, int roll, int marks, float cgpa) {  //constructer with passing parameters
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        this.cgpa = cgpa;
        noOfStudents++;

    }
    public students(){    // make a void construct so that you can write value.

    }
    public int getroll(){   // for private things.
        return roll;
    }
    public void setroll(int x){
        roll=x;
    }

    public void setcgpa(float cgpa){   //same name as of the attribute then
        this.cgpa=cgpa;                // we have to use the "this" keyword
    }



}
