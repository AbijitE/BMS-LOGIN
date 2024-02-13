package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {
	JLabel label2;
	JButton b1, b2;
	String pin;
	public BalanceEnquiry(String pin) {
		this.pin=pin;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(-60,0,1550,830);
		add(l3);

		JLabel label1 = new JLabel("TOUR CURRENT BALANCE IS Rs: ");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("System", Font.BOLD, 16));
		label1.setBounds(430,180,400,35);
		l3.add(label1);

		label2 = new JLabel();
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("System", Font.BOLD, 16));
		label2.setBounds(430,220,400,35);
		l3.add(label2);
		
		
		b1 = new JButton("BACK");
		b1.setBounds(700,406,150,35);
		b1.setBackground(new Color(65,125,128));
		b1.setForeground(Color.WHITE);
		 b1.addActionListener(this);
		l3.add(b1);
		
		int balance=0;
		try {
			Conn c=new Conn();
			ResultSet rs=c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		label2.setText(""+balance);
		

		setLayout(null);
		setSize(1550,1080);
		setLocation(0,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	setVisible(false);
	new main_class(pin);
		
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");

	}

	

}
