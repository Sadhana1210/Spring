package sravani;

import java.util.Scanner;

public class Atm {

	public static void main(String[] args) {
    int Balence = 20000,withdraw,deposite,num;
		Scanner sc = new Scanner(System.in);
		int username=0,password=0;
		System.out.println("Enter the username");
		System.out.println("Enter the password");
		if(username==123&&password==456) {
			System.out.println("your username");
			System.out.println("your passward");
		}
		
		username = sc.nextInt();
		password = sc.nextInt();
		while (true)
		{
			System.out.println("welcome to Atm machine ");
			System.out.println("1.withdaw");
			System.out.println("2.deposite");
			System.out.println("3.check Balence");
			System.out.println("4.exit");
			num = sc.nextInt();
			switch(num)
			{
			case 1:
				System.out.println("Enter amount to be withdraw");
				withdraw = sc.nextInt();
				if(Balence>=withdraw) {
					Balence = Balence-withdraw;
				    System.out.println("Balence amount is: "+ Balence);
					System.out.println("please collect money");
				}
				else {
					System.out.println("Enter amount to deposite");
				    System.out.println("you dont have enough money for withdraw");
				}
				System.out.println(" ");
				break;
			case 2:
				System.out.println("enter amount to deposite");
				deposite = sc.nextInt();
				Balence  = Balence+deposite;
				System.out.println(" ");
				System.out.println("money has been deposite succefully ");
				break;
			case 3:
				System.out.println("Balence of you account is :"+ Balence);
				System.out.println(" ");
				break;
			case 4:
				System.exit(0);
				System.out.println(" ");
				
			}
		}

	}

}
