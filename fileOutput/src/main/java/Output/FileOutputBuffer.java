package Output;

import Generator.SensorData;

import java.util.LinkedList;
import java.util.List;

/**
 * Buffer for SimpleSensorData objects. May be created with a maximum size but it has to be enforced manually.
 */
public class FileOutputBuffer {
	private LinkedList<SensorData> buffer;
	private long bufferCurrentSize;
	private long bufferMaxSize;
	private Timestamp timestamp;

	/**
	 * Initializes the object with values from SettingProvider.
	 * @param bufferMaxSize The maximum size of the buffer. Soft cap.
	 */
	public FileOutputBuffer(long bufferMaxSize) {
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
	 * Checks if the buffer is full.
	 * @return true if there are at least as many items in the buffer as the set maximum.
	 */
	public boolean isFull() {
		boolean result = true;
		if (this.bufferMaxSize == 0 || (this.bufferCurrentSize < this.bufferMaxSize)) {
			result = false;
		}
		return result;
	}

	/**
	 * Checks if the buffer is empty.
	 * @return true if there are no objects in the buffer.
	 */
	public boolean isEmpty() {
		return buffer.isEmpty();
	}

	/**
	 * Generates a list of Strings from the current contents of the buffer.
	 * @return A LinkedList containing the output lines in ascending order.
	 */
	public List<String> getContents() {
		List<String> result = new LinkedList<>();
		SensorData temp;
		while (!this.buffer.isEmpty()) {
			temp = this.buffer.removeFirst();
			result.add(timestamp.toString() + " " + temp.toString());
		}
		return result;
	}

}
