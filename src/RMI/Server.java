package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public Server(){

    }
    public static void main(String[] args) throws Exception {
        AddInterface stub = new AddClass();
        LocateRegistry.createRegistry(6789);
        Naming.rebind("rmi://localhost:6789/ravi",stub);
        System.out.println("Server has Started");
    }
}
