package utils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * 
 * @author beeworkshop
 *
 *         Swing中的4种基本类型的线程：
 *
 *         1. main()主线程
 *
 *         2. EDT(Event Dispatch Thread)线程（Swing组件的绘制必须 在EDT中进行。EDT是单线程模式。）
 * 
 *         EDT单线程规则：只能通过EDT来修改Swing组件的状态，否则需使用下边的线程来处理。
 *
 *         3. SwingUtilities.invokeLater（）界面处理线程
 * 
 *         	与EDT安全地交互。
 *
 *         4. 任务线程
 */
public class SwingConsole {

	public static void run(final JFrame f, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				f.setTitle(f.getClass().getSimpleName());
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(width, height);
				f.setVisible(true);
			}
		});

	}

	public static void run(final JFrame f, final int x, final int y, final int width, final int height) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				f.setTitle(f.getClass().getSimpleName());
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// f.setBounds(x, y, width, height);
				f.setSize(width, height);
				// 在屏幕中居中显示
				// 需在JFrame.setSize(x, y)或JFrame.pack()方法之后使用方有效
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
	}
}
