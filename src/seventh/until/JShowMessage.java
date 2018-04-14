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
		frame.setTitle("\u7528\u6237\u4FE1\u606F");
		frame.setBounds(100, 100, 719, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_name = new JLabel("Ãû×Ö£ºËÎ¿ÆÈå");
		label_name.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_name.setBounds(143, 164, 135, 50);
		frame.getContentPane().add(label_name);
		
		JLabel label_phone = new JLabel("µç»°£º181002244927");
		label_phone.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_phone.setBounds(143, 353, 398, 50);
		frame.getContentPane().add(label_phone);
		
		JLabel label_idcard = new JLabel("Éí·ÝÖ¤ºÅ£º440902199615213345");
		label_idcard.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_idcard.setBounds(143, 290, 398, 50);
		frame.getContentPane().add(label_idcard);
		
		JLabel label_address1 = new JLabel("¼ÒÍ¥×¡Ö·£º");
		label_address1.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_address1.setBounds(143, 419, 106, 50);
		frame.getContentPane().add(label_address1);
		
		JLabel label_sex = new JLabel("ÐÔ±ð£ºÄÐ");
		label_sex.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_sex.setBounds(143, 227, 135, 50);
		frame.getContentPane().add(label_sex);
		
		JLabel label_type = new JLabel("ÕËºÅÀàÐÍ£ºÐÅÓÃ¿¨");
		label_type.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_type.setBounds(406, 164, 204, 50);
		frame.getContentPane().add(label_type);
		
		JLabel label_address = new JLabel("11111111111111111112222222222222222222222");
		label_address.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_address.setBounds(225, 394, 336, 100);
		frame.getContentPane().add(label_address);
		
		JButton btn_confirm = new JButton("\u89E3\u6302");
		btn_confirm.setBounds(212, 512, 113, 42);
		frame.getContentPane().add(btn_confirm);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.setBounds(372, 512, 113, 42);
		frame.getContentPane().add(button);
		
		JLabel lblStatu = new JLabel("ÕËºÅ×´Ì¬£º");
		lblStatu.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		lblStatu.setBounds(406, 227, 204, 50);
		frame.getContentPane().add(lblStatu);
		
		JLabel label_bg = new JLabel("");
		label_bg.setIcon(new ImageIcon("E:\\CCB_ATM\\img\\UserInformation.png"));
		label_bg.setBounds(0, 0, 707, 603);
		frame.getContentPane().add(label_bg);
		
	}

	public void setMessage(){
		
	}
}
