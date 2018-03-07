import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GuessTheNumber extends JFrame implements ActionListener
{
	//global objects and declarations
	Container con = new Container();
	Random rand = new Random();
	int playerInput; 
	int computerValue; 
	int playerLives;
	Dimension dimension = new Dimension(100, 65);

	
	//banner components
	JPanel banner = new JPanel();
	JButton newGame = new JButton("New Game");
	
	//mainPanel components
	JPanel mainPanel = new JPanel();
	JLabel mainQuestion = new JLabel("Can you guess my number? (1-100)");
	Font font = new Font("Verdana", Font.PLAIN, 18);
	Font font2 = new Font("Verdana", Font.PLAIN, 18);
	Font font3 = new Font("Verdana", Font.PLAIN, 12);
	JTextArea answer = new JTextArea();
	JButton submit = new JButton("Submit");
	JLabel remainingLives = new JLabel("Lives remaining: ");
	JTextField lives = new JTextField(1);
	
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton enter = new JButton("Enter");
	JButton backspace = new JButton("<--");
	
	//bottom components
	JPanel bottom = new JPanel();
	JButton home = new JButton("");
	
	public GuessTheNumber()
	{
		//general properties
		super("Smartphone Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainQuestion.setFont(font2);
		answer.setPreferredSize(new Dimension(350,35));
		
		computerValue = rand.nextInt(100);
		playerLives = 6;
		
		//banner properties
		//banner.setLayout(new FlowLayout());
		banner.add(newGame);
		
		//mainPanel properties
		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(mainQuestion);
		mainPanel.add(answer);
		mainPanel.add(submit);
		mainPanel.add(remainingLives);
		mainPanel.add(lives);
		lives.setText(String.valueOf(playerLives));
		
		mainPanel.add(button0);
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainPanel.add(button4);
		mainPanel.add(button5);
		mainPanel.add(button6);
		mainPanel.add(button7);
		mainPanel.add(button8);
		mainPanel.add(button9);
		mainPanel.add(backspace);
		//mainPanel.add(enter);
		
		//bottom.add(home);
		
		button0.setPreferredSize(dimension);
		button1.setPreferredSize(dimension);
		button2.setPreferredSize(dimension);
		button3.setPreferredSize(dimension);
		button4.setPreferredSize(dimension);
		button5.setPreferredSize(dimension);
		button6.setPreferredSize(dimension);
		button7.setPreferredSize(dimension);
		button8.setPreferredSize(dimension);
		button9.setPreferredSize(dimension);
		enter.setPreferredSize(dimension);
		backspace.setPreferredSize(dimension);
		
		
		
		//bottom properties
		///bottom.setLayout(new FlowLayout());
		home.setPreferredSize(new Dimension(35, 35));
		home.setIcon(new ImageIcon("home.png"));
		bottom.setBackground(Color.BLACK);
		//bottom.add(home);
		
		//container properties
		con.setLayout(new BorderLayout());
		con.add(banner, BorderLayout.NORTH);
		con.add(mainPanel, BorderLayout.CENTER);
		con.add(bottom, BorderLayout.SOUTH);
		add(con);
		
		//listeners
		submit.addActionListener(this);
		newGame.addActionListener(this);
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		enter.addActionListener(this);
		backspace.addActionListener(this);
		//home.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		HomeScreen homehome = new HomeScreen();
		String userInputString;
		
		//System.out.println(computerValue);
		if(source == submit)
		{
			if(Integer.parseInt(answer.getText()) == computerValue)
			{
				mainQuestion.setFont(font);
				mainQuestion.setText("Correct! You Win!");
				answer.setText("");
				computerValue = rand.nextInt(100);
			}
			else if(Integer.parseInt(answer.getText()) > computerValue)
			{
				mainQuestion.setFont(font);
				mainQuestion.setText("Your number is too big, try again!");
				playerLives = playerLives - 1;
				lives.setText(String.valueOf(playerLives));
				answer.setText("");
			}
			else if(Integer.parseInt(answer.getText()) < computerValue)
			{
				mainQuestion.setFont(font);
				mainQuestion.setText("Your number is too small, try again!");
				playerLives = playerLives - 1;
				lives.setText(String.valueOf(playerLives));
				answer.setText("");
			}
		}
		else if (source == newGame)
		{
			playerLives = 6;
			lives.setText(String.valueOf(playerLives));
			mainQuestion.setFont(font2);
			mainQuestion.setText("Can you guess my number? (1-100)");
			answer.setText("");
			computerValue = rand.nextInt(100);
		}
		else if (source == button0)
		{
			answer.append("0");
		}
		else if (source == button1)
		{
			answer.append("1");
		}
		else if (source == button2)
		{
			answer.append("2");
		}
		else if (source == button3)
		{
			answer.append("3");
		}
		else if (source == button4)
		{
			answer.append("4");
		}
		else if (source == button5)
		{
			answer.append("5");
		}
		else if (source == button6)
		{
			answer.append("6");
		}
		else if (source == button7)
		{
			answer.append("7");
		}
		else if (source == button8)
		{
			answer.append("8");
		}
		else if (source == button9)
		{
			answer.append("9");
		}
		else if(source == backspace)
		{
			userInputString = answer.getText();
			if(userInputString.length() > 0)
			{
				answer.setText(userInputString.substring(0, userInputString.length()-1));
			}
			else
			{
				
			}
		}
		/*else if (source == enter)
		{
			if(Integer.parseInt(answer.getText()) == computerValue)
			{
				mainQuestion.setFont(font);
				mainQuestion.setText("Correct! You Win!");
				answer.setText("");
				computerValue = rand.nextInt(100);
			}
			else if(Integer.parseInt(answer.getText()) > computerValue)
			{
				mainQuestion.setFont(font);
				mainQuestion.setText("Your number is too big, try again!");
				playerLives = playerLives - 1;
				lives.setText(String.valueOf(playerLives));
				answer.setText("");
			}
			else if(Integer.parseInt(answer.getText()) < computerValue)
			{
				mainQuestion.setFont(font);
				mainQuestion.setText("Your number is too small, try again!");
				playerLives = playerLives - 1;
				lives.setText(String.valueOf(playerLives));
				answer.setText("");
			}
		}*/
		else if(source == home)
		{
			con.removeAll();
			repaint();
			validate();
			//con.add(banner);
			con.add(homehome.wallpaper);
			//con.add(home);
			repaint();
			validate();
		}
		
		if(playerLives == 0)
		{
			mainQuestion.setFont(font3);
			mainQuestion.setText("Sorry, you lose! Press New Game to retry.");
		}
		
	}
	
	public static void main(String[] args)
	{
		GuessTheNumber aFrame = new GuessTheNumber();
		final int WIDTH = 350;
		final int HEIGHT = 550;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setVisible(true);
		aFrame.setResizable(false);
		//aFrame.revalidate();
	}
}