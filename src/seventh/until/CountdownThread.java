package seventh.until;

import javax.swing.JFrame;
import javax.swing.JLabel;

import seventh.user.UsersLogin;

/**
 * 进行倒计时的线程，当 60s 内不进行操作，就会跳回开始界面
 */
public class CountdownThread extends Thread {
	private JFrame frame;
	private JLabel label;

	public void setCom(JFrame frame, JLabel label) {
		this.frame = frame;
		this.label = label;
	}

	private boolean runFlag = true;
	// TODO 设置倒计时时间
	private int time = 60;

	public void run() {
		runFlag = true;
		while (runFlag) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (runFlag) { // TODO 这里加需要线程执行的事件
				time--;
				label.setText(time + "");
			}
			// 如果时间耗尽，则结束该窗口，回到主界面
			if (time <= 0) {
				stopThread();
				frame.dispose();
				// TODO 修改为 ATM 界面
				UsersLogin.main(null);
			}
		}
	}

	// 终止线程
	public void stopThread() {
		runFlag = false;
	}

}
