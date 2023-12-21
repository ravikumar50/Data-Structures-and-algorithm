class Details {
    String Name;
    int YOJ;
    int Salary;
    String Address;
}

public class Employee{
    public static void main(String[] args) {
        Details a = new Details();
        a.Name="Rohit";
        a.YOJ=2027;
        a.Salary=999999999;
        a.Address="Katihar";

        Details b = new Details();
        b.Name="Ravi";
        b.YOJ=2026;
        b.Salary=10000000;
        b.Address="Chhapra";

        Details c = new Details();
        c.Name="Prince";
        c.YOJ=2026;
        c.Salary=20000000;
        c.Address="Vaishali";


        System.out.println("Name"+"         "+"YOJ"+"     "+"Salary"+"       "+"Address");
        System.out.println(a.Name+"         "+a.YOJ+"    "+a.Salary+"       "+a.Address);
        System.out.println(b.Name+"         "+b.YOJ+"    "+b.Salary+"       "+b.Address);
        System.out.println(c.Name+"         "+c.YOJ+"    "+c.Salary+"       "+c.Address);

    }
}
