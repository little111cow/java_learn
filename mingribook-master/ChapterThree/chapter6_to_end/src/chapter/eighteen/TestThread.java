package chapter.eighteen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestThread extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel jPanel1 = new JPanel();
	JButton startButton = new JButton();
	JButton stopButton = new JButton();
	private boolean isContinue;
	MyThread thread = null;
	
	public TestThread() {
		try {
			jbInit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread test = new TestThread();
		test.setBounds(300, 300, 300, 80);
		test.setVisible(true);
	}
	
	private class MyThread extends Thread{
		public MyThread() {
			isContinue = true;
		}
		
		public void run() {
			System.out.println("\n\n");
			while (true && isContinue) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Java ???̴ʵ?\thttp://www.mrbccd.com");
			}
		}
	}
	
	private void jbInit() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startButton.setText("start");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startButton_actionPerformed(e);
			}
		});
		
		stopButton.setText("stop");
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopButton_actionPerformed(e);
			}
		});
		
		this.getContentPane().add(jPanel1, BorderLayout.CENTER);
		jPanel1.add(startButton);
		startButton.setBounds(36, 105, 82, 30);
		jPanel1.add(stopButton);
		stopButton.setBounds(160, 108, 100, 31);
	}
	
	void startButton_actionPerformed(ActionEvent e) {
		if (thread != null)
			isContinue = false;
		thread = new MyThread();
		thread.start();
	}
	
	void stopButton_actionPerformed(ActionEvent e) {
		if (thread != null)
			isContinue = false;
		thread = null;
	}
}
