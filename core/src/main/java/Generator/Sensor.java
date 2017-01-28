package Generator;

/**
 * Interface for Sensors. The specific Sensors have to implement this to be usable in the Generator.
 */
public interface Sensor {
	/**
	 * This method returns a complete SensorData object filled with processed data.
	 * @return SensorData
	 */
	SensorData getData();
}
