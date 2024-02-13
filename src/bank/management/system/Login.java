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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	JLabel label1,label2,label3;
	JTextField textField2;
	JButton b1,b2,b3;
	JPasswordField jPasswordField3;

	Login(){
		super("Bank Management System"); //sets the title name 

		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
		Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350,10,100,100);//x,y,w,h
		add(image);

		ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
		Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon ii3=new ImageIcon(ii2);
		JLabel iimage=new JLabel(ii3);
		iimage.setBounds(630,350,100,100);//x,y,w,h
		add(iimage);

		label1=new JLabel("WELCOME TO ATM");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("AvantGarde",Font.BOLD,38));
		label1.setBounds(230,125,450,40);//x,y,w,h
		add(label1);

		label2=new JLabel("Card No:");
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("railway",Font.BOLD,28));
		label2.setBounds(150,190,375,30);//x,y,w,h
		add(label2);

		textField2=new JTextField(15);
		textField2.setBounds(325,190,230,30);//x,y,w,h
		textField2.setFont(new Font("Arial",Font.BOLD,14));
		add(textField2);



		label3=new JLabel("PIN: ");
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("railway",Font.BOLD,28));
		label3.setBounds(150,250,375,30);//x,y,w,h
		add(label3);

		jPasswordField3=new JPasswordField(15);
		jPasswordField3.setBounds(325,250,230,30);//x,y,w,h
		jPasswordField3.setFont(new Font("Arial",Font.BOLD,14));
		add(jPasswordField3);


		b1=new JButton("SIGN IN");
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setBounds(300,300,100,30); //x,y,w,h
		b1.addActionListener(this);
		add(b1);

		b2=new JButton("CLEAR");
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setBounds(430,300,100,30); //x,y,w,h
		b2.addActionListener(this);
		add(b2);

		b3=new JButton("SIGN UP");
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLACK);
		b3.setBounds(300,350,230,30);
		b3.addActionListener(this);
		add(b3);



		ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
		Image iii2=iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
		ImageIcon iii3=new ImageIcon(iii2);
		JLabel iiimage=new JLabel(iii3);
		iiimage.setBounds(0,0,850,480);//x,y,w,h
		add(iiimage);




		setLayout(null);
		setSize(850,480); //Frame height and width
		setLocation(350,200); //to display frame at center
		setUndecorated(true);
		setVisible(true); //to visible frame

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==b1){
				Conn c=new Conn();
				String cardno=textField2.getText();
				String pin=jPasswordField3.getText();
				String q="select * from login where card_no = '"+cardno+"' and pin = '"+pin+"'";
				ResultSet resultSet=c.statement.executeQuery(q);

				if(resultSet.next()) {
					setVisible(false);
					new main_class(pin);

				}
			}
			else if(e.getSource()==b2) {
				textField2.setText("");
				jPasswordField3.setText("");	
			}
			else if(e.getSource()==b3) {
				new Signup();
				setVisible(false);

			}


		} catch (Exception E) {
			// TODO: handle exception
			E.printStackTrace();
		}


	}
	public static void main(String[] args) {
		new Login();
	}
}
