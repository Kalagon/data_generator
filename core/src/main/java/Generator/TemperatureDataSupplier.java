package Generator;

import Main.SettingStore;

import java.util.Random;

/**
 * Generates SensorData objects filled with temperature data.
 */
public class TemperatureDataSupplier implements SensorDataSupplier {

	private float rangeMin;
	private float rangeMax;
	private float rangeDelta;
	private float precisionSetting;
	private Random rng;
	private NoiseAlgorithm noiseAlgorithm;

	public TemperatureDataSupplier(Random rng, NoiseAlgorithm noiseAlgorithm, SettingStore settings) {
		this.rng = rng;
		this.noiseAlgorithm = noiseAlgorithm;
		float rangeMin = settings.getRangeMin();
		float rangeMax = settings.getRangeMax();
		float rangeDelta = rangeMax - rangeMin;
		if (settings.isPrecisionAndRangeRelative()) {
			float mean = 25f;
			rangeMin = mean - ( rangeDelta / 2 );
			rangeMax = mean + ( rangeDelta / 2 );
		}
		this.rangeMax = rangeMax;
		this.rangeMin = rangeMin;
		this.rangeDelta = rangeDelta;
		this.precisionSetting = settings.getPrecision();
	}


	/**
	 * Generates the SensorData object.
	 *
	 * @return The finished data object.
	 */
	@Override
	public SensorData get() {
		return new SensorData(1, 1, "C");
	}
}
