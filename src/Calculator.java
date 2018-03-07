import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener
{
	//global objects and declarations
	Container con = getContentPane();
	//Font fontResult = new Font("Verdana", Font.PLAIN, 20);
	Font font = new Font("Verdana", Font.PLAIN, 18);
	Boolean bracketFlag = false;
	Boolean posNegFlag = false;
	
	Boolean addFlag = false;
	Boolean subtractFlag = false;
	Boolean multiplyFlag = false;
	Boolean divideFlag = false;
	int a = 0;
	int b = 0;
	int result = 0;
	
	
	Dimension dimension = new Dimension(65, 80);
	
	//banner components
	JPanel banner = new JPanel();
	//JTextArea mainDisplay = new JTextArea();
	
	//mainPanel components
	JPanel mainPanel = new JPanel();
	JTextArea mainDisplay = new JTextArea();
	JButton button0 = new JButton("");
	JButton button1 = new JButton("");
	JButton button2 = new JButton("");
	JButton button3 = new JButton("");
	JButton button4 = new JButton("");
	JButton button5 = new JButton("");
	JButton button6 = new JButton("");
	JButton button7 = new JButton("");
	JButton button8 = new JButton("");
	JButton button9 = new JButton("");
	JButton add = new JButton("");
	JButton subtract = new JButton("");
	JButton multiply = new JButton("");
	JButton divide = new JButton("");
	JButton backspace = new JButton("");
	JButton clear = new JButton("");
	JButton equalsTo = new JButton("");
	JButton point = new JButton("");
	JButton posNeg = new JButton("");
	JButton bracket = new JButton("");
	
	//bottom components
	JPanel bottom = new JPanel();
	JButton home = new JButton("");
	
	//constructor
	public Calculator()
	{
		//general properties
		super("Smartphone Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//banner properties
		banner.setLayout(new FlowLayout());
		//banner.add(mainDisplay);
		//mainDisplay.setPreferredSize(new Dimension(350, 50));
		banner.add(mainDisplay);
		
		mainDisplay.setPreferredSize(new Dimension(350,25));
		mainDisplay.setFont(font);
		//mainDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		
		//mainPanel properties
		//mainPanel.setLayout(new GridLayout(5,4));
		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(clear);
		mainPanel.add(divide);
		mainPanel.add(multiply);
		mainPanel.add(backspace);
		mainPanel.add(button7);
		mainPanel.add(button8);
		mainPanel.add(button9);
		mainPanel.add(subtract);
		mainPanel.add(button4);
		mainPanel.add(button5);
		mainPanel.add(button6);
		mainPanel.add(add);
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainPanel.add(bracket);
		mainPanel.add(posNeg);
		mainPanel.add(button0);
		mainPanel.add(point);
		mainPanel.add(equalsTo);
		
		button0.setIcon(new ImageIcon("0.png"));
		button1.setIcon(new ImageIcon("1.png"));
		button2.setIcon(new ImageIcon("2.png"));
		button3.setIcon(new ImageIcon("3.png"));
		button4.setIcon(new ImageIcon("4.png"));
		button5.setIcon(new ImageIcon("5.png"));
		button6.setIcon(new ImageIcon("6.png"));
		button7.setIcon(new ImageIcon("7.png"));
		button8.setIcon(new ImageIcon("8.png"));
		button9.setIcon(new ImageIcon("9.png"));
		add.setIcon(new ImageIcon("+.png"));
		subtract.setIcon(new ImageIcon("-.png"));
		multiply.setIcon(new ImageIcon("X.png"));
		divide.setIcon(new ImageIcon("÷.png"));
		clear.setIcon(new ImageIcon("C.png"));
		posNeg.setIcon(new ImageIcon("plusminus.png"));
		equalsTo.setIcon(new ImageIcon("=.png"));
		point.setIcon(new ImageIcon("dot.png"));
		backspace.setIcon(new ImageIcon("Del.png"));
		bracket.setIcon(new ImageIcon("( ).png"));
		
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
		add.setPreferredSize(dimension);
		subtract.setPreferredSize(dimension);
		divide.setPreferredSize(dimension);
		multiply.setPreferredSize(dimension);
		clear.setPreferredSize(dimension);
		posNeg.setPreferredSize(dimension);
		equalsTo.setPreferredSize(dimension);
		point.setPreferredSize(dimension);
		backspace.setPreferredSize(dimension);
		bracket.setPreferredSize(dimension);
		
		//bottom properties
		bottom.setBackground(Color.BLACK);
		//bottom.add(home);
		home.setPreferredSize(new Dimension(35,35));
		home.setIcon(new ImageIcon("home.png"));
		
		//container properties
		con.setLayout(new BorderLayout());
		con.add(banner, BorderLayout.NORTH);
		con.add(mainPanel, BorderLayout.CENTER);
		//con.add(bottom, BorderLayout.SOUTH);
		
		//listener
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		add.addActionListener(this);
		subtract.addActionListener(this);
		divide.addActionListener(this);
		multiply.addActionListener(this);
		point.addActionListener(this);
		posNeg.addActionListener(this);
		clear.addActionListener(this);
		backspace.addActionListener(this);
		equalsTo.addActionListener(this);
		home.addActionListener(this);
		bracket.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		HomeScreen homehome = new HomeScreen();
		String userInputString;
		
		
		if(source == button1)
		{
			mainDisplay.append("1");
		}
		else if (source == button2)
		{
			mainDisplay.append("2");
		}
		else if (source == button3)
		{
			mainDisplay.append("3");
		}
		else if (source == button4)
		{
			mainDisplay.append("4");
		}
		else if (source == button5)
		{
			mainDisplay.append("5");
		}
		else if (source == button6)
		{
			mainDisplay.append("6");
		}
		else if (source == button7)
		{
			mainDisplay.append("7");
		}
		else if (source == button8)
		{
			mainDisplay.append("8");
		}
		else if (source == button9)
		{
			mainDisplay.append("9");
		}
		else if (source == button0)
		{
			mainDisplay.append("0");
		}
		else if(source == add)
		{
			userInputString = mainDisplay.getText();
			a = Integer.parseInt(userInputString);
			addFlag = true;
			mainDisplay.setText("+");
			userInputString = mainDisplay.getText();
			a = Integer.parseInt(userInputString);
		}
		else if(source == subtract)
		{
			userInputString = mainDisplay.getText();
			a = Integer.parseInt(userInputString);
			subtractFlag = true;
			mainDisplay.setText("-");
			userInputString = mainDisplay.getText();
			a = Integer.parseInt(userInputString);
		}
		else if(source == multiply)
		{
			userInputString = mainDisplay.getText();
			a = Integer.parseInt(userInputString);
			multiplyFlag = true;
			mainDisplay.setText("*");
			userInputString = mainDisplay.getText();
			a = Integer.parseInt(userInputString);
		}
		else if(source == divide)
		{
			userInputString = mainDisplay.getText();
			a = Integer.parseInt(userInputString);
			divideFlag = true;
			mainDisplay.setText("/");
			userInputString = mainDisplay.getText();
			a = Integer.parseInt(userInputString);
		}
		else if(source == point)
		{
			mainDisplay.append(".");
		}
		else if(source == backspace)
		{
			userInputString = mainDisplay.getText();
			if(userInputString.length() > 0)
			{
			mainDisplay.setText(userInputString.substring(0, userInputString.length()-1));
			}
			else
			{
			}
		}
		else if(source == clear)
		{
			mainDisplay.setText("");
			bracketFlag = false;
			posNegFlag = false;
			addFlag = false;
			subtractFlag = false;
			multiplyFlag = false;
			divideFlag = false;
			//userInputString = "";
			a=0;
			b=0;
			result = 0;
		}
		else if(source == bracket && bracketFlag == false)
		{
			mainDisplay.append("(");
			bracketFlag = true;
		}
		else if(source == bracket && bracketFlag == true)
		{
			mainDisplay.append(")");
			bracketFlag = false;
		}
		else if(source == posNeg && posNegFlag == false)
		{
			mainDisplay.append("-");
			posNegFlag = true;
		}
		else if(source == posNeg && posNegFlag == true)
		{
			mainDisplay.append("+");
			posNegFlag = false;
		}
		else if(source == home)
		{
			remove(banner);
			remove(mainPanel);
			remove(bottom);
			add(homehome.con);
			revalidate();
		}
		else if(source == equalsTo && addFlag == true)
		{
			userInputString = mainDisplay.getText();
			b = Integer.parseInt(userInputString);
			result = a+b;
			mainDisplay.setText(Integer.toString(result));
		}
		else if(source == equalsTo && subtractFlag == true)
		{
			userInputString = mainDisplay.getText();
			b = Integer.parseInt(userInputString);
			result = a-b;
			mainDisplay.setText(Integer.toString(result));
		}
		else if(source == equalsTo && multiplyFlag == true)
		{
			userInputString = mainDisplay.getText();
			b = Integer.parseInt(userInputString);
			result = a*b;
			mainDisplay.setText(Integer.toString(result));
		}
		else if(source == equalsTo && divideFlag == true)
		{
			userInputString = mainDisplay.getText();
			b = Integer.parseInt(userInputString);
			result = a/b;
			mainDisplay.setText(Integer.toString(result));
		}
	}
	
	public static void main(String[] args)
	{
		Calculator aFrame = new Calculator();
		final int WIDTH = 350;
		final int HEIGHT = 550;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setResizable(false);
		aFrame.setVisible(true);
		aFrame.revalidate();
	}
	
}
