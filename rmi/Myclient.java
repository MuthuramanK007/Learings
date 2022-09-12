import java.rmi.*;  
import java.util.*;

public class Myclient{  
	public static void main(String args[]){  
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first number:");
		int firstNum = scanner.nextInt();
		System.out.println("Enter the second number:");
		int secondNum = scanner.nextInt();
		try{  
			Adder stub=(Adder)Naming.lookup("rmi://localhost:5000/sonoo");  
			int additionResult = stub.addings(firstNum, secondNum);
			System.out.println("Addition result : " + additionResult);  
		}catch(Exception e){
			System.out.println(e);}  
		}  
}  
