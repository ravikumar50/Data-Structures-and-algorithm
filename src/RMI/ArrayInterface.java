package RMI;
import java.rmi.*;

public interface ArrayInterface extends Remote{
    public int arraySum(int arr[]) throws Exception;
}