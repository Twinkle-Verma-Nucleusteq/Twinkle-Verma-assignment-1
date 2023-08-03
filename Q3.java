package allquestionMultithreading;

public class Q3 implements Runnable 
{
	public void run()
	{
		System.out.println("Twinkle");
	}

//main method
	public static void main(String[] args)
	{
		Runnable r1=new Q3();
		Thread t1=new Thread(r1,"tinku");
		t1.start();
	String st=t1.getName();
			{
		System.out.println(st);
			}
	}
}

