package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener{
	String pin;
	JButton button;
	MiniStatement(String pin) {
		this.pin=pin;

		getContentPane().setBackground(new Color(255,204,204));
		setSize(400,600);

		setLocation(20,20);
		setLayout(null);

		JLabel jLabel1=new JLabel();
		jLabel1.setBounds(20,140,400,200);
		add(jLabel1);

		JLabel jLabel2=new JLabel("ABIJIT E");
		jLabel2.setFont(new Font("System",Font.BOLD,15));
		jLabel2.setBounds(150,20,200,20);
		add(jLabel2);

		JLabel jLabel3=new JLabel();
		jLabel3.setBounds(20,80,300,20);
		add(jLabel3);

		JLabel jLabel4=new JLabel();
		jLabel4.setBounds(20,400,300,20);
		add(jLabel4);


		try {
			Conn conn=new Conn();
			ResultSet resultSet=conn.statement.executeQuery("select * from login where pin = '"+pin+"'");
			while(resultSet.next()) {
				jLabel3.setText("Card Number: "+resultSet.getString("card_no").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_no").substring(12));


			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		try {

			int balance=0;
			Conn c=new Conn();
			ResultSet resultSet=c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
			while(resultSet.next()) {
				jLabel1.setText(jLabel1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><br></html>");
				if(resultSet.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(resultSet.getString("amount"));					}

				else {
					balance -= Integer.parseInt(resultSet.getString("amount"));
				}
			}
			jLabel4.setText("Your Total Balance is Rs "+balance);


		} catch (Exception e) {
			e.printStackTrace();
		}
		button=new JButton("Exit");
		button.setBounds(20,500,100,25);
		button.addActionListener(this);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		add(button);
		
		
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	}

	public static void main(String[] args) {
		new MiniStatement("");

	}



}
