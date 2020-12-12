/*
 * Cheryl Gardner
 * Lab 01 
 * 09/21/2020
 * AccountHolder.java
 * Purpose: To create a file that will ask do all of the calculations from the 
 * data that was entered by the users in terms of balance, withdrawals and deposits
 */

//Import the scanner tool to be able to get the input from the user
import java.util.Scanner;

public class AccountHolder {

	//Declare the variables that will be used throughout the code
	private double balance;
	public static double annualInterestRate;
	
	Scanner scanner2 = new Scanner(System.in);
	
	//Create the AccountHolder Method
	public AccountHolder(double balance)
	{
		//Make sure that the balance is above 0
		if(balance >= 0)
		{
			this.balance = balance;
		}
		//Throw an exception if the balance entered is negative
		else 
		{
			throw new IllegalArgumentException("You cannot start out with a negative balance");
		}
	}
	
	//Create the deposit method 
	public void deposit(double depositamt)
	{
		//Add the deposit amount to the total balance 
		this.balance += depositamt;
		//Display the balance after the deposit to the user
		System.out.printf("Balance after Deposit: $%,.2f", this.balance);
		System.out.println("");
	}
	
	//Create the withdrawal method
	public void withdrawal(double withdrawalamt)
	{
		//Check to see if the balance drops below 50 dollars with the withdrawal
		if(this.balance - withdrawalamt >= 50)
		{
			//Take the withdrawal amount out of the bank account if it will keep your account above 50
			this.balance -= withdrawalamt;
			//Display the balance following the withdrawal
			System.out.printf("Balance after Withdrawal: $%,.2f", this.balance);
			System.out.println("");
		}
		//If it will take your balance below 50 dollars than tell the user that it cannot be done 
		else
		{
			throw new IllegalArgumentException("This withdrawal cannot happen because it will take your balance below $50");
		}
	}
	//Create a method called firstBalance that will give the user the balance prior to any interest
	public double firstBalance()
	{
		//Return the balance back to the user
		return balance;
	}
	//Declare a new method called monthlyInterest
	public void monthlyInterest(int i)
	{
		//Calculate the new balance using the interest rate
		this.balance += this.balance * (annualInterestRate / 12.0);
	}
	//Declare a method called changeMonthlyInterest
	public static void changeMonthlyInterest(double interestrate)
	{
		//Change the interest rate to whatever is coded in AccountHolderTest.java
		annualInterestRate = interestrate;	
	}
	//Declare a new method, getBalance
	public double getBalance()
	{
		//Get the final balance to give back to the user
		return this.balance;
	}

}
