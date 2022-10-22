package threadoperation;

public class ExtendedThread extends Thread {
public boolean condition=true;
public int sleep;
public String name;
	
	
	public void run()  {
		Thread.currentThread().setName(name);
		
		while(condition) {
			

			System.out.println( getName()+"My thread  is running...");
			System.out.println(getPriority());
			System.out.println( getState());
		
				System.out.println("Before going to sleep...");
				
				try {
					Thread.sleep(this.sleep);
//					Thread.dumpStack();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("After sleep...");
			}
			
		}
		
		
	public void changeCondition() {
		this.condition=false;
	}
	public  ExtendedThread(int inputSleep,String name) {
		
		this.sleep=inputSleep;
		this.name=name;
	}
	

}
