package IntroToArrayLists;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack <String> hardWord;
	Stack <String> easyWord;
	int n;
	String wordPicked;
	String letterCount;
	
	
	
	Hangman() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		letterCount = "";
		hardWord = new Stack<String>();
		easyWord = new Stack<String>();
		Object[] options = {"Easy Mode", "Hard Mode"};
		n = JOptionPane.showOptionDialog(frame, "Pick your level.", "Hangman", JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
	}
	
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		for(int i = 0; i< wordPicked.length(); i++) {
			letterCount += "_ ";
		}
		label.setText(letterCount);
		
		frame.pack();
	}
	
	void addPuzzles() {
		//Read from a file one line at a time
				try {
					BufferedReader br = new BufferedReader(new FileReader("src/IntroToArrayLists/HangmanWords.txt"));
					
					String line = br.readLine();
					while(line != null){
						hardWord.push(line);
						line = br.readLine();
					}
					
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Read from a file one line at a time
				try {
					BufferedReader br = new BufferedReader(new FileReader("src/IntroToArrayLists/EasyHangmanWords.txt"));
					
					String line = br.readLine();
					while(line != null){
						easyWord.push(line);
						line = br.readLine();
					}
					
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(n == 0) {
					wordPicked = easyWord.pop();
				}else if(n == 1) {
					wordPicked = hardWord.pop();
				}
				System.out.println(wordPicked);
				

			
	}
	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.addPuzzles();
		hangman.setup();
		
	}
}
