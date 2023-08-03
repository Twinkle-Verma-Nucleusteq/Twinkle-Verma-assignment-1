package allquestionMultithreading;

public class Q2 implements Runnable {
public void run()
{
	System.out.println("thread is running");
}
public static void main(String[] args)
{
	Q2 t1=new Q2();
	Thread t2=new Thread(t1);
	t2.start();
}
}
