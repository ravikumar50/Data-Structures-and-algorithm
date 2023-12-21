package RMI;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
public class ArrayRemote extends UnicastRemoteObject implements ArrayInterface{
    ArrayRemote() throws Exception{};

    public int arraySum(int arr[]){
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            ans+=arr[i];
        }
        return ans;
    }
}
