package jachin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import java.sql.ResultSet;  
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;  

public class LoginUI {

	private JFrame frameAdmin;
	private JTextField textAdminAccount;
	private JTextField textAdminPswd;
	private JButton buttonLogin;
	private JLabel labelMainBG;
	private String File = "E:\\Code\\java\\Eclipse-ATM\\CCB_ATM";
	private JTabbedPane tabbedPane;
	private JPanel panelUser;
	private JPanel panelAdmin;
	private JLabel labelAdminBg;
	private JLabel labelUserBg;
	private JTextField textUserCardnum;
	private JTextField textUserPswd;
//	private String File = ".";
	
	/**
	 * 启动后台管理系统
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LoginUI window = new LoginUI();
					window.frameAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 创建应用
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * 实例化组件
	 */
	public void initialize() {
		frameAdmin = new JFrame();
		frameAdmin.setResizable(false);
		frameAdmin.setIconImage(
				Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameAdmin.setFont(new Font("幼圆", Font.PLAIN, 18));
		frameAdmin.setTitle("管理员登陆");
		frameAdmin.setBounds(500, 280, 742, 431);
		frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAdmin.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 736, 396);
		frameAdmin.getContentPane().add(tabbedPane);
		
		panelUser = new JPanel();
		tabbedPane.addTab("\u7528\u6237\u767B\u9646", null, panelUser, null);
		panelUser.setLayout(null);
		
		JLabel labelCardnum = new JLabel("卡号");
		labelCardnum.setBounds(345, 114, 57, 46);
		panelUser.add(labelCardnum);
		labelCardnum.setFont(new Font("幼圆", Font.BOLD, 18));
		
		JLabel labelUserPswd = new JLabel("密码");
		labelUserPswd.setFont(new Font("幼圆", Font.BOLD, 18));
		labelUserPswd.setBounds(345, 188, 57, 46);
		panelUser.add(labelUserPswd);
		
		textUserCardnum = new JTextField();
		textUserCardnum.setFont(new Font("宋体", Font.PLAIN, 18));
		textUserCardnum.setBounds(402, 114, 264, 46);
		panelUser.add(textUserCardnum);
		textUserCardnum.setColumns(10);
		
		textUserPswd = new JPasswordField();
		textUserPswd.setFont(new Font("宋体", Font.PLAIN, 18));
		textUserPswd.setColumns(10);
		textUserPswd.setBounds(402, 188, 264, 46);
		textUserPswd.addKeyListener(new KeyAdapter() {	//用户 输入密码后，回车登陆。监听事件要设置在密码文本框
			@Override
			public void keyPressed(KeyEvent a) {
				if(a.getKeyChar() == KeyEvent.VK_ENTER){
					UserLogin();
				}
			}
		});
		panelUser.add(textUserPswd);
		
		JButton btnLogin = new JButton("登陆");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserLogin();
			}
		});
		btnLogin.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnLogin.setBounds(560, 268, 77, 35);
		panelUser.add(btnLogin);
		
		labelUserBg = new JLabel("");
		labelUserBg.setVerticalAlignment(SwingConstants.TOP);
		labelUserBg.setHorizontalAlignment(SwingConstants.LEFT);
		labelUserBg.setBounds(0, -32, 736, 396);
		labelUserBg.setIcon(new ImageIcon(File + "\\img\\backGround2.png"));
		panelUser.add(labelUserBg);
		
		panelAdmin = new JPanel();
		tabbedPane.addTab("\u7BA1\u7406\u5458\u767B\u9646", null, panelAdmin, null);
		panelAdmin.setLayout(null);

		JLabel labelAccount = new JLabel("账号");
		labelAccount.setToolTipText("请输入账号");
		labelAccount.setFont(new Font("幼圆", Font.BOLD, 18));
		labelAccount.setBounds(345, 114, 57, 46);
		panelAdmin.add(labelAccount);

		JLabel labelAdminPswd = new JLabel("密码");
		labelAdminPswd.setFont(new Font("幼圆", Font.BOLD, 18));
		labelAdminPswd.setBounds(345, 188, 57, 46);
		panelAdmin.add(labelAdminPswd);

		textAdminAccount = new JTextField();
		textAdminAccount.setToolTipText("请输入账号");
		textAdminAccount.setHorizontalAlignment(SwingConstants.LEFT);
		textAdminAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textAdminAccount.setBounds(402, 114, 264, 46);
		panelAdmin.add(textAdminAccount);
		textAdminAccount.setColumns(10);

		textAdminPswd = new JPasswordField();
		textAdminPswd.setToolTipText("请输入密码");
		textAdminPswd.setHorizontalAlignment(SwingConstants.LEFT);
		textAdminPswd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textAdminPswd.setColumns(10);
		textAdminPswd.setBounds(402, 188, 264, 46);
		textAdminPswd.addKeyListener(new KeyAdapter() {	//用户 输入密码后，回车登陆。监听事件要设置在密码文本框
			@Override
			public void keyPressed(KeyEvent a) {
				if(a.getKeyChar() == KeyEvent.VK_ENTER){
					AdminLogin();
				}
			}
		});
		panelAdmin.add(textAdminPswd);

		buttonLogin = new JButton("\u767B\u9646");

		buttonLogin.setFont(new Font("幼圆", Font.PLAIN, 18));
		buttonLogin.setBounds(560, 268, 77, 35);
		panelAdmin.add(buttonLogin);

		labelAdminBg = new JLabel("");
		labelAdminBg.setVerticalAlignment(SwingConstants.TOP);
		labelAdminBg.setHorizontalAlignment(SwingConstants.LEFT);
		labelAdminBg.setBounds(0, -32, 736, 396);
		labelAdminBg.setIcon(new ImageIcon(File + "\\img\\backGround2.png"));
		panelAdmin.add(labelAdminBg);

		labelMainBG = new JLabel("");
		labelMainBG.setVerticalAlignment(SwingConstants.TOP);
		labelMainBG.setHorizontalAlignment(SwingConstants.LEFT);
		labelMainBG.setIcon(new ImageIcon(File + "\\img\\backGround2.png"));
		labelMainBG.setBounds(0, 0, 736, 396);
		frameAdmin.getContentPane().add(labelMainBG);
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (a.getSource() == buttonLogin) {
					AdminLogin();
				}
			}
		});
	}

	public void UserLogin(){
		String cardnum = textUserCardnum.getText();
		String psd = textUserPswd.getText();
		if(!cardnum.isEmpty()){
			try {
				if(cardnum.equals("6221")& psd.equals("123")){
					JOptionPane.showMessageDialog(null, "登陆成功",null,JOptionPane.INFORMATION_MESSAGE);
					frameAdmin.dispose();
					MainFrame.main(null);
				}
				else{
					JOptionPane.showMessageDialog(null, "卡号或密码错误",null,JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}else{
			JOptionPane.showMessageDialog(null, "请输入卡号","参数不完整",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void AdminLogin() {
		try{
	    String sql = null;  
	    DBHelper db1 = null;  
	    ResultSet ret = null; 
		String adminid = null;
		String passwd = null;
		sql = "select *from admin";//SQL语句  
        db1 = new DBHelper(sql);//创建DBHelper对象  
        try {  
            ret = db1.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                adminid = ret.getString(1);  
                passwd = ret.getString(2);
            
		String account = textAdminAccount.getText();
        
		if (account.equals(adminid)) {
			String password = textAdminPswd.getText();
			if (password.equals(passwd)) {
				JOptionPane.showMessageDialog(null, "登陆成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				//AdminUI adminUI = new AdminUI();
				frameAdmin.dispose();
				AdminUI.main();
				
			} else {
				JOptionPane.showMessageDialog(null, "请输入正确密码", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "请输入正确账号", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		
            }
            ret.close();  
            db1.close();//关闭连接  
        }catch (SQLException e) {  
            e.printStackTrace();  
            }  
		}catch(Exception e){
			JOptionPane.showMessageDialog(buttonLogin, "数据库已经关闭",null,JOptionPane.ERROR_MESSAGE);
		}   
	}
		
}
