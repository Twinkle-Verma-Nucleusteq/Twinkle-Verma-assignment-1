 //Create a Program where Threads are reading a message and giving acknowlegement (What a particular thread is reading)//
package allquestionMultithreading;
import java.util.Scanner;
public class messrea {
private static String mess=null;

	public static void main(String[] args)
	//create thread
	//re-read message
	//acknowledgment
	{
	Thread re=new Thread(messrea::re);
	Thread ac=new Thread(messrea::ac);
	//start Thread
	re.start();
	ac.start();
}
	//function to read
	public static void re()
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter a mess:");
			mess=sc.nextLine();
			if(mess.equalsIgnoreCase("exit"))
			{
				break;
			}
		}
		sc.close();
	}
	// function acknowledge
	public static void ac()
	{
	while(true)
	{
		if(mess!=null)
		{
			System.out.println("Acknowledgement:Message"+mess+"received");
			mess=null;
		}
		try {
		Thread.sleep(1000);
	}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
}
}
}