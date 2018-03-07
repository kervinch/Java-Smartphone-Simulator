import java.io.*;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Contacts extends JFrame implements ActionListener
{	
	//general objects & declarations
	Container con = getContentPane();
	
	
	//banner objects
	JPanel banner = new JPanel();
	JButton back = new JButton("Back");
	JButton addContact = new JButton("Add");
	JLabel space = new JLabel("                                                                    ");
	
	JTextArea contacts = new JTextArea();
	JScrollPane sp = new JScrollPane(contacts);
	
	
	//main panel objects
	JPanel mainPanel = new JPanel();
	
	//add a contact objects
	Font font = new Font("Arial", Font.PLAIN, 18);
	JPanel addPanel = new JPanel();
	JLabel firstName = new JLabel("First Name: ");
	JTextField firstNameInput = new JTextField(20);
	JLabel lastName = new JLabel("Last Name: ");
	JTextField lastNameInput = new JTextField(20);
	JLabel number = new JLabel("Number:      ");
	JTextField numberInput = new JTextField(20);
	JLabel email = new JLabel("Email:          ");
	JTextField emailInput = new JTextField(20);
	JButton cancel = new JButton("Cancel");
	JLabel space2 = new JLabel("                        ");
	JButton save = new JButton("Save");

	public Contacts()
	{
		super("Smartphone Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//essentials
		File file = new File("contacts.txt");
		String line = null;
		
		//banner properties
		banner.setLayout(new FlowLayout());
		back.setEnabled(false);
		
		//banner components
		banner.add(back);
		banner.add(space);
		banner.add(addContact);
		
		//main panel properties
		mainPanel.setLayout(new FlowLayout());
		sp.setPreferredSize(new Dimension(350, 450));
		
		//main panel components
		mainPanel.add(sp);
		contacts.setText("");   //must. to prevent continious appending
		//reading from a file
		try
		{
			FileReader fr = new FileReader("contacts.txt");
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
                contacts.append(line);
                contacts.append("\n");
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
		
		//add properties
		firstName.setFont(font);
		lastName.setFont(font);
		number.setFont(font);
		email.setFont(font);
		
		//add components
		addPanel.setLayout(new FlowLayout());
		addPanel.add(firstName);
		addPanel.add(firstNameInput);
		addPanel.add(lastName);
		addPanel.add(lastNameInput);
		addPanel.add(number);
		addPanel.add(numberInput);
		addPanel.add(email);
		addPanel.add(emailInput);
		addPanel.add(cancel);
		addPanel.add(space2);
		addPanel.add(save);
		
		//listeners
		addContact.addActionListener(this);
		back.addActionListener(this);
		cancel.addActionListener(this);
		save.addActionListener(this);
		
		
		//container properties
		con.setLayout(new BorderLayout());
		con.add(banner, BorderLayout.NORTH);
		con.add(mainPanel, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		File file = new File("contacts.txt");
		String userFirstNameInput;
		String userLastNameInput;
		String userNumberInput;
		String userEmailInput;
		
		if(source == addContact)
		{
			back.setEnabled(true);
			addContact.setEnabled(false);
			con.remove(mainPanel);
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(addPanel, BorderLayout.CENTER);
			con.repaint();
			con.revalidate();
		}
		else if(source == back)
		{
			addContact.setEnabled(true);
			back.setEnabled(false);
			con.removeAll();
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(mainPanel, BorderLayout.CENTER);
			con.repaint();
			con.revalidate();
		}
		else if(source == cancel)
		{
			firstNameInput.setText("");
			lastNameInput.setText("");
			numberInput.setText("");
			emailInput.setText("");
		}
		else if(source == save)
		{
			userFirstNameInput = firstNameInput.getText();
			userLastNameInput = lastNameInput.getText();
			userNumberInput = numberInput.getText();
			userEmailInput = emailInput.getText();
			
			firstNameInput.setText("");
			lastNameInput.setText("");
			numberInput.setText("");
			emailInput.setText("");
			Notice.displayMessage();
			try
			{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.append(userFirstNameInput + ", " + userLastNameInput + ", " + userNumberInput + ", " + userEmailInput);
			bw.newLine();
			bw.flush();
			bw.close();
			}
			catch(Exception ex)
			{
				System.out.println("Message: " + ex);
			}
		}
	}

	public static void main(String[] args)
	{
		Contacts aFrame = new Contacts();
		final int WIDTH = 350;
		final int HEIGHT = 550;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setResizable(false);
		aFrame.setVisible(true);
		aFrame.revalidate();
	}

}
