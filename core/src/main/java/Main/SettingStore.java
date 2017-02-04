package Main;

import Generator.Sensor;

import java.io.Serializable;

/**
 * An Object of this class contains all user-selectable settings. This is used to initialize the generator.
 */
public class SettingStore implements Serializable {
	private int generatorSeed = 2345876;
	private long outputSize = 1000;
	private float rangeMin = 0f;
	private float rangeMax = 100f;
	private float precision = 0.5f;
	private boolean precisionAndRangeRelative = true;
	private Sensor.TYPE[] sensorTypes = { Sensor.TYPE.TEMPERATURE };
	private NoiseAlgorithmFactory.ALGORITHMS noiseAlgorithm = NoiseAlgorithmFactory.ALGORITHMS.RANDOM;
	private NoiseSettingStore noiseSettings = new RandomNoiseSettingStore();

	public int getGeneratorSeed() {
		return generatorSeed;
	}

	public void setGeneratorSeed(int generatorSeed) {
		this.generatorSeed = generatorSeed;
	}

	public long getOutputSize() {
		return outputSize;
	}

	public void setOutputSize(long outputSize) {
		this.outputSize = outputSize;
	}

	public NoiseAlgorithmFactory.ALGORITHMS getNoiseAlgorithm() {
		return noiseAlgorithm;
	}

	public void setNoiseAlgorithm(NoiseAlgorithmFactory.ALGORITHMS noiseAlgorithm) {
		this.noiseAlgorithm = noiseAlgorithm;
	}

	public NoiseSettingStore getNoiseSettings() {
		return noiseSettings;
	}

	public void setNoiseSettings(NoiseSettingStore noiseSettings) {
		this.noiseSettings = noiseSettings;
	}

	/**
	 * Sets rangeMin and rangeMax. Ensures that max > min.
	 * @param min
	 * @param max
	 */
	public void setRange(float min, float max) {
		if (min > max) {
			float tmp = min;
			min = max;
			max = tmp;
		}
		this.rangeMin = min;
		this.rangeMax = max;
	}

	public float getRangeMin() {
		return rangeMin;
	}

	public float getRangeMax() {
		return rangeMax;
	}

	public float getPrecision() {
		return precision;
	}

	public void setPrecision(float precision) {
		this.precision = precision;
	}

	public boolean isPrecisionAndRangeRelative() {
		return precisionAndRangeRelative;
	}

	public void setPrecisionAndRangeRelative(boolean precisionAndRangeRelative) {
		this.precisionAndRangeRelative = precisionAndRangeRelative;
	}

	public Sensor.TYPE[] getSensorTypes() {
		return sensorTypes;
	}

	public void setSensorTypes(Sensor.TYPE[] sensorTypes) {
		this.sensorTypes = sensorTypes;
	}
}
