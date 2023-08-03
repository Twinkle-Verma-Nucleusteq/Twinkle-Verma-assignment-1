import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q8 {


private static void readFileData(String fn) throws FileNotFoundException, IOException {
	// TODO Auto-generated method stub
	BufferedReader rd=new BufferedReader(new FileReader(fn));
	try
{
	String line;
	while((line=rd.readLine())!=null){
		System.out.print(line);
	}
}
	catch(IOException e)
	{
		System.out.println("Error reading filre:"+e.getMessage());
}
	finally {
		if(rd!=null)
		{
			try
			{
				rd.close();
			}
			catch(IOException e)
			{
				System.out.println("Error reading filre:"+e.getMessage());
			
		}
	}



	}
}
public static void main(String[] args)
{
	String fn="ip.txt";
	readFileData(fn);
	
}
}