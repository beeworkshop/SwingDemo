package demo.longjob;

import java.util.concurrent.Callable;

import javafx.concurrent.Task;

public class CallableTask extends Task implements Callable<String> {

	@Override
	public String call() throws Exception {
		run();
		return "Return value of " + this;
	}

	public void id() {
		System.out.println("ou yeah");

	}

}
