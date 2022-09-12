import java.rmi.*;
import java.rmi.server.*;

public class AdderRemote extends UnicastRemoteObject implements Adder {
	public AdderRemote()throws RemoteException{
		super();
	}
	public int addings(int i,int j){
		return i+j;
	}
}