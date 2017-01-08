package Generator;

/**
 * Template class for all kinds of SensorData objects. All result data obtained from sensors must be encapsulated inside an object of this or a subclass of this class.
 */
public class SensorData {
	/**
	 * The value of the last measurement.
	 */
	private float currentValue;
	/**
	 * The maximum deviation of the measurement under normal circumstances.
	 */
	private float precision;
	private String measurementUnit;

	public SensorData(float currentValue, float precision, String measurementUnit) {
		this.currentValue = currentValue;
		this.precision = precision;
		this.measurementUnit = measurementUnit;
	}


	@Override
	public String toString() {
		Character separator = ',';
		return  "currentValue:" + currentValue + separator +
				"precision:" + precision + separator +
				"measurementUnit:" + measurementUnit;
	}
}
