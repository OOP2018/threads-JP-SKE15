/**
 *  The thread class using different type of counter to add and subtract the value.
 * @author Hayato Kawai
 *
 */
public class ThreadSum {
	public static void main(String[] args) {
		final int LIMIT = 10_000_000;
	}

	public static void runThreads(Counter counter, int limit) {
	
		AddTask addtask = new AddTask(counter, limit);
		SubtractTask subtask = new SubtractTask(counter, limit);
		Thread thread1 = new Thread(addtask);
		Thread thread2 = new Thread(subtask);
		System.out.println("Starting threads");
		long startTime = System.nanoTime();
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("Threads interrupted");
		}
		double elapsed = 1.0E-9 * (System.nanoTime() - startTime);
		System.out.printf("Count 1 to %,d in %.6f sec\n", limit, elapsed);
		System.out.printf("Counter total is %d\n", counter.get());
	}
}

	/**
	 * AddTask adds number 1 ... limit to the counter, then exits.
	 */
	 class AddTask implements Runnable {
		private Counter counter;
		private int limit;

		public AddTask(Counter counter, int limit) {
			this.counter = counter;
			this.limit = limit;
		}

		public void run() {
			for (int k = 1; k <= limit; k++)
				counter.add(k);
			 System.out.println("Done "+Thread.currentThread().getName());
		}
	}

	 /**
	  * SubtractTask subtract number -1 ... -limit to the counter, then exits.
	  */
	 class SubtractTask  implements Runnable {
		 private Counter counter;
			private int limit;

			public SubtractTask(Counter counter, int limit) {
				this.counter = counter;
				this.limit = limit;
			}
		@Override
		public void run() {
		for(int k = 1 ; k <= limit; k++) {
			counter.add(-k);
		}
		}
		 
}