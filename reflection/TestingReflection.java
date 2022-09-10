package myfirstproj;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
public class TestingReflection {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the Pin number to create a account:");
		int firstPinNum = scanner.nextInt();
		BankAccount hdfcAcc = new BankAccount(firstPinNum);
		
		@SuppressWarnings("rawtypes")
		Class classOfHdfcAcc = hdfcAcc.getClass();
		
		Field[] fieldsInBankAcc = classOfHdfcAcc.getDeclaredFields();
		System.out.println("Enter the new Pin number: ");
		int newPin = scanner.nextInt();
		changePin(hdfcAcc, fieldsInBankAcc, newPin);
		System.out.println(hdfcAcc.getPin());
		
		Method[] methodsInBankAcc = classOfHdfcAcc.getDeclaredMethods();
		String methodToChange = "increaseBalanceBy500";
		giveBonus(hdfcAcc, methodsInBankAcc, methodToChange);
		
		int modifiersOfBankAcc = classOfHdfcAcc.getModifiers();
		boolean isItFinal = Modifier.isFinal(modifiersOfBankAcc);
		System.out.println("Given object is Final :"+isItFinal);
		
		@SuppressWarnings("rawtypes")
		Class[] interfacesImplByBankAcc = classOfHdfcAcc.getInterfaces();
		System.out.println(interfacesImplByBankAcc.length);
		
		System.out.println("end..");
		scanner.close();
	}

	private static void giveBonus(BankAccount accName, Method[] accMethods, String methodToChange) {
		for(Method method : accMethods) {
			if(method.getName() == methodToChange) {
				method.setAccessible(true);
				try {
					method.invoke(accName);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void changePin(BankAccount accName, Field[] accFields, int newPin) {
		for(Field field : accFields) {
			if(field.getName()=="pin") {
				field.setAccessible(true);
				try {
					field.set(accName, newPin);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
