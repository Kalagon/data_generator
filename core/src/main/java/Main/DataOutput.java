package Main;

import Generator.SensorData;

/**
 * Interface for external applications to accept the generated data one by one.
 */
public interface DataOutput {

	/**
	 * Saves the given data in any way. May persist it to a file or send it somewhere else.
	 * @param data The SimpleSensorData object to process.
	 */
	void save(SensorData data);
}
