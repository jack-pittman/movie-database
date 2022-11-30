package view;

public class InputDirOrCast extends Input {
	public String inputDirOrCast() {
		printStatement();
		return super.getInput();
	}
	
	public void printStatement() {
		System.out.print("Show Director (T) or Cast (C)? "); 
	}
}



