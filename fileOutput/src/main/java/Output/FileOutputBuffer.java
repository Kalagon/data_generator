package Output;

import Generator.SensorData;
import Generator.SettingProvider;

import java.util.LinkedList;
import java.util.List;

/**
 * Buffer for SensorData objects. May be created with a maximum size but it has to be enforced manually.
 */
public class FileOutputBuffer {
	private LinkedList<SensorData> buffer;
	private int bufferCurrentSize;
	private int bufferMaxSize;
	private Timestamp timestamp;

	/**
	 * Initializes the object with values from SettingProvider.
	 */
	public FileOutputBuffer() {
		this.bufferCurrentSize = 0;
		this.buffer = new LinkedList<>();
		this.timestamp = new SimpleCounterTimestamp();
		this.bufferMaxSize = SettingProvider.get().getBufferSize();
	}

	/**
	 * Initializes the object with values from SettingProvider.
	 */
	public FileOutputBuffer(int bufferMaxSize) {
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
	 * @return true if theere are no objects in the buffer.
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
			result.add(timestamp.getString() + " " + temp.toString());
		}
		return result;
	}

}
