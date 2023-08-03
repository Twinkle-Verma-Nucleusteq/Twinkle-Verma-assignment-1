class matrix
{
	public static void main(String[] arg)
	{
	int a[][]={{1,2,2},{1,6,7}};
	int b[][]={{2,3,4},{3,4,4}};
	
	int row = a.length;
	int col = a[0].length;
	
  for(int i=0;i<row;i++)
  {
  for(int j=0;j<col;j++)
  {
	b[i][j]+=a[i][j];
  }
  }
  
  for(int i=0;i<row;i++)
  {
  for(int j=0;j<col;j++)
  {
  System.out.print(b[i][j] + " ");
  }
  System.out.println();
  }
  }
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  