package Output;

import Generator.SettingProvider;
import Main.SettingStore;

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
		long outputSize = 1000;
		SettingProvider settings = SettingProvider.get();
		if (settings != null) {
			outputSize = settings.getOutputSize();
		}
		int outputLength = String.valueOf(outputSize).length();
		this.formatForPadding = "%0" + outputLength + "d";
	}

	/**
	 * Returns the string representation of the timestamp.
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		String result = String.format(this.formatForPadding, this.counter);
		this.counter++;
		return result;
	}
}
