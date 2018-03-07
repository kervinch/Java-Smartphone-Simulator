import java.io.*;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.*;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class Phone extends JFrame implements ActionListener
{
	Container con = getContentPane();
	JLabel space = new JLabel("                                                                 ");
	Font font = new Font("Verdana", Font.PLAIN, 22);
	//String stringDisplay = "";
	Boolean flag = false;
	JTextArea callLog = new JTextArea();
	JScrollPane sp = new JScrollPane(callLog);
	JPanel logPanel = new JPanel();
	//JLabel callLog = new JLabel("--TEST--");
	
	
	
	//banner components
	JPanel banner = new JPanel();
	JButton back = new JButton("Back");
	JButton log = new JButton("Log");
	JButton call = new JButton("Call");
	
	//mainPanel components
	JPanel mainPanel = new JPanel();
	JTextArea display = new JTextArea();
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button0 = new JButton("0");
	JButton buttonStar = new JButton("*");
	JButton buttonSharp = new JButton("#");
	JButton dial = new JButton("");
	JButton backspace = new JButton("");
	JButton nothing = new JButton("");
	
	//bottom components
	JPanel button = new JPanel();
	JButton home = new JButton("");
	
	
	public Phone()
	{
		//general properties
		super("Smartphone Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nothing.setEnabled(false);
		back.setEnabled(false);
		display.setFont(font);
		
		
		logPanel.add(sp);
		
		//icons
		home.setIcon(new ImageIcon("home.png"));
		dial.setIcon(new ImageIcon("dial.png"));
		backspace.setIcon(new ImageIcon("backspace.png"));
		
		//sizes
		display.setPreferredSize(new Dimension(350, 50));
		home.setPreferredSize(new Dimension(35,35));
		button1.setPreferredSize(new Dimension(100,65));
		button2.setPreferredSize(new Dimension(100,65));
		button3.setPreferredSize(new Dimension(100,65));
		button4.setPreferredSize(new Dimension(100,65));
		button5.setPreferredSize(new Dimension(100,65));
		button6.setPreferredSize(new Dimension(100,65));
		button7.setPreferredSize(new Dimension(100,65));
		button8.setPreferredSize(new Dimension(100,65));
		button9.setPreferredSize(new Dimension(100,65));
		button0.setPreferredSize(new Dimension(100,65));
		buttonStar.setPreferredSize(new Dimension(100,65));
		buttonSharp.setPreferredSize(new Dimension(100,65));
		dial.setPreferredSize(new Dimension(100,65));
		backspace.setPreferredSize(new Dimension(100,65));
		nothing.setPreferredSize(new Dimension(100,65));
		
		//layout
		banner.setLayout(new FlowLayout());
		banner.add(back);//, FlowLayout.LEFT);
		banner.add(space);
		banner.add(log);//, FlowLayout.RIGHT);
		//phoneLayer.setLayout(new BorderLayout());
		
		mainPanel.add(display);
		//display.setEditable(false);
		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainPanel.add(button4);
		mainPanel.add(button5);
		mainPanel.add(button6);
		mainPanel.add(button7);
		mainPanel.add(button8);
		mainPanel.add(button9);
		mainPanel.add(buttonStar);
		mainPanel.add(button0);
		mainPanel.add(buttonSharp);
		mainPanel.add(nothing);
		mainPanel.add(dial);
		mainPanel.add(backspace);
		
		button.setLayout(new FlowLayout());
		//button.add(home);
		
		//action listener
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
		buttonStar.addActionListener(this);
		buttonSharp.addActionListener(this);
		dial.addActionListener(this);
		backspace.addActionListener(this);
		home.addActionListener(this);
		back.addActionListener(this);
		log.addActionListener(this);
		
		//container layout
		button.setBackground(Color.BLACK);
		con.setLayout(new BorderLayout());
		con.add(banner, BorderLayout.NORTH);
		con.add(mainPanel, BorderLayout.CENTER);
		//con.add(button, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		HomeScreen homehome = new HomeScreen();
		
		File file = new File("call log.txt");
		String line = null;
		
		
		
		
		String userInputString;
		int userInput;
		if(source == button1)
		{
			display.append("1");
		}
		else if (source == button2)
		{
			display.append("2");
		}
		else if (source == button3)
		{
			display.append("3");
		}
		else if (source == button4)
		{
			display.append("4");
		}
		else if (source == button5)
		{
			display.append("5");
		}
		else if (source == button6)
		{
			display.append("6");
		}
		else if (source == button7)
		{
			display.append("7");
		}
		else if (source == button8)
		{
			display.append("8");
		}
		else if (source == button9)
		{
			display.append("9");
		}
		else if (source == button0)
		{
			display.append("0");
		}
		else if (source == buttonStar)
		{
			display.append("*");
		}
		else if (source == buttonSharp)
		{
			display.append("#");
		}
		else if(source == dial && flag == false)
		{
			userInputString = display.getText();
			StringBuilder sb = new StringBuilder(userInputString);
			//userInput = Integer.parseInt(userInputString);
			display.setText("Dialling " + sb + "...");
			dial.setIcon(new ImageIcon("endcall.png"));
			flag = true;
			
			//writing to a file
			try
			{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(userInputString);
			bw.newLine();
			bw.flush();
			bw.close();
			}
			catch(Exception ex)
			{
				System.out.println("Message: " + ex);
			}
			
		}
		else if(source == dial && flag == true)
		{
			userInputString = display.getText();
			//int userInputInteger = Integer.parseInt(userInputString);
			//int userInputInteger = Integer.valueOf(userInputString);
			//display.setText(Integer.toString(userInputInteger));
			display.setText("");
			dial.setIcon(new ImageIcon("C:/Users/kervinch/Desktop/Smartphone Simulator Project/dial.png"));
			flag = false;
			
			try
			{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\n");
			bw.flush();
			bw.close();
			}
			catch(Exception ex)
			{
				System.out.println("Message: " + ex);
			}
		}
		else if(source == backspace)
		{
			userInputString = display.getText();
			if(userInputString.length() > 0)
			{
			display.setText(userInputString.substring(0, userInputString.length()-1));
			}
			else
			{
				
			}
		}
		else if(source == log)
		{
			callLog.setText("");   //must. to prevent continious appending
			//reading from a file
			try
			{
				FileReader fr = new FileReader("call log.txt");
				BufferedReader br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
	                callLog.append(line);
	                callLog.append("\n");
	            }    
				br.close();
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("Unable to open file " + file + ".");
			}
			catch(IOException ex)
			{
				System.out.println("Error reading from file" + file + ".");
			}
			
			
			//remove(con);
			//con.remove(homehome.con);
			con.remove(mainPanel);
			/*con.repaint();
			con.validate();*/
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(sp, BorderLayout.CENTER);
			con.repaint();
			con.revalidate();
			back.setEnabled(true);
			log.setEnabled(false);
		}
		else if(source == back)
		{
			con.removeAll();
			//con.remove(logPanel);
			/*con.repaint();
			con.revalidate();*/
			//con.add(mainPanel);
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(mainPanel, BorderLayout.CENTER);
			con.repaint();
			con.revalidate();
			back.setEnabled(false);
			log.setEnabled(true);
		}
		else if(source == home)
		{
			remove(banner);
			remove(mainPanel);
			remove(button);
			add(homehome.con);
			revalidate();
		}
	}
	
	public static void main(String[] args)
	{
		Phone aFrame = new Phone();
		final int WIDTH = 350;
		final int HEIGHT = 550;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setResizable(false);
		aFrame.setVisible(true);
		aFrame.repaint();
		aFrame.validate();
	}
}
