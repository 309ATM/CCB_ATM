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
	String[] message =new String[4]; 
	// private MainFrame mainFrame = new MainFrame();
	//private String File = "E:\\Code\\java\\CCB_ATM";
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
		frameTransfer.setIconImage(
				Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
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
		
		label_tip = new JLabel("请输入转入账号");
		label_tip.setHorizontalAlignment(SwingConstants.CENTER);
		label_tip.setForeground(new Color(255, 255, 255));
		label_tip.setFont(new Font("幼圆", Font.BOLD, 24));
		label_tip.setBounds(392, 204, 311, 53);
		frameTransfer.getContentPane().add(label_tip);
		
		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(new Color(255, 0, 0));
		label_message.setFont(new Font("幼圆", Font.BOLD, 24));
		label_message.setBounds(392, 368, 311, 53);
		frameTransfer.getContentPane().add(label_message);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameTransfer.getContentPane().add(lblBg);
	}

	/**
	 * 输入卡号后的转账按钮监听器 
	 */
	class TransferMoney implements ActionListener {
		boolean flag;
		@Override
		public void actionPerformed(ActionEvent e) {
			//首先判断输入卡号已经选择的功能是否一致(指所属银行及转账类型)
			String cardNum = textField_money.getText();//获取输入要卡号
			//TODO *调用数据库方法 判断所属银行是否为其他行
			flag = false;
			//如果是跨行，那卡号要求不能是本行卡号
			if(isCross){
				if(flag){//flag表示为卡号是不是本行
					//修改label文本值
					label_tip.setText("请输入转账金额");
					btn_transfer.setVisible(false);
					btn_confirm.setVisible(true);
				}else{
					label_message.setText("<html><center>您选择的是跨行转账，<br>请输入其他银行的账号</center></html>");
				}
			}else{//卡号与选择功能不一致
				if(!flag){//flag表示为卡号是不是本行
					//修改label文本值
					label_tip.setText("请输入转账金额");
					btn_transfer.setVisible(false);
					btn_confirm.setVisible(true);
					textField_money.setText("");
				}else{
					label_message.setText("<html><center>您选择的是卡转出转账，<br>请输入本行的账号</center></html>");
				}
			}
			
			// TODO 转账操作，判断目标账号，增加交易记录进数据库，修改余额
			//System.out.println(isCross);
		}

	}

	/**
	 * 输入金额后的确认按钮监听器
	 */
	class ConfirmTransfer implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String moneys = textField_money.getText();
			label_message.setText(moneys);
			//输入转账金额的合法性判断，如果都没问题
			if(isCross){//跨行，收取手续费
				//检查账户余额，收取手续费后，余额足够的话
			}else{//本行转账，不收手续费
				//检查账户余额，足够的话
				// TODO 跳转转账成功界面，目前只是框架，逻辑全部没实现
				
				// 转账成功，发送消息给取款成功提示界面
				message[0] = "转账";
				message[1] = moneys; // 取款数
				message[2] = Float.toString(BlankAccout.getInstance().getBalance());// 账户余额
				message[3] = Float.toString(BlankAccout.getInstance().getTargetCard());// 今日可取款额度
				
				messageFrame.getFrameMessage().setVisible(true);
				messageFrame.showMessage(message);
				frameTransfer.dispose();
			}
			
			
		}
		
	}
	
	
	class Back implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTransfer.dispose();
			textField_money.setText("");
			//label_message.set
		}
		
	}
}
