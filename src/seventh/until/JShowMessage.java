package seventh.until;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class JShowMessage extends JDialog{

	private JFrame frame;
	private String[] message = new String[6]; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JShowMessage window = new JShowMessage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JShowMessage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_name = new JLabel("name");
		label_name.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_name.setBounds(101, 13, 135, 50);
		frame.getContentPane().add(label_name);
		
		JLabel label_phone = new JLabel("phone");
		label_phone.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_phone.setBounds(101, 139, 398, 50);
		frame.getContentPane().add(label_phone);
		
		JLabel label_idcard = new JLabel("idcard");
		label_idcard.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_idcard.setBounds(101, 205, 398, 50);
		frame.getContentPane().add(label_idcard);
		
		JLabel label_address1 = new JLabel("address");
		label_address1.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_address1.setBounds(101, 268, 68, 50);
		frame.getContentPane().add(label_address1);
		
		JLabel label_sex = new JLabel("sex");
		label_sex.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_sex.setBounds(351, 13, 135, 50);
		frame.getContentPane().add(label_sex);
		
		JLabel label_type = new JLabel("type");
		label_type.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_type.setBounds(101, 76, 385, 50);
		frame.getContentPane().add(label_type);
		
		JLabel label_address = new JLabel("");
		label_address.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_address.setBounds(183, 268, 305, 100);
		frame.getContentPane().add(label_address);
		
		JButton btn_confirm = new JButton("\u89E3\u6302");
		btn_confirm.setBounds(251, 381, 113, 42);
		frame.getContentPane().add(btn_confirm);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.setBounds(386, 381, 113, 42);
		frame.getContentPane().add(button);
		
		JLabel label_bg = new JLabel("");
		label_bg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\CCB.png"));
		label_bg.setBounds(0, 0, 593, 437);
		frame.getContentPane().add(label_bg);
		
	}

	public void setMessage(){
		
	}
}
