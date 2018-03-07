import java.io.*;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Messages extends JFrame implements ActionListener
{	
	//general objects & declarations
	Container con = getContentPane();
	
	//banner objects
	JPanel banner = new JPanel();
	JButton back = new JButton("Back");
	JButton outbox = new JButton("Outbox");
	JButton inbox = new JButton("Inbox");
	JLabel space = new JLabel("                  ");
	JLabel space2 = new JLabel("                 ");
	JLabel space3 = new JLabel("                                    ");
	Font font = new Font("Verdana", Font.PLAIN, 18);
	
	
	//main panel objects
	JPanel mainPanel = new JPanel();
	JLabel recipients = new JLabel("Recipients: ");
	JTextField recipientsInput = new JTextField(18);
	JLabel content = new JLabel("Content: ");
	JTextArea contentInput = new JTextArea();
	JButton cancel = new JButton("Cancel");
	JButton send = new JButton("Send");
	
	//outbox panel objects
	JPanel outboxPanel = new JPanel();
	JTextArea out = new JTextArea();
	JScrollPane spOut = new JScrollPane(out);
	
	//inbox panel objects
	JPanel inboxPanel = new JPanel();
	JTextArea in = new JTextArea();
	JScrollPane spIn = new JScrollPane(in);

	public Messages()
	{
		super("Smartphone Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inbox.setEnabled(false);
		
		//banner properties
		banner.setLayout(new FlowLayout());
		back.setEnabled(false);
		
		//banner components
		banner.add(back);
		banner.add(space);
		banner.add(outbox);
		banner.add(space2);
		banner.add(inbox);
		
		//main panel properties
		mainPanel.setLayout(new FlowLayout());
		recipients.setFont(font);
		content.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		content.setFont(font);
		contentInput.setPreferredSize(new Dimension(330, 310));
		cancel.setPreferredSize(new Dimension(160, 30));
		send.setPreferredSize(new Dimension(160, 30));
		
		//main panel components
		mainPanel.add(recipients);
		mainPanel.add(recipientsInput);
		mainPanel.add(content);
		mainPanel.add(contentInput);
		mainPanel.add(cancel);
		//mainPanel.add(space3);
		mainPanel.add(send);
		
		//outbox components
		spOut.setPreferredSize(new Dimension(350, 450));
		outboxPanel.setLayout(new FlowLayout());
		outboxPanel.add(spOut);
		
		//inbox components
		
		spIn.setPreferredSize(new Dimension(350,450));
		inboxPanel.setLayout(new FlowLayout());
		inboxPanel.add(spIn);
		
		//listeners
		outbox.addActionListener(this);
		back.addActionListener(this);
		inbox.addActionListener(this);
		cancel.addActionListener(this);
		send.addActionListener(this);
		
		//container properties
		con.setLayout(new BorderLayout());
		con.add(banner, BorderLayout.NORTH);
		con.add(mainPanel, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		File file = new File("messages.txt");
		String line = null;
		String userRecipientsInput;
		String userContentInput;
		
		if(source == outbox)
		{
			out.setText("");   //must. to prevent continious appending
			//reading from a file
			try
			{
				FileReader fr = new FileReader("messages.txt");
				BufferedReader br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
	                out.append(line);
	                out.append("\n");
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
			
			back.setEnabled(true);
			//inbox.setEnabled(true);
			outbox.setEnabled(false);
			con.remove(mainPanel);
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(outboxPanel, BorderLayout.CENTER);
			con.repaint();
			con.revalidate();
		}
		else if (source == inbox)
		{
			in.setText("");   //must. to prevent continuous appending
			//reading from a file
			try
			{
				FileReader fr = new FileReader("messages.txt");
				BufferedReader br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
	                in.append(line);
	                in.append("\n");
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
			
			back.setEnabled(true);
			outbox.setEnabled(true);
			inbox.setEnabled(false);
			con.remove(mainPanel);
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(inboxPanel, BorderLayout.CENTER);
			con.repaint();
			con.revalidate();
		}
		else if(source == back)
		{
			back.setEnabled(false);
			outbox.setEnabled(true);
			//inbox.setEnabled(true);
			con.removeAll();
			con.setLayout(new BorderLayout());
			con.add(banner, BorderLayout.NORTH);
			con.add(mainPanel, BorderLayout.CENTER);
			con.repaint();
			con.revalidate();
		}
		else if(source == cancel)
		{
			recipientsInput.setText("");
			contentInput.setText("");
		}
		else if (source == send)
		{
			userRecipientsInput = recipientsInput.getText();
			userContentInput = contentInput.getText();
			//recipientsInput.setText("Message Sent!");
			Notice.displayMessage();
			recipientsInput.setText("");
			contentInput.setText("");
			try
			{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write("====================================");
			bw.newLine();
			bw.append(userRecipientsInput);
			bw.newLine();
			bw.newLine();
			bw.append(userContentInput);
			bw.newLine();
			bw.write("====================================");
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
		Messages aFrame = new Messages();
		final int WIDTH = 350;
		final int HEIGHT = 550;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setResizable(false);
		aFrame.setVisible(true);
		aFrame.revalidate();
	}

}
