package allquestionMultithreading;
//method one-extend a class
public class Q1 extends Thread{
	public void run() {
		System.out.println("thread is running");
	}

public static void main(String[] args)
{
	Q1 mul=new Q1();
	mul.start();
}
}