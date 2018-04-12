package seventh.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import seventh.accout.BlankAccout;
import seventh.until.ATMButton;

/**
 * 存款
 *
 */
public class SaveFrame {

	private JFrame frameSave;
	private JTextField textField_money;
	private String File = "E:\\Code\\java\\CCB_ATM";
	private JLabel label_message;
	private JLabel label_success;
	// private String File = ".";

	public JFrame getFrameSave() {
		return frameSave;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SaveFrame window = new SaveFrame();
					window.frameSave.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaveFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSave = new JFrame();
		frameSave.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameSave.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameSave.setResizable(false);
		frameSave.setBounds(360, 150, 1095, 750);
		frameSave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSave.getContentPane().setLayout(null);

		JLabel label = new JLabel("请输入金额");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("幼圆", Font.BOLD, 28));
		label.setBounds(381, 260, 294, 48);
		frameSave.getContentPane().add(label);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.red);
		label_message.setFont(new Font("幼圆", Font.BOLD, 20));
		label_message.setBounds(381, 406, 294, 48);
		frameSave.getContentPane().add(label_message);
		
		label_success = new JLabel("");
		label_success.setHorizontalAlignment(SwingConstants.CENTER);
		label_success.setForeground(Color.WHITE);
		label_success.setFont(new Font("幼圆", Font.BOLD, 20));
		label_success.setBounds(381, 406, 294, 100);
		frameSave.getContentPane().add(label_success);

		textField_money = new JTextField();
		textField_money.setFont(new Font("微软雅黑 Light", Font.PLAIN, 40));
		textField_money.setBounds(380, 330, 294, 53);
		frameSave.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		ATMButton btn_confirm = new ATMButton("<html><center>确认<br>Exit</center></html>");
		btn_confirm.setForeground(new Color(0, 128, 0));
		btn_confirm.addActionListener(new SaveMoney());
		btn_confirm.setBounds(875, 550, 200, 80);
		frameSave.getContentPane().add(btn_confirm);

		ATMButton btn_exit = new ATMButton("<html><center>退出<br>Exit</center></html>");
		btn_exit.setForeground(Color.RED);
		btn_exit.addActionListener(new Back());
		btn_exit.setBounds(14, 550, 200, 80);
		frameSave.getContentPane().add(btn_exit);

		JLabel lblBg = new JLabel("");
		lblBg.setFont(new Font("微软雅黑 Light", Font.PLAIN, 36));
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameSave.getContentPane().add(lblBg);
	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameSave.setVisible(false);
		}
	}

	public Boolean poundage(String card) {
		// 判断所属银行
		return true;
	}

	public void deposit(Long card, int money) {
		// 存款方法
		//TODO 调用数据库函数，存钱
		BlankAccout.getInstance().setBalance(BlankAccout.getInstance().getBalance() + money);
		BlankAccout.getInstance().setTargetCard(BlankAccout.getInstance().getCardNum());
	}

	// 存钱监听器
	class SaveMoney implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			label_message.setText("");
				String moneys = textField_money.getText().trim();
				try {
					int money = Integer.parseInt(moneys);
//					BlankAccout.getInstance().setDepositLimit(4000);
//					BlankAccout.getInstance().setBlank("中国银行");
					if (money % 100 != 0){
						label_message.setText("金额数必须是100的整数倍");
					}
					else if (money > 10000) {
						label_message.setText("单笔存款最多为10,000元");
					} else if (money > BlankAccout.getInstance().getDepositLimit()) {
						label_message.setText("存款数额大于今日限额");
					} else {
						// 判断银行，手续费计算
						if (BlankAccout.getInstance().getBlank() == "建设银行") {
							// 直接调用数据库存款方法
							deposit(BlankAccout.getInstance().getCardNum(), money);
						} else {
							// 非本行，计算手续费
							money = money * 99 / 100;
							deposit(BlankAccout.getInstance().getCardNum(), money);
						}
						textField_money.setText("");
						float balace = BlankAccout.getInstance().getBalance();
						float overdraft = BlankAccout.getInstance().getOverdraft();
						
						label_success.setText("<html><center>存款成功<br>余额：" + balace + "<br>可透支额：" + overdraft + "</center></html>");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "请输入数字", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
	}

}
