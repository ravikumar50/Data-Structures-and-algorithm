package RMI;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class AddClass extends UnicastRemoteObject implements AddInterface{

    AddClass() throws RemoteException{

    }
    public int Add(int a, int b){
        return a+b;
    }
}
