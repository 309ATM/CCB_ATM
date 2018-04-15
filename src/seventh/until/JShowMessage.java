package seventh.until;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JShowMessage extends JDialog{

	public JFrame frame;
	private JTextField text_name;
	private JTextField text_sex;
	private JTextField text_idcard;
	private JTextField text_phone;
	private JTextField text_status;
	private JTextField text_type;
	private JButton btn_cancel;
	private JTextArea text_address;
	public JButton btn_confirm;
	public boolean isConfirm; 

	public JShowMessage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ÕË»§ÐÅÏ¢");
		frame.setBounds(680, 210, 719, 650);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_name = new JLabel("Ãû×Ö");
		label_name.setFont(new Font("Ó×Ô²", Font.PLAIN, 20));
		label_name.setBounds(100, 173, 81, 30);
		frame.getContentPane().add(label_name);
		
		JLabel label_type = new JLabel("ÕË»§ÀàÐÍ");
		label_type.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_type.setBounds(372, 174, 79, 30);
		frame.getContentPane().add(label_type);
		
		JLabel label_sex = new JLabel("ÐÔ±ð");
		label_sex.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_sex.setBounds(100, 241, 81, 30);
		frame.getContentPane().add(label_sex);
		
		JLabel label_Status = new JLabel("ÕË»§×´Ì¬");
		label_Status.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_Status.setBounds(372, 241, 79, 30);
		frame.getContentPane().add(label_Status);
		
		JLabel label_idcard = new JLabel("Éí·ÝÖ¤ºÅ");
		label_idcard.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_idcard.setBounds(100, 304, 81, 30);
		frame.getContentPane().add(label_idcard);
		
		JLabel label_phone = new JLabel("ÊÖ»úºÅÂë");
		label_phone.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_phone.setBounds(100, 367, 81, 30);
		frame.getContentPane().add(label_phone);
		
		JLabel label_address1 = new JLabel("¼ÒÍ¥×¡Ö·");
		label_address1.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_address1.setBounds(100, 434, 81, 30);
		frame.getContentPane().add(label_address1);
		
		text_name = new JTextField();
		text_name.setBackground(Color.WHITE);
		text_name.setEditable(false);
		text_name.setFont(new Font("Ó×Ô²", Font.PLAIN, 20));
		text_name.setBounds(185, 174, 140, 30);
		frame.getContentPane().add(text_name);
		text_name.setColumns(10);
		
		text_type = new JTextField();
		text_type.setBackground(Color.WHITE);
		text_type.setEditable(false);
		text_type.setFont(new Font("Ó×Ô²", Font.PLAIN, 20));
		text_type.setColumns(10);
		text_type.setBounds(465, 174, 140, 30);
		frame.getContentPane().add(text_type);
		
		text_sex = new JTextField();
		text_sex.setBackground(Color.WHITE);
		text_sex.setEditable(false);
		text_sex.setFont(new Font("Ó×Ô²", Font.PLAIN, 20));
		text_sex.setColumns(10);
		text_sex.setBounds(185, 241, 140, 30);
		frame.getContentPane().add(text_sex);
		
		text_status = new JTextField();
		text_status.setBackground(Color.WHITE);
		text_status.setEditable(false);
		text_status.setFont(new Font("Ó×Ô²", Font.PLAIN, 20));
		text_status.setColumns(10);
		text_status.setBounds(465, 241, 140, 30);
		frame.getContentPane().add(text_status);
		
		text_idcard = new JTextField();
		text_idcard.setBackground(Color.WHITE);
		text_idcard.setEditable(false);
		text_idcard.setFont(new Font("Ó×Ô²", Font.PLAIN, 20));
		text_idcard.setColumns(10);
		text_idcard.setBounds(185, 304, 420, 30);
		frame.getContentPane().add(text_idcard);
		
		text_phone = new JTextField();
		text_phone.setBackground(Color.WHITE);
		text_phone.setEditable(false);
		text_phone.setFont(new Font("Ó×Ô²", Font.PLAIN, 20));
		text_phone.setColumns(10);
		text_phone.setBounds(185, 367, 413, 30);
		frame.getContentPane().add(text_phone);
		
		text_address = new JTextArea();
		text_address.setEditable(false);
		text_address.setBackground(Color.WHITE);
		text_address.setLineWrap(true);
		text_address.setBounds(185, 434, 413, 64);
		text_address.setBorder(new LineBorder(Color.LIGHT_GRAY));
		frame.getContentPane().add(text_address);
		
		btn_confirm = new JButton();
		btn_confirm.addActionListener(new Confirm());
		btn_confirm.setBounds(212, 527, 113, 42);
		frame.getContentPane().add(btn_confirm);
		
		btn_cancel = new JButton("È¡Ïû");
		btn_cancel.addActionListener(new Cancel());
		btn_cancel.setBounds(372, 527, 113, 42);
		frame.getContentPane().add(btn_cancel);
		
		JLabel label_bg = new JLabel("");
		label_bg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\UserInformation.png"));
		label_bg.setBounds(0, 0, 707, 603);
		frame.getContentPane().add(label_bg);
		
	}

	public void setInfo(String[] message){
		text_name.setText(message[0]);
		text_type.setText(message[1]);
		text_sex.setText(message[2]);
		text_status.setText(message[3]);
		text_idcard.setText(message[4]);
		text_phone.setText(message[5]);
		text_address.setText(message[6]);
	}
	
	public  void clearInfo(){
		text_name.setText("");
		text_type.setText("");
		text_sex.setText("");
		text_status.setText("");
		text_idcard.setText("");
		text_phone.setText("");
		text_address.setText("");
	}
	
	class Confirm  implements ActionListener{

		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			isConfirm = true;
		}
		
	}
	
	class Cancel  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			clearInfo();
			isConfirm = false;
		}
		
	}
}
