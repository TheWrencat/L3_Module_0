package IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	JFrame frame;
	JPanel panel;
	JButton addName;
	JButton viewNames;
	JButton clearBook;
	String addedNames;
	ArrayList<String> guestBook;
	
	GuestBook() {
		frame = new JFrame();
		panel = new JPanel();
		addName = new JButton();
		viewNames = new JButton();
		clearBook = new JButton();
		guestBook =  new ArrayList<String>();
		
		
	}
	
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(addName);
		panel.add(viewNames);
		panel.add(clearBook);
		addName.addActionListener(this);
		viewNames.addActionListener(this);
		clearBook.addActionListener(this);
		addName.setText("Add name");
		viewNames.setText("View names");
		clearBook.setText("Clear names");
		frame.pack();
	}
	
	public static void main(String[] args) {
		GuestBook guestBook = new GuestBook();
		guestBook.setup();
	}
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addName) {
			System.out.println("add");
			addedNames = JOptionPane.showInputDialog("Enter a name to add to the Guest Book.");
			guestBook.add(addedNames);
		}
		if(e.getSource() == viewNames) {
			String message = "";
			System.out.println("view");
			for(int i = 0; i < guestBook.size(); i++){
				String s = guestBook.get(i);
				message += "Guest #"+(1+i)+" "+s+ "\n";
			}
			if(guestBook.isEmpty()) {
				message = "No names listed.";
			}
			JOptionPane.showMessageDialog(null, message);
			
		}
		if(e.getSource() == clearBook) {
			String inputCode;
			inputCode = JOptionPane.showInputDialog("What's the secret code?");
			if(inputCode.equals("clear the guestbook")){
			guestBook.clear();
			}else {
				JOptionPane.showMessageDialog(null, "Sorry, wrong code.");
			}
		}
	}
}
