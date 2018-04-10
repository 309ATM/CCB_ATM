package jachin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUI {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_sex;
	private JTextField textField_idcard;
	private JTextField textField_carNum;
	private JTextField textField_phone;
	private String File = "E:\\Code\\java\\Eclipse-ATM\\CCB_ATM";
	private JTextField textField_lock;
	private JTextField textField_loss;
	private JTextField textField_yue;
	// private String File = ".";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AdminUI window = new AdminUI();
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
	public AdminUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frame.setTitle("中国建设银行后台管理系统");
		frame.setBounds(500, 200, 1079, 660);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 15, 1062, 635);
		frame.getContentPane().add(tabbedPane);
		tabbedPane.setOpaque(false);

		ImageIcon ico_openAcc = new ImageIcon(File + "\\img\\OpenAccount.png");
		ImageIcon ico_reportLoss = new ImageIcon(File + "\\img\\ReportLoss.png");
		ImageIcon ico_lockAcc = new ImageIcon(File + "\\img\\LockAcc.png");
		ImageIcon ico_queryHistory = new ImageIcon(File + "\\img\\QueryHistory.png");
		ImageIcon ico_changePasswd = new ImageIcon(File + "\\img\\Admin.png");

		JPanel panel_Acc = new JPanel();
		tabbedPane.addTab(null, ico_openAcc, panel_Acc, "开户销户");
		panel_Acc.setLayout(null);

		JTabbedPane tabbedPane_Acc = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Acc.setBounds(0, 0, 1057, 514);
		panel_Acc.add(tabbedPane_Acc);

		JPanel panel_OpenAcc = new JPanel();
		tabbedPane_Acc.addTab("\u5F00\u6237", null, panel_OpenAcc, null);
		panel_OpenAcc.setLayout(null);
		panel_OpenAcc.setOpaque(false);

		JLabel label_inputAccInfo = new JLabel("请输入用户信息");
		label_inputAccInfo.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_inputAccInfo.setBounds(45, 13, 133, 43);
		panel_OpenAcc.add(label_inputAccInfo);

		JSeparator separator = new JSeparator();
		separator.setBounds(14, 70, 1024, 2);
		panel_OpenAcc.add(separator);

		JLabel label_name = new JLabel("姓名");
		label_name.setHorizontalAlignment(SwingConstants.LEFT);
		label_name.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_name.setBounds(180, 123, 72, 43);
		panel_OpenAcc.add(label_name);

		JLabel label_sex = new JLabel("性别");
		label_sex.setHorizontalAlignment(SwingConstants.LEFT);
		label_sex.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_sex.setBounds(180, 179, 72, 43);
		panel_OpenAcc.add(label_sex);

		JLabel label_idcard = new JLabel("身份证号");
		label_idcard.setHorizontalAlignment(SwingConstants.LEFT);
		label_idcard.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_idcard.setBounds(180, 235, 72, 43);
		panel_OpenAcc.add(label_idcard);

		JLabel label_phone = new JLabel("手机号码");
		label_phone.setHorizontalAlignment(SwingConstants.LEFT);
		label_phone.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_phone.setBounds(180, 291, 72, 43);
		panel_OpenAcc.add(label_phone);

		JLabel label_address = new JLabel("家庭住址");
		label_address.setHorizontalAlignment(SwingConstants.LEFT);
		label_address.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_address.setBounds(529, 123, 72, 43);
		panel_OpenAcc.add(label_address);

		textField_name = new JTextField();
		textField_name.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_name.setBounds(265, 131, 211, 28);
		panel_OpenAcc.add(textField_name);
		textField_name.setColumns(10);

		textField_sex = new JTextField();
		textField_sex.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_sex.setColumns(10);
		textField_sex.setBounds(266, 189, 211, 28);
		panel_OpenAcc.add(textField_sex);

		textField_idcard = new JTextField();
		textField_idcard.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_idcard.setColumns(10);
		textField_idcard.setBounds(266, 243, 211, 28);
		panel_OpenAcc.add(textField_idcard);

		textField_phone = new JTextField();
		textField_phone.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_phone.setColumns(10);
		textField_phone.setBounds(266, 299, 211, 28);
		panel_OpenAcc.add(textField_phone);

		JTextArea textArea_address = new JTextArea();
		textArea_address.setLineWrap(true);
		textArea_address.setFont(new Font("幼圆", Font.PLAIN, 18));
		textArea_address.setBounds(615, 133, 211, 190);
		panel_OpenAcc.add(textArea_address);
		textArea_address.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JButton btn_account = new JButton("录入用户信息");
		btn_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_name.getText();
				String sex = textField_sex.getText();
				String idCard = textField_idcard.getText();
				String phone = textField_phone.getText();
				String address = textArea_address.getText();
				if (name.isEmpty() | sex.isEmpty() | idCard.isEmpty() | phone.isEmpty() | address.isEmpty()) {
					JOptionPane.showMessageDialog(null, "信息不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				} else {
					String a = JOptionPane.showInputDialog(null, "请设置密码", "提示", JOptionPane.INFORMATION_MESSAGE);
					String b = JOptionPane.showInputDialog(null, "请再次输入密码", "提示", JOptionPane.INFORMATION_MESSAGE);
					try {
						if (a.equals(b)) {
							System.out.println(a);
						} else {
							JOptionPane.showMessageDialog(null, "两次密码不一致", "错误", JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "您取消了操作", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		btn_account.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_account.setBounds(415, 379, 153, 43);
		panel_OpenAcc.add(btn_account);

		JLabel label_bg11 = new JLabel("");
		label_bg11.setBounds(0, 0, 1052, 475);
		label_bg11.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		panel_OpenAcc.add(label_bg11);

		JPanel panel_DelAcc = new JPanel();
		tabbedPane_Acc.addTab("\u9500\u6237", null, panel_DelAcc, null);
		panel_DelAcc.setOpaque(false);
		panel_DelAcc.setLayout(null);

		JLabel label_inputCardNum = new JLabel("请输入卡号");
		label_inputCardNum.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_inputCardNum.setBounds(45, 13, 171, 43);
		panel_DelAcc.add(label_inputCardNum);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(14, 70, 1024, 2);
		panel_DelAcc.add(separator_1);

		textField_carNum = new JTextField();
		textField_carNum.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_carNum.setBounds(285, 155, 444, 43);
		panel_DelAcc.add(textField_carNum);
		textField_carNum.setColumns(10);

		JButton btn_delAcc = new JButton("销户");
		btn_delAcc.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_delAcc.setBounds(458, 258, 84, 27);
		panel_DelAcc.add(btn_delAcc);

		JLabel label_bg12 = new JLabel("");
		label_bg12.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		label_bg12.setBounds(0, 0, 1052, 475);
		panel_DelAcc.add(label_bg12);

		JPanel panel_Loss = new JPanel();
		tabbedPane.addTab(null, ico_reportLoss, panel_Loss, "挂失解挂");
		panel_Loss.setLayout(null);

		textField_loss = new JTextField();
		textField_loss.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_loss.setBounds(290, 128, 444, 43);
		panel_Loss.add(textField_loss);

		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u5361\u53F7");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_2.setBounds(35, 13, 171, 43);
		panel_Loss.add(label_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(14, 69, 1024, 2);
		panel_Loss.add(separator_3);

		JButton btn_loss = new JButton("确认");
		btn_loss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loss();
			}
		});
		btn_loss.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_loss.setBounds(470, 217, 90, 43);
		panel_Loss.add(btn_loss);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\bg.jpg"));
		label_1.setBounds(0, 0, 1065, 502);
		panel_Loss.add(label_1);

		JPanel panel_lock = new JPanel();
		tabbedPane.addTab(null, ico_lockAcc, panel_lock, "冻结解冻");
		panel_lock.setLayout(null);

		JLabel label_inputCardNumLock = new JLabel("请输入卡号");
		label_inputCardNumLock.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_inputCardNumLock.setBounds(35, 13, 171, 43);
		panel_lock.add(label_inputCardNumLock);
		separator_1.setBounds(14, 70, 1024, 2);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(14, 69, 1024, 2);
		panel_lock.add(separator_4);

		textField_lock = new JTextField();
		textField_lock.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_lock.setBounds(290, 128, 444, 43);
		panel_lock.add(textField_lock);
		textField_carNum.setColumns(10);

		JButton btn_lock = new JButton("\u786E\u8BA4");
		btn_lock.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_lock.setBounds(470, 217, 90, 43);
		panel_lock.add(btn_lock);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\bg.jpg"));
		label.setBounds(0, 0, 1065, 502);
		panel_lock.add(label);

		JPanel panel_queryHistory = new JPanel();
		tabbedPane.addTab(null, ico_queryHistory, panel_queryHistory, "查询交易历史");
		panel_queryHistory.setLayout(null);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\bg.jpg"));
		label_3.setBounds(0, 0, 1068, 504);
		panel_queryHistory.add(label_3);

		JPanel panel_changePasswd = new JPanel();
		tabbedPane.addTab(null, ico_changePasswd, panel_changePasswd, "修改密码");
		panel_changePasswd.setLayout(null);

		JLabel lblTips = new JLabel("\u8BF7\u8F93\u5165\u5361\u53F7");
		lblTips.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblTips.setBounds(35, 13, 101, 43);
		panel_changePasswd.add(lblTips);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(14, 69, 1024, 2);
		panel_changePasswd.add(separator_5);

		textField_yue = new JTextField();
		textField_yue.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_yue.setBounds(290, 128, 444, 43);
		panel_changePasswd.add(textField_yue);

		JButton btn_yue = new JButton("\u786E\u8BA4");
		btn_yue.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_yue.setBounds(752, 128, 90, 43);
		panel_changePasswd.add(btn_yue);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\bg.jpg"));
		label_4.setBounds(0, 0, 1068, 504);
		panel_changePasswd.add(label_4);
	}

	public void loss() {
		String card = textField_loss.getText();
		// 调用数据库方法判断卡号是否存在
		if (true) {
			String a = JOptionPane.showInputDialog(null, "请输入密码", "提示", JOptionPane.INFORMATION_MESSAGE);
			// 判断卡号密码一致
			if (true) {
				//获取账户状态
				System.out.println("");
			} else{
				JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "该账户不存在", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void lock() {
		String card = textField_lock.getText();
		// 调用数据库方法判断卡号是否存在
	}
 
	public void yue() {
		String card = textField_yue.getText();
		// 调用数据库方法判断卡号是否存在
	}

}
