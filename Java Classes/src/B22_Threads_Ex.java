
public class B22_Threads_Ex extends Thread{

	public static void main(String[] args) {
		B22_Threads_Ex thread = new B22_Threads_Ex();
		thread.start();
		System.out.println("This code is outside of the thread");
	}
	
	
	public void run() {
		System.out.println("This code is running in a thread");
	}
}
