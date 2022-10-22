package threadoperation;

import java.util.Scanner;

public class TestRunnerForThread {
	static Scanner myObj = new Scanner(System.in);

	public static String getUserInput() {
		String userName = myObj.next();
		return userName;
	}
	public static int getUserInputInt() {
		while (!myObj.hasNextInt()) {
			System.out.println("Please enter in  integer format");
			myObj.next();
		}
		int num =myObj.nextInt() ;
		return num;

	}

	public static void main(String[] args) throws InterruptedException {
		ThreadOperation thread1 =new ThreadOperation();
		RunnableThread runnableThread=new RunnableThread();


		Thread runThread1 =new Thread(runnableThread);


		boolean condition=true;
		while(condition==true) {
			System.out.println("Enter the choice");

			int choice=getUserInputInt();
			switch(choice) {
			case 1:
				System.out.println(thread1.getName());
				System.out.println(thread1.getPriority());
				System.out.println(thread1.getState());
				thread1.start();
				System.out.println(thread1.getName());
				System.out.println(thread1.getPriority());
				System.out.println(thread1.getState());
				break;
			case 2:

				System.out.println(runThread1.getName());
				System.out.println(runThread1.getPriority());
				System.out.println(runThread1.getState());
				runThread1.start();
				System.out.println(runThread1.getName());
				System.out.println(runThread1.getPriority());
				System.out.println(runThread1.getState());

				break;
			case 3:
				thread1.setThreadName("Extended Thread");
				runnableThread.setThreadName(runThread1, "Ansar");
				System.out.println(thread1.getName());
				System.out.println(thread1.getPriority());
				System.out.println(thread1.getState());

				System.out.println(runThread1.getName());
				System.out.println(runThread1.getPriority());
				System.out.println(runThread1.getState());
				runThread1.start();
				thread1.start();
				break;

			case 4:
				int caseCondition=0;
				while(caseCondition<5) {
					ThreadOperation thread11 =new ThreadOperation();
					RunnableThread runnableThread1=new RunnableThread();
					Thread runThread2=new Thread(runnableThread1);
					System.out.println("Enter the thread name ");
					String threadName=getUserInput();

					thread11.setThreadName(threadName);
					System.out.println("Enter the thread name ");
					String threadName1=getUserInput();
					runnableThread1.setThreadName(runThread2, threadName1);

					System.out.println("Enter the Sleep value");
					int sleep=getUserInputInt();
					System.out.println("Enter the Sleep value");
					int sleep1=getUserInputInt();

					thread11.start();
					runThread2.start();
					thread11.sleeps(sleep);
					runnableThread1.sleeps(runThread2, sleep1);
					caseCondition++;

				}

				break;
			case 5:
				ThreadOperation thread11 =new ThreadOperation();
				RunnableThread runnableThread5=new RunnableThread();
				Thread runThread5 =new Thread(runnableThread5);
				thread11.sleeps(2000);
				runnableThread5.sleeps(runThread5, 2000);


				break;
			case 6:
				InterfaceThread t6= new InterfaceThread(6000,"Interface");
				Thread t7=new Thread(t6);
				t7.start();
				t7.sleep(2000);
				ExtendedThread exThread6=new ExtendedThread(6000,"Interface");
				exThread6.start();

				break;
			case 7:
				//Exteneded Thread
				ExtendedThread exThread=new ExtendedThread(6000,"Myext1");
				
				exThread.start();
				
				ExtendedThread exThread1=new ExtendedThread(6000,"Myext2");
				
				exThread1.start();
				ExtendedThread exThread2=new ExtendedThread(6000,"Myext3");
			
				exThread2.start();
				
				ExtendedThread exThread4=new ExtendedThread(6000,"Myext4");
				
				exThread4.start();
				//Interface thread
				InterfaceThread interFaceThread= new InterfaceThread(6000,"interFaceThread1");
				
				Thread interThread=new Thread(interFaceThread);
				interThread.start();
				InterfaceThread thread7= new InterfaceThread(6000,"interFaceThread2");
				
				Thread thread77=new Thread(thread7);
				thread77.start();
				
				InterfaceThread interFaceThread1= new InterfaceThread(6000,"interFaceThread3");
				
				Thread interThread1=new Thread(interFaceThread);
				interThread1.start();
				
				InterfaceThread interFaceThread2= new InterfaceThread(6000,"interFaceThread4");
			
				Thread interThread2=new Thread(interFaceThread);
				interThread2.start();
				
				
				
				Thread.sleep(30000);
				exThread.changeCondition();
				System.out.println("stopped");

				Thread.sleep(30000);
				System.out.println("going to stop");
				exThread1.changeCondition();
				System.out.println("stopped");
				Thread.sleep(30000);
				System.out.println("going to stop");
				exThread2.changeCondition();
				System.out.println("stopped");
				Thread.sleep(30000);
				System.out.println("going to stop");
				exThread4.changeCondition();
				System.out.println("stopped");
				//first thread sleep
				Thread.sleep(30000);
				System.out.println("going to stop");
				interFaceThread.changeCondition();
				System.out.println("stopped");

				Thread.sleep(30000);
				System.out.println("going to stop");
				thread7.changeCondition();
				System.out.println("stopped");
				
				Thread.sleep(30000);
				System.out.println("going to stop");
				interFaceThread1.changeCondition();
				System.out.println("stopped");
				
				Thread.sleep(30000);
				System.out.println("going to stop");
				interFaceThread2.changeCondition();
				System.out.println("stopped");
				break;
				

			default:
				break;

			}
		}






	}
}
