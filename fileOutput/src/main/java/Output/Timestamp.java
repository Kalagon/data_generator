package Output;

/**
 * Interface for Timestamp classes. These objects are used to get timestamps for single SimpleSensorData objects when they are saved or sent.
 */
public interface Timestamp {
	/**
	 * Returns the string representation of the timestamp.
	 * @return String
	 */
	String toString();
}
