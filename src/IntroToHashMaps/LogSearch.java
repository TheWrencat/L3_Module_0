package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	HashMap<Integer, String> studentID;
	
	JFrame frame;
	JPanel panel;
	JButton addEntry;
	JButton search;
	JButton viewList;
	
	void setup() {
		studentID = new HashMap<Integer, String>();
		
		frame = new JFrame();
		panel = new JPanel();
		addEntry = new JButton();
		search = new JButton();
		viewList = new JButton();
		
		frame.setVisible(true);
		frame.add(panel);
		panel.add(addEntry);
		panel.add(search);
		panel.add(viewList);
		addEntry.addActionListener(this);
		addEntry.setText("Add Entry");
		search.addActionListener(this);
		search.setText("Search");
		viewList.addActionListener(this);
		viewList.setText("View List");
		
		frame.pack();
	}
	
	public static void main(String[] args) {
		LogSearch logSearch = new LogSearch();
		logSearch.setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addEntry) {
			int ID = 0;
			String IDname = "";
			String name = "";
			IDname = JOptionPane.showInputDialog("Enter an ID number");
			ID = Integer.parseInt(IDname);
			name = JOptionPane.showInputDialog("Enter a student's name");
			studentID.put(ID, name);
			
		}
		if(e.getSource() == search) {
			String nameFound = "";
			int IDfound = 0;
			String IDsearch = "";
			IDsearch = JOptionPane.showInputDialog("Imput ID Number");
			IDfound = Integer.parseInt(IDsearch);
			nameFound = studentID.get(IDfound);
			JOptionPane.showMessageDialog(null, nameFound);
			
		}
		if(e.getSource() == viewList) {
			String list = "";
			for(Integer i : studentID.keySet()){
				String name = studentID.get(i);
				list += "ID: " + i + " Name: " + name + "\n";
			}JOptionPane.showMessageDialog(null, list);
		}
		
	}
	
}
