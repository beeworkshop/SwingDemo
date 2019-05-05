package demo.swingworker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

class ProgressBarRealized extends SwingWorker<Void, Integer> {

	private JProgressBar progressBar;

	public ProgressBarRealized(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	@Override
	// 后台任务在此方法中实现（任务线程）
	// doInBackground​、publish是任务线程中调用的
	// EDT上执行的代码都尽可能是非耗时性的
	protected Void doInBackground() throws Exception {
		// 模拟有一百项任务，每次睡1s
		for (int i = 0; i < 100; i++) {
			TimeUnit.MICROSECONDS.sleep(500);
			publish(i);// 将当前进度信息加入chunks中
		}
		return null;
	}

	@Override
	// 每次更新进度条的信息（访问UI/EDT的线程）
	// done、process是在EDT中调用的
	protected void process(List<Integer> chunks) {
		progressBar.setValue(chunks.get(chunks.size() - 1));
	}

	@Override
	// 任务完成后返回一个信息
	protected void done() {
		JOptionPane.showMessageDialog(null, "任务完成！");
	}
}