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

public class SaveFrame {

	private JFrame frameSave;
	private JTextField textField_money;

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
		frameSave.setIconImage(
				Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frameSave.setResizable(false);
		frameSave.setBounds(360, 150, 1095, 750);
		frameSave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSave.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html>退出<br>Exit</html>");
		button_1.addActionListener(new Back());
		button_1.setBounds(875, 550, 200, 80);
		frameSave.getContentPane().add(button_1);
		
		JLabel label = new JLabel("请输入金额");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("幼圆", Font.BOLD, 20));
		label.setBounds(381, 216, 294, 48);
		frameSave.getContentPane().add(label);
		
		textField_money = new JTextField();
		textField_money.setFont(new Font("微软雅黑 Light", Font.PLAIN, 40));
		textField_money.setBounds(380, 338, 294, 53);
		frameSave.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		ATMButton button = new ATMButton("<html>确认<br>Exit</html>");
		button.addActionListener(new SaveMoney());
		button.setBounds(14, 550, 200, 80);
		frameSave.getContentPane().add(button);

		JLabel lblBg = new JLabel("");
		lblBg.setFont(new Font("微软雅黑 Light", Font.PLAIN, 36));
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameSave.getContentPane().add(lblBg);
	}


	class Back implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);;
			frameSave.setVisible(false);
		}
	}

	public Boolean poundage(String card) {
		//判断所属银行
		return true;
	}
	
	public void deposit(Long card,int money){
		//存款方法
	}

	// 存钱监听器
		class SaveMoney implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				String moneys = textField_money.getText().trim();
				try {
					int money = Integer.parseInt(moneys);
//					BlankAccout.getInstance().setDepositLimit(4000);
//					BlankAccout.getInstance().setBlank("中国银行");
					if (money % 100 != 0)
						JOptionPane.showMessageDialog(null, "金额数必须是100的整数倍", "错误", JOptionPane.ERROR_MESSAGE);
					else if (money > 10000) {
						JOptionPane.showMessageDialog(null, "存款数额大于单笔限额，单笔存款最多为10000元", "错误", JOptionPane.ERROR_MESSAGE);
					} else if (money > BlankAccout.getInstance().getDepositLimit()) {
						JOptionPane.showMessageDialog(null, "存款数额大于今日限额", "错误", JOptionPane.ERROR_MESSAGE);
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
						// 调用数据库函数，存钱
						JOptionPane.showMessageDialog(null, money, "存款成功", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "请输入数字", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	
}
