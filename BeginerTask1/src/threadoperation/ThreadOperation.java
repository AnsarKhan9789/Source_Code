package threadoperation;

public class ThreadOperation extends Thread{
	boolean condition;
	public void run(){  
		
		
			System.out.println("My thread  is running..."); 
			System.out.println(getName());
			System.out.println(getPriority());
			System.out.println(getState());
			
		
	
		
		}  
	public void setThreadName(String inputThreadName) {
		this.setName(inputThreadName);
	}
	public void sleeps(long sleep) throws InterruptedException {
		System.out.println("Going to sleep "+getName());
		System.out.println(getState());
		Thread.sleep(sleep);
		System.out.println("After the sleep");
		System.out.println(getState());
	}
	public void setCondition(String checkVariable) {
		
		if (checkVariable=="yes") {
			this.condition= false;
		}
		else {
			this.condition = true;
		}
		
		
	}
}
