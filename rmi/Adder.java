import java.rmi.*;


public interface Adder extends Remote{
	public int addings(int i, int j ) throws RemoteException;
}