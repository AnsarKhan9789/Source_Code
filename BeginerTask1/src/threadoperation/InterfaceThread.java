package threadoperation;

public class InterfaceThread implements Runnable {
	public boolean condition=true;
	public int sleep;
	public String name;
	@Override
	public void run() {
		
		
		while(condition) {
			Thread.currentThread().setName(name);
			
			System.out.println( Thread.currentThread().getName()+"My thread  is running...");
			System.out.println( Thread.currentThread().getPriority());
			System.out.println( Thread.currentThread().getState());
			System.out.println("Before going to sleep...");
			
			try {
				Thread.sleep(this.sleep);
//				Thread.dumpStack();
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
	

	public InterfaceThread(int inputSleep,String name) {
		this.sleep=inputSleep;
		this.name=name;
	}
	
}
