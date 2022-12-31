package atmSystem;

import java.util.ArrayList;
import java.util.Scanner;


public class SBIBank extends ATM 
{
	int ttwo_f = 0, five_f = 0, two_f = 0, one_f = 0, fifty_f = 0, pinFlag = 0, newPin = 0, oldPin = 0;
	long current_Bal = 0, updated_Bal;
	
	public SBIBank() {
		super();
	}

	public SBIBank(long cardNo, String accHolderName, long accNo, int accPin,long initialBal, long contactNo,
			String address) {
		super(cardNo, accHolderName, accNo, accPin, initialBal, contactNo, address);
	}

	@Override
	public void Deposit(int d_amt, long init_Bal) 
	{
		this.setInitialBal(init_Bal + d_amt);
		updated_Bal=this.getInitialBal();	
	}

	@Override
	public void Withdraw(int w_amt, long init_Bal) 
	{
		if(init_Bal >= w_amt)
		{
			
			System.out.println("you have enough balance to withdraw");
			this.setInitialBal(init_Bal - w_amt);		
			updated_Bal=this.getInitialBal();
			while(w_amt != 0)
			{
				if(w_amt >= 2000)
				{
					ttwo_f = w_amt / 2000;
					w_amt = w_amt % 2000;
				}
				else if(w_amt >= 500)
				{
					five_f = w_amt / 500;
					w_amt = w_amt % 500;
				}
				else if(w_amt >= 200)
				{
					two_f = w_amt / 200;
					w_amt = w_amt % 200;
				}
				else if(w_amt >= 100)
				{
					one_f = w_amt / 100;
					w_amt = w_amt % 100;
				}
				else if(w_amt >= 50)
				{
					fifty_f = w_amt / 50;
					w_amt = w_amt % 50;
				}
				else
				{
					//
				}
			}
			System.out.println("Rs.2000: "+ttwo_f+"  Rs.500: "+five_f+"  Rs.200: "+two_f+"  Rs.100: "+one_f+"  Rs.50: "+fifty_f);
		}
		else
		{
			System.out.println("you have not enough balance to withdraw");
		}
		
	}

	@Override
	public void PinGeneration(int cardPin) 
	{
		int t=2;
		Scanner sc = new Scanner (System.in);
		while(t!=0)
		{
			System.out.println("Enetr your Old Pin: ");
			 oldPin = sc.nextInt();
			 System.out.println("cardPin: "+cardPin);
			if(oldPin == cardPin)
			{
				System.out.println("Your Authentication is successful");
				System.out.println("Enetr your New Unique Pin: ");
				newPin = sc.nextInt();
				System.out.println("Your New Pin Generation is Successful");
				pinFlag = 1;
				break;
			
			}
			else
			{
				System.out.println("Your Authentication is failed");
			}
			t--;
		}
		if(pinFlag == 1)
		{
			this.accPin = newPin;
			System.out.println("New pin succesfully generated:"+this.accPin);
		}
		else
		{
			this.accPin = oldPin;
			this.setAccPin(accPin);			
		}
	}
	

	@Override
	public void CheckBal(long init_Bal) 
	{
		if(updated_Bal == init_Bal)
			System.out.println("After balance enquiry Current Balance: "+updated_Bal);
		else
			System.out.println("After balance enquiry Current Balance: "+init_Bal);
	}
	
	

	@Override
	protected long updateBalByCardNo(ArrayList<ATM> accList, long init_Bal, long cardNo)
	{
	    int flag=0;
	    ATM a=null;
	    for(ATM sbibank:accList)
	    {
	    	if(sbibank.getCardNo()==cardNo)
	    	{
	    		flag=1;
	    		a=sbibank;
	    		break;
	    	}
	    }
	    
	    if(updated_Bal == 0)
	    {
	    	a.setInitialBal(this.initialBal);
	    	return this.initialBal=init_Bal;
	    }
	    else
	    {
	    	a.setInitialBal(this.initialBal);
	    	return this.initialBal;
	    }
		
	}

}
