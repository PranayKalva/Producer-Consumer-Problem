package threadsAssignment;

//Importing Required Libraries
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Producer Method
class Producer implements Runnable{
	public void run() {
       			try {
					EditBufferClass.insertData();
				} catch (ExitException | InterruptedException e) {
					// TODO Auto-generated catch block
                     System.out.println("End of Producer Threads. . .");				}
		}
}

//Consumer Method
class Consumer implements Runnable {
	public void run(){
   			try {
				EditBufferClass.removeData();
			} catch (ExitException | InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("End of Consumer Threads. . .");			
			}
 	}
}

public class Runner {
	public static void main(String[] args) throws InterruptedException {
         
		int i= Integer.parseInt(args[0]); // Number of Producers from User Command Line Argument
        int p= Integer.parseInt(args[1]); // Number of Consumers from User Command Line Argument
        int q= Integer.parseInt(args[2]); // Amount of Time after which main thread sleeps user Command Line Argument  
 
        // Executor Service thread pool declarations for producers and consumers as per the user request
        ExecutorService es = Executors.newFixedThreadPool(i);
        ExecutorService es1 = Executors.newFixedThreadPool(p);
        
        // Starting all Producer Threads
        for(int j=0;j<i;j++){
        	es.submit(new Producer());
        }
        // Starting all Consumer Threads
        for(int j=0;j<p;j++){
        	es1.submit(new Consumer());
        }
        // Main Thread Sleeping
        Thread.sleep(q);
        
        // Killing Consumer Threads
        for(int j=0;j<p;j++){
        	es1.shutdownNow();
        }
        // Killing Producer Threads
        for(int j=0;j<i;j++){
        	es.shutdownNow();
        }
        }
}
