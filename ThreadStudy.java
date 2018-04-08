package threadStudy;

import javax.swing.SortingFocusTraversalPolicy;

/*
 * 多线程的实现
 * 方法一：继承Thread类
 * 方法二：实现Runnable接口
 * 方法三：终止线程的典型方式
 * 方法四：暂停线程的sleep()方法
 * 方法五：yield()方法，直接进入就绪状态
 * 方法六:join()方法，两个线程相结合，一个线程结束后另一个线程才可以进行
 * @andan
 */
////method 1
//public class TestThread extends Thread {//user-defined class extends Thread class
//	//run() method is thread body
//	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(this.getName()+":"+i);
//		}
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		TestThread t = new TestThread();//create a new thread
//		t.start();//start thread
//		TestThread t2 = new TestThread();
//		t2.start();
//	}
//
//}
/*
//method two
public class TestThread implements Runnable{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
	public static void main(String[] args) {
		//创建线程对象，把实现了Runnable接口的对象作为参数传入
		Thread t1 = new Thread(new TestThread());
		t1.start();
		Thread t2 = new Thread(new TestThread());
		t2.start();
	}
}
*/

/*
//method 3：终止线程的典型方式
public class TestThread implements Runnable{
	String name;
	boolean flag = true;
	public TestThread(String name){
		super();
		this.name = name;
	}
	public void run() {
		int i = 0;
		while (flag) {
			System.out.println(name + (i++));
		}
	}
	public void terminate() {
		flag = false;
	}
	
	public static void main(String[] args) {
		TestThread t1 = new TestThread("Thread A");
		Thread t2 = new Thread(t1);
		t2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread" + i);
		}
		t1.terminate();
		System.out.println("t1 stop!");
	}
}
*/
/*
//method 4:sleep()方法可以让正在运行的线程进入阻塞状态，知道休眠时间结束，进入就绪状态
public class TestThread implements Runnable{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new TestThread());
		t1.start();
		Thread t2 = new Thread(new TestThread());
		t2.start();
	}
}
*/

/*
//method 5:yield()方法，可以让正在进行的线程直接进入就绪状态，让出CPU的使用权
public class TestThread implements Runnable{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new TestThread());
		t1.start();
		Thread t2 = new Thread(new TestThread());
		t2.start();
	}
}
*/

/*
//方法六:join()方法，两个线程相结合，一个线程结束后另一个线程才可以进行
public class TestThread{
	public static void main(String[] args) {
		System.out.println("爸爸和儿子买烟的故事：");
		Thread t = new  Thread(new FatherThread());
		t.start();
	}
}

//father thread
class FatherThread implements Runnable{
	public void run() {
		System.out.println("爸爸想抽烟，发现烟抽完了");
		System.out.println("爸爸让儿子去买包烟");
		Thread son = new Thread(new SonThread());
		son.start();
		System.out.println("爸爸等儿子买烟回来");
		try {
			son.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("爸爸出去找儿子");
			System.exit(1);
		}
		System.out.println("开始抽烟，并将零钱给了儿子");
	}
}
//son thread
class SonThread implements Runnable{
	public void run() {
		System.out.println("儿子出门去买烟");
		System.out.println("买烟需要十分钟");
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println("买烟第" + (i+1) + "分钟");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("买烟回来了");
	}
}
*/
