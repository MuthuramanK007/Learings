package myfirstproj;

import java.io.Serializable;

public final class BankAccount implements Serializable{
	private static final long serialVersionUID = 4984171912555727116L;
	private int pin;
	private int balance;
	public BankAccount(int pin) {
		this.pin = pin;
	}
	public int getBalance() {
		return balance;
	}
	public int getPin() {
		return pin;
	}
	@SuppressWarnings("unused")
	private void increaseBalanceBy500() {
		balance+=500;
	}
}
