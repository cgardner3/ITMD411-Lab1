/*
 * Cheryl Gardner 
 * Lab 1
 * 09/21/2020
 * AccountHolderTest.java
 * The goal of this program is to write code that will ask the user for all of the information
 * and then use the information given to calculate values and display them back to the user
 */

//Import the scanner tool to be able to get the input from the user
import java.util.Scanner;

//Declare a new class called AccountHolderTest
public class AccountHolderTest {

	//Declare the main method
	public static void main(String[] args) {
		
		//Declare the local variables that will be used throughout the program
		double interestrate,depositamt,withdrawalamt,startBalance = 0;
		
		//Declare a new scanner system to keep track of the values
		Scanner scanner1 = new Scanner(System.in);
		
		//Hardcode the 4% interest rate and then send that interest rate to AccountHolder.java
		interestrate = 0.04;
		AccountHolder.changeMonthlyInterest(interestrate);
		
		//Have the user enter their initial balance into the program
		System.out.print("Enter your account's starting balance: $");
		startBalance = scanner1.nextDouble();
		
		//Store that value in a new AccountHolder
		AccountHolder holder = new AccountHolder(startBalance);
		
		//Display the starting balance to the user
		System.out.println("Your starting balance is: $" + startBalance);
		
		//Ask the user how much they want to deposit into their account
		System.out.print("\nHow much would you like to deposit into your account? $");
		depositamt = scanner1.nextDouble();
		
		//Store the value in the AccountHolder
		holder.deposit(depositamt);
		
		//Ask the user how much they want to withdrawal
		System.out.print("\nHow much would you like to withdrawal from your account?: $");
		withdrawalamt = scanner1.nextDouble();
		
		//Store the withdrawal amount into the AccountHolder
		holder.withdrawal(withdrawalamt);
		
		//Print the balance before interest rate
		System.out.printf("\nYour bank balance before the interest is: $%,.2f\n", holder.firstBalance());
		
		//Print the balances with the interest rate for 12 months
		System.out.println("Below are your balances with interest rate for the next year");
		//Display the starting balance
		System.out.printf("\nStarting Balance: $%,.2f\n", holder.firstBalance());
		//Have a loop that will go through all 12 months and then stop after Month 12
		for (int i = 1; i<=12;){
			//Call the montly Interest method
			holder.monthlyInterest(i);
			//Print the balance for that month
			System.out.print("");
			System.out.printf("Month "+i+ ": $%,.2f\n", holder.getBalance());
			//Add one to the i value
			i++;
		}
	}
}
