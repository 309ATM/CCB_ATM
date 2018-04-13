package seventh.user;

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
import java.awt.Font;
import javax.swing.SwingConstants;

public class MessageFrame {

	private JFrame frameMessage;
	private JLabel label_message;

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
					MessageFrame window = new MessageFrame();
					window.frameMessage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MessageFrame() {
		initialize();
	}

	public void showMessage(String[] message) {
		if (message[0].equals("取款")|message[0].equals("透支取款")|message[0].equals("存款")) {
			String messages = "<html><center>{0}成功<br>{0}{1}元<br>您当前可用余额：{2}<br>您今日可{0}额：{3}";
			messages = messages.replace("{0}", message[0]);
			messages = messages.replace("{1}", message[1]);
			messages = messages.replace("{2}", message[2]);
			messages = messages.replace("{3}", message[3]);
			label_message.setText(messages);
		}else if (message[0].equals("转账")) {
			String messages = "<html><center>{0}成功<br>{0}{1}元<br>转账目标：{3}<br>您当前可用余额：{2}";
			messages = messages.replace("{0}", message[0]);
			messages = messages.replace("{1}", message[1]);
			messages = messages.replace("{2}", message[2]);
			messages = messages.replace("{3}", message[3]);
			label_message.setText(messages);
		}
	}

	public JFrame getFrameMessage() {
		return frameMessage;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMessage = new JFrame();
		frameMessage.setTitle("建设银行ATM");
		frameMessage.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameMessage.setResizable(false);
		frameMessage.setBounds(360, 150, 1095, 750);
		frameMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMessage.getContentPane().setLayout(null);

		label_message = new JLabel();
		label_message.setForeground(new Color(255, 255, 255));
		label_message.setFont(new Font("幼圆", Font.BOLD, 20));
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setBounds(287, 282, 504, 204);
		frameMessage.getContentPane().add(label_message);

		ATMButton button_continue = new ATMButton("<html><center>继续<br>Continue</center></html>");
		button_continue.setForeground(new Color(0, 128, 0));
		// button_1.addActionListener(new ToHistory());
		button_continue.setBounds(875, 550, 200, 80);
		frameMessage.getContentPane().add(button_continue);

		ATMButton button_exit = new ATMButton("<html><center>退出<br>Exit</center></html>");
		button_exit.setForeground(Color.RED);
		button_exit.addActionListener(new Back());
		button_exit.setBounds(14, 550, 200, 80);
		frameMessage.getContentPane().add(button_exit);

		JLabel lblBg = new JLabel("");
		lblBg.setFont(new Font("幼圆", Font.BOLD, 24));
		lblBg.setForeground(Color.WHITE);
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameMessage.getContentPane().add(lblBg);

	}

	// 返回主菜单界面
	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameMessage.setVisible(false);
		}
	}

}
