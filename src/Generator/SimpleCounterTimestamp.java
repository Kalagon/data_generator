package Generator;

/**
 * Uses a simple counter for timestamps.
 */
public class SimpleCounterTimestamp implements Timestamp {
	private long counter;
	private String formatForPadding;

	/**
	 * Initializes the counter to 0 and sets the formatForPadding String which is used to zero-pad the output.
	 */
	public SimpleCounterTimestamp() {
		this.counter = 0;
		long outputSize = SettingProvider.get().getOutputSize();
		int outputLength = String.valueOf(outputSize).length();
		this.formatForPadding = "%0" + outputLength + "d";
	}

	/**
	 * Returns the string representation of the timestamp.
	 *
	 * @return String
	 */
	@Override
	public String getString() {
		String result = String.format(this.formatForPadding, this.counter);
		this.counter++;
		return result;
	}
}
