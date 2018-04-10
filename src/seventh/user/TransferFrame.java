package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TransferFrame {

	private JFrame frameTransfer;
	private JTextField textField_money;
	// private MainFrame mainFrame = new MainFrame();

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

	public JFrame getFrameTransfer() {
		return frameTransfer;
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

		ATMButton btn_exit = new ATMButton("<html><center>ÍË³ö<br>Confirm</center></html>");
		btn_exit.addActionListener(new Back());
		btn_exit.setBounds(875, 550, 200, 80);
		frameTransfer.getContentPane().add(btn_exit);

		textField_money = new JTextField();
		textField_money.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 40));
		textField_money.setBounds(300, 335, 451, 53);
		frameTransfer.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		ATMButton button = new ATMButton("<html><center>×ªÕË<br>Transfer</center></html>");
		button.addActionListener(new TransferMoney());
		button.setBounds(14, 550, 200, 80);
		frameTransfer.getContentPane().add(button);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameTransfer.getContentPane().add(lblBg);
	}

	class TransferMoney implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO ×ªÕË²Ù×÷

		}

	}

	class Back implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTransfer.dispose();

		}
		
	}

}
