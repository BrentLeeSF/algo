package Structural;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Adapter - Converts the interface of a class into another interface that a client wants 
 * https://www.javatpoint.com/adapter-pattern */
/** Target Interface */
interface CreditCard {

	public void giveBankDetails();

	public String getCreditCard();

}

/** Adaptee class */
class BankDetails {

	private String bankName;
	private String accHolderName;
	private long accNumber;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
}

/** Adapter Class - uses Target Interface and Adaptee Class */
class BankCustomer extends BankDetails implements CreditCard {

	public void giveBankDetails() {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter the account holder name :");
			String customername = br.readLine();
			System.out.print("\n");

			System.out.print("Enter the account number:");
			long accno = Long.parseLong(br.readLine());
			System.out.print("\n");

			System.out.print("Enter the bank name :");
			String bankname = br.readLine();

			setAccHolderName(customername);
			setAccNumber(accno);
			setBankName(bankname);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getCreditCard() {

		long accno = getAccNumber();
		String accholdername = getAccHolderName();
		String bname = getBankName();

		return ("The Account number " + accno + " of " + accholdername + " in " + bname
				+ " bank is valid and authenticated for issuing the credit card. ");
	}
}

public class Adapter {

	public static void main(String args[]) {

		CreditCard targetInterface = new BankCustomer();
		targetInterface.giveBankDetails();

		System.out.print(targetInterface.getCreditCard());
	}

}
