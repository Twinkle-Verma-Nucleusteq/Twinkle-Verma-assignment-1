//Create a Program to print each state of a thread (From creation to termination)
package allquestionMultithreading;
	class ques5 extends Thread
	{
		public ques5(String name)
		{
			super(name);
		}

	public void run()
	{
	@SuppressWarnings("unused")
	String st ="tinku";
		//while(3)
		{
		System.out.println("MY NAME:"+this.getState());
	}
		}
		//private String getState() {
		// TODO Auto-generated method stub
			//String s1="payal";
		//return s1;
	//private void sysout() {
		// TODO Auto-generated method stub

	
	//}

		public static void main(String[] args)
		{
			ques5 t1=new ques5("Twinkle");
			ques5 t2=new ques5("name:Verma");
			System.out.println(t1.getState());
			t1.start();
			t2.start();
			
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(t1.getState());
			
}
	}

	