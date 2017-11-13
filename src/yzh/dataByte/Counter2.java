package yzh.dataByte;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class SeparateSubTask extends Thread {
	private int count = 0;
	private Counter2 c2;
	private boolean runFlag = true;

	public SeparateSubTask(Counter2 c2) {
		this.c2 = c2;
		start();// 关键点，启动线程

	}

	public void inverFlat() {
		runFlag = !runFlag;
	}

	public void run() {
		while (true) {
			try {
				sleep(100);
				System.out.println("线程运行中");
			} catch (InterruptedException e) {
			}
			if (runFlag)
				c2.t.setText(Integer.toString(count++));
		}
	}
}

public class Counter2 extends Applet {
	TextField t = new TextField(10);
	private SeparateSubTask sp = null;
	private Button onOff = new Button("Toggle"), start = new Button("Start");

	public void init() {
		add(t);
		start.addActionListener(new StartL());
		add(start);
		onOff.addActionListener(new OnOffL());
		add(onOff);
	}

	class StartL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sp == null)
				sp = new SeparateSubTask(Counter2.this);// 实例化对象，
		}
	}

	class OnOffL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sp != null)
				sp.inverFlat();// 只改变标志位，线程一直在运行着只是显示框中的内容不再显示了
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter2 applet = new Counter2();
		Frame aFrame = new Frame("Counter2");
		aFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		aFrame.add(applet, BorderLayout.CENTER);
		aFrame.setSize(300, 200);
		applet.init();
		applet.start();
		aFrame.setVisible(true);
	}

}
