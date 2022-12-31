package atmSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Long;

public class ATMApp 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		long cardNo = 0, init_Bal = 0;
		int pin = 0, cardPin = 0, index = 0;
		int cardFlag=0, w_amt = 0, d_amt = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("====================================================================");
		System.out.println("================= ATM Interface System =============================");
		System.out.println("====================================================================");
		try
		{
		String ch=null;
		SBIBank sb =new SBIBank();
		
		ArrayList<ATM> AccList = new ArrayList<ATM>();
		AccList.add(new SBIBank(43562345, "Sankalpa", 43215675, 4567, 25000, 90711159, "Manvi"));
		AccList.add(new SBIBank(56748393, "Mahalakshmi", 43225775, 8756,250650, 98711189, "Raichur"));
		AccList.add(new SBIBank(45368297, "Anjali", 43215389, 5436, 152000, 98459297, "Davanagere"));
		AccList.add(new SBIBank(56342527, "Manoj", 43265874, 4657,123459, 94718158, "Davanagere"));
		
		do
		{
			System.out.println("============= Welcome to SBI =============================");
			System.out.println("====================================================================");
			System.out.println("Please insert your card");
			System.out.println("Please do not remove your chip card. Leave your card inserted during the entire transaction");
			System.out.println("Please enter your ATM card number");
			
			cardNo = Long.parseLong(br.readLine());
			for(ATM temp: AccList) 
			{
				if(((SBIBank) temp).getCardNo() == cardNo)
				{
					cardPin = ((SBIBank) temp).getAccPin();
					init_Bal = ((SBIBank) temp).getInitialBal();
					index = AccList.indexOf(temp);
					cardFlag = 1;
				}
			}
			if(cardFlag == 0)
			{
				System.out.println("Authentication failed");
				break;
			}
			else
			{
				System.out.println("Authentication successful!! \n You can continue further processes");
			}
			
			
			System.out.println("Please enter your PIN");
			{
				pin = Integer.parseInt(br.readLine());
				if(cardPin == pin)
				{
					System.out.println("Valid pin");
				}
				else
				{
					System.out.println("Invalid pin");
					break;
				}
			
			}
			
			System.out.println("Enter your transaction kind");
			System.out.println("\t\t 1)Deposit.\r\n"
					+ "\t\t 2)Withdraw.\r\n"
					+ "\t\t 3)Pin Generation.\r\n"
					+ "\t\t 4)Balance Enquiry.\r\n");
			System.out.println("====================================================================");
			System.out.println("Enter your choice:");
			int choice=Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1: 	System.out.println("Enter the amount you want to deposit: ");
						d_amt = Integer.parseInt(br.readLine());
						sb.Deposit(d_amt, init_Bal);
						init_Bal = sb.updateBalByCardNo(AccList,init_Bal, cardNo);
						break;
						
					
			
			case 2:		System.out.println("Withdraw amount must be multiples of 50, 100, 200, 500 and 2000 only");
						System.out.println("Enter the amount you want to withdraw: ");
						w_amt = Integer.parseInt(br.readLine());
						if(w_amt % 50 != 0)
						{
							System.out.println("Your entered amount is not multiples of 50");
							break;
						}
						sb.Withdraw(w_amt, init_Bal);
						init_Bal = sb.updateBalByCardNo(AccList, init_Bal, cardNo);
						System.out.println("Withdrawn Successfully");
						break;
					
			
			case 3:		sb.PinGeneration(cardPin);
						break;
					
			
			case 4:		init_Bal = sb.updateBalByCardNo(AccList,init_Bal, cardNo);
						sb.CheckBal(init_Bal);
						init_Bal = sb.updateBalByCardNo(AccList,init_Bal, cardNo);
						break;
					
			
			default:System.out.println("Wrong choice!!"); 		   
			}
			System.out.println("Do you want to continue? (Y-Yes / N-No)");
			ch=br.readLine();
		}
	
			while(ch.equals("Y")||ch.equals("y"));
			System.out.println("====================================================================");
			System.out.println("Please remove your card");
			System.out.println("Bye....");
		
			System.out.println("====================================================================");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		}
}
