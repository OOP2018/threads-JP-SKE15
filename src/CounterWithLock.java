import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Use ReetranLock to lock the thread.
 * @author Hayato Kawai
 *
 */
public class CounterWithLock extends Counter {
	private Lock lock = new ReentrantLock();

	/**
	 * lock the thread.when finish adding amount, unlock the thread
	 */
	public void add(int amount) {
		try {
			lock.lock();
			super.add(amount);
		} finally {
			lock.unlock();
		}
	}
}
