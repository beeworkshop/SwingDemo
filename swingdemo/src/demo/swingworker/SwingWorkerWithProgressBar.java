package demo.swingworker;

import static utils.SwingConsole.run;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class SwingWorkerWithProgressBar extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;
	private JButton btnBegin;

	public SwingWorkerWithProgressBar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		progressBar = new JProgressBar(0, 99);
		contentPane.add(progressBar, BorderLayout.NORTH);

		btnBegin = new JButton("Begin");
		btnBegin.addActionListener(new ActionListener() {

			// 大多数Swing API是非线程安全的，只能在EDT中调用。
			// Swing的线程安全靠事件队列和EDT来保障。
			// 对非EDT的并发调用需通过 invokeLater(runnable)或invokeAndWait(runnable)
			// 使请求插入到队列中等待EDT去执行。
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProgressBarRealized(progressBar).execute();
			}

		});

		contentPane.add(btnBegin, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		run(new SwingWorkerWithProgressBar(), 100, 100, 600, 500);

	}

}
