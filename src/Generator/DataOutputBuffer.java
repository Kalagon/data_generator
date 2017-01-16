package Generator;

import java.util.LinkedList;
import java.util.List;

/**
 * Buffer for SensorData objects. May be created with a maximum size but it has to be enforced manually.
 */
public class DataOutputBuffer {
	private LinkedList<SensorData> buffer;
	private int bufferCurrentSize;
	private int bufferMaxSize;
	private Timestamp timestamp;

	/**
	 * Initializes the object with default values;
	 */
	public DataOutputBuffer() {
		this(0);
	}

	/**
	 * Initializes the object with a given maximum size for the buffer.
	 * @param bufferMaxSize The maximum size. 0 means no limit.
	 */
	public DataOutputBuffer(int bufferMaxSize) {
		this.bufferCurrentSize = 0;
		this.buffer = new LinkedList<>();
		this.timestamp = new SimpleCounterTimestamp();
		this.bufferMaxSize = bufferMaxSize;
	}

	/**
	 * Appends an item to the buffer.
	 * @param item The SensorData object.
	 */
	public void append(SensorData item) {
		this.buffer.add(item);
		this.bufferCurrentSize++;
	}

	/**
	 * Checks if the buffer has not reached the limit set on creation.
	 * @return true if there are fewer items in the buffer than the set maximum.
	 */
	public boolean notFull() {
		boolean result = false;
		if (this.bufferMaxSize == 0 || (this.bufferCurrentSize < this.bufferMaxSize)) {
			result = true;
		}
		return result;
	}

	/**
	 * Generates a list of Strings from the current contents of the buffer.
	 * @return A LinkedList containing the output lines in ascending order.
	 */
	public List<String> getContents() {
		List<String> result = new LinkedList<>();
		SensorData temp;
		while (!this.buffer.isEmpty()) {
			temp = this.buffer.getFirst();
			result.add(timestamp.getString() + " " + temp.toString());
		}
		return result;
	}

}
