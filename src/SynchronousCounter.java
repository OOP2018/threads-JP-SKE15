/**
 * Lock the thread from interrupting the running thread and prevent the data race.
 * @author Hayato Kawai
 *
 */
public class SynchronousCounter extends Counter {

	/**
	 * add amount to the total.
	 */
	@Override
	 public synchronized void add(int amount) {
		total += amount;
	 }

}
