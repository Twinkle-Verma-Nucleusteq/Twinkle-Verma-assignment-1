

import java.io.*;

public class Q5 {
	public static void main(String a[]) throws IOException
    {
		
       FileReader fr = null;
       FileWriter fr1 = null;
       
	try {
		fr = new FileReader("C:\\Users\\twink\\OneDrive\\Desktop\\lambdaExpression\\src\\lambdaExpression\\ReadingFile.txt");
		try {
			fr1=new FileWriter("C:\\Users\\twink\\OneDrive\\Desktop\\lambdaExpression\\src\\lambdaExpression\\ip1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       BufferedReader br=new BufferedReader(fr);
       BufferedWriter br1=new BufferedWriter(fr1);
       String[] str = new String[45];
       String st;
       int i=0;
       while((st=br.readLine())!=null)
       {
    	   str[i] = st;
    	   i++;
       }
       i--;
       while(i>=0) {
    	   System.out.println(str[i]);
    	   br1.write(str[i]);
    	   br1.newLine();
    	   i--;
       }
       br.close();
       br1.close();
       
    }
}
