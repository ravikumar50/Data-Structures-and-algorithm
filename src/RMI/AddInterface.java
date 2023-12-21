package RMI;

import java.rmi.Remote;

public interface AddInterface extends Remote {

    public int Add(int a, int b) throws Exception;
}
