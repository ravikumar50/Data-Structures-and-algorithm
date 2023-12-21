package RMI;

import java.rmi.Naming;

public class Client2{
    public static void main(String[] args) throws Exception{
        ArrayInterface stub = (ArrayInterface) Naming.lookup("rmi://localhost:2425/ravi");
        int arr[] = {1,2,3,4,5};

        int ans = stub.arraySum(arr);
        System.out.println(ans);
    }
}
