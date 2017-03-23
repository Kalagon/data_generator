package Generator;

/**
 * Interface for SimpleSensorData providers. These objects do the concrete calculations to generate a SimpleSensorData object.
 */
public interface SensorDataSupplier {

	/**
	 * Generates the SimpleSensorData object.
	 * @return The finished data object.
	 */
	SensorData get();
}
