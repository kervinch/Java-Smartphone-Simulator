import java.io.*;
import java.lang.Thread;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Help extends JFrame implements ActionListener
{
	//general objects & declarations
	Container con = getContentPane();
	Font font = new Font("Verdana", Font.PLAIN, 12);
	Font font2 = new Font("Verdana", Font.PLAIN, 18);
	Dimension dimension = new Dimension(350,35);
	JLabel space = new JLabel("                                                                      ");
	
	//banner components
	JPanel banner = new JPanel();
	JLabel helpIcon = new JLabel();
	JLabel helpText = new JLabel("This app provides clear, to-the-point, step-by-step ");//guide for first time users so you know how to use OneDollarBill OS to the fullest. You can start by selecting the app you want to learn more.");
	JLabel helpText2 = new JLabel("guide for first time users so you know how to use");
	JLabel helpText3 = new JLabel("the OneDollarBill OS to the fullest. You can start by");
	JLabel helpText4 = new JLabel(" selecting the app you want to learn more.");
	JButton back = new JButton("Back");
	Boolean flag = false;
	
	//main panel components
	JPanel mainPanel = new JPanel();
	JButton phone = new JButton("Phone");
	JButton messages = new JButton("Messages");
	JButton contacts = new JButton("Contacts");
	JButton calculator = new JButton("Calculator");
	JButton game = new JButton("Guess The Number");
	
	//phone components
	JPanel phonePanel = new JPanel();
	JTextArea phoneTextArea = new JTextArea();
	JScrollPane spPhone = new JScrollPane(phonePanel);
	JLabel tutorial1 = new JLabel("Use the numpad provided to type in the number");
	JLabel tutorial2 = new JLabel("you want to call. Then press Dial");
	
	//messages components
	JPanel messagesPanel = new JPanel();
	JTextArea messagesTextArea = new JTextArea();
	
	//contacts components
	JPanel contactsPanel = new JPanel();
	JTextArea contactsTextArea = new JTextArea();
	
	//calculator components
	JPanel calculatorPanel = new JPanel();
	JTextArea calculatorTextArea = new JTextArea();
	
	//game components
	JPanel gamePanel = new JPanel();
	JTextArea gameTextArea = new JTextArea();
	
	
	
	public Help()
	{
		super("Smartphone Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//banner properties
		banner.setLayout(new FlowLayout());
		//banner.setPreferredSize(new Dimension(350,150));
		banner.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		back.setEnabled(false);
		banner.add(back);
		banner.add(space);
		banner.add(helpIcon);
		helpIcon.setIcon(new ImageIcon("helpHelpIcon.png"));
		
		//mainPanel properties
		mainPanel.setLayout(new FlowLayout());
		phone.setPreferredSize(dimension);
		messages.setPreferredSize(dimension);
		contacts.setPreferredSize(dimension);
		calculator.setPreferredSize(dimension);
		game.setPreferredSize(dimension);
		
		//	--icons
		phone.setIcon(new ImageIcon("helpPhoneIcon.png"));
		messages.setIcon(new ImageIcon("helpMessagesIcon.png"));
		contacts.setIcon(new ImageIcon("helpContactsIcon.png"));
		calculator.setIcon(new ImageIcon("helpCalculatorIcon.png"));
		game.setIcon(new ImageIcon("helpGameIcon.png"));
		
		helpText.setFont(font);
		helpText2.setFont(font);
		helpText3.setFont(font);
		helpText4.setFont(font);
		mainPanel.add(helpText);
		mainPanel.add(helpText2);
		mainPanel.add(helpText3);
		mainPanel.add(helpText4);
		
		mainPanel.add(phone);
		mainPanel.add(messages);
		mainPanel.add(contacts);
		mainPanel.add(calculator);
		mainPanel.add(game);
		
		//phone components
		//phonePanel.add(spPhone);
		phonePanel.setLayout(new FlowLayout());
		//spPhone.setPreferredSize(new Dimension(350,400));
		phoneTextArea.setPreferredSize(new Dimension(350,400));
		phonePanel.add(phoneTextArea);
		phoneTextArea.setText("•Di bar atas terdapat tiga button yaitu back button, outbox button\n"
				+ " dan inbox button. \n"
				+ "•Pengunna dapat langsung memasuki nama orang yang\n"
				+ " ditujui ke dalam recipients field.\n"
				+ "•Pengunna bisa langsung memasukkan pesan ke dalam\n"
				+ " content box yang telah tersedia\n"
				+ "•Jika pengunna ingin membatalkan pesan, pengunna dapat\n"
				+ " mengklik cancel buton\n"
				+ "•Send button akan mengirim pesan ke orang yang dituju\n");
		//phonePanel.add(tutorial1);
		//phonePanel.add(tutorial2);
		
		//messages components
		messagesPanel.setLayout(new FlowLayout());
		messagesTextArea.setPreferredSize(new Dimension(350,400));
		messagesPanel.add(messagesTextArea);
		messagesTextArea.setText("•Di bar atas terdapat tiga button yaitu back button\n"
				+ ", outbox button dan inbox button. \n"
				+ "•Pengunna dapat langsung memasuki nama orang yang ditujui\n"
				+ " ke dalam recipients field.\n"
				+ "•Pengunna bisa langsung memasukkan pesan ke dalam\n"
				+ " content box yang telah tersedia\n"
				+ "•Jika pengunna ingin membatalkan pesan, pengunna dapat\n"
				+ " mengklik cancel buton\n"
				+ "•Send button akan mengirim pesan ke orang yang dituju\n");
		
		//contacts components
		contactsPanel.setLayout(new FlowLayout());
		contactsTextArea.setPreferredSize(new Dimension(350,400));
		contactsPanel.add(contactsTextArea);
		contactsTextArea.setText("•Terdapat 2 button di bar atas, yaitu button back dan button add\n"
				+ " yang bisa digunakan untuk memasuki contact baru\n"
				+ "•Nama, nomor telfon dan email ditampilkan di layar.");
		
		//calculator components
		calculatorPanel.setLayout(new FlowLayout());
		calculatorTextArea.setPreferredSize(new Dimension(350,400));
		calculatorPanel.add(calculatorTextArea);
		calculatorTextArea.setText("•Ada dua fungsi untuk menghapus yaitu menghapus satu per\n"
				+ " satu atau menghapus langsung dengan mengunakan “C”\n"
				+ " button\n"
				+ "•Angka akan tertampil di atas button-button angka\n");
		
		//game components
		gamePanel.setLayout(new FlowLayout());
		gameTextArea.setPreferredSize(new Dimension(350,400));
		gamePanel.add(gameTextArea);
		gameTextArea.setText("•Komputer akan merandom angka dari satu sampai seratus\n"
				+ "•Pengunna ditantang untuk mencari tahu angka yang dirandom\n"
				+ " oleh komputer\n"
				+ "•Pengunna diberi enam kesempatan untuk menebak angka itu\n"
				+ "•Program akan memberi tahu user jika angka yang ditebak itu\n"
				+ " lebih besar\n"
				+ "•Program akan memberi tahu user jika angka yang ditebak itu\n"
				+ " lebih kecil\n"
				+ "•On-Screen numpad disediakan untuk kemudahan pengunna\n"
				+ " menginput angka yang diinginkan\n"
				+ "•Button New Game mereset angka yang dirandom oleh\n"
				+ " komputer sehingga pengunna dapat kesempatan untuk\n"
				+ " bermain lagi\n");
		
		
		//listeners
		phone.addActionListener(this);
		messages.addActionListener(this);
		contacts.addActionListener(this);
		calculator.addActionListener(this);
		game.addActionListener(this);
		back.addActionListener(this);
		
		//container properties
		con.setLayout(new BorderLayout());
		con.add(banner, BorderLayout.NORTH);
		con.add(mainPanel, BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if(source == phone)
		{
			back.setEnabled(true);
			con.remove(mainPanel);
			con.setLayout(new FlowLayout());
			con.add(banner);
			con.add(phonePanel);
			con.repaint();
			con.revalidate();
		}
		else if (source == messages)
		{
			back.setEnabled(true);
			con.remove(mainPanel);
			con.setLayout(new FlowLayout());
			con.add(banner);
			con.add(messagesPanel);
			con.repaint();
			con.revalidate();
		}
		else if (source == contacts)
		{
			back.setEnabled(true);
			con.remove(mainPanel);
			con.setLayout(new FlowLayout());
			con.add(banner);
			con.add(contactsPanel);
			con.repaint();
			con.revalidate();
		}
		else if (source == calculator)
		{
			back.setEnabled(true);
			con.remove(mainPanel);
			con.setLayout(new FlowLayout());
			con.add(banner);
			con.add(calculatorPanel);
			con.repaint();
			con.revalidate();
		}
		else if (source == game)
		{
			back.setEnabled(true);
			con.remove(mainPanel);
			con.setLayout(new FlowLayout());
			con.add(banner);
			con.add(gamePanel);
			con.repaint();
			con.revalidate();
		}
		else if(source == back)
		{
			back.setEnabled(false);
			con.removeAll();;
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(mainPanel, BorderLayout.CENTER);
			con.repaint();
			con.revalidate();
		}
	}

	public static void main(String[] args)
	{
		Help aFrame = new Help();
		final int WIDTH = 350;
		final int HEIGHT = 550;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setVisible(true);
		aFrame.setResizable(false);
	}
}
