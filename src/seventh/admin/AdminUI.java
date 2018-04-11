package seventh.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import seventh.accout.BlankAccout;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * 管理员功能
 *
 */
public class AdminUI {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_sex;
	private JTextField textField_idcard;
	private JTextField textField_carNum;
	private JTextField textField_phone;
	private JTextField textField_lock;
	private JTextField textField_loss;
	private JTextField textField_yue;
	private JTextArea textArea_address;
	private JButton btn_begin;
	private JButton btn_end;
	private JButton btn_confirm;
	private JTable table;
	private String File = "E:\\Code\\java\\CCB_ATM";
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

		JLabel label_5 = new JLabel("\u8D26\u6237\u7C7B\u578B");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_5.setBounds(529, 123, 72, 43);
		panel_OpenAcc.add(label_5);

		JLabel label_address = new JLabel("家庭住址");
		label_address.setHorizontalAlignment(SwingConstants.LEFT);
		label_address.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_address.setBounds(529, 179, 72, 43);
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

		textArea_address = new JTextArea();
		textArea_address.setLineWrap(true);
		textArea_address.setFont(new Font("幼圆", Font.PLAIN, 18));
		textArea_address.setBounds(615, 189, 211, 134);
		panel_OpenAcc.add(textArea_address);
		textArea_address.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JButton btn_account = new JButton("录入用户信息");
		btn_account.addActionListener(new UserInformation());

		String[] s = { "信用卡", "储蓄卡" };
		JComboBox comboBox = new JComboBox(s);
		comboBox.setFont(new Font("幼圆", Font.PLAIN, 18));
		comboBox.setBounds(615, 133, 211, 24);
		panel_OpenAcc.add(comboBox);

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
		btn_loss.addActionListener(new LossOperation());
		btn_loss.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_loss.setBounds(470, 217, 90, 43);
		panel_Loss.add(btn_loss);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
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
		label.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		label.setBounds(0, 0, 1065, 502);
		panel_lock.add(label);

		JPanel panel_queryHistory = new JPanel();
		tabbedPane.addTab(null, ico_queryHistory, panel_queryHistory, "查询交易历史");
		panel_queryHistory.setLayout(null);

		JLabel lblBegin = new JLabel("起始日期");
		lblBegin.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblBegin.setBounds(363, 30, 72, 40);
		panel_queryHistory.add(lblBegin);

		JLabel lblEnd = new JLabel("结束日期");
		lblEnd.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblEnd.setBounds(632, 30, 72, 40);
		panel_queryHistory.add(lblEnd);

		// TODO 按钮
		btn_begin = new JButton("选择日期");
		btn_begin.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btn_begin.addActionListener(new getDate());
		btn_begin.setBounds(444, 30, 155, 40);
		panel_queryHistory.add(btn_begin);

		btn_end = new JButton("选择日期");
		btn_end.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btn_end.addActionListener(new getDate());
		btn_end.setBounds(711, 30, 160, 40);
		panel_queryHistory.add(btn_end);

		btn_confirm = new JButton("确定");
		btn_confirm.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_confirm.addActionListener(new getDate());
		btn_confirm.setBounds(900, 30, 113, 41);
		panel_queryHistory.add(btn_confirm);

		// 表格
		JPanel panel = new JPanel();
		panel.setBounds(73, 100, 954, 365);
		panel_queryHistory.add(panel);

		table = new JTable();
		// 设置表格的格式
		table.setRowHeight(50); // 设置行高
		table.getTableHeader().setFont(new Font("幼圆", Font.BOLD, 20)); // 设置表头字体
		table.setFont(new Font("幼圆", Font.BOLD, 20)); // 设置表格字体
		table.setRowMargin(5);// 设置相邻两行单元格的距离
		table.setRowSelectionAllowed(true);// 设置可否被选择.默认为false
		table.setSelectionBackground(Color.white);// 设置所选择行的背景色
		table.setSelectionForeground(new Color(135, 136, 250));// 设置所选择行的前景色
		table.setGridColor(Color.black);// 设置网格线的颜色
		table.setDragEnabled(false);// 不懂这个
		table.setShowGrid(false);// 是否显示网格线
		table.setShowHorizontalLines(true);// 是否显示水平的网格线
		table.setShowVerticalLines(true);// 是否显示垂直的网格线
		table.getTableHeader().setResizingAllowed(false);// 设置表格不可整列移动
		table.getTableHeader().setReorderingAllowed(false);// 设置表格列宽不可改

		table.doLayout();
		panel.setLayout(null);
		table.setBackground(SystemColor.control);

		JScrollPane JSP = new JScrollPane(table);
		JSP.setBounds(0, 0, 954, 365);
		panel.add(JSP);
		table.setBounds(171, 236, 700, 700);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(120, 32, 223, 36);
		panel_queryHistory.add(textField);
		
		JLabel label_6 = new JLabel("\u5361\u53F7");
		label_6.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_6.setBounds(68, 32, 47, 40);
		panel_queryHistory.add(label_6);
		
				JLabel label_3 = new JLabel("");
				label_3.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
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
		label_4.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		label_4.setBounds(0, 0, 1068, 504);
		panel_changePasswd.add(label_4);
	}

	public void lock() {
		String card = textField_lock.getText();
		// 调用数据库方法判断卡号是否存在
	}

	public void yue() {
		String card = textField_yue.getText();
		// 调用数据库方法判断卡号是否存在
	}

	//TODO 获取填入表格的数据
	public void WriteData(String[] month) {
		final String[] columnNames = { "日期", "交易类型", "交易金额", "目标账户", "手续费" };
		// 调用数据库方法获取记录
		// function(BlankAccout.getInstance().getCardNum(),getDate(6));
		// 这部分数据从数据库里获取
		String[][] rowData = { { "2018.04.01 08:09:56", "转账", "￥1200", "62218858000005086", "￥0.00" },
				{ "2018.04.01 14:04:38", "转账", "￥13000", "62218858000005086", "￥0.00" },
				{ "2018.04.04 15:50:21", "转账", "￥100", "62218858000005086", "￥1.00" },
				{ "2018.04.08 11:34:23", "转账", "￥200", "62218858000005086", "￥2.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" } };

		table.setModel(new DefaultTableModel(rowData, columnNames));
		// 设置文字居中
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumn("日期").setCellRenderer(render);
		table.getColumn("交易类型").setCellRenderer(render);
		table.getColumn("交易金额").setCellRenderer(render);
		table.getColumn("目标账户").setCellRenderer(render);
		table.getColumn("手续费").setCellRenderer(render);
		// 设置列宽
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
	}

	String dateBefore = "";
	String dateNow = "";
	private JTextField textField;

	// TODO 获取日期监听器
	class getDate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JDateChooser dateChoose = new JDateChooser();

			if (e.getSource() == btn_begin) {
				dateChoose.showDateChooser();
				dateBefore = dateChoose.getDateFormat("yyyy-MM-dd");
				btn_begin.setText(dateBefore);
			}
			if (e.getSource() == btn_end) {
				dateChoose.showDateChooser();
				dateNow = dateChoose.getDateFormat("yyyy-MM-dd");
				btn_end.setText(dateNow);
			}
			if (e.getSource() == btn_confirm) {
				if(dateBefore.isEmpty()||dateNow.isEmpty()){
					JOptionPane.showMessageDialog(null, "请选择正确日期", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else if (dateBefore.compareTo(dateNow) <= 0) {
					// TODO 读取记录信息，插入信息到表格JTable中
					String[] date = {dateBefore,dateNow};
					WriteData(date);
				} else {
					JOptionPane.showMessageDialog(null, "请选择正确日期", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	// 录入用户信息的监听器
	class UserInformation implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// 去除信息头尾的空格
			String name = textField_name.getText().trim();
			String sex = textField_sex.getText().trim();
			String idCard = textField_idcard.getText().trim();
			String phone = textField_phone.getText().trim();
			String address = textArea_address.getText().trim();
			// 开始进行信息检查
			if (name.isEmpty() | sex.isEmpty() | idCard.isEmpty() | phone.isEmpty() | address.isEmpty()) {
				JOptionPane.showMessageDialog(null, "信息不能为空", "错误", JOptionPane.ERROR_MESSAGE);
			} else if (phone.length() != 11) {
				JOptionPane.showMessageDialog(null, "手机号长度不正确", "错误", JOptionPane.ERROR_MESSAGE);
			} else if (idCard.length() != 18) {
				JOptionPane.showMessageDialog(null, "身份证号码长度不正确", "错误", JOptionPane.ERROR_MESSAGE);
			} else {
				String password = JOptionPane.showInputDialog(null, "请设置密码", "提示", JOptionPane.INFORMATION_MESSAGE);
				String confirmPassword = null;
				// 如果用户取消输入密码，则不弹出确认密码的输入框
				if (password != null) {
					confirmPassword = JOptionPane.showInputDialog(null, "请再次输入密码", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				}
				try {
					if (confirmPassword.length() == 6 && password.length() == 6) {
						if (password.equals(confirmPassword)) {
							BlankAccout.getInstance().setCardNum(Long.parseLong(idCard));
							System.out.println(BlankAccout.getInstance().getCardNum());
						} else {
							JOptionPane.showMessageDialog(null, "两次密码不一致", "错误", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "请输入6位密码", "错误", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "您取消了操作", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		}
	}

	// 挂失解挂监听器
	class LossOperation implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String card = textField_loss.getText();
			Boolean flag = true;
			// 调用数据库方法判断卡号是否存在
			if (flag) {
				String a = JOptionPane.showInputDialog(null, "请输入密码", "提示", JOptionPane.INFORMATION_MESSAGE);
				// 判断卡号密码一致
				if (flag) {
					// 获取账户状态
					System.out.println("");
				} else {
					JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "该账户不存在", "错误", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
