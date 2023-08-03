//Create a Java program that reads data from a text file specified by the user. The program
//should handle potential exceptions such as the file not found, permission issues, or other
//file-related exceptions gracefully using proper exception handling techniques. Provide
//appropriate error messages for each type of exception.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q4 {
public static void main(String[] args) throws IOException
{
	if(args.length!=1)
	{
		System.out.println("file");
		return;
	}
	String fn=args[0];
	readFileData(fn);
}

private static void readFileData(String fn) throws FileNotFoundException, IOException {
	// TODO Auto-generated method stub
	try(BufferedReader rd=new BufferedReader(new FileReader(fn)))
{
	String line;
	while((line=rd.readLine())!=null){
		System.out.print(line);
	}
}
	catch(Exception e)
	{
		System.out.println("File not found:"+"Permission issue"+"Error reading"+e.getMessage());
}

{
	
}
}

}
