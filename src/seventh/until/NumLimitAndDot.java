package seventh.until;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** 限制文本框只能输入数字和小数点
 * @author Jachin
 *
 */
public class NumLimitAndDot implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int keyChar = e.getKeyChar();
		if ((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) || keyChar == KeyEvent.VK_PERIOD) {
		} else {
			e.consume(); // 关键，屏蔽掉非法输入
		}
	}

}
