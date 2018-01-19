package IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame;
	JPanel panel;
	JLabel label;
	String letter;
	String textBox;
	Stack<String> letters = new Stack<String>();
	void setup() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.pack();
	}
	
	
	
	public static void main(String[] args) {
		TextUndoRedo text = new TextUndoRedo();
		text.setup();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		letter = e.getKeyChar() + "";
		letters.push(letter);
		for(String text: letters) {
		textBox += letters.pop();
		}label.setText(textBox);
		System.out.println(letter);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
