package Generator;

/**
 * Interface for SensorData providers. These objects do the concrete calculations to generate a SensorData object.
 */
public interface SensorDataSupplier {

	/**
	 * Generates the SensorData object.
	 * @return The finished data object.
	 */
	SensorData get();
}
