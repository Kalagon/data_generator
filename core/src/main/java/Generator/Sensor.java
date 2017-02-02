package Generator;

import Main.SettingProvider;

import java.util.Random;

/**
 * This class is used for objects that create the SensorData. Can have different types, which are implemented inside this class.
 */
public class Sensor {

	/**
	 * The types of sensors implemented. Each type corresponds to a SensorDataSupplier used to create SensorData objects.
	 */
	enum TYPE {
		TEMPERATURE,
	}

	/**
	 * Holds the generator object that creates the actual SensorData object.
	 */
	private SensorDataSupplier supplier;

	/**
	 * On creation, stores a reference to the RNG in the object.
	 * @param rng Random
	 * @param sensorType The type this sensor should represent.
	 */
	Sensor(Random rng, NoiseAlgorithm noiseAlgorithm, TYPE sensorType) {
		switch (sensorType) {
			case TEMPERATURE:
				this.supplier = new TemperatureDataSupplier(rng, noiseAlgorithm, SettingProvider.getSettingStore());
				break;
			default:
				break;
		}
	}

	/**
	 * This method returns a complete SensorData object.
	 * @return SensorData
	 */
	public SensorData getData() {
		return this.supplier.get();
	}
}
