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
	String remove;
	String textBox;
	Stack<String> letters = new Stack<String>();
	Stack<String> removed = new Stack<String>();
	void setup() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		label.setText("");
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setSize(1500, 50);
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
		
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			String deleated = letters.pop();
			label.repaint();
			panel.repaint();
			frame.repaint();
			removed.push(deleated);
		}else if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
			letters.push(removed.pop());
			 
		}else {
		letter = e.getKeyChar() + "";
		letters.push(letter);
		
		}
		String textBox = "";
		for(int i = 0; i<letters.size(); i++) {
		textBox += letters.get(i);
		}
		label.setText(textBox);
		label.repaint();
		panel.repaint();
		frame.repaint();
	
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
