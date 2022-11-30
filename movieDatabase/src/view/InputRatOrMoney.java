package view;

public class InputRatOrMoney extends Input{
	public String inputRatOrMoney() {
		printStatement();
		return super.getInput();
	}
	
	public void printStatement() {
		System.out.print("Get Rating Rank (R) or Money Rank (M)? "); 
	}
}
