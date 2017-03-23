package Generator;

import Main.SettingProvider;

/**
 * This class is used to create Sensor objects. It holds the enum containing available types and provides a method to create the objects for a given TYPE.
 */
public class SensorFactory {

	/**
	 * The types of sensors implemented. Each type corresponds to a SensorDataSupplier used to create SimpleSensorData objects.
	 */
	public enum TYPE {
		TEMPERATURE,
	}

	/**
	 * Builds and returns a Sensor of the requested TYPE with settings from SettingProvider.
	 * @param type The TYPE of Sensor that should be built.
	 * @return Sensor
	 */
	protected static Sensor createSensor(TYPE type) {
		Sensor result = null;
		switch (type) {
			case TEMPERATURE:
				result = new TemperatureSensor();
				break;
			default:
				break;
		}
		result.setup(SettingProvider.getRandomNumberGenerator(), SettingProvider.getNoiseAlgorithm(), SettingProvider.getSettingStore());

		return result;
	}
}
