/*TASK (MultiThreading) :


1) Explore Threads, Thread Method and State of Threads
2) Create a program where you check running threads (should be 3 Threads and more)
3) Create a program which can take input (int) (Ex -10 and display all the numbers below 10 that is 1-9) and preform task - Reverse the list, Fibonacci, Sum of all number
4) Create a Program where Threads are reading a message and giving acknowlegement (What a particular thread is reading)
5) Create a Program to print each state of a thread (From creation to termination)
6) Read about Thread Executor, thread pool
7) Create a Program to set priority of a thread*/
//Create a Program to set priority of a thread*/

package allquestionMultithreading;
class mThre extends Thread
{
	public mThre(String name)
	{
		super(name);
	}

public void run()
{
@SuppressWarnings("unused")
String st ="tinku";
	while(true)
	{
	System.out.println("MY NAME:"+this.getName());
}}
}
public class priority {
public static void main(String[] args)
{
	mThre t1=new mThre("Twinkle");
	mThre t2=new mThre("name:Verma");
	mThre t3=new mThre("name:Verma1");
	mThre t4=new mThre("name:Verma2");
	mThre t5=new mThre("name:Verma3");
	t1.setPriority(Thread.MAX_PRIORITY);
	t1.start();
	t2.setPriority(Thread.MAX_PRIORITY);
	t2.start();
	t3.setPriority(Thread.MIN_PRIORITY);
	t3.start();
	t4.setPriority(Thread.NORM_PRIORITY);
	t4.start();
	t5.setPriority(Thread.MIN_PRIORITY);	
}
}

