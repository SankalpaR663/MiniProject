package atmSystem;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class ATM
{
	public long cardNo;
	public String accHolderName;
	public long accNo;
	public int accPin;
	public long initialBal;
	public long contactNo;
	public String address;
	
	
	public abstract void Deposit(int d_amt, long init_Bal);	
	public abstract void Withdraw(int w_amt, long init_Bal);
	public abstract void PinGeneration(int cardPin);
	public abstract void CheckBal(long init_Bal);
	protected abstract long updateBalByCardNo(ArrayList<ATM> accList, long init_Bal, long cardNo);
	
	public ATM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ATM(long cardNo, String accHolderName, long accNo, int accPin, long initialBal, long contactNo, String address)
			 {
		super();
		this.cardNo = cardNo;
		this.accHolderName = accHolderName;
		this.accNo = accNo;
		this.accPin = accPin;
		this.initialBal = initialBal;
		this.contactNo = contactNo;
		this.address = address;
		
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public int getAccPin() {
		return accPin;
	}
	public void setAccPin(int accPin) {
		this.accPin = accPin;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getInitialBal() {
		return initialBal;
	}
	public void setInitialBal(long initialBal) {
		this.initialBal = initialBal;
	}
	
	
	@Override
	public String toString() {
		return "ATM [cardNo=" + cardNo + ", accHolderName=" + accHolderName + ", accNo=" + accNo + ", accPin=" + accPin
				+ ", contactNo=" + contactNo + ", address=" + address + ", initialBal=" + initialBal + "]";
	}	
	
}
