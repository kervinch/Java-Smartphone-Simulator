import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeScreen extends JFrame implements ActionListener
{
	Container con = getContentPane();
	JLabel wallpaper = new JLabel();
	Date date = new Date();
	JPanel isi = new JPanel();
	
	
	//all components
	JPanel banner = new JPanel();
	JLabel carrier = new JLabel("AT&T");
	JLabel signal = new JLabel();
	JLabel battery = new JLabel("100%");
	//JLabel dateAndTime = new JLabel();
	JLabel space = new JLabel("                                                                               ");
	
	JPanel mainPanel = new JPanel();
	GridLayout layout = new GridLayout(3,2);
	JButton phone = new JButton("");
	JButton messages = new JButton("");
	JButton contacts = new JButton("");
	JButton calculator = new JButton("");
	JButton game = new JButton("");
	JButton help = new JButton("");
	
	JPanel button = new JPanel();
	JButton home = new JButton("");

	JLabel Phone = new JLabel("Phone");
	public HomeScreen()
	{
		//general properties
		super("powered by OneDollarBill OS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//banner.setPreferredSize(new Dimension(350,30));
		
		//banner properties
		banner.setLayout(new FlowLayout());
		banner.setBackground(Color.LIGHT_GRAY);
		banner.add(carrier);
		signal.setIcon(new ImageIcon("signal.png"));
		banner.add(signal);
		banner.add(space);
		banner.add(battery);
		
		//button icons
		phone.setIcon(new ImageIcon("phone.png"));
		messages.setIcon(new ImageIcon("messages.png"));
		contacts.setIcon(new ImageIcon("contacts.png"));
		calculator.setIcon(new ImageIcon("calculator.png"));
		home.setIcon(new ImageIcon("home.png"));
		game.setIcon(new ImageIcon("guess.png"));
		help.setIcon(new ImageIcon("help.png"));
		
		//button sizes
		home.setPreferredSize(new Dimension(35, 35));
		phone.setPreferredSize(new Dimension(128,128));
		messages.setPreferredSize(new Dimension(128,128));
		contacts.setPreferredSize(new Dimension(128,128));
		calculator.setPreferredSize(new Dimension(128,128));
		game.setPreferredSize(new Dimension(128,128));
		help.setPreferredSize(new Dimension(128,128));
		
		//mainPanel properties
		//add(wallpaper);
		//isi.add(wallpaper);
		wallpaper.setIcon(new ImageIcon("wallpaper.jpg"));
		wallpaper.setLayout(new FlowLayout());
		wallpaper.add(phone);
		wallpaper.add(messages);
		wallpaper.add(contacts);
		wallpaper.add(calculator);
		wallpaper.add(game);
		wallpaper.add(help);
		/*
		mainPanel.add(phone);
		mainPanel.add(messages);
		mainPanel.add(contacts);
		mainPanel.add(calculator);
		mainPanel.add(game);
		mainPanel.add(help);
		*/
		
		//button properties
		button.setLayout(new FlowLayout());
		button.setBackground(Color.black);
		button.add(home);
		
		//action listener
		phone.addActionListener(this);
		calculator.addActionListener(this);
		game.addActionListener(this);
		home.addActionListener(this);
		help.addActionListener(this);
		messages.addActionListener(this);
		contacts.addActionListener(this);
		
		//container properties
		con.setLayout(new BorderLayout());
		con.add(banner, BorderLayout.NORTH);
		con.add(wallpaper, BorderLayout.CENTER);
		con.add(button, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		Phone phonephone = new Phone();
		Contacts cont = new Contacts();
		Calculator calc = new Calculator();
		Messages mess = new Messages();
		GuessTheNumber gtn = new GuessTheNumber();
		Help helphelp = new Help();
		
		if(source == phone)
		{
			//con.removeAll();
			con.remove(wallpaper);
			add(phonephone.con);
			repaint();
			validate();
		}
		else if(source == calculator)
		{
			con.remove(wallpaper);
			add(calc.con);
			repaint();
			validate();
		}
		else if(source == contacts)
		{
			con.remove(wallpaper);
			add(cont.con);
			repaint();
			validate();
		}
		else if(source == messages)
		{
			con.remove(wallpaper);
			add(mess.con);
			repaint();
			validate();
		}
		else if (source == game)
		{
			//remove(banner);
			con.remove(wallpaper);
			add(gtn.con);
			repaint();
			validate();
		}
		else if(source == help)
		{
			con.remove(wallpaper);
			add(helphelp.con);
			repaint();
			validate();
		}
		else if(source == home)
		{
			con.removeAll();
			repaint();
			validate();
			//con.add(banner);
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(wallpaper, BorderLayout.CENTER);
			con.add(button, BorderLayout.SOUTH);
			//con.add(wallpaper);
			//con.add(home);
			repaint();
			validate();
		}
		
	}
	
	public static void main(String[] args)
	{
		HomeScreen aFrame = new HomeScreen();
		final int WIDTH = 350;
		final int HEIGHT = 550;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setResizable(false);
		aFrame.setVisible(true);
		aFrame.revalidate();
	}
}