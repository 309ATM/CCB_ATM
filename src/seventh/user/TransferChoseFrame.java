package seventh.user;

import seventh.accout.BlankAccout;
import seventh.until.ATMButton;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class TransferChoseFrame {

	private JFrame frameTransferChose;
	private TransferFrame transferFrame = new TransferFrame();
	private String File = "E:\\Code\\java\\CCB_ATM";
	private ATMButton button;
	// private String File = ".";

	public JFrame getFrameTransferChose() {
		return frameTransferChose;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TransferChoseFrame window = new TransferChoseFrame();
					window.frameTransferChose.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TransferChoseFrame() {
		initialize();
		transferFrame.getFrameTransfer().setVisible(false);
		if(!BlankAccout.getInstance().getBlank()){
			button.setVisible(false);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameTransferChose = new JFrame();
		frameTransferChose.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameTransferChose.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameTransferChose.setResizable(false);
		frameTransferChose.setBounds(360, 150, 1095, 750);
		frameTransferChose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTransferChose.getContentPane().setLayout(null);

		button = new ATMButton("<html><center>建行转建行<br>Transfer</center></html>");
		button.addActionListener(new ToTransfer());
		button.setBounds(14, 330, 200, 80);
		frameTransferChose.getContentPane().add(button);

		ATMButton overdeaftButton = new ATMButton("<html><center>跨行转账<br>Cross Bank</center></html>");
		overdeaftButton.setActionCommand("跨行转账");
		overdeaftButton.addActionListener(new ToTransfer());
		overdeaftButton.setBounds(875, 330, 200, 80);
		frameTransferChose.getContentPane().add(overdeaftButton);

		ATMButton button_2 = new ATMButton("<html>退出<br>Exit</html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Back());
		button_2.setBounds(875, 550, 200, 80);
		frameTransferChose.getContentPane().add(button_2);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameTransferChose.getContentPane().add(lblBg);
	}

	class ToTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// 判断是哪一种转账
			if (e.getActionCommand().equals("跨行转账")) {
				transferFrame.isCross = true;
			} else {
				transferFrame.isCross = false;
			}
			transferFrame.getFrameTransfer().setVisible(true);
			frameTransferChose.dispose();
		}
	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTransferChose.dispose();
		}
	}
}
