package yzh.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ThreadExample {

	public static void main(String[] args) {
		System.out.print(Thread.currentThread().getName());
		Lock lock = new Lock() {
			
			@Override
			public void unlock() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean tryLock() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Condition newCondition() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void lockInterruptibly() throws InterruptedException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void lock() {
				// TODO Auto-generated method stub
				
			}
		};
		for(int i =0 ;i<10;i++) {
			new Thread(""+i) {
				public void run() {
					System.out.println("Thread"+getName()+"running");
				}
			}.start();
		}
	}

}
