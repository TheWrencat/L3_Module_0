package IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class IntroToStack {
	Stack<Double> stickstack = new Stack<Double>(); 
	Double nOne;
	Double nTwo;
	String sOne;
	String sTwo;
	Double popped;
	void setup(){
		for(int i = 0; i<100; i++) {
			Random r=new Random();
			double stick = r.nextDouble();
			stick *= 100;
			stickstack.push(stick);
		}
		sOne = JOptionPane.showInputDialog("Write a number betewen 0 and 100");
		sTwo = JOptionPane.showInputDialog("Write another number betewen 0 and 100");
		nOne = Double.parseDouble(sOne);
		nTwo = Double.parseDouble(sTwo);
		
		for(int i = 0; i < stickstack.size(); i++){
			popped = stickstack.pop();
			if (popped > nOne && popped <nTwo) {
				JOptionPane.showMessageDialog(null, popped);
				System.out.println(popped);
			}
		}
	}
	public static void main(String[] args) {
		IntroToStack stacks =  new IntroToStack();
		stacks.setup();
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
	
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
