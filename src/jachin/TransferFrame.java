package jachin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TransferFrame {

	private JFrame frameTransfer;
	private JTextField textField_money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferFrame window = new TransferFrame();
					window.frameTransfer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TransferFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameTransfer = new JFrame();
		frameTransfer.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameTransfer.setIconImage(
				Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frameTransfer.setResizable(false);
		frameTransfer.setBounds(360, 150, 1095, 750);
		frameTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTransfer.getContentPane().setLayout(null);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		button_1.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnExit.png"));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button_1.setBounds(875, 550, 200, 80);
		frameTransfer.getContentPane().add(button_1);
		
		textField_money = new JTextField();
		textField_money.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 40));
		textField_money.setBounds(282, 335, 451, 53);
		frameTransfer.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferMoney();
			}
		});
		button.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_confirm.png"));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button.setBounds(14, 550, 200, 80);
		frameTransfer.getContentPane().add(button);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\ATM_bg.png"));
		lblBg.setBounds(0, 0, 1086, 715);
		frameTransfer.getContentPane().add(lblBg);
	}
	
	public void TransferMoney(){
		
	}
	
	public void Back(){
		MainFrame.main(null);
		frameTransfer.dispose();
	}

}
