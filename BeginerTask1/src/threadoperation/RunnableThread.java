package threadoperation;

public class RunnableThread implements Runnable {
	boolean condition;
	@Override
	public void run() {
		
		System.out.println("My thread  is running..."); 
		System.out.println( Thread.currentThread().getName());
		System.out.println( Thread.currentThread().getPriority());
		System.out.println( Thread.currentThread().getState());
		
	
		
	}
	public void setThreadName(Thread inputThread,String inputName) {
		inputThread.setName(inputName);
		
	}
	public void sleeps(Thread inputThread,long sleep) throws InterruptedException {
		System.out.println("My thread going to sleep..."+inputThread.getName()); 
		Thread.sleep(sleep);
		System.out.println("After the sleep..."+inputThread.getName()); 
	}
	public boolean checkCondition(String checkVariable) {
		checkVariable=checkVariable.toLowerCase();
		if (checkVariable!="yes") {
			return false;
		}
		return true;
		
	}
}
