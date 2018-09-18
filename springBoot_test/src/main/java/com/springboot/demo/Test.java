package com.springboot.demo;

/**
 *  线程实现方式一 ： 继承Thread类
 * @author licp
 *
 */
public class Test {
	public static void main(String[] args) {
		MThread t =  new MThread();
		Thread t1 = new Thread(t,"PP");
		Thread t2 = new Thread(t,"yy");
		t1.start();
		t2.start();
		System.out.println("==================");
	}
}

class MThread extends Thread{
	 private int num = 0; // 出票数
	    private int count = 10; // 剩余票数
	    boolean flag = false;
	    @Override
	    public void run() {
	        while (true) {
	            synchronized (this) {            
	                // 没有余票时，跳出循环
	                if (count <= 0) {
	                    break;
	                }
	                num++;
	                count--;
	                try {
	                    Thread.sleep(10);// 模拟网络延时
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	                System.out.println("显示出票信息：" + Thread.currentThread().getName()
	                        + "抢到第" + num + "张票，剩余" + count + "张票");
	            }
	        }
	    }
}