import java.util.concurrent.atomic.AtomicLong;
/**
 * Count number by using AtomicLong.
 * @author Hayato Kawai
 *
 */
public class AtomicCounter extends Counter {
	private AtomicLong total;

	/**
	 * constructor for set the total.
	 */
	public AtomicCounter() {
		total = new AtomicLong();
	}

	/** add amount to the total. */

	public void add(int amount) {
		total.getAndAdd(amount);
	}

	/** return the total as a long value. */
	public long get() {
		return total.longValue();
	}
}
