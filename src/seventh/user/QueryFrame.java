package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import seventh.accout.BlankAccout;
import seventh.until.ATMButton;

import java.awt.Color;

/**
 * 查询余额
 *
 */
public class QueryFrame {

	private JFrame frameQuery;
	private JLabel label;
	//private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryFrame window = new QueryFrame();
					window.frameQuery.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrameQuery() {
		return frameQuery;
	}
	/**
	 * Create the application.
	 */
	public QueryFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameQuery = new JFrame();
		frameQuery.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameQuery.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameQuery.setResizable(false);
		frameQuery.setBounds(360, 150, 1095, 750);
		frameQuery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameQuery.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html><center>退出<br>Confirm</center></html>");
		button_1.addActionListener(new Back());
		button_1.setBounds(875, 550, 200, 80);
		frameQuery.getContentPane().add(button_1);

		label = new JLabel("您的余额信息：");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("幼圆", Font.BOLD, 26));
		label.setBounds(304, 181, 464, 271);
		frameQuery.getContentPane().add(label);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameQuery.getContentPane().add(lblBg);
	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameQuery.dispose();
		}
	}

	public void showMessage() {
		float balance= BlankAccout.getInstance().getBalance();
		float overdraft = BlankAccout.getInstance().getOverdraft();
		float withdrawalsLimit = BlankAccout.getInstance().getWithdrawalsLimit();
		float depositLimit = BlankAccout.getInstance().getDepositLimit(); 
		
		String messages = "<html><p align=\"left\">您的余额为：{0}元<br>您的透支额度为：{1}元<br>您今日存款限额还剩：{2}元<br>您今日取款限额还剩：{3}元</p></html>";//显示信息还要修改
		messages = messages.replace("{0}", String.valueOf(balance));//message[0-3]换成上面的money等
		messages = messages.replace("{1}", String.valueOf(overdraft));
		messages = messages.replace("{2}", String.valueOf(depositLimit));
		messages = messages.replace("{3}", String.valueOf(withdrawalsLimit));
		label.setText(messages);
	}
	
	
}
