import java.util.Scanner;

class InvalidInputException extends Exception {
	InvalidInputException (String string) {
		super(string);
	}
}
class Customer {
	private String custNo, custName, category;
	Customer(String custNo, String custName, String category) throws InvalidInputException {
		if (custNo.startsWith("C") || custNo.startsWith("c")) {
			this.custNo = custNo;
		} else
			throw new InvalidInputException("Customer Number is Invalid (Must start with 'C') ");
		if(custName.length() >= 4) {
			this.custName = custName;
		} else
			throw new InvalidInputException("Name must be atleast 4 characters long");
		if (category.equals("Platinum") || category.equals("Gold") || category.equals("Silver")) {
			this.category = category;
		} else
			throw new InvalidInputException("Invalid Cateogry");
	}
	@Override
	public String toString() {
		return "Customer [custNo = " + custNo + ", custName = " + custName + ", category = " + category + "]";
	}
	
}
public class TestCustomer {
	public static void main(String[] args) {
		String custNo, custName, category;
		System.out.println("Enter Customer Number, Customer Name, Category");
		Scanner kb = new Scanner(System.in);
		custNo = kb.nextLine();
		custName = kb.nextLine();
		category = kb.nextLine();
		try {
			Customer c = new Customer(custNo, custName, category);
			System.out.println(c.toString());
		} catch(InvalidInputException iie) {
			System.out.println(iie);
		}
		kb.close();
	}
}