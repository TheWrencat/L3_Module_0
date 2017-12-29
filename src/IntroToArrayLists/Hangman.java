package IntroToArrayLists;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel livesdisplay;
	Stack<String> hardWord;
	Stack<String> easyWord;
	ArrayList<JLabel> boxes;
	int n;
	int lives;
	String wordPicked;
	String letterCount;
	String lettersUp;
	char keypressed;

	Hangman() {
		boxes = new ArrayList<JLabel>();
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		livesdisplay = new JLabel();
		letterCount = "";
		hardWord = new Stack<String>();
		easyWord = new Stack<String>();
		Object[] options = { "Easy Mode", "Hard Mode" };
		lives = 9;
		livesdisplay.setText(" "+lives);
		n = JOptionPane.showOptionDialog(frame, "Pick your level.", "Hangman", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	}

	
	void lineMaker() {
		for (int i = 0; i < wordPicked.length(); i++) {
			JLabel label = new JLabel();
			label.setText("_ ");
			panel.add(label);
			boxes.add(label);
		}
		panel.add(livesdisplay);
		livesdisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		frame.pack();
		label.setText(letterCount);
		
	}
	
	void reset() {
		for (int i = 0; i < wordPicked.length(); i++) {
			label = boxes.get(i);
			panel.remove(label);
		}
		boxes.clear();
	}
	
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(label);
		lineMaker();


		frame.pack();
	}

	void addPuzzles() {
		// Read from a file one line at a time
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/IntroToArrayLists/HangmanWords.txt"));

			String line = br.readLine();
			while (line != null) {
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

		// Read from a file one line at a time
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/IntroToArrayLists/EasyHangmanWords.txt"));

			String line = br.readLine();
			while (line != null) {
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
		if (n == 0) {
			wordPicked = easyWord.pop();
		} else if (n == 1) {
			wordPicked = hardWord.pop();
		}

	}

	private void updateSpacesWithUserInput(char keyChar) {
		for (int i = 0; i < wordPicked.length(); i++) {
			if (wordPicked.charAt(i) == keyChar) {
				boxes.get(i).setText("" + keyChar);
			}
		}
	}

	private void loadNextPuzzle() {
		reset();
		if(n==0) {
			Random r=new Random();
			int word = r.nextInt(easyWord.size());
			wordPicked = easyWord.get(word);
		}else if(n==1) {
			Random r=new Random();
			int word = r.nextInt(hardWord.size());
			wordPicked = hardWord.get(word);
		}
		lineMaker();
	}
	
	private String getCurrentAnswer() {
		StringBuffer answer = new StringBuffer();
		for (JLabel textBox : boxes) {
			answer.append(textBox.getText());
		}
		return answer.toString();
	}

	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.addPuzzles();
		hangman.setup();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 keypressed = e.getKeyChar();
		if(wordPicked.indexOf(keypressed) >= 0){
			//System.out.println("yay");
			updateSpacesWithUserInput(keypressed);
		}else {
			lives --;
			livesdisplay.setText(" "+lives);
		}
		lettersUp = getCurrentAnswer();
		if(lettersUp.equals(wordPicked)) {
			JOptionPane.showMessageDialog(null, "Hey good job you did the thing");
			loadNextPuzzle();
			lives=9;
			frame.pack();
		}
	}

	public void playDeathKnell() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/League/Google Drive/league-sounds/funeral-march.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			Thread.sleep(8400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if(lives==0) {
			playDeathKnell();

		}
	}
}
