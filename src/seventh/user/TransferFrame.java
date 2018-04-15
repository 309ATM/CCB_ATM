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

import seventh.accout.BlankAccout;
import seventh.until.ATMButton;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * 转账
 *
 */
public class TransferFrame {

	private JFrame frameTransfer;
	private JTextField textField_money;
	boolean isCross;
	boolean fees;
	String[] message = new String[5];
	// private MainFrame mainFrame = new MainFrame();
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";
	private JLabel label_tip;
	private ATMButton btn_confirm;
	private ATMButton btn_transfer;
	private JLabel label_message;
	private MessageFrame messageFrame = new MessageFrame();

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
		frameTransfer.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameTransfer.setResizable(false);
		frameTransfer.setBounds(360, 150, 1095, 750);
		frameTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTransfer.getContentPane().setLayout(null);

		ATMButton btn_exit = new ATMButton("<html><center>退出<br>Confirm</center></html>");
		btn_exit.setForeground(new Color(255, 0, 0));
		btn_exit.addActionListener(new Back());
		btn_exit.setBounds(14, 550, 200, 80);
		frameTransfer.getContentPane().add(btn_exit);

		textField_money = new JTextField();
		textField_money.setFont(new Font("微软雅黑 Light", Font.PLAIN, 40));
		textField_money.setBounds(321, 284, 451, 53);
		frameTransfer.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		btn_transfer = new ATMButton("<html><center>转账<br>Transfer</center></html>");
		btn_transfer.setForeground(new Color(0, 128, 0));
		btn_transfer.addActionListener(new TransferMoney());
		btn_transfer.setBounds(875, 550, 200, 80);
		frameTransfer.getContentPane().add(btn_transfer);

		btn_confirm = new ATMButton("<html><center>确认<br>Confirm</center></html>");
		btn_confirm.setForeground(new Color(0, 128, 0));
		btn_confirm.addActionListener(new ConfirmTransfer());
		btn_confirm.setBounds(875, 550, 200, 80);
		frameTransfer.getContentPane().add(btn_confirm);

		label_tip = new JLabel("请输入转入账号，无误后继续");
		label_tip.setHorizontalAlignment(SwingConstants.CENTER);
		label_tip.setForeground(new Color(255, 255, 255));
		label_tip.setFont(new Font("幼圆", Font.BOLD, 24));
		label_tip.setBounds(321, 204, 451, 53);
		frameTransfer.getContentPane().add(label_tip);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(new Color(255, 0, 0));
		label_message.setFont(new Font("幼圆", Font.BOLD, 24));
		label_message.setBounds(392, 368, 311, 92);
		frameTransfer.getContentPane().add(label_message);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameTransfer.getContentPane().add(lblBg);
	}

	/**
	 * 输入卡号后的 转账按钮 监听器
	 */
	class TransferMoney implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label_message.setText("");
			// 首先判断输入卡号已经选择的功能是否一致(指所属银行及转账类型)
			String inputCard = textField_money.getText();// 获取输入要卡号
			if (!inputCard.isEmpty()) {
				Long card = Long.parseLong(inputCard);
				BlankAccout.getInstance().setTargetCard(card);
				// 判断输入卡号是否存在
				if (BlankAccout.getInstance().getAccountDAO().getCardExit(card)) {
					if (isCross) {// 跨行按钮
						if (BlankAccout.getInstance().getBlank()) {
							// 1.建行用户跨行转
							if (!BlankAccout.getInstance().getAccountDAO().getBanks(card)) {// 输入不能是本行卡号
								// 界面更改
								label_tip.setText("请输入转账金额，确认键转账");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
								fees = true;
							} else {
								// 提示不能输入本行卡号
								label_message.setText("<html><center>您选择的是跨行转账，<br>请输入其他银行的账号</center></html>");
							}
						} else {
							// 2.非建行用户转
							// TODO 不能转给自己的提示信息怎么写
							if (BlankAccout.getInstance().getCardNum() == BlankAccout.getInstance().getTargetCard()) {
								label_message.setText("请输入其他人的账号");
							} else {
								// 界面跳转
								label_tip.setText("请输入转账金额");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
								fees = true;
							}
						}

					} else {// 建行转建行按钮
							// 只需要判断输入卡号是不是建行以及不能输入自己的卡号
						if (BlankAccout.getInstance().getAccountDAO().getBanks(card)) {
							if (BlankAccout.getInstance().getCardNum() == BlankAccout.getInstance().getTargetCard()) {
								// TODO 不能转给自己的提示信息怎么写
								label_message.setText("请输入其他人的账号");
							} else {
								// 界面更改
								label_tip.setText("请输入转账金额");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
								fees = false;
							}
						} else {
							// 提醒输入建行账号
							label_message.setText("请输入建设银行账号");
						}
					}
				} else {
					label_message.setText("<html><center>您输入的账号不存在，<br>请重新输入</center></html>");
				}
			} else {
				label_message.setText("请输入账号");
			}
		}
	}

	/**
	 * 输入金额后的 确认按钮 监听器
	 */
	class ConfirmTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label_message.setText("");
			String moneys = textField_money.getText();
			float money = Float.parseFloat(moneys);
			float fee = 0;
			// 输入转账金额的合法性判断，如果都没问题
			if (fees) {// 跨行，收取手续费
				// 检查账户余额，收取手续费后，余额足够的话
				float balance = BlankAccout.getInstance().getBalance();// 用户转账前的余额
				balance = (float) (balance - money * 1.01);// 按手续费收取后的余额
				if (balance >= 0) {
					// 余额足够，则从余额中扣除转账金额
					BlankAccout.getInstance().setBalance(balance);
					// 转出卡号
					Long cardOut = BlankAccout.getInstance().getCardNum();
					// 转入卡号
					Long cardIn = BlankAccout.getInstance().getTargetCard();
					// 转账金额
					money = (float) (money * 0.99);
					// 手续费
					fee = (float) (money * 0.01);
					// 卡转出后余额
					float balanceOut = balance;
					// 卡转入后余额
					float balanceIn = BlankAccout.getInstance().getAccountDAO().getCardBalance(cardIn) + money;

					// 设置消息，传给交互界面
					message[0] = "跨行转账";
					message[1] = moneys; // 转账金额
					message[4] = String.valueOf(money * 0.1);
					message[2] = Float.toString(BlankAccout.getInstance().getBalance());// 账户余额
					message[3] = Long.toString(BlankAccout.getInstance().getTargetCard());// 目标账号
					messageFrame.getFrameMessage().setVisible(true);
					messageFrame.showMessage(message);
					frameTransfer.dispose();
					// 设置文本框为空，按钮重调
					label_tip.setText("请输入转入账号，无误后继续");
					textField_money.setText("");
					btn_transfer.setVisible(true);
					btn_confirm.setVisible(false);

					// 设置转账转出方的余额，转出卡号+余额
					BlankAccout.getInstance().getAccountDAO().setCardBalance(cardOut, balanceOut);
					// 设置转账转入方的余额，转入卡号+余额
					BlankAccout.getInstance().getAccountDAO().setCardBalance(cardIn, balanceIn);

					// 下面是将记录插入交易历史记录表
					// 卡转出的记录
					BlankAccout.getInstance().getTradingrecDAO().insertRecording(cardOut, money, "转账转出", cardIn, fee);
					// 卡转入的记录
					BlankAccout.getInstance().getTradingrecDAO().insertRecording(cardIn, money, "转账转入", cardOut, fee);

				} else {
					// 提醒用户扣除手续费后余额不足
					label_message.setText("扣除1%的手续费后余额不足");
				}
			} else {// 本行转账，不收手续费
					// 检查账户余额，足够的话
				float balance = BlankAccout.getInstance().getBalance();
				balance = balance - money; // 转账后的余额
				if (balance >= 0) {
					// 余额足够，则从余额中扣除转账金额
					BlankAccout.getInstance().setBalance(balance);
					// 转出卡号
					Long cardOut = BlankAccout.getInstance().getCardNum();
					// 转入卡号
					Long cardIn = BlankAccout.getInstance().getTargetCard();
					// 转账金额就是输入的金额money
					// 手续费就是fee = 0
					// 卡转出后的余额
					float balanceOut = balance;
					// 卡转入后的余额
					float balanceIn = BlankAccout.getInstance().getAccountDAO().getCardBalance(cardIn) + money;

					// 转账成功，发送消息给转账成功提示界面
					message[0] = "转账";
					message[1] = moneys; // 转账金额
					message[2] = Float.toString(BlankAccout.getInstance().getBalance());// 账户余额
					message[3] = Long.toString(BlankAccout.getInstance().getTargetCard());// 目标账号
					messageFrame.getFrameMessage().setVisible(true);
					messageFrame.showMessage(message);
					frameTransfer.dispose();
					label_tip.setText("请输入转入账号，无误后继续");
					textField_money.setText("");
					btn_transfer.setVisible(true);
					btn_confirm.setVisible(false);

					// 设置转账转出方的余额，转出卡号+余额
					BlankAccout.getInstance().getAccountDAO().setCardBalance(cardOut, balanceOut);
					// 设置转账转入方的余额，转入卡号+余额
					BlankAccout.getInstance().getAccountDAO().setCardBalance(cardIn, balanceIn);

					// 下面是将记录插入交易历史记录表
					// 卡转出的记录
					BlankAccout.getInstance().getTradingrecDAO().insertRecording(cardOut, money, "转账转出", cardIn, fee);
					// 卡转入的记录
					BlankAccout.getInstance().getTradingrecDAO().insertRecording(cardIn, money, "转账转入", cardOut, fee);

				} else {
					// 提醒用户余额不足
				}

			}
			// TODO 转账操作，判断目标账号，增加交易记录进数据库，修改余额
		}
	}

	class Back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTransfer.dispose();
			label_message.setText("");
			label_tip.setText("请输入转入账号，无误后继续");
			btn_transfer.setVisible(true);
			textField_money.setText("");
			btn_confirm.setVisible(false);

		}

	}

}
