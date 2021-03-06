package seventh.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import seventh.accout.BankAccout;
import seventh.until.JDateChooser;
import seventh.until.JShowInfo;
import org.junit.Test;

/**
 * 管理员功能
 *
 */
/**
 * @author Admin
 *
 */
/**
 * @author Admin
 *
 */
@SuppressWarnings("rawtypes")
public class AdminUI {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_idcard;
	private JTextField textField_delAccount;
	private JTextField textField_phone;
	private JTextField textField_queryBalance;
	private JTextField textField_loss;
	private JTextField textField_chaUserPass;
	private JTextArea textArea_address;
	private JTextField textField_query;
	private JTextField textField_queryInfo;
	private JTextField textField_changeInfo;
	private JTextField textField_OpenCard;
	private JButton btn_begin;
	private JButton btn_end;
	private JButton btn_confirm;
	private JComboBox comboBox_cardType;
	private JComboBox comboBox;
	private JButton btn_loss;
	private JTable table;
	private String[] date;

	// private String File = "E:\\Code\\java\\CCB_ATM";
	private JTextField textField_lock;
	private JTextField textField_chaAdminPass;
	private String File = ".";
	private JButton btn_openCardChu;
	private JButton btn_openCardXin;

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
		date = new String[2];
		InitialDate();
		initialize();
	}

	/**
	 * 为Frame添加控件，并实例化它们
	 */
	@SuppressWarnings("unchecked")
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
		ImageIcon ico_statusOprea = new ImageIcon(File + "\\img\\StatusOperation.png");
		ImageIcon ico_query = new ImageIcon(File + "\\img\\QueryBlance.png");
		ImageIcon ico_queryHistory = new ImageIcon(File + "\\img\\QueryHistory.png");
		ImageIcon ico_changePasswd = new ImageIcon(File + "\\img\\Admin.png");
		ImageIcon ico_background = new ImageIcon(File + "\\img\\bg.jpg");

		JPanel panel_Acc = new JPanel();
		tabbedPane.addTab(null, ico_openAcc, panel_Acc, "开户销户");
		panel_Acc.setLayout(null);

		JTabbedPane tabbedPane_Acc = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Acc.setBounds(0, 0, 1066, 505);
		panel_Acc.add(tabbedPane_Acc);

		JPanel panel_OpenAcc = new JPanel();
		tabbedPane_Acc.addTab("开户", null, panel_OpenAcc, null);
		panel_OpenAcc.setLayout(null);

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
		label_name.setBounds(180, 130, 72, 35);
		panel_OpenAcc.add(label_name);

		JLabel label_sex = new JLabel("性别");
		label_sex.setHorizontalAlignment(SwingConstants.LEFT);
		label_sex.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_sex.setBounds(180, 185, 72, 35);
		panel_OpenAcc.add(label_sex);

		JLabel label_idcard = new JLabel("身份证号");
		label_idcard.setHorizontalAlignment(SwingConstants.LEFT);
		label_idcard.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_idcard.setBounds(180, 240, 72, 35);
		panel_OpenAcc.add(label_idcard);

		JLabel label_phone = new JLabel("手机号码");
		label_phone.setHorizontalAlignment(SwingConstants.LEFT);
		label_phone.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_phone.setBounds(180, 295, 72, 35);
		panel_OpenAcc.add(label_phone);

		JLabel label_type = new JLabel("账户类型");
		label_type.setHorizontalAlignment(SwingConstants.LEFT);
		label_type.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_type.setBounds(529, 130, 72, 35);
		panel_OpenAcc.add(label_type);

		JLabel label_address = new JLabel("家庭住址");
		label_address.setHorizontalAlignment(SwingConstants.LEFT);
		label_address.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_address.setBounds(529, 185, 72, 35);
		panel_OpenAcc.add(label_address);

		textField_name = new JTextField();
		textField_name.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_name.setBounds(265, 130, 211, 35);
		panel_OpenAcc.add(textField_name);
		textField_name.setColumns(10);

		String[] sex = { "男", "女" };
		comboBox = new JComboBox(sex);
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("幼圆", Font.PLAIN, 18));
		comboBox.setBounds(265, 185, 211, 35);
		panel_OpenAcc.add(comboBox);

		textField_idcard = new JTextField();
		textField_idcard.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_idcard.setColumns(10);
		textField_idcard.setBounds(266, 240, 211, 35);
		panel_OpenAcc.add(textField_idcard);

		textField_phone = new JTextField();
		textField_phone.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_phone.setColumns(10);
		textField_phone.setBounds(266, 295, 211, 35);
		panel_OpenAcc.add(textField_phone);

		textArea_address = new JTextArea();
		textArea_address.setLineWrap(true);
		textArea_address.setFont(new Font("幼圆", Font.PLAIN, 18));
		textArea_address.setBounds(615, 185, 211, 145);
		panel_OpenAcc.add(textArea_address);
		textArea_address.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JButton btn_account = new JButton("录入用户信息");
		btn_account.addActionListener(new UserInformation());

		String[] type = { "信用卡", "储蓄卡" };
		comboBox_cardType = new JComboBox(type);
		comboBox_cardType.setForeground(Color.BLUE);
		comboBox_cardType.setFont(new Font("幼圆", Font.PLAIN, 18));
		comboBox_cardType.setBounds(615, 130, 211, 35);
		panel_OpenAcc.add(comboBox_cardType);

		btn_account.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_account.setBounds(410, 379, 153, 43);
		panel_OpenAcc.add(btn_account);

		JLabel label_bg11 = new JLabel("");
		label_bg11.setBounds(0, -29, 1065, 502);
		label_bg11.setIcon(ico_background);
		panel_OpenAcc.add(label_bg11);

		JPanel panel_DelAcc = new JPanel();
		tabbedPane_Acc.addTab("销户", null, panel_DelAcc, null);
		panel_DelAcc.setLayout(null);

		JLabel label_inputCardNum = new JLabel("请输入卡号");
		label_inputCardNum.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_inputCardNum.setBounds(45, 13, 171, 43);
		panel_DelAcc.add(label_inputCardNum);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(14, 70, 1024, 2);
		panel_DelAcc.add(separator_1);

		textField_delAccount = new JTextField();
		textField_delAccount.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_delAccount.setBounds(285, 155, 444, 43);
		panel_DelAcc.add(textField_delAccount);
		textField_delAccount.setColumns(10);

		JButton btn_delAcc = new JButton("销户");
		btn_delAcc.addActionListener(new Cancellation());
		btn_delAcc.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_delAcc.setBounds(458, 258, 84, 27);
		panel_DelAcc.add(btn_delAcc);

		JLabel label_bg12 = new JLabel("");
		label_bg12.setIcon(ico_background);
		label_bg12.setBounds(0, -29, 1065, 502);
		panel_DelAcc.add(label_bg12);

		// 开卡界面
		JPanel panel_OpenCard = new JPanel();
		tabbedPane_Acc.addTab("开卡", null, panel_OpenCard, null);
		panel_OpenCard.setLayout(null);

		JLabel lblTips5 = new JLabel("请输入身份证号");
		lblTips5.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblTips5.setBounds(45, 13, 171, 43);
		panel_OpenCard.add(lblTips5);

		JSeparator separator_90 = new JSeparator();
		separator_90.setBounds(14, 70, 1024, 2);
		panel_OpenCard.add(separator_90);

		textField_OpenCard = new JTextField();
		textField_OpenCard.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_OpenCard.setBounds(285, 155, 444, 43);
		panel_OpenCard.add(textField_OpenCard);

		btn_openCardChu = new JButton("开储蓄卡");
		btn_openCardChu.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_openCardChu.setBounds(358, 258, 105, 29);
		panel_OpenCard.add(btn_openCardChu);
		btn_openCardChu.addActionListener(new openCard());

		btn_openCardXin = new JButton("开信用卡");
		btn_openCardXin.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_openCardXin.setBounds(558, 258, 105, 29);
		panel_OpenCard.add(btn_openCardXin);
		btn_openCardXin.addActionListener(new openCard());

		JLabel label_bg15 = new JLabel("");
		label_bg15.setIcon(ico_background);
		label_bg15.setBounds(0, -29, 1065, 502);
		panel_OpenCard.add(label_bg15);

		// 查询用户信息界面
		JPanel panel_queryInfo = new JPanel();
		tabbedPane_Acc.addTab("查询信息", null, panel_queryInfo, null);
		panel_queryInfo.setLayout(null);

		JLabel lblTips1 = new JLabel("请输入身份证号");
		lblTips1.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblTips1.setBounds(45, 13, 171, 43);
		panel_queryInfo.add(lblTips1);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(14, 70, 1024, 2);
		panel_queryInfo.add(separator_6);

		textField_queryInfo = new JTextField();
		textField_queryInfo.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_queryInfo.setBounds(285, 155, 444, 43);
		panel_queryInfo.add(textField_queryInfo);

		JButton btn_query = new JButton("\u786E\u8BA4");
		btn_query.addActionListener(new queryUserInfo());
		btn_query.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_query.setBounds(458, 258, 69, 29);
		panel_queryInfo.add(btn_query);

		JLabel label_14 = new JLabel("");
		label_14.setIcon(ico_background);
		label_14.setBounds(0, -29, 1065, 502);
		panel_queryInfo.add(label_14);

		// 修改用户信息界面
		JPanel panel_changeInfo = new JPanel();
		tabbedPane_Acc.addTab("修改信息", null, panel_changeInfo, null);
		panel_OpenAcc.setLayout(null);
		panel_changeInfo.setLayout(null);

		JLabel lblTips2 = new JLabel("请输入身份证号");
		lblTips2.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblTips2.setBounds(45, 13, 171, 43);
		panel_changeInfo.add(lblTips2);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(14, 70, 1024, 2);
		panel_changeInfo.add(separator_7);

		textField_changeInfo = new JTextField();
		textField_changeInfo.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_changeInfo.setBounds(285, 155, 444, 43);
		panel_changeInfo.add(textField_changeInfo);

		JButton btn_change = new JButton("确认");
		btn_change.addActionListener(new changeUserInfo());
		btn_change.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_change.setBounds(458, 258, 69, 29);
		panel_changeInfo.add(btn_change);

		JLabel label_13 = new JLabel("");
		label_13.setIcon(ico_background);
		label_13.setBounds(0, -29, 1065, 502);
		panel_changeInfo.add(label_13);

		// 状态操作界面
		JPanel panel_statusOpera = new JPanel();
		tabbedPane.addTab(null, ico_statusOprea, panel_statusOpera, "挂失解挂");
		panel_statusOpera.setLayout(null);

		JLabel label_2 = new JLabel("请输入要挂失或解挂的卡号");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_2.setBounds(35, 13, 290, 43);
		panel_statusOpera.add(label_2);

		textField_loss = new JTextField();
		textField_loss.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_loss.setBounds(290, 84, 444, 43);
		panel_statusOpera.add(textField_loss);

		btn_loss = new JButton("确认");
		btn_loss.addActionListener(new LossOperation());
		btn_loss.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_loss.setBounds(470, 140, 90, 43);
		panel_statusOpera.add(btn_loss);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(14, 240, 1024, 2);
		panel_statusOpera.add(separator_2);

		JLabel label_5 = new JLabel("请输入要冻结或解冻的卡号");
		label_5.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_5.setBounds(35, 255, 290, 43);
		panel_statusOpera.add(label_5);

		textField_lock = new JTextField();
		textField_lock.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_lock.setBounds(290, 338, 444, 43);
		panel_statusOpera.add(textField_lock);

		JButton btn_lock = new JButton("\u786E\u8BA4");
		btn_lock.addActionListener(new LockOperation());
		btn_lock.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_lock.setBounds(470, 394, 90, 43);
		panel_statusOpera.add(btn_lock);

		JLabel label_bg2 = new JLabel("");
		label_bg2.setIcon(ico_background);
		label_bg2.setBounds(0, 0, 1065, 502);
		panel_statusOpera.add(label_bg2);
		panel_OpenAcc.setLayout(null);

		// 查询余额界面
		JPanel panel_queryBalance = new JPanel();
		tabbedPane.addTab(null, ico_query, panel_queryBalance, null);
		panel_queryBalance.setLayout(null);

		JLabel label_inputCardNumLock = new JLabel("请输入卡号");
		label_inputCardNumLock.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_inputCardNumLock.setBounds(35, 13, 171, 43);
		panel_queryBalance.add(label_inputCardNumLock);
		separator_1.setBounds(14, 70, 1024, 2);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(14, 69, 1024, 2);
		panel_queryBalance.add(separator_4);

		textField_queryBalance = new JTextField();
		textField_queryBalance.setFont(new Font("幼圆", Font.PLAIN, 24));
		textField_queryBalance.setBounds(290, 128, 444, 43);
		panel_queryBalance.add(textField_queryBalance);
		textField_delAccount.setColumns(10);

		JButton btn_queryBalance = new JButton("\u786E\u8BA4");
		btn_queryBalance.addActionListener(new QueryBalacne());
		btn_queryBalance.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_queryBalance.setBounds(483, 216, 90, 43);
		panel_queryBalance.add(btn_queryBalance);

		JLabel label_bg3 = new JLabel("");
		label_bg3.setIcon(ico_background);
		label_bg3.setBounds(0, 0, 1065, 502);
		panel_queryBalance.add(label_bg3);

		// 查询交易历史记录界面
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

		btn_begin = new JButton(date[0]);
		btn_begin.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btn_begin.addActionListener(new getDate());
		btn_begin.setBounds(444, 30, 155, 40);
		panel_queryHistory.add(btn_begin);

		btn_end = new JButton(date[1]);
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
		table.getTableHeader().setFont(new Font("幼圆", Font.BOLD, 18)); // 设置表头字体
		table.setFont(new Font("幼圆", Font.BOLD, 18)); // 设置表格字体
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

		textField_query = new JTextField();
		textField_query.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_query.setColumns(10);
		textField_query.setBounds(120, 32, 223, 36);
		panel_queryHistory.add(textField_query);

		JLabel label_6 = new JLabel("\u5361\u53F7");
		label_6.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_6.setBounds(68, 32, 47, 40);
		panel_queryHistory.add(label_6);

		JLabel label_bg4 = new JLabel("");
		label_bg4.setIcon(ico_background);
		label_bg4.setBounds(0, 0, 1068, 504);
		panel_queryHistory.add(label_bg4);

		// 修改密码界面
		JPanel panel_changePasswd = new JPanel();
		tabbedPane.addTab(null, ico_changePasswd, panel_changePasswd, "修改密码");
		panel_changePasswd.setLayout(null);

		JTabbedPane tabbedPane_changePass = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_changePass.setBounds(0, 0, 1066, 505);
		panel_changePasswd.add(tabbedPane_changePass);

		// 用户改密界面
		JPanel panel_chaUserPass = new JPanel();
		tabbedPane_changePass.addTab("用戶", null, panel_chaUserPass, null);
		panel_chaUserPass.setLayout(null);

		JLabel lblTips3 = new JLabel("请输入卡号");
		lblTips3.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblTips3.setBounds(45, 13, 171, 43);
		panel_chaUserPass.add(lblTips3);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(14, 70, 1024, 2);
		panel_chaUserPass.add(separator_8);

		textField_chaUserPass = new JTextField();
		textField_chaUserPass.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_chaUserPass.setBounds(285, 155, 444, 43);
		panel_chaUserPass.add(textField_chaUserPass);

		JButton btn_chaUserPass = new JButton("\u786E\u8BA4");
		btn_chaUserPass.addActionListener(new changeUserPasswd());
		btn_chaUserPass.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_chaUserPass.setBounds(458, 258, 69, 29);
		panel_chaUserPass.add(btn_chaUserPass);

		JLabel label_41 = new JLabel("");
		label_41.setIcon(ico_background);
		label_41.setBounds(0, -29, 1065, 502);
		panel_chaUserPass.add(label_41);

		// 管理员改密界面
		JPanel panel_chaAdminPass = new JPanel();
		tabbedPane_changePass.addTab("管理员", null, panel_chaAdminPass, null);
		panel_chaAdminPass.setLayout(null);

		JLabel lblTips4 = new JLabel("请输入管理员账号");
		lblTips4.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblTips4.setBounds(45, 13, 171, 43);
		panel_chaAdminPass.add(lblTips4);

		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(14, 70, 1024, 2);
		panel_chaAdminPass.add(separator_9);

		textField_chaAdminPass = new JTextField();
		textField_chaAdminPass.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField_chaAdminPass.setBounds(285, 155, 444, 43);
		panel_chaAdminPass.add(textField_chaAdminPass);

		JButton btn_chaAdminPass = new JButton("确认");
		btn_chaAdminPass.addActionListener(new changeAdminPasswd());
		btn_chaAdminPass.setFont(new Font("幼圆", Font.PLAIN, 18));
		btn_chaAdminPass.setBounds(458, 258, 69, 29);
		panel_chaAdminPass.add(btn_chaAdminPass);

		JLabel label_42 = new JLabel("");
		label_42.setIcon(ico_background);
		label_42.setBounds(0, -29, 1065, 502);
		panel_chaAdminPass.add(label_42);

	}

	/**
	 * 读取数据库交易记录，把数据写进JTable表格中
	 */
	public void WriteData(Long card, String[] date) {
		final String[] columnNames = { "账号", "日期", "交易类型", "交易金额", "目标账户", "手续费" };
		// 调用数据库方法获取记录
		// function(BlankAccout.getInstance().getCardNum(),getDate(6));
		// 这部分数据从数据库里获取
		String[][] rowData = BankAccout.getInstance().getTradingrecDAO().getSpecifiedRecording(card, date);

		table.setModel(new DefaultTableModel(rowData, columnNames));
		// 设置文字居中
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumn("账号").setCellRenderer(render);
		table.getColumn("日期").setCellRenderer(render);
		table.getColumn("交易类型").setCellRenderer(render);
		table.getColumn("交易金额").setCellRenderer(render);
		table.getColumn("目标账户").setCellRenderer(render);
		table.getColumn("手续费").setCellRenderer(render);
		// 设置列宽
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
	}

	/**
	 * 获取始末日期的按钮监听器
	 */
	class getDate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JDateChooser dateChoose = new JDateChooser();
			//TODO 查询默认今天
			if (e.getSource() == btn_begin) {
				dateChoose.showDateChooser();
				date[0] = dateChoose.getDateFormat("yyyy-MM-dd");
				btn_begin.setText(date[0]);
			}
			if (e.getSource() == btn_end) {
				dateChoose.showDateChooser();
				date[1] = dateChoose.getDateFormat("yyyy-MM-dd");
				btn_end.setText(date[1]);
			}
			if (e.getSource() == btn_confirm) {
				if (date[0].isEmpty() || date[1].isEmpty()) {
					JOptionPane.showMessageDialog(null, "请选择日期", "错误", JOptionPane.ERROR_MESSAGE);
				} else if (textField_query.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入卡号", "错误", JOptionPane.ERROR_MESSAGE);
				} else if (date[0].compareTo(date[1]) <= 0) {
					WriteData(Long.parseLong(textField_query.getText()), date);
				} else {
					JOptionPane.showMessageDialog(null, "请选择正确日期", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		public String SQLDate(String source) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try {
				date = simpleDateFormat.parse(source);
			} catch (Exception e) {
			}
			Calendar calendar = Calendar.getInstance(); // 得到日历
			calendar.add(Calendar.DATE, 1);
			date = calendar.getTime();

			return simpleDateFormat.format(date);

		}

	}

	/**
	 * 初始化日期 ，时间为上一个月到今天
	 */
	public void InitialDate(){
		Date dNow = new Date(); // 当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); // 得到日历
		dNow = calendar.getTime();
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(calendar.MONTH, -1); // 设置为前month月
		dBefore = calendar.getTime(); // 得到前3月的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // HH:mm:ss");
																	// //设置时间格式
		date[0] = sdf.format(dBefore);
		date[1] = sdf.format(dNow);
	}
	
	
	/**
	 * 开户功能监听器
	 */
	class UserInformation implements ActionListener {
		/**
		 * 清空文本框
		 */
		public void setTextNone() {
			textField_name.setText("");
			textField_idcard.setText("");
			textField_phone.setText("");
			textArea_address.setText("");
		}

		/**
		 * 生成卡号
		 * 
		 * @return 一个 string 类型的卡号
		 */
		public String generateCardNum() {
			// 用 621700 的固定开头和时间戳生成卡号
			String cardNum = "621700" + String.valueOf(new Date().getTime()).substring(1);
			return cardNum;
		}

		public void actionPerformed(ActionEvent arg0) {
			// 去除信息头尾的空格
			String name = textField_name.getText().trim();
			String sex = (String) comboBox.getSelectedItem();// 下拉框获取性别
			String phone = textField_phone.getText().trim();
			String idCard = textField_idcard.getText();
			String cardType = (String) comboBox_cardType.getSelectedItem();// 下拉框获取开户卡类型
			String address = textArea_address.getText().trim();
			// 开始进行信息检查
			if (name.isEmpty() | phone.isEmpty() | address.isEmpty()) {
				JOptionPane.showMessageDialog(null, "信息不能为空", "错误", JOptionPane.ERROR_MESSAGE);
			} else if (phone.length() != 11) {
				JOptionPane.showMessageDialog(null, "手机号长度不正确", "错误", JOptionPane.ERROR_MESSAGE);
			} else if (idCard.length() != 18) {
				JOptionPane.showMessageDialog(null, "身份证号码长度不正确", "错误", JOptionPane.ERROR_MESSAGE);
			} else {
				Long[] password = showPasswordDialog("请输入密码");
				if (password[0] == 0) {
					Long[] confirmPassword = showPasswordDialog("请确认密码");
					if (confirmPassword[0] == 0) {

						if (password[1].equals(confirmPassword[1])) {
							try {
								if (String.valueOf(confirmPassword[1]).length() == 6
										&& String.valueOf(password[1]).length() == 6) {
									if (password[1].equals(confirmPassword[1])) {
										// 生成卡号
										String cardnum = generateCardNum();
										// 透支额度默认为 0
										float overdraft = 0;
										JOptionPane.showMessageDialog(null, "开户成功，您的卡号为：\n" + cardnum, "恭喜",
												JOptionPane.INFORMATION_MESSAGE);
										// 完成用户信息录入后清空所有文本框内容
										setTextNone();
										// 如果账号类型是信用卡，透支额度则设为5000
										if (cardType == "信用卡") {
											overdraft = 5000;
										}
										// 调用数据库方法，传入用户信息，在 user 和 account 表中插入录入数据
										BankAccout.getInstance().getUserDao().insertUserInformation(name, sex, idCard,
												phone, address);
										BankAccout.getInstance().getAccountDAO().setAccount(idCard,
												Long.parseLong(cardnum), password[1], "正常", cardType, "建设银行", 0,
												overdraft, "2018-04-170");
									} else {
										JOptionPane.showMessageDialog(null, "两次密码不一致", "错误", JOptionPane.ERROR_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(null, "请输入6位密码", "错误", JOptionPane.ERROR_MESSAGE);
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "您取消了操作", "提示", JOptionPane.INFORMATION_MESSAGE);
								e.printStackTrace();
							}
						}
					}
				}
			}

		}
	}

	/**
	 * 销户功能监听器
	 */
	class Cancellation implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 获取卡号
			String cardNums = textField_delAccount.getText().trim();
			long cardNum = Long.parseLong(cardNums);
			// 判断卡号是否存在，如果存在进入下一步，不存在则进行提示
			if (BankAccout.getInstance().getAccountDAO().getCardExit(cardNum)) {
				// 如果该卡属于建设银行，则继续，否则进行提示
				if (BankAccout.getInstance().getAccountDAO().getBanks(cardNum)) {
					float balance = BankAccout.getInstance().getAccountDAO().getCardBalance(cardNum);
					// 检查该卡的类型，如果是信用卡，则需要检查是否有未还透支。
					if (BankAccout.getInstance().getAccountDAO().getCardType(cardNum).equals("信用卡")) {
						// 获取该卡的余额和透支额
						float overdraft = BankAccout.getInstance().getAccountDAO().getCardOverdraft(cardNum);
						if (balance + overdraft >= 5000) {
							// 调用销户方法
							accountCancellation(cardNum);
						} else {
							JOptionPane.showMessageDialog(null, "您有未还清的透支，请偿还之后再进行销户", "拒绝", JOptionPane.ERROR_MESSAGE);
						}
						// 如果是储蓄卡,则可以直接进行销户
					} else {
						// 调用销户方法
						accountCancellation(cardNum);
					}
				} else {
					JOptionPane.showMessageDialog(null, "该卡不属于建设银行", "错误", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "输入的卡号不存在", "错误", JOptionPane.ERROR_MESSAGE);
			}

		}

		/**
		 * 对输入的银行卡进行检查和销户操作
		 * 
		 * @param cardNum
		 */
		private void accountCancellation(long cardNum) {
			if (BankAccout.getInstance().getAccountDAO().getCardStatu(cardNum).equals("正常")) {
				JShowInfo jSM = new JShowInfo();
				jSM.setBtnText("销户");
				String[] info = new String[7];// 获取用户信息
				info = BankAccout.getInstance().getConnectTable().getUserMessage(cardNum);
				jSM.StatusOpera(info);
				// 选择销户操作，输入验证密码
				if (jSM.showJSM()) {
					Long[] result = showPasswordDialog("请输入密码:");
					// 调用数据库方法，判断卡号是否对应密码
					if (result[0] == 0) {
						if (BankAccout.getInstance().getAccountDAO().checkPawd(cardNum, result[1])) {
							// 调用数据库方法设置账户状态为销户
							JOptionPane.showMessageDialog(null, "销户成功", "提示", JOptionPane.INFORMATION_MESSAGE);
							BankAccout.getInstance().getAccountDAO().updateStatus(cardNum, "销户");
							// 清空卡号输入框
							textField_delAccount.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "您的卡状态不正常，拒绝销户", "拒绝", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	class openCard implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String idCard = textField_OpenCard.getText();
			// 检查该用户是否存在
			if (BankAccout.getInstance().getUserDao().checkIdCardExit(idCard)) {
				// 调用数据库方法，根据身份证查询用户信息
				String[] info = BankAccout.getInstance().getUserDao().getUserInformation(idCard);
				// 显示用户信息
				JShowInfo jSM = new JShowInfo();
				jSM.setBtnText("开卡");
				jSM.QueryUserInfo(info);
				if (jSM.showJSM()) {
					Long[] result1 = showPasswordDialog("请输入密码");
					if (result1[0] == 0) {
						Long[] result2 = showPasswordDialog("请确认密码");
						if (result2[0] == 0) {

							if (result1[1].equals(result2[1])) {
								// 生成卡号，插入 account 表
								String cardnum = generateCardNum();

								if (e.getSource() == btn_openCardChu) {
									BankAccout.getInstance().getAccountDAO().setAccount(idCard, Long.parseLong(cardnum),
											result2[1], "正常", "储蓄卡", "建设银行", 0, 0, "2018-04-170");
								}
								if (e.getSource() == btn_openCardXin) {
									BankAccout.getInstance().getAccountDAO().setAccount(idCard, Long.parseLong(cardnum),
											result2[1], "正常", "信用卡", "建设银行", 0, 5000, "2018-04-170");
								}
								JOptionPane.showMessageDialog(null, "开户成功，您的卡号为：\n" + cardnum, "恭喜",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "两次密码不一致", "错误", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "用户不存在,请使用开户功能", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}

		/**
		 * 生成卡号
		 * 
		 * @return 一个 string 类型的卡号
		 */
		public String generateCardNum() {
			// 用 621700 的固定开头和时间戳生成卡号
			String cardNum = "621700" + String.valueOf(new Date().getTime()).substring(1);
			return cardNum;
		}

	}

	/**
	 * 查询用户信息功能 的按钮事件监听器
	 * 
	 * @author Jachin
	 *
	 */
	class queryUserInfo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 获取输入的身份证号
			String idCard = textField_queryInfo.getText();// 440981199611046654
			if (!idCard.isEmpty()) {// 输入不为空
				// 判断身份证号是否存在
				try {
					// 调用数据库方法，根据身份证查询用户信息
					String[] info = BankAccout.getInstance().getUserDao().getUserInformation(idCard);
					// 显示用户信息
					JShowInfo jSM = new JShowInfo();
					jSM.QueryUserInfo(info);
					jSM.showJSM();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "用户不存在", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		}

	}

	/**
	 * 用户修改信息功能按钮事件监听器
	 * 
	 * @author Jachin
	 *
	 */
	class changeUserInfo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 获取输入的身份证号
			String idCard = textField_changeInfo.getText();// 440981199611046654
			if (!idCard.isEmpty()) {// 输入不为空
				// 判断身份证号是否存在
				try {
					// 调用数据库方法，根据身份证查询用户信息
					String[] info = BankAccout.getInstance().getUserDao().getUserInformation(idCard);
					// 显示用户信息
					JShowInfo jSM = new JShowInfo();
					jSM.ChangeUserInfo(info);
					// 用户修改信息，按下确定键
					if (jSM.showJSM()) {
						// 对输入信息的合法性作判断
						jSM.ConfirmChange();
						// 调用数据库修改信息的方法，将新的数据写入数据库
						try {
							String[] info2 = jSM.info;
							info2[0] = info[2];
							BankAccout.getInstance().getUserDao().updateUserInformation(info2);
							JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "修改失败", "提示", JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "用户不存在", "提示", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	// 挂失解挂监听器
	class LossOperation implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String cards = textField_loss.getText();
			Long card = Long.parseLong(cards);
			// 调用数据库方法判断卡号是否存在
			Boolean flag = BankAccout.getInstance().getAccountDAO().getCardExit(card);
			if (flag) {
				// 调用数据库方法获取账户状态
				String cardStatus = BankAccout.getInstance().getAccountDAO().getCardStatu(card);
				// 1.如果挂失了，则提问是否要解挂
				if (cardStatus.equals("挂失")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("解挂");
					String[] info = new String[7];// 获取用户信息
					info = BankAccout.getInstance().getConnectTable().getUserMessage(card);
					jSM.StatusOpera(info);
					if (jSM.showJSM()) { // 选择解挂操作，输入验证密码
						Long[] result = showPasswordDialog("请输入密码:");
						// 调用数据库方法，判断卡号是否对应密码
						if (result[0] == 0) {
							if (BankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
								// 调用数据库方法设置账户状态为正常
								JOptionPane.showMessageDialog(null, "解挂成功", "提示", JOptionPane.INFORMATION_MESSAGE);
								BankAccout.getInstance().getAccountDAO().updateStatus(card, "正常");
								// 清空卡号输入框
								textField_loss.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				}

				// 2.如果账户正常，询问是否要挂失
				else if (cardStatus.equals("正常")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("挂失");
					String[] info = new String[7];// 获取用户信息
					// String[] info_Data = { "张三", "信用卡", "男", "正常",
					// "440823199602133837", "13724867853",
					// "广东省广州市海珠区仑头路21号" };
					// info = info_Data;
					info = BankAccout.getInstance().getConnectTable().getUserMessage(card);
					jSM.StatusOpera(info);
					if (jSM.showJSM()) { // 选择挂失操作，输入验证密码
						Long[] result = showPasswordDialog("请输入密码:");
						// 调用数据库方法，判断卡号是否对应密码
						if (result[0] == 0) {
							if (BankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
								// 调用数据库方法设置账户状态为挂失
								JOptionPane.showMessageDialog(null, "挂失成功", "提示", JOptionPane.INFORMATION_MESSAGE);
								BankAccout.getInstance().getAccountDAO().updateStatus(card, "挂失");
								// 清空卡号输入框
								textField_loss.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
				// 3.如果账户冻结，提示用户不能操作
				else if (cardStatus.equals("冻结")) {
					JOptionPane.showMessageDialog(null, "您的卡已冻结，请先解冻", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "该账户不存在", "错误", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * 用户冻结解冻功能监听器
	 * 
	 * @author Jachin
	 *
	 */
	class LockOperation implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String cards = textField_lock.getText();
			Long card = Long.parseLong(cards);
			// 调用数据库方法判断卡号是否存在
			Boolean flag = BankAccout.getInstance().getAccountDAO().getCardExit(card);
			if (flag) {
				// 调用数据库方法获取账户状态
				String cardStatus = BankAccout.getInstance().getAccountDAO().getCardStatu(card);
				// 1.如果冻结了，则提问是否要解冻
				if (cardStatus.equals("冻结")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("解冻");
					String[] info = new String[7];// 获取用户信息
					info = BankAccout.getInstance().getConnectTable().getUserMessage(card);
					jSM.StatusOpera(info);
					if (jSM.showJSM()) { // 选择解冻操作，输入验证密码
						Long[] result = showPasswordDialog("请输入密码:");
						// 调用数据库方法，判断卡号是否对应密码
						if (result[0] == 0) {
							if (BankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
								// 调用数据库方法设置账户状态为正常
								JOptionPane.showMessageDialog(null, "解冻成功", "提示", JOptionPane.INFORMATION_MESSAGE);
								BankAccout.getInstance().getAccountDAO().updateStatus(card, "正常");
								// 清空卡号输入框
								textField_queryBalance.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}

				// 2.如果账户正常，询问是否要冻结
				else if (cardStatus.equals("正常")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("冻结");
					String[] info = new String[7];// 获取用户信息
					// String[] info_Data = { "张三", "信用卡", "男", "正常",
					// "440823199602133837", "13724867853",
					// "广东省广州市海珠区仑头路21号" };
					// info = info_Data;
					info = BankAccout.getInstance().getConnectTable().getUserMessage(card);
					jSM.StatusOpera(info);
					if (jSM.showJSM()) { // 选择冻结操作，输入验证密码
						Long[] result = showPasswordDialog("请输入密码:");
						// 调用数据库方法，判断卡号是否对应密码
						if (result[0] == 0) {
							if (BankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
								// 调用数据库方法设置账户状态为冻结
								JOptionPane.showMessageDialog(null, "冻结成功", "提示", JOptionPane.INFORMATION_MESSAGE);
								BankAccout.getInstance().getAccountDAO().updateStatus(card, "冻结");
								// 清空卡号输入框
								textField_loss.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
				// 3.如果账户挂失，提示用户不能操作
				else if (cardStatus.equals("挂失")) {
					JOptionPane.showMessageDialog(null, "您的卡已挂失，请先解挂", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "该账户不存在", "错误", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * 用户查询余额功能的监听器
	 * 
	 * @author Jachin
	 *
	 */
	class QueryBalacne implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textField_queryBalance.setText("656885452136697452");
			String cards = textField_queryBalance.getText().trim();
			Long card = Long.parseLong(cards);
			// 判断卡号是否存在
			Boolean flag = BankAccout.getInstance().getAccountDAO().getCardExit(card);
			if (flag) {
				// 用户输入密码
				Long[] result = showPasswordDialog("请输入密码:");
				if (result[0] == 0) {

					if (BankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
						// 调用数据库方法，获取该卡号余额信息
						JOptionPane.showMessageDialog(null, showMessage(card), "账户余额信息",
								JOptionPane.INFORMATION_MESSAGE);
						textField_queryBalance.setText("");
					} else
						JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "账号不存在", "错误", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * 用户修改密码监听器
	 * 
	 * @author SAM
	 *
	 */
	class changeUserPasswd implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String card = textField_chaUserPass.getText().trim();
			Long cardNum = 0L;
			boolean flagF = true;
			try {
				cardNum = Long.parseLong(card);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请输入正确账号", "确认", JOptionPane.ERROR_MESSAGE);
				flagF = false;
			}
			// 判断卡号是否存在
			if (flagF) {
				Boolean flag = BankAccout.getInstance().getAccountDAO().getCardExit(cardNum);
				if (flag) {
					// 用户输入旧密码
					Long[] result = showPasswordDialog("请输入旧密码:");
					if (result[0] == 0) {
						// 数据库对比密码
						long OldPasswd = result[1];
						if (BankAccout.getInstance().getAccountDAO().checkPawd(cardNum, OldPasswd)) {
							// 用户输入新密码
							Long[] result2 = showPasswordDialog("请输入新密码");
							long NewPasswd = result2[1];
							// 数据库修改密码
							if (result2[0] == 0) {
								// 确认新密码
								Long[] result3 = showPasswordDialog("确认新密码");
								if (result3[0] == 0) {
									if (result3[1] == NewPasswd) {
										BankAccout.getInstance().getAccountDAO().updatePasswd(cardNum, OldPasswd,
												NewPasswd);
										JOptionPane.showMessageDialog(null, "密码修改成功", "确认",
												JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null, "两次输入密码不一致", "错误",
												JOptionPane.ERROR_MESSAGE);
									} // if6
								} // else{}//if5

							} // else{}//if4
						} else {
							JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
						} // if3
					} // else{}//if2
				} else {
					JOptionPane.showMessageDialog(null, "账号不存在", "错误", JOptionPane.ERROR_MESSAGE);
				} // if1
			}
		}
	}

	/**
	 * 管理员修改密码功能
	 * 
	 * @author SAM
	 *
	 */
	class changeAdminPasswd implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String AccountId = "";
			boolean flagF = true;
			try {
				AccountId = textField_chaAdminPass.getText().trim();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请输入正确密码", "确认", JOptionPane.ERROR_MESSAGE);
				flagF = false;
			}
			// 判断管理员账号是否存在
			if (flagF) {
				Boolean flag = BankAccout.getInstance().getAdminDAO().getAccountExit(AccountId);
				if (flag) {
					// 用户输入旧密码
					Long[] result = showPasswordDialog("请输入旧密码:");
					if (result[0] == 0) {
						// 数据库对比密码
						String OldPasswd = String.valueOf(result[1]);
						if (BankAccout.getInstance().getAdminDAO().cheeckAdmin(AccountId, OldPasswd)) {
							// 管理员输入新密码
							Long[] result2 = showPasswordDialog("请输入新密码");
							String NewPasswd = String.valueOf(result2[1]);
							// 数据库修改密码
							if (result2[0] == 0) {
								// 确认新密码
								Long[] result3 = showPasswordDialog("确认新密码");
								String NewPasswdDemo = String.valueOf(result3[1]);
								if (result3[0] == 0) {
									if (NewPasswdDemo.equals(NewPasswd)) {
										// 调用数据库方法修改管理员密码
										BankAccout.getInstance().getAdminDAO().updateAccountPasswd(AccountId, OldPasswd,
												NewPasswd);
										JOptionPane.showMessageDialog(null, "密码修改成功", "确认",
												JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null, "两次输入密码不一致", "错误",
												JOptionPane.ERROR_MESSAGE);
									} // if6
								} // else{}//if5
							} // else{}//if4
						} else {
							JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
						} // if3
					} // else{}//if2
				} else {
					JOptionPane.showMessageDialog(null, "账号不存在", "错误", JOptionPane.ERROR_MESSAGE);
				} // if1
			}
		}
	}

	/**
	 * 输入密码界面，密码显示为圆点
	 * 
	 * @return Long[] reslut,第一个是 判断用户是否按下取消(等于2)，第二个是用户输入的密码
	 */
	public Long[] showPasswordDialog(String text) {
		JPasswordField pwd = new JPasswordField();
		Object[] message = { text, pwd };
		int res = JOptionPane.showConfirmDialog(null, message, "请输入密码:", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		Long password = -0L;
		try {
			password = Long.valueOf(new String(pwd.getPassword()));
		} catch (Exception e1) {
		}
		Long[] result = { (long) res, password };
		return result;
	}

	public String showMessage(Long card) {
		float balance = BankAccout.getInstance().getAccountDAO().getCardBalance(card);
		float overdraft = BankAccout.getInstance().getAccountDAO().getCardOverdraft(card);
		float withdrawalsLimit = BankAccout.getInstance().getTradingrecDAO().getWithdrawalsLimit(card);
		float depositLimit = BankAccout.getInstance().getTradingrecDAO().getDepositLimit(card);

		String messages = "<html><p align=\"left\">您的余额为：{0}元<br>您的透支额度为：{1}元<br>您今日存款限额还剩：{2}元<br>您今日取款限额还剩：{3}元</p></html>";// 显示信息还要修改
		messages = messages.replace("{0}", String.valueOf(balance));// message[0-3]换成上面的money等
		messages = messages.replace("{1}", String.valueOf(overdraft));
		messages = messages.replace("{2}", String.valueOf(depositLimit));
		messages = messages.replace("{3}", String.valueOf(withdrawalsLimit));

		return messages;
	}
}
